<%@ include file="header.jsp" %>
<body>
<% 
if (user.getType() != UserType.ServerAdmin && user.getType() != UserType.InstitutionAdmin){
	response.sendRedirect(request.getContextPath() + "/Login.jsp");
	return;
}

	Institution institution = null;
	if((Institution)request.getAttribute("institution") == null){
		%> <script> alert("Não foi possivel acessar essa instituição");</script> <%
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
		return;
	}
		institution = (Institution)request.getAttribute("institution");
		if(user.getType() == UserType.InstitutionAdmin){
			InstitutionAdmin admin = AdminDAL.getAdmin(user.getId());
			if(admin.getInstitution().getId() != institution.getId()){
				%> <script> alert("Você não tem permissão para editar essa instituição");</script> <%
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
			action="<%=request.getContextPath()%>/EditInstitution">
			<label for="InstitutionName" class="form-label">Nome da instituição:</label> 
			<input class="form-control" type="text" name="InstitutionName" required value="<%=institution.getName()%>"> 
			<input class="visually-hidden" type="number" name="InstitutionId" value="<%=institution.getId()%>" required>
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
