package com.giogandola.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.giogandola.beans.User;
import com.giogandola.dao.LoginDAO;

@WebServlet("/LoginValidatorController")
public class LoginValidatorController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	//mapping
	private static final String on_success="/LayerPrinterController";
	private static final String on_fail="/sign-in.jsp";
	
    public LoginValidatorController() {super();}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User userLogged =null;
		LoginDAO loginDao = new LoginDAO();
		HttpSession session=request.getSession(true);
		
		userLogged = loginDao.userLogin(request.getParameter("username"), request.getParameter("password"));	
		session.setAttribute("user",  userLogged);
		if (userLogged!=null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(on_success);
			dispatcher.forward(request, response);
		}
		else
			response.sendRedirect(request.getContextPath() + on_fail);
		
	}

}
