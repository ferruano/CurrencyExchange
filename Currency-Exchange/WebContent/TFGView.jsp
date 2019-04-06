<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>Datos de tu TFG</h2>
	
		<h5>Título: ${tfg.title}</h5>
		<h5>Nombre: ${tfg.name}</h5>
		<h5>e-mail: ${tfg.email}</h5>
		<h5>Estado: ${tfg.status}</h5>
		
		<h5>Documento: ${tfg.document}</h5>
		<c:if test="${tfg.status == 3}">	
		<form action="Form4TFGServlet" method="post" enctype="multipart/form-data">
		<input type= "hidden" name="email" value="${tfg.email}">
   		<input type="file" name="file" />
    	<button type="submit">Subir memoria</button>
		</form>
		</c:if>
		<c:if test="${tfg.status == 4}">	
		<form action="ServeFileServlet" method="get">
		<input type= "hidden" name="email" value="${tfg.email}">
    	<button type="submit">Descargar memoria</button>
		</form>
		</c:if>
		<h5>Nombre tutor: ${tfg.advisor.name}</h5>
		<h5>e-mail tutor: ${tfg.advisor.email}</h5>
		</shiro:user>
	
</body>
</html>