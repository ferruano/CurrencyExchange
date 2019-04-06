<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Login View </title>
    </jsp:attribute>
    <jsp:body>
        <shiro:guest>
		<h2>Login</h2>
		<form action="LoginServlet" method="post">
			<div class="form-group">
    			<label for="exampleInputEmail1">Email address</label>
    			<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
    			<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  			</div>
			<div class="form-group">
    			<label for="exampleInputPassword1">Password</label>
    			<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
  			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<c:if test= "${not empty professor_list}">
		<h2>Crear nuevo TFG</h2>
		<form action="CreateTFGServlet" method="post">
			<p>
				Nombre: <input type="text" name="name" />
			</p>
			<p>
				Title: <input type="text" name="title" />
			</p>
			<p>
				Email: <input type="text" name="email" />
			</p>
			<p>
				Tutor: <select name = "advisor"><option value="" disabled selected>Elija un tutor</option>
				<c:forEach items="${professor_list}" var="professori">
					<option value="${professori.email}">${professori.name}-${professori.email}</option>
				</c:forEach>
				</select>
			</p>
			<p>
				Password: <input type="password" name="password" />
			</p>
			<p>
				<button type="submit" class="btn btn-primary">Solicitar TFG</button>
			</p>
		</form>
		</c:if>
	</shiro:guest>
    </jsp:body>
</t:layout>