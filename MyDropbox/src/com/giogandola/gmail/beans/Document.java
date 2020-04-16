package com.giogandola.gmail.beans;

public class Document {
	
	private int propFolder;
	private String name;
	private String type;
	private String dateCreation;
	private String dateUpdate;
	private String summary;
	private String filename;

	public Document(int pF, String nam, String ext, String datCreat, String datUpdat, String text, String filename) {
		this.propFolder = pF;
		this.name = nam;
		this.type = ext;
		this.dateCreation = datCreat;
		this.dateUpdate = datUpdat;
		this.summary = text;
		this.filename=filename;
	}
	
	public void setFileName(String fn) 	{this.filename=fn;}
	public void setPropFolder(int pF)  	{this.propFolder = pF;}
	public void setName(String nam) 	{this.name = nam;}
	public void setCreation_d(String datCreat) {this.dateCreation = datCreat;}
	public void setUpdate_d(String datUpdat) {this.dateUpdate = datUpdat;}
	public void setSummary(String text) {this.summary = text;}
	public void setType(String ext) {this.type = ext;}
	
	public int getPropFolder() {return this.propFolder;}
	public String getName() {return this.name;}
	public String getDateCreation() {return this.dateCreation;}
	public String getDateUpdate() {return this.dateUpdate;}
	public String getSummary() {return this.summary;}
	public String getType() {return this.type;}
	public String getFileName() {return this.filename;}
}
