package com.giogandola.interfaces;

import java.util.ArrayList;

import com.giogandola.beans.Document;
import com.giogandola.beans.Folder;


public interface ExtractLayerInterface 
{
	public ArrayList<Folder> getFolders();
	public ArrayList<Document> getDocuments();
	public void extractLayer(Integer upLayerIndex);

}
