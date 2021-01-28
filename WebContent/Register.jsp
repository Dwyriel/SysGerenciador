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
<link rel="stylesheet" type="text/css" href="style/Login.css" media="screen" />
<title>Insert title here</title>
</head>
<body>
<div class="sidenav">
   <div class="login-main-text">
      <h2>Blackbox</h2>
      <p>Página de Registro.</p>
   </div>
</div>
<div class="main">
	   <div class="col-md-6 col-sm-12">
	      <div class="login-form">
	         <form method="post" action="<%=request.getContextPath()%>/Register">
	          <div class="form-group">
	             <label for="txtEmail">E-mail</label>
					<input type="email" class="form-control" id="txtEmail"  name="txtEmail" placeholder="Seu email" required>
				<% if(msg != null) { %>
	     		<span style="color: red;"><%= msg %></span> 
	   			 <% msg=null; }   %>
	            </div>
	            <div class="form-group">
				<label for="txtName">nome</label>
				<input type="text" class="form-control" id="txtName" name="txtName" placeholder="Nome">
			</div>
	            <div class="form-group">
	              <label for="txtPassword">Senha</label>
			<input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Senha">
	            </div>
	            <button type="submit" class="btn btn-black">Enviar</button>
	            <a type="submit" class="btn btn-secondary" href="Login.jsp">Voltar</a>
	         </form>
	      </div>
	   </div>
	   </div>

</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>