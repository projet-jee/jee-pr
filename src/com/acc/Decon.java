package com.acc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Decon
 */
public class Decon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Decon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
        session.invalidate(); 
        
        //connecte=0  
        
        String username=request.getParameter("username") ;
        PrintWriter out=response.getWriter();
        out.print(username);
		 
		  try{
		 String url = "jdbc:mysql://127.0.0.1:3306/";  
	     String dbName = "geochat";  
	     String driver = "com.mysql.jdbc.Driver";  
	     String userName = "root";  
	     String password = "";
	     
	     Class.forName(driver).newInstance();  
	     Connection conn = DriverManager.getConnection(url + dbName, userName, password); 
	     
   	 	PreparedStatement ps1=conn.prepareStatement("update user set connecte=0 where username='"+username+"'");
        ps1.executeUpdate();}
        catch(Exception e){
        	
        	return;
        }
        
        
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/connex.jsp" ).forward( request, response );
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
