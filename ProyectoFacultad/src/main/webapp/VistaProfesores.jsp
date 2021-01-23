<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ar.com.facultad.enumerator.ECurso"%>
<%@ page import="ar.com.facultad.entity.Profesor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista de profesores</title>
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
	<h1>Listado de profesores</h1>


	<form action="AltaProfesorServlet" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" required autofocus /></td>
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

	<form action="EliminarProfesorServlet" method="post">
		Eliminar por id: <input type="number" min="1" max="10000"
			name="eliminarPorId" /> <input type="submit" value="Eliminar" />
	</form>

	<form action="ActualizarProfesor.jsp" method="post">
		Actualizar por id:
		<!--<input type="number" min="1" max="10000" name="actualizarPorId"/>-->
		<input type="submit" value="Actualizar" />
	</form>


	<form>
		<table
			style="width: 700px; margin-left: auto; margin-right: auto; background-color: white; border-style: solid; border-color: black; text-align: center;">
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>APELLIDO</th>
				<th>MATERIA</th>
			</tr>

			<%
				List<Profesor> listaProfesores = (List<Profesor>) request.getAttribute("listado");
				for (Profesor item : listaProfesores) {
					out.println("<tr>");
					out.print("<td>" + item.getId() + "</td>");
					out.print("<td>" + item.getNombreCompleto().getNombre() + "</td>");
					out.print("<td>" + item.getNombreCompleto().getApellido() + "</td>");
					out.print("<td>" + item.getCurso().toString() + "</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</form>

	<form action="MenuPrincipal.jsp">
		<input type="submit" value="Volver" />
	</form>
</body>
</html>