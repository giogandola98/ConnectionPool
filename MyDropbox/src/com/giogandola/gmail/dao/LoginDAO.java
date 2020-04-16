package com.giogandola.gmail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;

import com.giogandola.gmail.beans.User;
import com.giogandola.gmail.utils.DbUtil;
public class LoginDAO {
	private Connection conn = null;
	private static String querySQl="SELECT * FROM User WHERE password=? LIMIT 1";
	
	public LoginDAO() {}
	public User userLogin(String user, String pass) throws ServletException 
	{
		conn=DbUtil.getConnection();
		User userLogged =null;
		ResultSet rs = null;
		PreparedStatement pStatmnt = null;
		try 
		{
			pStatmnt = conn.prepareStatement(querySQl);
			pStatmnt.setString(1, pass);
			rs = pStatmnt.executeQuery();
			while(rs.next()) 
				if(user.equals(rs.getString("user"))) 
				{
					userLogged=new User(rs.getInt("idUser"),rs.getString("user"),rs.getString("password"));
				}
			
		} 
		catch (SQLException e) {throw new UnavailableException("Errore: impossibile scaricare i dati dell'utente");} 
		finally 
		{
			if(rs!=null)
				try {rs.close();} catch (SQLException e1) {e1.printStackTrace();}
			if(pStatmnt!=null)
				try {pStatmnt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn!=null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}conn=null;}
			
		}
		return userLogged;
	}
}
