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
	if (session.getAttribute("user") == null) {
		request.getRequestDispatcher("Login.jsp").include(request, response);
		return;
	}
	User user = (User) session.getAttribute("user");
	if (request.getAttribute("Institution") == null) {
		response.sendRedirect(request.getContextPath() + "/Institution.jsp");
		return;
	}
	Institution institution = (Institution) request.getAttribute("Institution");
	%>
	<h1><%=institution.getName()%></h2>
		<%
		if (user.getType() == UserType.InstitutionAdmin || user.getType() == UserType.ServerAdmin) {
			InstitutionAdmin admin = null;
			if (user.getType() == UserType.InstitutionAdmin)
				admin = AdminDAL.getAdmin(user.getId());
			if (user.getType() == UserType.ServerAdmin || (admin != null && admin.getInstitution().getId() == institution.getId())) {
				%>
				<a href="#">Editar instituição</a> <br>
				<a href="<%=request.getContextPath()%>/RegLesson?id=<%=institution.getId()%>">Nova turma</a><br>
				<%
			}
		}
		if (institution.getClasses() == null || (institution.getClasses() != null && institution.getClasses().isEmpty())) {
		%>
		<span>Esta instituição nao possui classes ainda.</span>
		<%
		} else
		for (Lesson lesson : institution.getClasses()) {
		%>
		<p>
			Aula:
			<%=lesson.getName()%>
			ID:
			<%=lesson.getId()%></p>
		<%
		}
		%>
	
</body>
</html>