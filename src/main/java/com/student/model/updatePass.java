package com.student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.student.dao.DBUtil;

public class updatePass {
	private ResultSet rs;
	private Connection con;
	private String roll;
    private String pass;
    public updatePass(String roll, String pass) {
		super();
		this.roll = roll;
		this.pass = pass;
	}
    public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int Update() throws NamingException, SQLException{
        int i=0;
        con=DBUtil.getConnection();
        
        try{
//        	String roll=getRoll();
//        	String pass=getPass();
            String sql=("Update PASSWORDCHANGER set rollno=?,password=? where rollno=?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roll);
            ps.setString(2, pass);
            ResultSet r=ps.executeQuery();
//            while(r.next()) {
//            	if(r.getString(1).equals(roll)) {
            		i = ps.executeUpdate();
//            		i=1;
//            	}
//            }
            
            con.close();
           
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(i);
        return i;
            
        
            
    }   
    } 


