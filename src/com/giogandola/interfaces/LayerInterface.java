package com.giogandola.interfaces;

import java.util.ArrayList;

import com.giogandola.beans.Document;
import com.giogandola.beans.Folder;


public interface LayerInterface 
{
	public void addFolder(Folder folder);
	public void addDocument(Document document);
	public ArrayList<Document> getDocuments();
	public ArrayList<Folder> getFolders();
}
