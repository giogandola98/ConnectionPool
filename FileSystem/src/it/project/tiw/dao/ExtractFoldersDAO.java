package it.project.tiw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;

import it.project.tiw.beans.Folder;
import it.project.tiw.dbmanager.DbUtil;

public class ExtractFoldersDAO {
	private Connection conn = null;
	private static String querySQL = "SELECT F.idFolder, F.name, F.dateCreation, F.dateUpdate, F.upFolder FROM Folder as F WHERE owner = ?";
	public ExtractFoldersDAO() {}
	
	public ArrayList<Folder> estractUserFolders(int idUserLogged) throws ServletException 
	{
		conn=DbUtil.getConnection();
		PreparedStatement pStatmnt = null;
		ResultSet rs = null;
		ArrayList<Folder> userLoggedFolders= null;
		
		try {
			userLoggedFolders= new ArrayList<Folder>();
			pStatmnt = conn.prepareStatement(querySQL);
			pStatmnt.setInt(1,idUserLogged);
			rs = pStatmnt.executeQuery();
			
			while(rs.next()) 			
				userLoggedFolders.add(new Folder(rs.getInt("idFolder"), rs.getString("name"), rs.getString("dateCreation"), rs.getString("dateUpdate"), rs.getInt("upFolder")));
			
		} 
		catch (SQLException e) {throw new UnavailableException("Errore: imppossibile caricare i dati dell'utente");}
		finally {
			if(rs!= null) try {rs.close();} catch(SQLException e) {throw new UnavailableException("Errore: -----------------");}
			if(pStatmnt!=null) try {pStatmnt.close();} catch (SQLException e) {throw new UnavailableException("Errore: -----------------");}
			if(conn!=null)try {conn.close();}catch (SQLException e) {e.printStackTrace();}
		}	
		return userLoggedFolders;
	}

}
