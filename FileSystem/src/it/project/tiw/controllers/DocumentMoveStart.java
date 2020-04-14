package it.project.tiw.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.project.tiw.beans.Document;


public class DocumentMoveStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path="/home_page.jsp";
	static boolean isFolderMoving = true;
	
    public DocumentMoveStart() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    public void init() throws ServletException { }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Document docFolderMoving = new Document(Integer.parseInt(request.getParameter("propFolder")), request.getParameter("name"), request.getParameter("type"), "", "", "");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		request.setAttribute("docMoved", docFolderMoving);
		request.setAttribute("isMoved", isFolderMoving);
		dispatcher.forward(request, response);
	}
	
}
