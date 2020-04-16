package com.giogandola.gmail.interfaces;

import com.giogandola.gmail.beans.Document;
import com.giogandola.gmail.beans.Folder;

public interface UpdateData 
{
	public boolean updateFolderPos(Folder folder,Integer newUpFolderID);
	public boolean updateDocumentPos(Document document,Integer newUpFolderID);
	public boolean renameDocument(Document document,String newName);
	public boolean renameFolder(Folder folder,String newName);
	public boolean eraseDocument(Document document);
	public boolean eraseFolder(Folder folder);
	public boolean createFolder(Folder folder);

}
