<%@ include file="header.jsp" %>
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