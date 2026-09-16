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


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("p");
		String email = request.getParameter("e");
		
		InstagramUser iu = new InstagramUser();
		iu.setPassword(password);
		iu.setEmail(email);
		
		InstagramServiceInterface is = new InstagramService();
		int i = is.loginProfileService(iu);
		
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		if(i>0) {
			HttpSession ss = request.getSession(true);
			ss.setAttribute("myemail", email);
			out.println("Welcome "+email+" <a href=ViewProfileServlet>view profile</a>|| <a href=EditProfileServlet>edit profile</a> to continue");
			
		
		}
		else {
			out.println("invalid id and password <a href=signin.html>Try Again</a>");
		}
		out.println("</center></body></html>");
		
	}

}
