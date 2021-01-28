<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.http.*,classes.*,classes.users.*" %>
     <%		String msg = null; if(request.getAttribute("Msg") != null ) { msg = (String)request.getAttribute("Msg"); 
request.setAttribute("Msg", null);}; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/Login.css" media="screen" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Blackbox</title>
</head>
<body>
	
	<div class="sidenav">
	         <div class="login-main-text">
	            <h2>Backbox</h2>
	            <p>Faça Login ou se Registre para ter acesso.</p>
	         </div>
	      </div>
	      <div class="main">
	         <div class="col-md-6 col-sm-12">
	            <div class="login-form">
	               <form method="post" action="<%=request.getContextPath()%>/Login">
	                  <div class="form-group">
	                     <label>E-Mail</label>
	                     <input type="text" name="UserEmail" class="form-control" placeholder="E-Mail" required>
	                  </div>
	                  <div class="form-group">
	                     <label>Password</label>
	                     <input type="password" name="UserPassword" class="form-control" placeholder="Password" required>
	                     <% if(msg != null) { %>
	                    	<span style="color: red;"><%= msg %></span> 
	                     <% msg=null; }   %>
	                  </div>
	                  <button type="submit" class="btn btn-black">Login</button>
	                 <!--  <a type="submit" class="btn btn-secondary" href="Register.jsp">Registrar</a>  -->
	               </form>
	            </div>
	         </div>
	         </div>
</body>
<%
	    String alert = null; if(request.getAttribute("Alert") != null ){ alert = (String)request.getAttribute("Alert");}  
 if (alert != null ) { %> 	<script> alert("<%= alert %>"); </script> 	<% } %>
 <% 	
 	if(session.getAttribute("user") != null) {
 		
 		User user = (User)session.getAttribute("user");
 		
 		if(user.getType() == UserType.ServerAdmin) {
			 
			 response.sendRedirect(request.getContextPath() + "/AdminPainel.jsp");
			 
        }  else if (user.getType() == UserType.InstitutionAdmin){
    
       	 response.sendRedirect(request.getContextPath() + "/InstitutionPage.jsp");
 
  		 }  else if (user.getType() == UserType.Teacher){
  			 
  			response.sendRedirect(request.getContextPath() + "/Institution.jsp");
        
  		 } else if (user.getType() == UserType.Student){   
  			 
  			response.sendRedirect(request.getContextPath() + "/Content.jsp");
  			
  		 } else {
  			 
  			response.sendRedirect(request.getContextPath() + "/ERROR.jsp");
  		 }
	}
 %>
</html>