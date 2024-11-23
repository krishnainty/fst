

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SessionCount
 */
public class SessionCount extends HttpServlet {
	private int hitCount;
	public void init() 
    { 
        // Reset hit counter. 
        hitCount = 0; 
    } 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionCount() {
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
		  
        // This method executes whenever the servlet is hit  
        // increment hitCount 
		
        hitCount++; 
        PrintWriter out = response.getWriter(); 
        String title = "Count of total number of hits"; 
        String docType 
            = "<!doctype html public \"-//w3c//dtd html 4.0 "
              + "transitional//en\">\n"; 
  
        out.println( 
            docType + "<html>\n"
            + "<head><title>" + title + "</title></head>\n"
            + "<body bgcolor = \"#f0f0f0\">\n"
            + "<h1 align = \"center\">" + title + "</h1>\n"
            + "<h2 align = \"center\">" + hitCount 
            + "</h2>\n"
            + "</body>"
            + "</html>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
