<%@ include file="header.jsp" %>
<body>
<% if (user.getType() != UserType.ServerAdmin){
	response.sendRedirect(request.getContextPath() + "/Login.jsp");
	return;
}%>
	<div class="container">
		<form method="post"
			action="<%=request.getContextPath()%>/RegInstitution">
			<label for="InstitutionName" class="form-label">Nome da instituição:</label> 
			<input class="form-control" type="text" name="InstitutionName" required> 
			<label for="datalist" class="form-label">Administrador:</label> 
			<input class="form-control" list="datalistOptions" id="datalist" name="Admin" placeholder="Type to search...">
			<datalist id="datalistOptions">
				<% List<User> userList = UserDAL.getAllUsers();
				for(User tempUser : userList){ %>
				<option value="<%= tempUser.getEmail() %>">
				<% } %>
			</datalist>
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>