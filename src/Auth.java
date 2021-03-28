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


@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Auth() {
        Statement stmt = null;
        
        try {
        	Connection con = DatabaseConnection.initializeDatabase();
			stmt = con.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS USERS" +
			   "(username VARCHAR(60) not NULL, " +
			   " password VARCHAR(60) not NULL, " + 
			   " name VARCHAR(60) not NULL, " + 
			   " contact VARCHAR(60) not NULL, " + 
			   " PRIMARY KEY ( username ))"; 

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
			String username = request.getParameter("username");
	        String password = request.getParameter("pass");
	        
	        Boolean login = false;
	        
	        System.out.println("Username: " + username);
	        
        	Statement stmt = null;
        	
            try {
            	Connection con = DatabaseConnection.initializeDatabase();
    			
    			stmt = con.createStatement();
    			
    			String selector = "SELECT username, password FROM USERS";
			    ResultSet rs = stmt.executeQuery(selector);
			    
			    if (rs.next() == false) { 
			    	System.out.println("Incorrect username or password.");
			    	PrintWriter out=response.getWriter();  
			    	String someMessage = "Incorrect username or password.";
			    	out.println("<script type='text/javascript'>");
			    	out.println("alert(" + "'" + someMessage + "'" + ");</script>");
			    	out.println("</head><body></body></html>");
			    	response.sendRedirect("signin.html");
			    	login = false;
			    } else {
			    	while(rs.next()){
				    	String usr  = rs.getString("username");
				    	String pass = rs.getString("password");
				    	
				    	if(usr.equals(username) && pass.equals(password)){
				    		System.out.println("Logged in with user: " + username); 
				    		System.out.println("Successfully Logged In!");
				    		
				    		HttpSession session=request.getSession();  
				            session.setAttribute("username", username);  
				    		
				    		response.sendRedirect("index.jsp");
				    		login = true;
				    		break;
				    	} else {
				    		login = false;
				    		PrintWriter out=response.getWriter();  
				    		out.println("<script type=\"text/javascript\">");
							   out.println("alert('User or password incorrect');");
							   out.println("location='signin.html';");
							   out.println("</script>");
//					    	response.sendRedirect("signin.html");
				    	}
				    }
			    	
			    	PrintWriter out=response.getWriter();  
			    	out.println("<script type=\"text/javascript\">");
					   out.println("alert('User or password incorrect');");
					   out.println("location='signin.html';");
					   out.println("</script>");
//			    	response.sendRedirect("signin.html");
			    }
    		} catch (Exception e) {
    			System.out.println(e);
    			PrintWriter out=response.getWriter();  
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect');");
				   out.println("location='signin.html';");
				   out.println("</script>");
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}