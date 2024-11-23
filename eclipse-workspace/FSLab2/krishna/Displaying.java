

import jakarta.servlet.ServletException;
import java.sql.*;
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
 * Servlet implementation class Displaying
 */
public class Displaying extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Displaying() {
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
		
		String url = "jdbc:mysql://localhost:3306/CSE";
		Statement smt = null;
		//Object Connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","krishna@inty");
			
//			if(con!=null)
//			pw.println("Connection established");
			
			smt = con.createStatement();
			String s = "select * from Student" ;
	                    
	                  
			ResultSet rs=smt.executeQuery(s);
			pw.println("<!DOCTYPE html>\n"
					+ "<html lang=\"en\">\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <title>Document</title>\n"
					+ "    <style>@keyframes colorchange {\n"
					+ "        0% {\n"
					+ "          background: #ff0000;\n"
					+ "        }\n"
					+ "        14% {\n"
					+ "          background: #ffa500;\n"
					+ "        }\n"
					+ "        28% {\n"
					+ "          background: #ffff00;\n"
					+ "        }\n"
					+ "        42% {\n"
					+ "          background: #58ec58;\n"
					+ "        }\n"
					+ "        56% {\n"
					+ "          background: aqua;\n"
					+ "        }\n"
					+ "        70% {\n"
					+ "          background: #a12df4;\n"
					+ "        }\n"
					+ "        84% {\n"
					+ "          background: #ee82ee;\n"
					+ "        }\n"
					+ "        100% {\n"
					+ "          background: #ff0000;\n"
					+ "        }\n"
					+ "      }\n"
					+ "      .rainbow {\n"
					+ "        animation: colorchange 15s;\n"
					+ "        animation-timing-function: ease-in-out;\n"
					+ "        animation-iteration-count: infinite;\n"
					+ "        animation-play-state: running;\n"
					+ "      }\n"
					+ "    </style>\n"
					+ "</head>\n"
					+ "<body class=\"rainbow\">\n"
					+ "    <table border=\"1\">\n"
					+ "        <tr>\n"
					+ "            <th>Roll NO</th>\n"
					+ "            <th>Name</th> <th>Age</th>  <th>CGPA</th>\n"
					);
			while(rs.next()) {
				int rno=rs.getInt("RollNo");
				String nam=rs.getString("name");
				int age=rs.getInt("Age");
				int cgpa=rs.getInt("CGPA");
				pw.print(" </tr>\n"
						+ "        <tr><td>"+rno+"</td>\n"
						+ "        <td>"+nam+"</td>"+ "<td>"+age+"</td>"+"<td>"+cgpa+"</td>"
								+ "</tr>\n");
						
			}
			pw.print("    </table>\n"
						+ "</body>\n"
						+ "</html>");
			
			
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
