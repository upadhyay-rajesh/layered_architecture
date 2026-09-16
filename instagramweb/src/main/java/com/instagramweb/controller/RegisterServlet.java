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


//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("n"); //here servlet is taking data from html input box name n using request.getPrameter() method
		String password = request.getParameter("p");
		String email = request.getParameter("e");
		String address = request.getParameter("a");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age); //here converting string age into int age1 using Integer.parseInt() method
		
		InstagramUser iu = new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		iu.setAge(age1);
		
		InstagramServiceInterface is = new InstagramService();
		int i = is.createProfileService(iu);
		
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		if(i>0) {
			out.println("your profile created please <a href=signin.html>click here</a> to continue");
			
		
		}
		else {
			out.println("oops something wrong");
		}
		out.println("</center></body></html>");
	}

}
