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
import com.giogandola.dao.NextLayerDAO;

/**
 * If user set extract layer with file ad folders and forward else forward to error page
 */
@WebServlet("/LayerPrinterController")
public class LayerPrinterController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String on_success="/user_home.jsp";
	private static final String on_error="/error_page.html";

    public LayerPrinterController() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession(true);
		User userLogged =(User) session.getAttribute("user");
		
		if(userLogged!=null)	//only if user logged into session else to error page
		{
			NextLayerDAO nLayer =null;
			System.out.println();
			if(request.getParameter("nextLayer")!=null)//if is not the root extract subroot
				{
					nLayer=new NextLayerDAO(userLogged.getIdUser(),(Integer.parseInt(request.getParameter("nextLayer"))));
				}
			else	
				nLayer=new NextLayerDAO(userLogged.getIdUser());
			
			dispatcher= request.getServletContext().getRequestDispatcher(on_success);
			System.out.println("N_FOLD: "+nLayer.getFolders().size()+" N_F: "+nLayer.getDocuments().size());
			request.setAttribute("folders", nLayer.getFolders());	
			request.setAttribute("documents", nLayer.getDocuments());
			
		}
		else
			dispatcher= request.getServletContext().getRequestDispatcher(on_error);
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		doGet(request, response);
	}

}
