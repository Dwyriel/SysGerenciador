<%@ include file="header.jsp" %>
<body>
<% 
if (user.getType() != UserType.ServerAdmin && user.getType() != UserType.InstitutionAdmin){
	response.sendRedirect(request.getContextPath() + "/Login.jsp");
	return;
}

	Lesson lesson = null;
	if(request.getAttribute("lesson") == null){
		%> <script> alert("Não foi possivel acessar essa classe");</script> <%
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
		return;
	}
		lesson = (Lesson)request.getAttribute("lesson");
		if(user.getType() == UserType.InstitutionAdmin){
			InstitutionAdmin admin = AdminDAL.getAdmin(user.getId());
			if(admin.getInstitution().getId() != lesson.getInstitution().getId()){
				%> <script> alert("Você não tem permissão para editar essa classe");</script> <%
				response.sendRedirect(request.getContextPath() + "/Login.jsp");
				return;
			}
		}
		if(request.getAttribute("errorMsg") != null){
			%> <script> alert("<%= request.getAttribute("errorMsg") %>");</script> <%
			request.removeAttribute("errorMgs");
		}
%>
	<div class="container">
		<form method="post"
			action="<%=request.getContextPath()%>/RemoveStudent">
			
			<label for="datalist" class="form-label">Aluno:</label> 
			<input class="form-control" list="datalistOptions" id="datalist" name="student" placeholder="Type to search...">
			<datalist id="datalistOptions">
				<% List<User> studentList = LessonStudentDAL.getStudentsByLesson(lesson.getId());
				for(User tempUser : studentList){ 
				%>
				<option value="<%= tempUser.getEmail() %>">
				<% } %>
			</datalist>
			
			<input class="visually-hidden" type="number" name="lessonId" value="<%=lesson.getId()%>" required>
			
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>