package com.student.model;

public class ForgotPass {
      private String useremail;
      private String code;
	public ForgotPass(String useremail, String code) {
		super();
		this.useremail = useremail;
		this.code = code;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
      
}
