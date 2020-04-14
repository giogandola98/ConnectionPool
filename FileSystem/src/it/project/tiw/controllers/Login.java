package it.project.tiw.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.project.tiw.beans.User;
import it.project.tiw.dao.LoginDAO;
import it.project.tiw.dbmanager.DbUtil;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	
    public Login() {super();}   

    public void init() throws ServletException 
    {
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDao = new LoginDAO();
		User userLogged = loginDao.userLogin(request.getParameter("username"), request.getParameter("password"));
		RequestDispatcher dispatcher = null;
		if(userLogged.getIdUser()!=0) 
		{
			System.out.println("L'username inserito corrisponde ad quello di un utente registrato, reindirizzamento...");
			dispatcher = request.getRequestDispatcher("ExtractFolders");
			request.setAttribute("userLogged", userLogged);
			dispatcher.forward(request, response);
		}
		else 
		{
			String path ="/sign-in.jsp";
			System.out.println("Credenziali utente errate, reindirizzamento...");
			dispatcher = request.getServletContext().getRequestDispatcher(path);
			request.setAttribute("failedLogin", false);
			dispatcher.forward(request, response);
		}
	}
       

}
