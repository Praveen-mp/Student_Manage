package com.student.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.student.model.DeleteBean;
import com.student.model.UpdateBean;
import com.student.model.updatePass;

/**
 * Servlet implementation class changePass
 */
@WebServlet("/changePassword")
public class changePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, NamingException, SQLException {
//        
//    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        	String srollno=request.getParameter("sroll");
            String spass=request.getParameter("spass");
            updatePass bean1=new updatePass(srollno,spass);
            bean1.setPass(spass);
            bean1.setRoll(srollno);
            int res = bean1.Update();
            System.out.println(res);
             if(res==0)
            {
                out.println("<script>alert('Sorry! Invalid ID')");
                out.println("location='HomePage.jsp';");
                out.println("</script>");
                
            }
             else{
            response.sendRedirect("PasswordCode.html");
             }        
            

        }
        catch(Exception e){
            System.out.println(e);
        }
		doGet(request, response);
	}

}
