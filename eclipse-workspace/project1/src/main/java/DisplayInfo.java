

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DisplayInfo
 */
public class DisplayInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data  
		pw.println("<html><body style=\"background-color:aqua;\"><h1>hello</h1></body></html>");
		pw.println("<table border=\"2\"><tr><td>ServerName </td>");
		pw.println("<td>"+request.getServerName()+"</td></tr>");
		pw.println("<tr><td>Server Port </td>");
		pw.println("<td>"+request.getServerPort()+"</td></tr>");
		pw.println("<tr><td>Protocol </td>");
		pw.println("<td>"+request.getProtocol()+"</td></tr>");
		pw.println("<tr><td>Scheme </td>");
		pw.println("<td>"+request.getScheme()+"</td></tr>"); 
		pw.println("<tr><td>ContextPath </td>");
		pw.println("<td>"+request.getContextPath()+"</td></tr>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
