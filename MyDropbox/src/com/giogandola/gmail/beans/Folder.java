package com.giogandola.gmail.beans;

public class Folder {
	
	private int idFolder;
	private String name;
	private String dateCreation;
	private String dateUpdate;
	private int upFolder;

	public Folder(int id, String nam, String datCreat, String datUpdat, int upFol) {
		this.idFolder = id;
		this.name = nam;
		this.dateCreation = datCreat;
		this.dateUpdate = datUpdat;
		this.upFolder = upFol;
	}
	
	public void setIdFolder(int id) {
		this.idFolder = id;
	}
	public void setName(String nam) {
		this.name = nam;
	}
	public void setDateCreation(String datCreat) {
		this.dateCreation = datCreat;
	}
	public void setDateUpdate(String datUpdat) {
		this.dateUpdate = datUpdat;
	}
	public void setUpFolder(int upFol) {
		this.upFolder = upFol;
	}
	
	public int getIdFolder() {
		return this.idFolder;
	}
	public String getName() {
		return this.name;
	}
	public String getDateCreation() {
		return this.dateCreation;
	}
	public String getDateUpdate() {
		return this.dateUpdate;
	}
	public int getUpFolder() {
		return this.upFolder;
	}

}
