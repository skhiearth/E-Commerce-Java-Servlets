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

import java.util.*;
import javax.servlet.*;

@WebServlet("/Cart")
public class Cart extends HttpServlet{

  private ServletConfig config;

  //Setting JSP page
  String page="Cart.jsp";

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	
	  Connection con = null;
	
	  ResultSet rs;
	
	  response.setContentType("text/html");
	
	  List dataList = new ArrayList(); 
	  List<Integer> ids = new ArrayList();
	
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  con = DatabaseConnection.initializeDatabase();
		  
		  String sql = "select * from CART";
		  Statement s = con.createStatement();
		  s.executeQuery (sql);
		  rs = s.getResultSet();
		  
		  HttpSession session=request.getSession(false); 
			
		String name = null;
		
		if(session!=null){  
        	name=(String)session.getAttribute("username");  
        	System.out.println(name);
        	if(name != null) {
        		while (rs.next ()){
      			  String username = rs.getString("username");
      			  
      			  if(username.equals(name)){
//        			dataList.add(rs.getInt("id"));
      				  ids.add(rs.getInt("id"));
      			  }
      		  	}
        		
        		System.out.println(ids);
        		Set<Integer> uniqueIds = new HashSet<Integer>(ids);
        		for (Integer id : uniqueIds) {
        	        System.out.println(id);
        	        
        	        Statement stmt = null;
            		
            		stmt = con.createStatement();
            		sql = "SELECT * FROM CATALOGUE";
            		
            	    rs = stmt.executeQuery(sql);
            	      while(rs.next()){
            	         //Retrieve by column name
            	         int _id  = rs.getInt("id");
            	         double price = rs.getDouble("price");
            	         String _name = rs.getString("name");
            	         
            	         if(_id == id) {
            	        	 dataList.add(id);
            	        	 dataList.add(_name);
            	        	 dataList.add(price);
            	         }
            	      }
        	     }
        		
        		
        	} else {
        		out.println("<script type=\"text/javascript\">");
				   out.println("alert('You need to be logged in!');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
        	}
		} else {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('You need to be logged in!');");
			   out.println("location='index.jsp';");
			   out.println("</script>");
		}
		
		  
		
		  rs.close ();
		  s.close ();
	  } catch(Exception e){
		  System.out.println("Exception is ;"+e);
		  out.println("<script type=\"text/javascript\">");
		   out.println("alert('You need to be logged in!');");
		   out.println("location='index.jsp';");
		   out.println("</script>");
	  }
	
	  request.setAttribute("data",dataList);
	  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	  if (dispatcher != null){
		  dispatcher.forward(request, response);
	  }

  }

}