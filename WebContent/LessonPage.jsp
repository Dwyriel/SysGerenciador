<%@ include file="header.jsp" %>
<body>
<div class="container">
	<%
	if ((Lesson)request.getAttribute("Lesson") == null) {
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
		return;
	}
	Lesson lesson = (Lesson) request.getAttribute("Lesson");
	%>
	<h1><%=lesson.getName()%></h1>
		<p>Professor: <%= lesson.getTeacher().getName() %></p>
		Alunos:
		<% if (lesson.getStudents() == null || (lesson.getStudents() != null && lesson.getStudents().isEmpty())) { 
				%>
				<span>Esta Aula nao possui alunos ainda.</span>
				<%
			} else {
				for(User student : lesson.getStudents()){
					%> <%=student.getName() %><br> <% 
				} 
			}%>
			</div>
</body>
</html>