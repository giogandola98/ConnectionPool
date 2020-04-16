package com.giogandola.gmail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.giogandola.gmail.beans.Document;
import com.giogandola.gmail.beans.Folder;
import com.giogandola.gmail.interfaces.UpdateData;
import com.giogandola.gmail.utils.DbUtil;

public class UpdateLayerDAO implements UpdateData
{
	private Connection conn=null;
	PreparedStatement pStatmnt = null;
	
	private static String createFolder="INSERT INTO Folder(name,upFolder) VALUES (?,?);";
	private static String moveDocument_sql = "UPDATE Document as D SET D.propFolder=? WHERE D.propFolder=? AND D.name=? AND D.type=?";
	private static String renameDocument_sql = "UPDATE Document as D SET D.name=? WHERE D.propFolder=? AND D.name=? AND D.type=?";
	private static String renameFolder_sql="UPDATE Folder as F SET F.name=? WHERE F.idFolder=?;";
	private static String moveFolder_sql="UPDATE Folder as F SET F.upFolder=? WHERE F.idFolder=?;";
	private static String eraseFolder_sql="DELETE FROM Folder AS F WHERE F.idFolder=?;";
	private static String eraseDocument_sql="DELETE FROM Document AS D WHERE D.propFolder=? AND D.name=? AND D.type=?;";
	
	 
	@Override
	public boolean updateFolderPos(Folder folder, Integer newUpFolderID) 
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(moveFolder_sql);
		pStatmnt.setInt(1,newUpFolderID);
		pStatmnt.setInt(2,folder.getIdFolder());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean updateDocumentPos(Document document, Integer newUpFolderID)
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(moveDocument_sql);
		pStatmnt.setInt(1,newUpFolderID);
		pStatmnt.setInt(2,newUpFolderID);
		pStatmnt.setString(3,document.getName());
		pStatmnt.setString(4,document.getType());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean renameDocument(Document document,String newName) 
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(renameDocument_sql);
		pStatmnt.setString(1,newName);
		pStatmnt.setInt(2,document.getPropFolder());
		pStatmnt.setString(3,document.getName());
		pStatmnt.setString(4,document.getType());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean renameFolder(Folder folder,String newName) 
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(renameFolder_sql);
		pStatmnt.setString(1,newName);
		pStatmnt.setInt(2,folder.getIdFolder());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean eraseDocument(Document document) 
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(eraseDocument_sql);
		pStatmnt.setInt(1,document.getPropFolder());
		pStatmnt.setString(2,document.getName());
		pStatmnt.setString(3,document.getType());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean eraseFolder(Folder folder) 
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(eraseFolder_sql);
		pStatmnt.setInt(1,folder.getIdFolder());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	@Override
	public boolean createFolder(Folder folder)
	{
		boolean _toreturn=false;
		this.initConnection();
		try
		{
		pStatmnt=conn.prepareStatement(createFolder);
		pStatmnt.setString(1,folder.getName());
		pStatmnt.setInt(2,folder.getUpFolder());
		pStatmnt.executeQuery();
		_toreturn=true;
		}
		catch (Exception e) {e.printStackTrace();}
		this.closeConnection();
		return _toreturn;
	}
	
	
	
	
	private void initConnection(){if(conn==null)	conn=DbUtil.getConnection();}
	private void closeConnection()
	{
		if(conn!=null)	try{conn.close();} catch (SQLException e) {e.printStackTrace();}
		if(pStatmnt!=null)	try{pStatmnt.close();} catch (SQLException e) {e.printStackTrace();}
	}

}
