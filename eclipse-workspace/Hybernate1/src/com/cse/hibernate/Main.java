package com.cse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo s=new StudentInfo();
		s.setRno(4);
		s.setName("abc");
		Configuration cfg=new Configuration();  
  cfg.configure("hibernate.cfg.xml");

	    SessionFactory factory=cfg.buildSessionFactory(); 	      
	    //creating session object  
	    Session session=factory.openSession();  	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	    session.persist(s);//persisting the object  	      
	    t.commit();  
	    session.close();  	      
	    System.out.println("successfully saved");  
	}
}
