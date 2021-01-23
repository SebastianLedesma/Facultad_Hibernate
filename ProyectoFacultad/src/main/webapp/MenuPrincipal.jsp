<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de la facultad</title>
<style>
form {
	margin-top: 10px;
}

body {
	background-color: lightgreen;
}

h1 {
	color: slateblue;
}
</style>
</head>
<body>
	<form action="ListaProfesoresServlet" method="post">
		<input type="submit" value="Ver profesores">
	</form>

	<form action="ListaAlumnosServlet" method="post">
		<input type="submit" value="Ver Alumnos">
	</form>
</body>
</html>