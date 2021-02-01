<%@ include file="header.jsp" %>
<% if(user.getType() == UserType.Student || user.getType() == UserType.InstitutionAdmin) {
	response.sendRedirect(request.getContextPath() + "/Login.jsp");
	return;
}
	%>


<body>
	<!--SideNav-->
	<div class="container">
		<div class="text-center">
			<%
			List<Institution> institutionList = InstitutionDAL.getAllInstitutions();
			if (institutionList != null || !institutionList.isEmpty())
				for (Institution institution : institutionList) {
			%>
			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><%=institution.getName()%></h5>
					<p class="card-text">
						Institution id:
						<%=institution.getId()%></p>
					<a
						href="<%=request.getContextPath()%>/InstituPage?id=<%=institution.getId()%>"
						class="btn btn-primary">Go there</a>
				</div>
			</div>
			<%
			} else { %>
			<span>No institutions yet</span>
			<% } %>
		</div>
	</div>
</body>
</html>