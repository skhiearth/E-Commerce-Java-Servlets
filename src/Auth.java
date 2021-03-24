import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String username = request.getParameter("inputEmail");
	        String password = request.getParameter("inputPassword");
	        String name = request.getParameter("name");
	        String contact = request.getParameter("contact");
	        
	        String loginusername = request.getParameter("loginusername");
	        String loginpassword = request.getParameter("loginpassword");
	        
	        Boolean login = false;
	        
	        System.out.println("Login username: " + loginusername);
	        
	        if(loginusername == null) {
	        	System.out.println("username: " + username);
	            System.out.println("password: " + password);
	     
	            PrintWriter writer = response.getWriter();
	
	            String htmlRespone = "<html>";
	            htmlRespone += "<h2>Your username is: " + username + "<br/>";      
	            htmlRespone += "Your password is: " + password + "</h2>";    
	            htmlRespone += "</html>";
	            
	            Statement stmt = null;
	            
	            try {
	            	Connection con = DatabaseConnection.initializeDatabase();
	    			System.out.println("Connected database successfully...");
	    			
	    			stmt = con.createStatement();
	    			
	    			PreparedStatement insertstm = con.prepareStatement("insert into USERS (username, password, name, contact) VALUES (?,?,?,?)");  
	    			
	    			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
	    		    
	    	    	insertstm.setString(1, username);
	    	    	insertstm.setString(2, password);
	    	    	insertstm.setString(3, name);
	    	    	insertstm.setString(4, contact);
	    			int i = insertstm.executeUpdate();
	    		} catch (Exception e) {
	    			System.out.println(e);
	    		}
	             
	    		System.out.println("Successfully Registered!");
	        } else {
	        	Statement stmt = null;
	        	
	            try {
	            	Connection con = DatabaseConnection.initializeDatabase();
	    			System.out.println("Connected database successfully...");
	    			
	    			stmt = con.createStatement();
	    			
	    			String selector = "SELECT username, password FROM USERS";
				    ResultSet rs = stmt.executeQuery(selector);
				    
				    while(rs.next()){
				    	String usr  = rs.getString("username");
				    	String pass = rs.getString("password");
				    	
				    	if(usr.equals(loginusername) && pass.equals(loginpassword)){
				    		System.out.println("Logged in with user: " + loginusername); 
				    		System.out.println("Successfully Logged In!");
				    		login = true;
				    		break;
				    	} else {
				    		login = false;
				    	}
				    }
	    		} catch (Exception e) {
	    			System.out.println(e);
	    		}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


