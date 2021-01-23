<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
<style>
body {
	background-color: lightgreen;
}

h1 {
	color: slateblue;
}
</style>
</head>
<body>
	<h1>Resultado de operación</h1>
	<%
		boolean resultado = (boolean) request.getAttribute("resultado");
		if (resultado) {
			out.println("<h2>La opreacion de realizó correctamente.</h2>.");
		} else {
			out.println("<h2>No se pudo realizar la operación.");
		}
	%>

	<form action="MenuPrincipal.jsp">
		<input type="submit" value="Volver" />
	</form>
</body>
</html>