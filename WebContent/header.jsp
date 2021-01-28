<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,classes.*,classes.users.*, java.lang.*, DAL.*, java.util.ArrayList, java.util.List"  
  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackbox</title>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="style/style.css" media="screen" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<%
		if(session.getAttribute("user") == null) {
			String alert ="Você precisa estar logado";
			request.setAttribute("Alert", alert);
			request.getRequestDispatcher("/Login.jsp").include(request, response);
			return;
			}	
				User user = (User)session.getAttribute("user");
					 
					 %>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top background">
    <div class="container">
      <a class="navbar-brand text" href="#">Blackbox</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
          <li class="nav-item">
     		<%  %>
            <a class="nav-link" href="Institution.jsp">Admin Painel</a>
      		
          </li>
          <li class="nav-item dropdown">
        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Usuário
        	</a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Editar Informações</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="<%=request.getContextPath()%>/Logout">Desconectar</a>
        </div>
      </li>        
        </ul>
      </div>
    </div>
  </nav>
</header>
