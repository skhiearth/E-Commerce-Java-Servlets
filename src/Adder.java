import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

/**
 * Servlet implementation class Adder
 */
@WebServlet("/Adder")
public class Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adder() {
        super();
        Statement stmt = null;
        
	        try {
	        	Connection con = DatabaseConnection.initializeDatabase();
				stmt = con.createStatement();
	
				String sql = "CREATE TABLE IF NOT EXISTS CART" +
				   "(username VARCHAR(60) not NULL, " +
				   " id VARCHAR(60) not NULL)";
	
				stmt.executeUpdate(sql);
				System.out.println("Created table in given database...");
			} catch (Exception e) {
				System.out.println(e);
			}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Statement stmt = null;
			try {
				Connection con = DatabaseConnection.initializeDatabase();
				
				stmt = con.createStatement();
				
				HttpSession session=request.getSession(false); 
				
				String name = null;
				
		        if(session!=null){  
		        	name=(String)session.getAttribute("username");  
		        	System.out.println(name);
		        	if(name != null) {
		        		PreparedStatement prep = con.prepareStatement("insert into CART values(?,?)");  
			        	prep.setString(1,name);  
			        	
			        	if (request.getParameter("0") != null){
			        		prep.setString(2,"0");  
						 }
						else if (request.getParameter("1") != null){
							prep.setString(2,"1");  
						 }
						else if (request.getParameter("2") != null){
							prep.setString(2,"2");  
						 }
						else if (request.getParameter("3") != null){
							prep.setString(2,"3");  
						 }
						else if (request.getParameter("4") != null){
							prep.setString(2,"4");  
						 }
						else if (request.getParameter("5") != null){
							prep.setString(2,"5");  
						 }
			        	prep.executeUpdate();
		        	} else {
		        		PrintWriter out=response.getWriter();  
		        		out.println("<script type=\"text/javascript\">");
						   out.println("alert('You need to login first!');");
//						   out.println("location='/E_Commerce/Catalogue");
						   out.println("</script>");
		        		response.sendRedirect("");
		        	}
		        } else {  
		        	PrintWriter out=response.getWriter();  
		    		out.println("<script type=\"text/javascript\">");
				   out.println("alert('You need to login first!');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
		        }  
			} catch (Exception e) {
    			System.out.println(e);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
