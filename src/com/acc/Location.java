package com.acc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Location
 */
public class Location extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Location() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();


		    
		    String lon=request.getParameter("lon");
		    String lat=request.getParameter("lat");
		    String un=request.getParameter("un");
		    

			 String url = "jdbc:mysql://127.0.0.1:3306/";  
		     String dbName = "geochat";  
		     String driver = "com.mysql.jdbc.Driver";  
		     String userName = "root";  
		     String password = "";

		     try{
		    	 /*stocker logn et lat */
			     Class.forName(driver).newInstance();  
			     Connection conn = DriverManager.getConnection(url + dbName, userName, password); 
			     PreparedStatement pst = conn.prepareStatement("update user set longitude=?,latitude=? where username=?");
			     pst.setString(3, un);  
		         pst.setString(1, lon);
		         pst.setString(2, lat);
		         pst.executeUpdate();
		         
		         /*chercher les utilisateurs connectés et récupérer leurs long et lat*/
		         Statement ps1 = conn.createStatement();
		         String sql = "SELECT * FROM user where connecte=1";
		         ResultSet rs = ps1.executeQuery(sql);
		         
		         String js="{\"tab\":[";
		         while(rs.next())
		         {String u=rs.getString("username");
		         String lo=rs.getString("longitude");
		         String la=rs.getString("latitude");
		          js+="{\"user\":\""+u+"\",\"lon\":\""+lo+"\",\"lat\":\""+la+"\"},";	 
		         }
		         
		         js=js.substring(0, js.length()-1);
		         js+="]}";
		         
		         
		         

				    out.print(js);		    
					out.flush();
				    out.close();
		         
		         
			     }
			     catch(Exception e)
			     {
			    	 out.print(e.toString());
			     }
		    
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
		
	
	
	}

}
