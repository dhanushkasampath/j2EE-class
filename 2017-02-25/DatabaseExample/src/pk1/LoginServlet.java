package pk1;

import java.beans.Statement;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		//request object eken thamai client ge parameters catch karagena thiyenne
		String user=request.getParameter("username");
		String pword=request.getParameter("password");
		
		
		
		
		
		
		
		//handle authentication
		
		if((user.matches("Nimal")) && (pword.matches("1234"))){
			RequestDispatcher rd=request.getRequestDispatcher("home.html");//request dispatcher object eka hadanawa.
			rd.forward(request,response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("registration.html");//request dispatcher object eka hadanawa.
			rd.include(request,response);
		}
		
	}

}
