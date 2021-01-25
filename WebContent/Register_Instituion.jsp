<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="javax.servlet.http.*, classes.*, classes.users.* , DAL.*, java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head> <% //TODO check if user is admin, redirect if false %>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form method="post"
			action="<%=request.getContextPath()%>/RegInstitution">
			<label for="InstitutionName" class="form-label">Nome da instituição:</label> 
			<input class="form-control" type="text" name="InstitutionName" required> 
			<label for="datalist" class="form-label">Administrador:</label> 
			<input class="form-control" list="datalistOptions" id="datalist" name="Admin" placeholder="Type to search...">
			<datalist id="datalistOptions">
				<% List<User> userList = UserDAL.getAllUsers();
				for(User user : userList){ %>
				<option value="<%= user.getEmail() %>">
				<% } %>
			</datalist>
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>