<%@ include file="header.jsp" %>
<body>
<div class="container">
	<%
	if ((Institution)request.getAttribute("Institution") == null) {
		response.sendRedirect(request.getContextPath() + "/Institution.jsp");
		return;
	}
	Institution institution = (Institution) request.getAttribute("Institution");
	%>
	<h1><%=institution.getName()%></h1>
		<% InstitutionAdmin admin = null;
		if (user.getType() == UserType.InstitutionAdmin)
			admin = AdminDAL.getAdmin(user.getId());
		if (user.getType() == UserType.InstitutionAdmin || user.getType() == UserType.ServerAdmin) {
			if (user.getType() == UserType.ServerAdmin || (admin != null && admin.getInstitution().getId() == institution.getId())) {
				%>
				<a href="<%=request.getContextPath()%>/EditInstitution?id=<%=institution.getId()%>">Editar instituição</a> <br>
				<a href="<%=request.getContextPath()%>/RegLesson?id=<%=institution.getId()%>">Nova turma</a><br>
				<%
			}
		}
		if (institution.getClasses() == null || (institution.getClasses() != null && institution.getClasses().isEmpty())) {
		%>
		<span>Esta instituição nao possui classes ainda.</span>
		<%
		} else {
			List<Lesson> listLesson = new ArrayList<Lesson>();
			switch(user.getType()){
				case Teacher:
					listLesson = TeacherLessonDAL.getLessonsByTeacher(user.getId());
					break;
				case Student:
					listLesson = LessonStudentDAL.getLessonsByStudent(user.getId());
					break;
				default:
					listLesson = institution.getClasses();
					break;
			}
			if(listLesson.isEmpty())
				%> <span>Você não participa de nenhuma aula dessa instituição.</span> <%
		for (Lesson lesson : listLesson) {
			if(!lesson.isActive())
				continue;
			lesson.setStudents(LessonStudentDAL.getStudentsByLesson(lesson.getId()));
		%>
    <div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><%=lesson.getName()%></h5>
					<p class="card-text">
						ID:	<%=lesson.getId()%></p>
						<%if (user.getType()==UserType.ServerAdmin || (admin != null && admin.getInstitution().getId() == institution.getId())) { %>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/AddStudent?id=<%=lesson.getId()%>">Adicionar aluno</a>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/RemoveStudent?id=<%=lesson.getId()%>">Remover aluno</a>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/EditLesson?id=<%=lesson.getId()%>">Editar aula</a>
					<% } %>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/LessonPage?id=<%=lesson.getId()%>">Entrar</a>
				</div>
			</div>
		<% }
		} %> 
</body>
</html>