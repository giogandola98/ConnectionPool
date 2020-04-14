package it.project.tiw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;

import it.project.tiw.dbmanager.DbUtil;

public class CompleteDocumentMoveDAO {
	private Connection conn = null;
	private static String querySQL = "UPDATE Document as D SET D.propFolder=? WHERE D.propFolder=? AND D.name=? AND D.type=?";
	
	public CompleteDocumentMoveDAO() {}
	
	public boolean completeDocumentMove(int dest, int originFDoc,String namDoc, String typeDoc) throws ServletException 
	{
		conn=DbUtil.getConnection();
		PreparedStatement pStatement = null;
		try 
		{
			pStatement = conn.prepareStatement(querySQL);
			pStatement.setInt(1, dest);
			pStatement.setInt(2, originFDoc);
			pStatement.setString(3, namDoc);
			pStatement.setString(4, typeDoc);
			pStatement.executeUpdate();
			return true;
		} 
		catch (SQLException e) {throw new UnavailableException("Errore: l'aggiornamento dei dati non è andato a buon fine");} 
		finally 
		{
			if(pStatement!=null)try {pStatement.close();} catch (SQLException e) {e.printStackTrace();}	
			if(conn!=null) try {conn.close();conn=null;}catch (SQLException e) {e.printStackTrace();}
			
		}
	}
}
