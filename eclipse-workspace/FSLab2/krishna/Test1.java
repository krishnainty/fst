

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Servlet implementation class Test1
 */
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType ("text/html");
		PrintWriter pw=response.getWriter();
		Connection con=null; 
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		try {
		Class. forName ("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/skillplusplus", "root","krishna@inty");
		stmt = con.createStatement();
		
		rs = stmt.executeQuery("select * from User");
		while (rs.next()) {
		pw.print("<br›"+rs.getString("Name")+", "+rs.getString("Email"));
		}
		}// End of try block
		catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}