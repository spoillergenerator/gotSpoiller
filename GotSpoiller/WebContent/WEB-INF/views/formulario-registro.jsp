<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registro de usuário</h2>
	<form action="efetuaRegistro" method="post"
		enctype="multipart/form-data">
		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		Foto: <input type="file" name="foto" /> <br /> <br /> 
		<input type="submit" value="Registrar" />
	</form>

</body>
</html>