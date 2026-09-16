package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.instagramweb.entity.InstagramUser;
import com.instagramweb.service.InstagramService;
import com.instagramweb.service.InstagramServiceInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CheckEmailServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		InstagramUser iu=new InstagramUser();
		iu.setEmail(email);
		
		InstagramServiceInterface is=new InstagramService();
		int i =is.checkEmailService(iu);
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		
		if(i>0) {
			out.println("<font color=red>email already exist</font>");
		}
		else {
			out.println("<font color=green>valid email</font>");
		}
		out.println("</center></body></html>");
	}

}
