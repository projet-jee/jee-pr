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
import javax.servlet.http.HttpSession;

import bean.User;


public class Connex extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Connex() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("con")==null || session.isNew() )
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/connex.jsp" ).forward( request, response );
        else
        {request.setAttribute("user", session.getAttribute("con"));
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/home.jsp" ).forward( request, response );
        }
	}
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
         HttpSession session = request.getSession();

		 
		 
		 String username=request.getParameter("username") ;
		 String pass=request.getParameter("password") ;
		 
		 String url = "jdbc:mysql://127.0.0.1:3306/";  
	     String dbName = "geochat";  
	     String driver = "com.mysql.jdbc.Driver";  
	     String userName = "root";  
	     String password = "";
	     
	     try{
		     Class.forName(driver).newInstance();  
		     Connection conn = DriverManager.getConnection(url + dbName, userName, password); 
		     
		     
		     Statement pst = conn.createStatement();
	         String sql = "SELECT * FROM user where username='"+username+"' and password='"+pass+"'";
	         ResultSet rs = pst.executeQuery(sql);

	         if(rs.isBeforeFirst())
	        	 
	         {	rs.next();
	        	 User u=new User(rs.getString("username"),rs.getString("mail"),rs.getString("password"));
	        	 request.setAttribute("user",u);
	        	 
	        	 //session
	        	 PreparedStatement ps1=conn.prepareStatement("update user set connecte=1 where username='"+username+"'");
		         ps1.executeUpdate();

	        	 
	             session.setAttribute( "con",u);

	        	 this.getServletContext().getRequestDispatcher( "/WEB-INF/home.jsp" ).forward( request, response );
	         
	         }
	         else 
	         {  
	             session.setAttribute( "con", null );
	        	 this.getServletContext().getRequestDispatcher( "/WEB-INF/connex.jsp" ).forward( request, response );
	        	 
	        	 
	         }
		     }
	     catch(Exception e){out.print(e.toString());}
	     
	
	
	

	}

}
