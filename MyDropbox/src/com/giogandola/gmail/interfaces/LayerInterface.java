package com.giogandola.gmail.interfaces;

import java.util.ArrayList;

import com.giogandola.gmail.beans.Document;
import com.giogandola.gmail.beans.Folder;

public interface LayerInterface 
{
	public void addFolder(Folder folder);
	public void addDocument(Document document);
	public ArrayList<Document> getDocuments();
	public ArrayList<Folder> getFolders();
}
