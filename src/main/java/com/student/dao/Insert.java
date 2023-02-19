/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import com.student.model.InsertPojo;
import com.student.model.UpdateBean;
import com.student.model.UserLogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Insert")
public class Insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             try{
//              Context cx=  new InitialContext();
//              DataSource ds=  (DataSource)cx.lookup("StudentResource");
            	 ResultSet r;
              String sql="insert into LOGAUTH values (?,?,?,?)";
              String sql1="insert into PASSWORDCHANGER values (?,?)";
              String sId = request.getParameter("sid");
              String sName = request.getParameter("sname");
              String sGender = request.getParameter("sgender");
              String sCgpa = request.getParameter("scgpa");
              class Node{
            		String sid;
            		String sname;
            		String sgender;
            		String scgpa;
            		Node next;
            		public Node(String sid, String sname, String sgender, String scgpa) {
            			super();
            			this.sid = sid;
            			this.sname = sname;
            			this.sgender = sgender;
            			this.scgpa = scgpa;
//            			this.next = next;
            		}
            		
            	}
              Connection con=  DBUtil.getConnection();
              Node t = new Node(sId,sName,sGender,sCgpa);
              PreparedStatement ps = con.prepareStatement(sql);
              PreparedStatement ps1 = con.prepareStatement(sql1);
//              @SuppressWarnings("hiding")
			  Node head = new Node(sId,sName,sGender,sCgpa);
          	
          	//check function to check record is already exist or not
          	
          		//base case
			 
			  
          		InsertPojo i = new InsertPojo(sId, sName, sGender, sCgpa);
          		 DuplicateChecck d = new DuplicateChecck();
          		boolean b=d.authenticateUser(i);
          		System.out.println(b);
           
              if (d.authenticateUser(i)) {
                  response.sendRedirect("DuplicateDetails.html");
                  return;
              }else {
//            	  Node k=new Node(sid, sname, sgender, scgpa);
            	  t.sid=sId;
            	  t.sname=sName;
            	  t.sgender=sGender;
            	  t.scgpa=sCgpa;
            	 //insert at begin
            	  String f=head.sid;
            	  String q=t.sid;
            	  int x=Integer.parseInt(f);
            	  int y=Integer.parseInt(q);
            	  if(head==null || x>=y) {
            		  t.next=head;
            		  head=t;
            		  ps.setString(1, t.sid);
                      ps.setString(2, t.sname);
                      ps.setString(3, t.sgender);
                      ps.setString(4, t.scgpa);
                      ps1.setString(1, t.sid);
                      ps1.setString(2,t.sid+"eee");
//                      System.out.println(head.sid);
                      ps.executeUpdate();
                      ps1.executeUpdate();
            	  }
            	  //insert at mid or end
            	  else {
            		  Node c = head;
            		  String h=c.next.sid;
            		  String k=t.next.sid;
            		  int q1=Integer.parseInt(h);
            		  int z=Integer.parseInt(k);
            		  while(c.next!=null && q1<z) {
            			  c=c.next;
            		  }
            		  t.next=c.next;
            		  c.next=t;
            		  ps.setString(1, c.sid);
                      ps.setString(2, c.sname);
                      ps.setString(3, c.sgender);
                      ps.setString(4, c.scgpa);
                      ps1.setString(1, t.sid);
                      ps1.setString(2,t.sid+"eee");
                      ps.executeUpdate();
                      ps1.executeUpdate();
//                      System.out.println(c.sid);
            	  }
            	  
             
              }
              
              
              response.sendRedirect("HomePage.jsp");
              
          }catch(Exception e){
              out.println("Error occured : " +e);
          }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
