package pk1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "this servlet will get the values pass from register.html file and add them database", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//mulinma database connection eka hada geniimata pera variables initialize kara ganna.
	 public String DB_URL = "jdbc:mysql://localhost/registration";
	 public String DB_USER = "root";
	 public String PASSWORD = "";
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	// server ekata data damana nisa doPost method eka use karanna ona.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ඒක ඇතුලෙ register.html page එකෙන් ගන්න variables හදා ගන්න 
		
		  String uname=request.getParameter("uname");
		  String password=request.getParameter("password");
		  String fname=request.getParameter("fname");
		  String city=request.getParameter("city");
		  String sex=request.getParameter("sex");
		  String prof = request.getParameter("prof");
		  String tele=request.getParameter("tele");
		  String email=request.getParameter("email");
		 //දැන් try catch එකක් ඇතුලෙ database connection එක හදා  ගන්න .
		  try{
			   
			  Class.forName("com.mysql.jdbc.Driver");//load vendor specific driver
			  
			  Connection conn= DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);
			  Statement stmt = conn.createStatement();                           
			  
			  //දැන් sql statement එක ලියන්න.
			  String insert="INSERT INTO reg_users(user_name,password,fullname,city,sex,profession,tele,email) VALUES ('"+uname+"'," +
			    "'"+password+"','"+fname+"','"+city+"','"+sex+"','"+prof+"','"+tele+"','"+email+"')";
			  
			  //දැන් query එක run කරන්න 
			  stmt.executeUpdate(insert);
			  
			  //query එක run වූ  පසු  datainserted.html page එකට direct කරන්න. 
			  response.sendRedirect("datainserted.html");
			  
			  //අවසානයේ database connection එක close කරන්න.
			  conn.close();
			  
			  }catch(ClassNotFoundException e){
			   
			   e.printStackTrace();   
			  }catch(SQLException sql){
			   
			   sql.printStackTrace();
			  }
	}

}
