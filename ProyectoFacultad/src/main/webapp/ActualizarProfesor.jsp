<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ar.com.facultad.enumerator.ECurso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar profesor</title>
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
	<h1>Ingrese los datos del profesor</h1>

	<form action="ActualizarProfesorServlet" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="number" name="idProfesor" required autofocus /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" required /></td>
			</tr>

			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" required /></td>
			</tr>

			<tr>
				<td>Materia:</td>
				<td><select name="materia">
						<%
							for (ECurso item : ECurso.values()) {
								out.println("<option value=" + item + ">" + item + "</option>");
							}
						%>
				</select>
				<td />
			</tr>

			<tr>
				<td><input type="reset" value="Limpiar" /></td>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form>

	<form action="MenuPrincipal.jsp">
		<input type="submit" value="Volver" />
	</form>
</body>
</html>