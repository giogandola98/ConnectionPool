package com.giogandola.gmail.utils;

import java.sql.*;
import org.apache.commons.dbcp.*;

public class DbUtil 
{
	static BasicDataSource dataSource=null;
	private static void getMapping()
	{
		try {
			  URI dbUri = new URI("mysql://bbd6032aafd0b8:95fe8fa0@eu-cdbr-west-02.cleardb.net/heroku_6fca6f9bee22f9c");
			  String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
			  connectionPool = new BasicDataSource();

			  if (dbUri.getUserInfo() != null) {
			    connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
			    connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
			  }
			  connectionPool.setDriverClassName("com.mysql.cj.jdbc.Driver");
			  connectionPool.setUrl(dbUrl);
			  connectionPool.setInitialSize(1);

			
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