

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Insertion
 */
public class Insertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter pw = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/CSE";
		Statement smt = null;
		//Object Connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","krishna@inty");
			
			if(con!=null)
			pw.println("Connection established");
			
			smt = con.createStatement();
			int roll = Integer.parseInt(request.getParameter("Roll")); 
	        String name = request.getParameter("Name"); 
	        int age = Integer.parseInt(request.getParameter("Age")); 
	        int cgpa = Integer.parseInt(request.getParameter("CGPA")); 
			//String s = "Insert into Student (RollNo,Name) Values (roll,Name)" ;
	        PreparedStatement st = con .prepareStatement("insert into student values(?, ?,?,?)");
			st.setInt(1, roll);
			st.setString(2, name);
			st.setInt(3, age);
			st.setInt(4, cgpa);
			
			
			st.executeUpdate();
	                    
	                  
			
			
			//pw.println("Values Inserted");
			response.sendRedirect("Displaying");
			
			
		}
	    catch(SQLException | ClassNotFoundException e){
			throw new Error("Error", e);
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
