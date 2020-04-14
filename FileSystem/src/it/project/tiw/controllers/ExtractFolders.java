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

import it.project.tiw.beans.Folder;
import it.project.tiw.beans.User;
import it.project.tiw.dao.ExtractFoldersDAO;
import it.project.tiw.dbmanager.DbUtil;


public class ExtractFolders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	static String path="/home_page.jsp";
	static boolean isMoved=false;
	
    public ExtractFolders() 
    {
        super();
    }
     
    public void init() throws ServletException {}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conn=DbUtil.getConnection();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		ArrayList<Folder> userFolders = new ArrayList<Folder>();
		User userLogged = null;
		userLogged = (User) request.getAttribute("userLogged");
		ExtractFoldersDAO estractFoldersDao = new ExtractFoldersDAO();
		userFolders = estractFoldersDao.estractUserFolders(userLogged.getIdUser());
		
		setSesssionAttr(request.getSession(true),userLogged,userFolders,isMoved);
		
		if(userFolders.isEmpty()==true)
			System.out.println("Accesso effettuato: al momento non possiedi alcuna cartella");
		else
			System.out.println("Accesso effettuato: ecco il tuo albero delle cartelle");
		dispatcher.forward(request, response);
	}
	
	private void setSesssionAttr(HttpSession session,User userLogged,ArrayList<Folder> userFolders,boolean isMoved)
	{
		session.setAttribute("userLogged", userLogged); //Inserisce l'utente nella sessione
		session.setAttribute("userFolders", userFolders); //Inserisce le cartelle nella sessione
		session.setAttribute("isMoved", isMoved);
	}
	   
}
