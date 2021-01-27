<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,classes.*,classes.users.*" %>
     <%		String msg = null; if(request.getAttribute("Msg") != null ) { msg = (String)request.getAttribute("Msg"); 
request.setAttribute("Msg", null);}; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/Register">
		<div class="container">
		  <div class="form-group">
		    <label for="txtEmail">Email</label>
		    <input type="email" class="form-control col-md-8" id="txtEmail"  name="txtEmail" placeholder="Seu email">
		     	<% if(msg != null) { %>
	             <span style="color: red;"><%= msg %></span> 
	            <% msg=null; }   %>
		  </div>
		  <div class="form-group">
		    <label for="txtName">nome</label>
		    <input type="text" class="form-control col-md-8" id="txtName" name="txtName" placeholder="Nome">
		  </div>
		  <div class="form-group">
		    <label for="txtPassword">Senha</label>
		    <input type="password" class="form-control col-md-8" id="txtPassword" name="txtPassword" placeholder="Senha">
		  </div>
	     <div class="form-group col-md-8">
		   <select id="UserType" name="UserType" class="form-control">
		   <option value="0">Administrador Site</option>
		   <option value="1">Administrador Instituição</option>
		   <option value="2">Professor</option>
		   <option value="3">Aluno</option>
		   <option value="4">     </option>
		   </select>
		  </div> 
		  <button type="submit" class="btn btn-primary">Enviar</button>
		</div>
		<div>
		<a href="DelTest.jsp" class="btn btn-secondary">deletar UserTest</a>
		
		</div>
		
</form>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>