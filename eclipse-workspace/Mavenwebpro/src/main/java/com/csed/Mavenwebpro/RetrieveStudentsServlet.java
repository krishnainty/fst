package com.csed.Mavenwebpro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

@WebServlet("/retrievestudents")
public class RetrieveStudentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialize Hibernate Session
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            // Query to retrieve all students
            Query<Student1> query = session.createQuery("from Student1", Student1.class);
            List<Student1> students = query.getResultList();

            // Set the student list as a request attribute
            request.setAttribute("students", students);

            // Forward the request to displayStudents.jsp for rendering the student list
            request.getRequestDispatcher("displayStudents.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error retrieving students!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            session.close();
        }
    }
}