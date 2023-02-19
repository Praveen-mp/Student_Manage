/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.student.dao.DBUtil;

import java.io.PrintWriter;
import static java.lang.System.out;

/**
 *
 * @author kishan
 */
public class UpdateBean {
    private String id,name,gender,cgpa;
    
    public UpdateBean(String id, String name, String gender, String cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.cgpa = cgpa;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
    
   

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    public int Update() throws NamingException, SQLException{
        int j=0;
       
        try (Connection con = DBUtil.getConnection()) {
                
                
                String sql = ("Update LOGAUTH set sname=?,sgender=?,scgpa=? where sid=?");
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,gender);
                ps.setString(3,cgpa);
                ps.setString(4,id);
                j = ps.executeUpdate();
            
           
        }
        catch(Exception e){
            System.out.println(e);
        }
        return j;
            
        
            
    }   
    } 


