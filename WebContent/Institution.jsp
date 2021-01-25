<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="javax.servlet.http.*, classes.*, classes.users.* , DAL.*, java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
#sidebar-wrapper {
	left: -300px;
	width: 300px;
	background-color: #51A8B1;
	color: white;
	position: fixed;
	height: 100%;
	z-index: 1;
}

.sidebar-nav {
	position: fixed;
	top: 0;
	margin: 0;
	padding: 0;
	width: 300px;
	list-style: none;
}

.sidebar-nav li {
	font-size: 20px;
	text-indent: 55px;
	line-height: 70px;
}

.sidebar-nav li a {
	color: white;
	display: block;
	text-decoration: none;
}

.sidebar-nav li a:hover {
	background: #448B93;
	color: white;
	text-decoration: none;
}

.sidebar-nav li a:active, .sidebar-nav li a:focus {
	text-decoration: none;
}

#ufpb-logo {
	margin-top: 50px;
	margin-bottom: 50px;
	padding-left: 110px;
}

#sidebar-wrapper.sidebar-toggle {
	transition: all 0.3s ease-out;
	margin-left: -200px;
}

#main {
	padding-left: 70px;
}

@media ( min-width : 768px) {
	#sidebar-wrapper.sidebar-toggle {
		transition: 0s;
		left: 200px;
	}
}
</style>
</head>

<body>
	<!--SideNav-->
	<div class="container">
		<div id="sidebar-wrapper" class="sidebar-toggle">
			<ul class="sidebar-nav">
				<li><a href="#item1">Instituições</a></li>
				<li><a href="#item2">Adicionar</a></li>
				<li><a href="#item3">Remover</a></li>
				<li><a href="#item3">##</a></li>
				<li><a href="#item3">##</a></li>
			</ul>
		</div>
		<div class="text-center" style="margin-left: 500px">
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