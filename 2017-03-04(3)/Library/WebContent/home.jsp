<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>

<h1>HOME</h1>

<%
	request.getSession();//methana mokakda karala thiyenne.
	String userInJSP=(String)session.getAttribute("setuser");//getAttribute() method eka return karanne object ekak nisa eka string walata cast karanna ona.
	String cityInJSP=(String)session.getAttribute("setcity");
%>

<h3>Welcome user <%= userInJSP%>, &nbsp; 
you are from <%= cityInJSP %>
</h3>

<a href="library.jsp">Go to my library</a>

<!-- wenath jsp page ekak include karanne mehemai -->
<div class = "footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>