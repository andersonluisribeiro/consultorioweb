<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Médicos</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
		</tr>

		<c:forEach items="${medicos}" var="medico">
			<tr>
				<td>${medico.id}</td>
				<td>${medico.nome}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>