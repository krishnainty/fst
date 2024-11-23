package com.cse.HibDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Students s= new Students();
        s.setRno(2);
        s.setName("abcd");
        s.setBrn("cse");
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class);
        SessionFactory sf = con.buildSessionFactory();
        Session se = sf.openSession();
        Transaction tx = se.beginTransaction();
        se.save(s);
        tx.commit();
    }
}
