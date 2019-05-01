<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>You$wap</title>
    </jsp:attribute>
   
    <jsp:body>    	
			<div align="center" class="card" style="width: 30rem; display: block; margin: auto; margin-top:20px">
			  <img src="${pageContext.request.contextPath}/images/Logo.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h2 class="card-title">You$wap</h2>
			    <p class="card-text">The perfect way to change your money.</p>
			    <shiro:user>
			    <a href="AccountServlet?email=${client.email}" class="btn btn-primary">Your balance</a>
			    </shiro:user>
			  </div>
			</div>
    </jsp:body>
</t:layout>