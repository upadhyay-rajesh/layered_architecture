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
import com.instagramweb.entity.State;
import com.instagramweb.service.InstagramService;
import com.instagramweb.service.InstagramServiceInterface;


public class LoadStateServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("countryName");
		System.out.println(cname);
		Country c=new Country();
		c.setCountryName(cname);
		
		InstagramServiceInterface lc = new InstagramService();
		 ArrayList<State> st = lc.loadStateService(c);
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		out.println("<select id=state1>");
		for(State c2:st) {
			out.println("<option>"+c2.getStateName()+"</option>");
		}
		out.println("</select></center></body></html>");
	}

}
