package com.giogandola.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DbUtil 
{
	static BasicDataSource connectionPool=null;
	private static void getMapping()
	{
		URI dbUri;
		try {
			dbUri = new URI("mysql://bbd6032aafd0b8:95fe8fa0@eu-cdbr-west-02.cleardb.net/heroku_6fca6f9bee22f9c");
		
	  String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
	  connectionPool = new BasicDataSource();

	  if (dbUri.getUserInfo() != null) {
	    connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
	    connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
	  }
	  connectionPool.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  connectionPool.setUrl(dbUrl);
	  connectionPool.setInitialSize(1);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		if(connectionPool == null)
			getMapping();
		try {
			return connectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	
}