

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
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int roll=Integer.parseInt(request.getParameter("Roll"));
		String url = "jdbc:mysql://localhost:3306/CSE";
		Statement smt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","krishna@inty");
			
//			if(con!=null)
//			pw.println("Connection established");
			
			smt = con.createStatement();
			String s = "select * from Student where RollNo="+roll ;
			
	                    
	                  
			ResultSet rs=smt.executeQuery(s);
			if(rs.next()) {
				pw.print("User found");
				int rno=rs.getInt("RollNo");
				String nam=rs.getString("name");
				int age=rs.getInt("Age");
				int cgpa=rs.getInt("CGPA");
				pw.print("<!DOCTYPE html>\n"
						+ "<html lang=\"en\">\n"
						+ "<head>\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Document</title>\n"
						+ "</head>\n"
						+ "<body>\n"
						+ "    <form action=\"Updated\">\n"
						+ "		<label>RollNo</label>\n"
						+ "		<input type=\"number\" name=\"Roll\" value=\""+rno+"\"/>\n"
						+ "		<br/>\n"
						+ "		<label>Name</label>\n"
						+ "		<input type=\"text\" name=\"Name\" value=\""+nam+"\"/>\n"
						+ "		<br/>\n"
						+ "		<label>Age</label>\n"
						+ "		<input type=\"number\" name=\"Age\" value=\""+age+"\"/>\n"
						+ "		<br/>\n"
						+ "		<label>CGPA</label>\n"
						+ "		<input type=\"number\" name=\"CGPA\" value=\""+cgpa+"\"/>\n"
						+ "		<br/>\n"
						+ "		<input type=\"submit\" value=\"Update\"/>\n"
						+ "	</form>\n"
						+ "</body>\n"
						+ "</html>");
			}
			
			else
				pw.print("Not found");
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
