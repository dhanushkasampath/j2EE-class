package pk1;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    String message="hellow from login server";
    
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
			RequestDispatcher rd=request.getRequestDispatcher("registration.html");
			rd.forward(request,response);
		}else{
			out.println("sorry you are not nimal");
		}
		
	}

}
