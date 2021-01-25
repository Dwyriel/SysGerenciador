<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/deltestuser">
	<label for="txtEmail">ID</label>
	<input type="text" class="form-control col-md-8" id="iduser"  name="iduser" placeholder="ID do usuário para deletar">
	<button type="submit" class="btn btn-primary">Enviar</button>
</form>
</body>
</html>