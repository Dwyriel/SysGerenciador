<%@ include file="header.jsp" %>
<body>
	<div class="container">
		<a class="btn" href="<%=request.getContextPath()%>/Register_Institution.jsp">New Institution</a>
		<div class="text-center">
			<%
			List<Institution> institutionList = InstitutionDAL.getAllInstitutions();
			if (!institutionList.isEmpty())
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
						<a
						href="<%=request.getContextPath()%>/EditInstitution?id=<%=institution.getId()%>"
						class="btn btn-primary">Edit this</a>
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