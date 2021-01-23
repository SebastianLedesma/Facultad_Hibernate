<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ar.com.facultad.entity.Alumno"%>
<%@ page import="ar.com.facultad.entity.Profesor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista de alumnos</title>
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
	<h1>Listado de alumnos</h1>

	<form action="AltaAlumnoServlet" method="post">
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

	<form action="EliminarAlumnoServlet" method="post">
		Eliminar por id: <input type="number" min="1" max="10000"
			name="eliminarPorId" /> <input type="submit" value="Eliminar" />
	</form>

	<form action="ActualizarAlumnoServlet" method="post">
		Actualizar:
		<!-- <input type="number" min="1" max="10000" name="actualizarPorId"/> -->
		<input type="submit" value="Actualizar" />
	</form>




	<form>

		<form>
			<table
				style="width: 700px; margin-left: auto; margin-right: auto; background-color: white; border-style: solid; border-color: black; text-align: center;">
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>DIRECCIÓN</th>
					<th>TELÉFONO</th>
					<th>PROFESOR</th>
				</tr>

				<%
					List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listadoAlumnos");
					for (Alumno item : listaAlumnos) {
						out.println("<tr>");
						out.print("<td>" + item.getId() + "</td>");
						out.print("<td>" + item.getNombreCompleto().getNombre() + "</td>");
						out.print("<td>" + item.getNombreCompleto().getApellido() + "</td>");
						out.print("<td>" + item.getDireccion() + "</td>");
						out.print("<td>" + item.getTelefono() + "</td>");
						out.print("<td>" + item.getProfesor().getId() + "</td>");
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