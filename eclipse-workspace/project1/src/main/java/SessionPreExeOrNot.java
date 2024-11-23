

import jakarta.servlet.ServletException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Servlet implementation class SessionPreExeOrNot
 */
public class SessionPreExeOrNot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionPreExeOrNot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		HttpSession se=req.getSession(false);
		if(se==null) {
			pw.println("No Active Session<br>");
		pw.println("Creating Session");
		}
		else {
			pw.println("Active Session <br>");
			
		}
		se=req.getSession(true);
		if(se==null)
			pw.println("No Active Session");
		else
			pw.println("Active Session<br>");
//		pw.println(se.getCreationTime()+"<br>");
//		pw.println(se.getLastAccessedTime()+"<br>");
		 // create an instance of the SimpleDateFormat class for modifying the date object   
        DateFormat obj = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");   
           // we create instance of the Date and pass milliseconds to the constructor    
           Date res2 = new Date(se.getCreationTime());   
           // now we format the res by using SimpleDateFormat   
           pw.println("Session created Time: "+obj.format(res2)+"<br>"); 
           Date res1 = new Date(se.getLastAccessedTime());
           pw.println("Session Accessed Time: "+obj.format(res1)); 
           
           
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
