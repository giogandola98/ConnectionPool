package it.project.tiw.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.project.tiw.beans.Document;
import it.project.tiw.dao.ExtractDocumentsDAO;
import it.project.tiw.dbmanager.DbUtil;

public class ExtractDocuments extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	static String path="/documents.jsp";
       

    public ExtractDocuments() {
        super();
    }

    public void init() throws ServletException {}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	conn=DbUtil.getConnection();
    	ArrayList<Document> documentsInFolder = new ArrayList<Document>();
    	ExtractDocumentsDAO estractDocumentsDao = new ExtractDocumentsDAO();
    	HttpSession session = request.getSession(true);
    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(path);
    	
    	documentsInFolder = estractDocumentsDao.estractFolderDocuments(Integer.parseInt(request.getParameter("idFolder")));

    	if(documentsInFolder.isEmpty())
    		System.out.println("Non sono presenti documenti in questa cartella");
    	else
    		System.out.println("Restituzione documenti in corso");
    	
		session.setAttribute("documents", documentsInFolder);
    	dispatcher.forward(request, response);
	}
    public void destroy() {
 		
 	}	
	

}
