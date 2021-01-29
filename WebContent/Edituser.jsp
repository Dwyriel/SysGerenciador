<%@ include file="header.jsp" %>
<%		String msg = null; if(request.getAttribute("Msg") != null ) { msg = (String)request.getAttribute("Msg"); 
		request.setAttribute("Msg", null);};
		String msgPassword = null; if(request.getAttribute("MsgPassword") != null ) { msgPassword = (String)request.getAttribute("MsgPassword"); 
		request.setAttribute("MsgPassword", null);}; %>
<body>
<div class="main">
	   <div class="col-md-6 col-sm-12">
	      <div class="login-form">
	         <form method="post" action="<%=request.getContextPath()%>/Edituser">
	         	<div class="form-group">
	             	<label for="txtEmail">E-mail Atual: <%= user.getEmail() %></label>
					<input type="email" class="form-control" id="txtEmail"  name="txtEmail" placeholder="Novo email" required>
					<% if(msg != null) { %>
	     		<span style="color: red;"><%= msg %></span> 
	   			 <% msg=null; }   %>
	            </div>
	            <div class="form-group">
					<label for="txtName">Nome Atual: <%= user.getName() %></label>
					<input type="text" class="form-control" id="txtName" name="txtName" placeholder="Novo Nome">
				</div>
	            <div class="form-group">
	             	<label for="txtPassword">Senha</label>
					<input type="password" class="form-control" id="txtPasswordOne" name="txtPasswordOne" placeholder="Nova Senha">
	            </div>
	            <div class="form-group">
	            	<% if(msgPassword != null) { %>
	     			<span style="color: red;"><%= msgPassword %></span> 
	   			 	<% msgPassword=null; }   %>
					<input type="password" class="form-control" id="txtPasswordTwo" name="txtPasswordTwo" placeholder="Digite a Nova Senha novamente">
	            </div>	
	            	<button type="submit" class="btn btn-secondary">Alterar Dados</button>
	            	<a type="submit" class="btn btn-secondary" href="Login.jsp">Voltar</a>
	         </form>
	         		<div class="form-group" style="margin-top: 10px">
	            	<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#modalDel">Deletar conta</button>
	            	</div>
	      </div>
	   </div>
	   </div>
</body>
<!-- Modal -->
<div class="modal fade" id="modalDel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Deseja deletar sua conta?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      Confirme se deseja ou não.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
        <a type="button" class="btn btn-secondary" href="DelUser">Sim</a>
      </div>
    </div>
  </div>
</div>
</html>