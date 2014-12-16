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


/**
 * Servlet implementation class Insc
 */
public class Insc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/insc.jsp" ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 
		 String username=request.getParameter("username") ;
		 String pass=request.getParameter("password") ;
		 String mail=request.getParameter("mail") ;
		 String confirm=request.getParameter("passwordsignup_confirm") ;
		 String url = "jdbc:mysql://localhost:3306/";  
	     String dbName = "geochat";  
	     String driver = "com.mysql.jdbc.Driver";  
	     String userName = "root";  
	     String password = "";
	     String erreur ="" ;
	     if(username.isEmpty() || pass.isEmpty() || mail.isEmpty() || confirm.isEmpty())
	     {
	    	 erreur = "il faut remplir tous les champs" ;
	     }
	     else if ( mail != null && !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) )
	     {
	    	 erreur = "Veuillez entrer un email valide" ;
	     }
	     else if(!pass.equals(confirm))
	     {erreur = "Les mots de passe ne sont pas identiques" ;
	    	 
	    	 
	     }
	     
	     
	     
	     if(!erreur.equals(""))
	     {
	    	 
	    	 getServletContext().getRequestDispatcher("/WEB-INF/insc.jsp").forward(request, response);
	    	 
	     }
	     else{
	     try{
	     Class.forName(driver).newInstance();  
	     Connection conn = DriverManager.getConnection(url + dbName, userName, password); 
	     PreparedStatement pst = conn.prepareStatement("insert into user(username,mail,password) values(?,?,?)");
	     pst.setString(1, username);  
         pst.setString(2, mail);
         pst.setString(3, pass);
         pst.executeUpdate();
         this.getServletContext().getRequestDispatcher( "/WEB-INF/connex.jsp" ).forward( request, response );
         
	     }
	     catch(Exception e)
	     {
	    	 out.print(e.toString());
	     }
	     
	     }
	}

}
