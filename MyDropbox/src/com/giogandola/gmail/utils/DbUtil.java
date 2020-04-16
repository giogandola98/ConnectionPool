package com.giogandola.gmail.utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil 
{
	static DataSource dataSource=null;
	private static void getMapping()
	{
		try {
			// Get DataSource
			Context initContext  = new InitialContext();
			System.out.println(initContext.getNameInNamespace());
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource= (DataSource)envContext.lookup("jdbc/testdb");

			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		if(dataSource == null)
			getMapping();
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	
}