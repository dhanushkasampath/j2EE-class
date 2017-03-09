<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.*" %><!--jsp page එකකට java classes import කරන්නෙ  මෙහෙමයි. -->  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">My library</h1>

<% 
		request.getSession();
		String user =(String)session.getAttribute("setuser");
		String city =(String)session.getAttribute("setcity");
		String prof =(String) session.getAttribute("setprof");
	%>	
		<font style="color:red">welcome,&nbsp; <%= prof %></font></br>
	<%			
		 String DB_URL = "jdbc:mysql://localhost/registration";
		 String DB_USER = "root";
		 String PASSWORD = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);
			java.sql.Statement stmt = conn.createStatement();
			
			String valsql = "SELECT path FROM image_path WHERE prof='"+prof+"'";
					
			ResultSet rs = stmt.executeQuery(valsql);
			%>
			
			
			
			<%
			while(rs.next()){
				String imp = rs.getString("path");
				%>
				<img alt="MBook" src="<%= imp %>"  width="100" height="160"> 
				<%
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
%>





</body>
</html>