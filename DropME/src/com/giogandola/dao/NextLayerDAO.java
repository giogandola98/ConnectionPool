package com.giogandola.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.giogandola.beans.Document;
import com.giogandola.beans.Folder;
import com.giogandola.interfaces.ExtractLayerInterface;
import com.giogandola.utils.DbUtil;
import com.giogandola.utils.Level;


public class NextLayerDAO extends Level implements ExtractLayerInterface
{
	private Integer userID;
	private Connection conn=null;
	PreparedStatement pStatmnt = null;
	ResultSet rs = null;
	private static String sqlF="SELECT F.idFolder, F.name, F.dateCreation, F.dateUpdate, F.upFolder FROM Folder as F WHERE owner = ? AND F.upFolder = ? ;";
	private static String sqlD="SELECT D.propFolder, D.name, D.type, D.dateCreation, D.dateUpdate, D.summary,D.filename FROM Document as D WHERE propFolder = ? ;";
	
	private void initConnection(){if(conn==null)	conn=DbUtil.getConnection();}
	private void closeConnection()
	{
		if(conn!=null)	try{conn.close();} catch (SQLException e) {e.printStackTrace();}
		if(rs!=null)	try{rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pStatmnt!=null)	try{pStatmnt.close();} catch (SQLException e) {e.printStackTrace();}
	}
	public NextLayerDAO(Integer userID){super();this.userID=userID;extractLayer(0);}
	public NextLayerDAO(Integer userID,Integer upLayerIndex){super();this.userID=userID;extractLayer(upLayerIndex);}
	@Override
	public void extractLayer(Integer upLayerIndex) 
	{
		this.cleanLayer();
		initConnection();
		processFolders(this.userID,upLayerIndex);
		processDocuments(upLayerIndex);
		closeConnection();
		
	}
	private void processFolders(int userID,int upLayer)
	{
		initConnection();
		try 
		{
			pStatmnt = conn.prepareStatement(sqlF);
			pStatmnt.setInt(1,userID);
			pStatmnt.setInt(2,upLayer);
			rs = pStatmnt.executeQuery();
			while(rs.next()) 
				this.addFolder(new Folder(rs.getInt("idFolder"), rs.getString("name"), rs.getString("dateCreation"), rs.getString("dateUpdate"), rs.getInt("upFolder")));
		}
		catch (SQLException e) {e.printStackTrace();}
	}
	private void processDocuments(int upLayer)
	{
		try 
		{
			pStatmnt = conn.prepareStatement(sqlD);
			pStatmnt.setInt(1,upLayer);
			rs = pStatmnt.executeQuery();
			while(rs.next()) 
				this.addDocument(new Document(rs.getInt("propFolder"), rs.getString("name"), rs.getString("type"), rs.getString("dateCreation"), rs.getString("dateUpdate"), rs.getString("summary"),rs.getString("filename")));
		}
		catch (SQLException e) {e.printStackTrace();}
	}
	
			
			
						

		
}
