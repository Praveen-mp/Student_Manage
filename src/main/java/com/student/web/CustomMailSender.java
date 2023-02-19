package com.student.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student.model.ForgotPass;
import com.student.model.UserLogin;



/**
 * Servlet implementation class CustomMailSender
 */
//@WebServlet("/VerifyMail")
public class CustomMailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
		   String name= request.getParameter("usermail");
//		   String pass=request.getParameter("password");
		  
		   RandomMailer r = new RandomMailer();
		   String code  = r.getRandom();
		   System.out.println(name+" "+code);
		   System.out.println(code);
		   ForgotPass f = new ForgotPass(name,code);
		   r.sendEmail(f);
		   boolean test=r.sendEmail(f);
		   System.out.println(test);
		   if(test) {
			   HttpSession sess = request.getSession();
			   sess.setAttribute("authcode", code);
			   response.sendRedirect("index.html");
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
