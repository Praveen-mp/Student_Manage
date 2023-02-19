package com.student.web;
//package com.exam.web.course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.model.UserLogin;



/**
 * Servlet implementation class VerifyMailCode
 */
@WebServlet("/VerifyMail")
public class VerifyMailCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		UserLogin user = (UserLogin) session.getAttribute("authcode");
		String name=null,pass=null;
		String code=request.getParameter("usermail");
		UserLogin user = new UserLogin(name,pass,code);
		System.out.println(user.getCode());
//		String code = request.getParameter("authcode");
		if(code.equals(user.getCode())) {
			out.print("Verification done");
			response.sendRedirect("PassUpdate.jsp");
		}else {
			out.print("Incorrect Code");
		}
	}
}
