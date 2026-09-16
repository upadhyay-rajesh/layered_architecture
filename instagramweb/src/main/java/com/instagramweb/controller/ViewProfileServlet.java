package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.instagramweb.entity.InstagramUser;
import com.instagramweb.service.InstagramService;
import com.instagramweb.service.InstagramServiceInterface;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email = ss.getAttribute("myemail").toString();
		
		InstagramUser iu=new InstagramUser();
		iu.setEmail(email);
		
		InstagramServiceInterface is = new InstagramService();
		InstagramUser iu1 = is.viewProfileService(iu);
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		if(iu1!=null) {
			out.println("your profile is ");
			out.println("<br> your name is "+iu1.getName());
			out.println("<br> your password is "+iu1.getPassword());
			out.println("<br> your email is "+iu1.getEmail());
			out.println("<br> your address is "+iu1.getAddress());
			out.println("<br> your age is "+iu1.getAge());
			
		
		}
		else {
			out.println("profile not found");
		}
		out.println("</center></body></html>");
	}

}
