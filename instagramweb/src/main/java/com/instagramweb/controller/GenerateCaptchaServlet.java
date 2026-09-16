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

public class GenerateCaptchaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(Math.random());
		int i = (int)((Math.random())*10000);
		System.out.println(i);
		
		PrintWriter out = response.getWriter(); //how servlet will write response on browser using PrintWriter object
		response.setContentType("text/html"); //how to set in which format servlet will give response
		out.println("<html><body><center>");
		out.println("<input type=text name=cc id=cc value="+i+" disabled><input type=button value=refresh onclick=generatecaptcha()>");
		out.println("<tr><td>enter the text of above box <input type=hidden id=hh value="+i+" ><input type=text name=dd id=dd><input type=button value=verify onclick=verifycapcha()></td></tr>");
		out.println("</center></body></html>");
	}

}
