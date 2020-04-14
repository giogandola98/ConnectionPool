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

import it.project.tiw.dao.RegisterDAO;
import it.project.tiw.dbmanager.DbUtil;


public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	
    public Register() {
    	super();
    }
	public void init() throws ServletException {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		conn=DbUtil.getConnection();
		RequestDispatcher dspatcher = null;
		boolean isUserCreated=registerUser(conn,request.getParameter("user"),request.getParameter("pass"),request.getParameter("repPass"));
		if(isUserCreated)
		{
			String path ="/sign-in.jsp";
			dspatcher = request.getServletContext().getRequestDispatcher(path);
			System.out.println("Utente registrato correttamente: reindirizzamento alla pagina di accesso");
		}
		else 
		{
			String path ="/sign-up.jsp";
			dspatcher = request.getServletContext().getRequestDispatcher(path);
			System.out.println("Utente non registrato correttamente: reindirizzamento alla pagina di registrazione");
		}
		request.setAttribute("registerStatus", isUserCreated);
		dspatcher.forward(request, response);
	}
	
	private boolean registerUser(Connection conn,String username, String pass, String repass) throws ServletException
	{
		if(pass.equals(repass))
		{
			RegisterDAO registerDao = new RegisterDAO();
			return registerDao.userRegistration(username, pass);
		}
		else 
			return false;		
	}
	   
}
