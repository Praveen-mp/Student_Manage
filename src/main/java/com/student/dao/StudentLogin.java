package com.student.dao;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.student.model.UserLogin;



/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/studentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno=request.getParameter("rollno");
		String pass = request.getParameter("password");
		String code="null";
		PrintWriter out = response.getWriter();
		UserLogin user = new UserLogin(rollno, pass,code);
		
		LoginDa loginDAO = new LoginDa();
		String result = "";
		try {
			result = loginDAO.authenticateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.sendRedirect("HomePage.jsp");
		System.out.println();

		System.out.println(result);
		if(result.equals("success")) {
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			response.sendRedirect("HomePage.jsp");
			out.print("welcome");
		}else {
//			response.sendRedirect("error.html");
			out.print("nothing");
		}
		System.out.println();

		System.out.println(result);
	}

}
