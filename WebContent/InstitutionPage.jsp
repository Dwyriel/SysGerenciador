<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="javax.servlet.http.*, classes.*, classes.users.* , DAL.*, java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (request.getAttribute("Institution") != null) {
		Institution institution = (Institution) request.getAttribute("Institution");
	%>
	<h1><%=institution.getName()%></h2>
		<%
		for (Lesson lesson : institution.getClasses()) {
		%>
		<p>Aula: <%= lesson.getName() %> ID: <%= lesson.getId() %></p>
		<%
		}
	} else 
		response.sendRedirect(request.getContextPath() + "/Institution.jsp");
	%>
	
</body>
</html>