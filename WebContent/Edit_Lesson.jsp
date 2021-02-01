<%@ include file="header.jsp" %>
<% if(request.getAttribute("lesson") == null){
	response.sendRedirect(request.getContextPath() + "/Institution.jsp");
	return;
}
Lesson lesson = (Lesson) request.getAttribute("lesson");%>
<body>
	<div class="container">
		<form method="post" action="<%=request.getContextPath()%>/EditLesson">
			<label for="LessonName" class="form-label">Nome da classe:</label> 
			<input class="form-control" type="text"	name="LessonName" required <%= lesson.getName() %>> 
			
			<label for="datalist" class="form-label">Professor:</label> 
			<input class="form-control" list="datalistOptions" id="datalist" name="Teacher" placeholder="Type to search..." value="<%= lesson.getTeacher().getEmail() %>">
			<datalist id="datalistOptions">
				<%
				List<User> userList = UserDAL.getAllUsersOfType(UserType.Teacher);
				for (User tempUser : userList) { %>
					<option value="<%=tempUser.getEmail()%>">
					<% } %>				
			</datalist>
			
			<input class="visually-hidden" type="number" name="LessonId" value="<%=lesson.getId()%>" required>
						
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>
</body>
	