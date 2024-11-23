package com.csed.Mavenwebpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

@WebServlet("/insertstudent")
public class InsertStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data from request
        int rno = Integer.parseInt(request.getParameter("rno"));
        String name = request.getParameter("name");
        String brn = request.getParameter("brn");

        // Create new Student1 object and set values
        Student1 student = new Student1();
        student.setRno(rno);
        student.setName(name);
        student.setBrn(brn);

        // Initialize Hibernate Session
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Save student to the database
            session.save(student);
            transaction.commit();
            
            // Set a success message in the request
            request.setAttribute("message", "Student inserted successfully!");
            
            // Forward to the JSP page to display the message
            request.getRequestDispatcher("insertStudentResult.jsp").forward(request, response);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            request.setAttribute("message", "Error inserting student!");
            request.getRequestDispatcher("insertStudentResult.jsp").forward(request, response);
        } finally {
            session.close();
        }
    }
}