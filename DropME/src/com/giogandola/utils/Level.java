package com.giogandola.utils;

import java.util.ArrayList;

import com.giogandola.beans.Document;
import com.giogandola.beans.Folder;
import com.giogandola.interfaces.LayerInterface;


public class Level implements LayerInterface
{
	private ArrayList<Folder> folders=null;
	private ArrayList<Document> documents=null;
	
	public Level(ArrayList<Folder> folders,ArrayList<Document> documents)
	{
		this.folders=folders;
		this.documents=documents;
	}
	
	public Level(){init();}
	
	private void init()
	{
		this.folders=new ArrayList<Folder>();
		this.documents=new ArrayList<Document>();
	}
	
	public void addFolder(Folder folder)
	{
		if(this.folders==null)
			this.init();
		this.folders.add(folder);
	}
	
	public void addDocument(Document document)
	{
		if(this.documents==null)
			this.init();
		this.documents.add(document);
	}
	
	public ArrayList<Document> getDocuments(){return this.documents;}
	public ArrayList<Folder> getFolders(){return this.folders;}
	public void cleanLayer() {this.folders.clear();this.documents.clear();}

}
