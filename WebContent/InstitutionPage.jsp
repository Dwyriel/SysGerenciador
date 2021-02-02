<%@ include file="header.jsp" %>
<body>
	<%
	if ((Institution)request.getAttribute("Institution") == null) {
		response.sendRedirect(request.getContextPath() + "/Institution.jsp");
		return;
	}
	Institution institution = (Institution) request.getAttribute("Institution");
	%>
	<h1><%=institution.getName()%></h1>
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
			if(!lesson.isActive())
				continue;
			lesson.setStudents(LessonStudentDAL.getStudentsByLesson(lesson.getId()));
		%>
		<p>
			Aula:
			<%=lesson.getName()%>
			ID:
			<%=lesson.getId()%></p>
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/AddStudent?id=<%=lesson.getId()%>">Adicionar aluno</a>
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/EditLesson?id=<%=lesson.getId()%>">Editar aula</a>
			<p>Alunos:</p>
			<% 
			if (lesson.getStudents() == null || (lesson.getStudents() != null && lesson.getStudents().isEmpty())) {
				%>
				<span>Esta Aula nao possui alunos ainda.</span>
				<%
			} else
			for(User student : lesson.getStudents()){
				%> <%=student.getName() %><br> <% 
			}
		}
		%>
	
</body>
</html>