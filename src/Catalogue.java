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

import java.util.*;
import javax.servlet.*;

@WebServlet("/Catalogue")
public class Catalogue extends HttpServlet{

  private ServletConfig config;

  //Setting JSP page
  String page="Catalogue.jsp";
  
  public Catalogue() {
      Statement stmt = null;
      
      try {
      		Connection con = DatabaseConnection.initializeDatabase();
			stmt = con.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS CATALOGUE" +
					   "(id INTEGER not NULL, " +
					   " image VARCHAR(60) not NULL, " + 
					   " name VARCHAR(60) not NULL, " + 
					   " price DOUBLE not NULL, " + 
					   " description VARCHAR(120) not NULL, " + 
					   " PRIMARY KEY ( id ))"; 
			
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO CATALOGUE " +
	                   "VALUES (0, 'a', 'Example1', 10, 'this is the description')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CATALOGUE " +
					"VALUES (1, 'a', 'Example2', 20, 'this is the description')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CATALOGUE " +
					"VALUES (2, 'a', 'Example3', 20, 'this is the description')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CATALOGUE " +
					"VALUES (3, 'a', 'Example4', 20, 'this is the description')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CATALOGUE " +
					"VALUES (4, 'a', 'Example5', 20, 'this is the description')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO CATALOGUE " +
					"VALUES (5, 'a', 'Example6', 20, 'this is the description')";
			stmt.executeUpdate(sql);
			
			System.out.println("Created table in given database...");
		} catch (Exception e) {
			System.out.println(e);
		}
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	
	  Connection con = null;
	
	  ResultSet rs;
	
	  response.setContentType("text/html");
	
	  List dataList = new ArrayList(); 
	
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  con = DatabaseConnection.initializeDatabase();
		  
		  String sql = "select * from CATALOGUE";
		  Statement s = con.createStatement();
		  s.executeQuery (sql);
		  rs = s.getResultSet();
		
		  while (rs.next ()){
			  dataList.add(rs.getString("name"));
			  dataList.add(rs.getInt("price"));
			  dataList.add(rs.getString("description"));
			  dataList.add(rs.getInt("id"));
		  }
		
		  rs.close ();
		  s.close ();
	  } catch(Exception e){
		  System.out.println("Exception is ;"+e);
	  }
	
	  request.setAttribute("data",dataList);
	  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	  if (dispatcher != null){
		  dispatcher.forward(request, response);
	  } 

  }

}