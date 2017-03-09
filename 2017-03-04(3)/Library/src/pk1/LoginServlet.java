package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(description = "this servlet is basically used to get username and password and do authentications", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();//print ekak ganna nam printwriter class ekee object ekak hadala enna onna
		
		String user=request.getParameter("username");//index.html form eken ena values catch karai.
		String pword=request.getParameter("password");
		
		//dan database variables initialize kara ganimu
		String DB_URL="jdbc:mysql://localhost/registration";
		String DB_USER="root";
		String PASSWORD="";
		//dan database connection eka hadanna. eya try catch ekak athule karanna
		
try{
			
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);
			java.sql.Statement stmt = conn.createStatement();
			
			String valsql = "SELECT user_name,password,city,profession FROM reg_users WHERE user_name='"+user+"'";
			//database ekee athi usenames walin user name eka pera gesuu agayata samaana eke 
					//user_name,password,city,profession athi virtual table ekak create karai 
			ResultSet rs = stmt.executeQuery(valsql);
			while(rs.next()){
				//me thiyenne database eken ganna values
				String dbuser = rs.getString("user_name");  
				String dbpw = rs.getString("password");
				String dbcity = rs.getString("city");
				String dbprof = rs.getString("profession");
				
				//dan eewa user enter karapu values walata samanada kiyala check karanawa
				if((user.matches(dbuser)) && (pword.matches(dbpw))){
					
					HttpSession session = request.getSession(); //samaana nam session object ekak hadanawa
					session.setAttribute("setuser", dbuser);   //dan a session object ekata values set karanawa
					session.setAttribute("setcity", dbcity);
					session.setAttribute("setprof", dbprof);
					
					//dan userwa home.jsp page ekata direct karanawa
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
					
					
				}
				else if((user.matches(dbuser)) || (pword.matches(dbpw))){
					//username password match wenne nethnam registration.html page ekata direct karanawa
					RequestDispatcher rd = request.getRequestDispatcher("register.html");
					rd.include(request, response);
					
				}
				
			}
			conn.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
