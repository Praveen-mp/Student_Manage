package com.student.model;

public class InsertPojo {
     private String sid;
     private String sname;
     private String sgender;
     private String scgpa;
	public InsertPojo(String sid, String sname, String sgender, String scgpa) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sgender = sgender;
		this.scgpa = scgpa;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getScgpa() {
		return scgpa;
	}
	public void setScgpa(String scgpa) {
		this.scgpa = scgpa;
	}
	@Override
	public String toString() {
		return "InsertPojo [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender + ", scgpa=" + scgpa + "]";
	}
     
}
