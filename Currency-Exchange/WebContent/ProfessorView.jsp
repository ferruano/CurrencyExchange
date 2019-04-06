<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TFG View</title>
</head>
<body>
<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
<hr>
	<shiro:user>
	<h2>Datos personales</h2>
	
		
		<h5>Nombre: ${professor.name}</h5>
		<h5>e-mail: ${professor.email}</h5>
		
	<h2>TFGs aceptados</h2>
	<table border="1">
			<tr>
				<th>Título</th>
				<th>Email alumno</th>
				<th>Nombre del alumno</th>
				<th>Estado del TFG</th>
				<th>Memoria</th>
				<th>Acción requerida</th>
			</tr>
			<c:forEach items="${tfgs_accepted}" var="tfgi">
				<tr>
					<td>${tfgi.title }</td>
					<td>${tfgi.email }</td>
					<td>${tfgi.name }</td>
					<td>${tfgi.status }</td>
					<td><c:if test="${tfgi.status > 3}">
							<form action="ServeFileServlet">
								<input type="hidden" name="email" value="${tfgi.email}" />
								<button type="submit">Descargar</button>
							</form>
						</c:if></td>
					<td><c:if test="${tfgi.status == 1}">
							<form action="Form2ProfessorServlet" method="post">
								<input type="hidden" name="email" value="${tfgi.email}" />
								<button type="submit">Aceptar tfg</button>
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>	
		
	</shiro:user>
	
</body>
</html>