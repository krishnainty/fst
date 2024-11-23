package com.m4;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.Optional;


/**
 * Servlet implementation class CourseSelection
 */
public class CourseSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSelection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		int id = Integer.parseInt(request.getParameter("id"));
		
		CourseAllocation object = new CourseAllocation();
		
		Optional<Course> optional = object.getCid(id);
		
		
		
		if(optional.isEmpty())
		{
			response.sendRedirect("error.jsp");
		}
		else
		{
			request.setAttribute("course", optional.get());
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
