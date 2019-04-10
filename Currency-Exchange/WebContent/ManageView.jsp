<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Balance</title>
    </jsp:attribute>
    <jsp:body>
    	<shiro:guest>
			<h4>DEPOSIT</h4>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <c:choose>
			        <c:when test="${client.localCurrency == 6}"><span class="input-group-text">USD</span></c:when>
			        <c:when test="${client.localCurrency == 3}"><span class="input-group-text">EUR</span></c:when>
			        <c:when test="${client.localCurrency == 7}"><span class="input-group-text">YEN</span></c:when>
			        <c:when test="${client.localCurrency == 4}"><span class="input-group-text">GBP</span></c:when>
			        <c:when test="${client.localCurrency == 5}"><span class="input-group-text">SFr</span></c:when>
			        <c:when test="${client.localCurrency == 1}"><span class="input-group-text">AUD</span></c:when>
			        <c:when test="${client.localCurrency == 2}"><span class="input-group-text">CAD</span></c:when>
			        <c:otherwise>undefined</c:otherwise>
			    </c:choose>
			    <form action="CreateTransactionServlet" method="post">
			    	<input type="number" class="form-control" aria-label="Amount" name="amount">
			    	<input type="hidden" name="transactionType" value="0" />
			    	<input type="hidden" name="email" value="${client.email}" />
			    	<button type="submit" class="btn btn-outline-secondary" type="button">Deposit</button>
			    </form>
			    
			  </div>
			</div>
			<h4>WITHDRAW</h4>
			<div class="input-group mb-3">
				 <div class="input-group-prepend">
				    <c:choose>
				        <c:when test="${client.localCurrency == 6}"><span class="input-group-text">USD</span></c:when>
				        <c:when test="${client.localCurrency == 3}"><span class="input-group-text">EUR</span></c:when>
				        <c:when test="${client.localCurrency == 7}"><span class="input-group-text">YEN</span></c:when>
				        <c:when test="${client.localCurrency == 4}"><span class="input-group-text">GBP</span></c:when>
				        <c:when test="${client.localCurrency == 5}"><span class="input-group-text">SFr</span></c:when>
				        <c:when test="${client.localCurrency == 1}"><span class="input-group-text">AUD</span></c:when>
				        <c:when test="${client.localCurrency == 2}"><span class="input-group-text">CAD</span></c:when>
				        <c:otherwise>undefined</c:otherwise>
				    </c:choose>
				    <form action="CreateTransactionServlet" method="post">
				    	<input type="hidden" name="email" value="${client.email}" />
				    	<input type="hidden" name="transactionType" value="1" />
		  				<input type="number" class="form-control" aria-label="Amount" name="amount">
		  				<button type="submit" class="btn btn-outline-secondary" type="button">Whitdraw</button>
				    </form>
				</div>
			</div>
			
			<c:if test="${!correcto}">
    			<script>
    				window.addEventListener("load",function(){
         				alert("No dispones de saldo suficiente");
         			}
    			</script>
			</c:if>
		</shiro:guest>
    </jsp:body>
</t:layout>