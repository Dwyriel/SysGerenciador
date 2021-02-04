<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.http.*,classes.*,classes.users.*, java.lang.*, DAL.*, java.util.ArrayList, java.util.List"  
  %>
  <%

		if(session.getAttribute("user") == null) {
			String alert ="Você precisa estar logado";
			request.setAttribute("Alert", alert);
			request.getRequestDispatcher("/Login.jsp").include(request, response);
			return;
			}	

		User user = (User)session.getAttribute("user");			 
					 %>
  <% String text = null; if(request.getAttribute("Text") != null ) { text = (String)request.getAttribute("Text"); 
	request.setAttribute("Text", null);}; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackbox</title>
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<h1><%= text %></h1>
<a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/Logout">Desconectar</a>
<a type="button" class="btn btn-secondary" href="<%=request.getContextPath()%>/Delbyid?id=<%=user.getId()%>">Deletar Conta</a>
</div>
</body>
</html>