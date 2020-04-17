package com.giogandola.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giogandola.beans.Document;

@WebServlet("/ExtractDocumentInfo")
public class ExtractDocumentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String path = "/documentInfo.jsp";
	
    public ExtractDocumentInfo() {super();}
    public void init() throws ServletException { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Document inspectedDoc = new Document(0,  request.getParameter("name"), request.getParameter("type"), request.getParameter("dateCreat"), request.getParameter("dateUpdat"), request.getParameter("summary"),"");
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(path);
		request.setAttribute("docInfo", inspectedDoc);
		dispatcher.forward(request, response);
	}
	

}
