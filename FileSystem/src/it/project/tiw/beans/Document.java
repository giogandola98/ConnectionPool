package it.project.tiw.beans;

public class Document {
	
	private int propFolder;
	private String name;
	private String type;
	private String dateCreation;
	private String dateUpdate;
	private String summary;

	public Document(int pF, String nam, String ext, String datCreat, String datUpdat, String text) {
		this.propFolder = pF;
		this.name = nam;
		this.type = ext;
		this.dateCreation = datCreat;
		this.dateUpdate = datUpdat;
		this.summary = text;
	}
	
	public void setPropFolder(int pF) {
		this.propFolder = pF;
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
	public void setSummary(String text) {
		this.summary = text;
	}
	public void setType(String ext) {
		this.type = ext;
	}
	
	public int getPropFolder() {
		return this.propFolder;
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
	public String getSummary() {
		return this.summary;
	}
	public String getType() {
		return this.type;
	}

}
