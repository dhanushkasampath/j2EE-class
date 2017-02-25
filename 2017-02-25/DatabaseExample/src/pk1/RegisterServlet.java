package pk1;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String DB_URL="jdbc:mysql://localhost/registration";
	public String DB_USER="root";
	public String PASSWORD="";
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Database connection
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String city=request.getParameter("city");
		String sex=request.getParameter("gender");
		String tele=request.getParameter("tele");
		String email=request.getParameter("email");
		
		try{
			
		Class.forName("com.mysql.jdbc.Driver");//load vendor specific driver
		
		Connection conn=DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);
		Statement stmt = conn.createStatement();                       
		
		String insert="INSERT INTO reg_users (user_name,password,fullname,city,sex,tele,email) VALUES ('"+username+"'," +
				"'"+password+"','"+fullname+"','"+city+"','"+sex+"','"+tele+"','"+email+"')";
		
		stmt.executeUpdate(insert);
		
		response.sendRedirect("insert_message.html");
		
		conn.close();
		
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();			
		}catch(SQLException sql){
			
			sql.printStackTrace();
		}
		
	}

}
