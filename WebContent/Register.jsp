<%@ include file="header.jsp" %>
    <%		String msg = null; if(request.getAttribute("Msg") != null ) { msg = (String)request.getAttribute("Msg"); 
		request.setAttribute("Msg", null);}; %>
	 <% if(user.getType() != UserType.InstitutionAdmin && user.getType() != UserType.ServerAdmin) {
				String alert ="Você não tem permissão para acessar está página";
				request.setAttribute("Alert", alert);
				request.getRequestDispatcher("/Login.jsp").include(request, response);
				return;
				}	
				%>
				<%
	    String alert = null; if(request.getAttribute("Alert") != null ){ alert = (String)request.getAttribute("Alert");}  
 if (alert != null ) { %> 	<script> alert("<%= alert %>"); </script> 	<% } %>
<body>
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
	            <div class="form-group">		            
				   <select id="UserType" name="UserType" class="form-control">
				   	<% if(user.getType() == UserType.ServerAdmin) { %>
            			<option value="0">Administrador Site</option>
            		<% }  %>	
				   		<option value="1">Administrador Instituição</option>	
				   		<% if(user.getType() == UserType.InstitutionAdmin) { %>
            			<option value="2">Professor</option>		            
				   		<option value="3">Aluno</option>
            		<% }  %>
				   		
				   </select>
		   	</div>	
	            <button type="submit" class="btn btn-primary">Cadastrar</button>
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