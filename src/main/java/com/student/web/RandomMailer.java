package com.student.web;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.student.model.ForgotPass;
import com.student.model.UserLogin;


public class RandomMailer {
      public String getRandom() {
    	  Random random = new Random();
    	  int num = random.nextInt(99999);
    	  
    	  return String.format("%06d", num);
      }
      public boolean sendEmail(ForgotPass user) {
    	  boolean res=false;
    	    String toEmail=user.getUseremail();
    	    String fromEmail="pravinkabi6@gmail.com";
    	    String password = "cuayhjzhrlyppvsn";
    	    try {
    	    	Properties p = new Properties();
    	    	p.setProperty("mail.smtp.host", "smtp.gmail.com");
    	    	p.setProperty("mail.smtp.port", "465");
    	    	p.setProperty("mail.smtp.auth", "true");
    	    	p.setProperty("mail.smtp.starttls.enable", "true");
    	    	p.put("mail.smtp.socketFactory.port", "465");
    	    	p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	    	
    	    		Session session = Session.getInstance(p, new Authenticator() {
    	    			@Override
    	    			protected PasswordAuthentication getPasswordAuthentication() {
    	    				return new PasswordAuthentication(fromEmail,password);
    	    			}
    	    		});
//    	    		System.out.println(session);
    	    		Message mess = new MimeMessage(session);
//    	    		System.out.println(mess);
//    	    		System.out.println(new InternetAddress(fromEmail));
    	    		mess.setFrom(new InternetAddress(fromEmail));
//    	    		System.out.println(Message.RecipientType.TO);
//    	    		System.out.println(new InternetAddress(user.getUsername()));
    	    		mess.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getUseremail()) );
    	    		mess.setSubject("User Email Verfication");
    	    		mess.setText("Make a payment");
    	    		System.out.println(mess);
    	    		Transport transport = session.getTransport();
    	    		transport.connect(p.getProperty("mail.smtp.host"), 465, "pravinkabi6@gmail.com", "cuayhjzhrlyppvsn");
    	    		transport.sendMessage(mess,mess.getRecipients(Message.RecipientType.TO));
    	    		res=true;
    	    }catch(Exception e) {
    	    	e.printStackTrace();
    	    }
			return res;
      }
}
