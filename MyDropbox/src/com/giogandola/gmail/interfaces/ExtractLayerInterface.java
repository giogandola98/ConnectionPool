package com.giogandola.gmail.interfaces;

import java.util.ArrayList;

import com.giogandola.gmail.beans.Document;
import com.giogandola.gmail.beans.Folder;

public interface ExtractLayerInterface 
{
	public ArrayList<Folder> getFolders();
	public ArrayList<Document> getDocuments();
	public void extractLayer(Integer upLayerIndex);

}
