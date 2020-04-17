package com.giogandola.beans;

public class User {
	private int idUser;
	private String user;
	private String password;

	public User(int id, String usr, String pass) {
		this.idUser = id;
		this.user = usr;
		this.password = pass;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void setUser(String usr) {
		this.user = usr;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public int getIdUser() {
		return this.idUser;
	}
	public String getUser() {
		return this.user;
	}
	public String getPassword() {
		return this.password;
	}

}
