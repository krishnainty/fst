

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreatingTable
 */
public class CreatingTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatingTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			String s = "CREATE TABLE Student " +
	                   "(RollNo INTEGER not NULL, " +
	                   " Name VARCHAR(255)," +  "Age INTEGER," + "CGPA INTEGER)"  ;
	                    
	                  
			smt.executeUpdate(s);
			
			pw.println("Table Created..");
			
			String st = "";
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
