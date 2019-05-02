<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>History</title>
    </jsp:attribute>
    <jsp:body>
    	<shiro:guest> 
    	<br>
    	<div class="alert alert-info" role="alert">
		  <h4 class="alert-heading">You are not logged in!</h4>
		  <p>Please login to access this information.</p>
		  <hr>
		  <p class="mb-0">You can do this by selecting a user at the top right of the navigation bar.</p>
		</div>
    </shiro:guest>
        <shiro:user>
	        <br>
	      <div class="card">
			  <div class="card-body">  
					<h3 class="card-title">Transaction history</h3>
					<table class="table">
					  <thead class="thead-light" >
					    <tr>
					      <th scope="col">Transaction ID</th>
					      <th scope="col">Amount</th>
					      <th scope="col">Currency</th>
					      <th scope="col">Date</th>
					      <th scope="col">Type</th>
					      <!-- <th scope="col">User</th> -->
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${transactions}" var="tri">
					  	<c:if test="${tri.user.accountID == client.account.accountID}">
						    <tr>
						      <td>${tri.transactionID}</td>
						      <td>${tri.amount}</td>
						      <td>
						      	 <c:choose>
			                          <c:when test="${tri.currencyType == 6}">USD</c:when>
			                          <c:when test="${tri.currencyType == 3}">EUR</c:when>
			                          <c:when test="${tri.currencyType == 7}">JPY</c:when>
			                          <c:when test="${tri.currencyType == 4}">GBP</c:when>
			                          <c:when test="${tri.currencyType == 5}">CHF</c:when>
			                          <c:when test="${tri.currencyType == 1}">AUD</c:when>
			                          <c:when test="${tri.currencyType == 2}">CAD</c:when>
			                          <c:otherwise>undefined</c:otherwise>
                        		</c:choose>
						      </td>
						      <td>${tri.transactionDate}</td>
						      <td>
						      	<c:choose>
						      		<c:when test="${tri.transactionType == 1}">POS Terminal</c:when>
						      		<c:when test="${tri.transactionType == 2}">Swap Out</c:when>
						      		<c:when test="${tri.transactionType == 3}">Swap In</c:when>
			                        <c:otherwise>Load</c:otherwise>
						      	</c:choose>
						      </td>
						      <!--<td>${tri.user}</td> -->
						    </tr>
					    </c:if>
					   </c:forEach>
					  </tbody>
					</table>
				</div>
			</div>
		</shiro:user>
    </jsp:body>
</t:layout>