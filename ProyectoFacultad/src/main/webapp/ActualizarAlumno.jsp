
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ar.com.facultad.entity.Alumno"%>
<%@ page import="ar.com.facultad.entity.Profesor"%>
<%
	Alumno alumno = (Alumno) request.getAttribute("alumno");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar alumno</title>
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
	<h1>Actualizar datos del alumno</h1>
	<form action="ActualizarDatosAlumnoServlet" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="number" name="idAlumno" required autofocus /></td>
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
				<td>Dirección:</td>
				<td><input type="text" name="direccion" required /></td>
			</tr>

			<tr>
				<td>Teléfono:</td>
				<td><input type="text" name="telefono" required /></td>
			</tr>

			<tr>
				<td>Profesor:</td>
				<td><select name="profesorId">
						<%
							List<Profesor> listaProfesores = (List<Profesor>) request.getAttribute("listaProfesores");
							for (Profesor lista : listaProfesores) {
								out.println("<option value=" + lista.getId() + ">" + lista.getNombreCompleto().getApellido() + " "
										+ lista.getCurso().toString() + "</option>");
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