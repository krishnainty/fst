package com.cse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Retrive {
	public static void main(String args[]) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file

        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        //Query query = session.createQuery("from StudentInfo");
        
//        java.util.List list = query.list();
//        System.out.println(list);
//        for (Object student : list) {
//        	StudentInfo s1=(StudentInfo) student;
//            System.out.println(s1.rno+" "+s1.name);
//        }
        StudentInfo s1=session.get(StudentInfo.class);
        System.out.println(s1.rno+" "+s1.name);
        t.commit();
        
        session.close();
    }
}
