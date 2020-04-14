package it.project.tiw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;

import it.project.tiw.beans.User;
import it.project.tiw.dbmanager.DbUtil;

public class RegisterDAO {
	private Connection conn = null;
	private static String query = "INSERT INTO User (user,password) VALUES (?,?)";
	
	public RegisterDAO() {}
	
	public boolean userRegistration(String uNam, String uPass) throws ServletException 
	{
		conn=DbUtil.getConnection();
		PreparedStatement pStatmnt = null;
		try 
		{
			
			pStatmnt = conn.prepareStatement(query);
			pStatmnt.setString(1, uNam);
			pStatmnt.setString(2, uPass);
			pStatmnt.executeUpdate();
			return true;
		}  catch (SQLException e) {	throw new UnavailableException("Errore: il database non è riuscito a salvare i tuoi dati");}
		finally 
		{
			if(pStatmnt != null)try {pStatmnt.close();} catch (SQLException e) {throw new UnavailableException("Errore: -----------------");}
			if(conn!=null)try {conn.close();}catch (SQLException e) {e.printStackTrace();}
		}
	}
}
