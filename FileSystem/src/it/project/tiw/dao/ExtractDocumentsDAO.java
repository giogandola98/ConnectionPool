package it.project.tiw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.project.tiw.beans.Document;
import it.project.tiw.dbmanager.DbUtil;

public class ExtractDocumentsDAO {
	private Connection conn = null;
	private static String querySQL = "SELECT D.propFolder, D.name, D.type, D.dateCreation, D.dateUpdate, D.summary FROM Document as D WHERE propFolder=?";
	
	public ExtractDocumentsDAO() {}
	
	public ArrayList<Document> estractFolderDocuments(int folderContainer) {
		conn=DbUtil.getConnection();
		PreparedStatement pStatmnt = null;
    	ResultSet rs = null;
		ArrayList<Document> documents = null;
		try 
		{
			documents=new ArrayList<Document>();
    		pStatmnt = conn.prepareStatement(querySQL);
    		pStatmnt.setInt(1, folderContainer);
    		rs = pStatmnt.executeQuery();
    		
    		while (rs.next()) 
    			documents.add(new Document(rs.getInt("propFolder"), rs.getString("name"), rs.getString("type"), rs.getString("dateCreation"), rs.getString("dateUpdate"), rs.getString("summary")));
    		
    	} 
		catch (SQLException e) {e.printStackTrace();} 
		finally {
    		if(rs!=null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
    		if(pStatmnt!=null) try {pStatmnt.close();} catch (SQLException e) {e.printStackTrace();}
    		if(conn!=null)try {conn.close(); conn=null;}catch (SQLException e) {e.printStackTrace();};
    	}		
		return documents;
	}

}
