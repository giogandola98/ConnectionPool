package it.project.tiw.controllers;
import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.project.tiw.dao.CompleteDocumentMoveDAO;
import it.project.tiw.dbmanager.DbUtil;


public class DocumentMoveEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	
    public DocumentMoveEnd() {
        super();
    }
       
    public void init() throws ServletException { }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conn=DbUtil.getConnection();
		int idPFDocMoved = Integer.parseInt(request.getParameter("idPF"));
		String namDocMoved = request.getParameter("nameDoc");
		String typeDocMoved = request.getParameter("typeDoc");
		int destination = Integer.parseInt(request.getParameter("docDestination"));
		CompleteDocumentMoveDAO complDocMoveDao = new CompleteDocumentMoveDAO();
		
		if(complDocMoveDao.completeDocumentMove(destination, idPFDocMoved, namDocMoved, typeDocMoved))
		{
			System.out.println("Aggiornamento della posizione del documento completato");	
			String path ="/ExtractDocuments?idFolder="+destination;
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
			dispatcher.forward(request, response);	
		}
	}
	   public void destroy() {
			
		}	
	
	
	
	

}
