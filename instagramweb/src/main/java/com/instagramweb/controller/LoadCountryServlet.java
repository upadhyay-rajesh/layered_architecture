package com.instagramweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.instagramweb.entity.Country;
import com.instagramweb.service.InstagramService;
import com.instagramweb.service.InstagramServiceInterface;


public class LoadCountryServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstagramServiceInterface lc = new InstagramService();
		 ArrayList<Country> cr = lc.loadCountryService();
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		out.println("<select id=country1>");
		for(Country c2:cr) {
			out.println("<option>"+c2.getCountryName()+"</option>");
		}
		out.println("</select></center></body></html>");
	}

}
