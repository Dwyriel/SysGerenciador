<%@ include file="header.jsp" %>
<% if(user.getType() != UserType.ServerAdmin) {
	response.sendRedirect(request.getContextPath() + "/Login.jsp");
	return;
}
	%>
	<%
	    String alert = null; if(request.getAttribute("Alert") != null ){ alert = (String)request.getAttribute("Alert");}  
 if (alert != null ) { %> 	<script> alert("<%= alert %>"); </script> 	<% } %>
<body>
	<div class="container">
		<div class="text-center">
			<%
			List<User> userList = UserDAL.getAllUsers();
			if (!userList.isEmpty())
				for (User users : userList) {
			%>
			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><%=users.getName()%></h5>
					<p class="card-text">
						<%=users.getEmail()%></p>
					<% if (users.isActive() == true) { %>
					<a href="<%=request.getContextPath()%>/disableUser?id=<%=users.getId()%>"
						class="btn btn-primary">Desativar Usuario</a>
						<% } %>
						<% if (users.isActive() == false)  {%>
						<a href="<%=request.getContextPath()%>/disableUser?id=<%=users.getId()%>"
						class="btn btn-primary">Ativar Usuario</a>
						<% } %>
						<a    href="<%=request.getContextPath()%>/Delbyid?id=<%=users.getId()%>"
						class="btn btn-secondary" style="margin-top: 6px">Deletar Usuario</a>
				</div>
			</div>
			<%
			} else { %>
			<span>sem usuários cadastrados</span>
			<% } %>
		</div>
	</div>
</body>
</html>