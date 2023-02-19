package com.student.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.student.model.InsertPojo;

public class DuplicateChecck {
//	 private ResultSet rs;
		private Connection con;

		public boolean authenticateUser(InsertPojo user) throws SQLException {
			
			try {
				con=DBUtil.getConnection();
				PreparedStatement pst = con.prepareStatement("select * from LOGAUTH");
//				pst.setString(1,user.getSid());
//				pst.setString(1,user.getSname());
				ResultSet rs = pst.executeQuery();
//				System.out.println(rs.getString(1));
//				System.out.print(rs.getString(1)+" "+user.getSid());
				while(rs.next()) {
//					System.out.print(rs.getString(1)+" "+user.getSid());
					if(user.getSid().equals(rs.getString(1))) {
						return true;
					}
				}
			
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			return false;
		}
		
}
