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
		<h2>Account</h2>
		<table class="table">
  <thead class="thead-light" >
    <tr>
      <th scope="col">COIN</th>
      <th scope="col">AMOUNT</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>USD</td>
      <td>${cliente.account.wallet.usd}</td>
    </tr>
    <tr>
     <td>EUR</td>
     <td>${cliente.account.wallet.eur}</td>
    </tr>
    <tr>
     <td>YEN</td>
     <td>${cliente.account.wallet.yen}</td>
    </tr>
    <tr>
     <td>GBP</td>
     <td>${cliente.account.wallet.gbp}</td>
    </tr>
    <tr>
     <td>SFr</td>
     <td>${cliente.account.wallet.sfr}</td>
    </tr>
    <tr>
     <td>AUD</td>
     <td>${cliente.account.wallet.aud}</td>
    </tr>
    <tr>
     <td>CAD</td>
     <td>${cliente.account.wallet.cad}</td>
    </tr>
  </tbody>
</table>
	<h4>DEPOSIT</h4>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <c:choose>
	        <c:when test="${client.divisa == usd}"><span class="input-group-text">USD</span></c:when>
	        <c:when test="${client.divisa == eur}"><span class="input-group-text">EUR</span></c:when>
	        <c:when test="${client.divisa == yen}"><span class="input-group-text">YEN</span></c:when>
	        <c:when test="${client.divisa == gbp}"><span class="input-group-text">GBP</span></c:when>
	        <c:when test="${client.divisa == sfr}"><span class="input-group-text">SFr</span></c:when>
	        <c:when test="${client.divisa == aud}"><span class="input-group-text">AUD</span></c:when>
	        <c:when test="${client.divisa == cad}"><span class="input-group-text">CAD</span></c:when>
	        <c:otherwise>undefined</c:otherwise>
	    </c:choose>
	    <input type="text" class="form-control" aria-label="Amount" name="depositAmount">
	    <input type="hidden" name="email" value="${client.email}" />
	    <button type="submit" class="btn btn-outline-secondary" type="button" action="DepositServlet" method="post">Deposit</button>
	  </div>
	</div>
	<h4>WITHDRAW</h4>
	<div class="input-group mb-3">
		 <div class="input-group-prepend">
		    <c:choose>
		        <c:when test="${client.divisa == usd}"><span class="input-group-text">USD</span></c:when>
		        <c:when test="${client.divisa == eur}"><span class="input-group-text">EUR</span></c:when>
		        <c:when test="${client.divisa == yen}"><span class="input-group-text">YEN</span></c:when>
		        <c:when test="${client.divisa == gbp}"><span class="input-group-text">GBP</span></c:when>
		        <c:when test="${client.divisa == sfr}"><span class="input-group-text">SFr</span></c:when>
		        <c:when test="${client.divisa == aud}"><span class="input-group-text">AUD</span></c:when>
		        <c:when test="${client.divisa == cad}"><span class="input-group-text">CAD</span></c:when>
		        <c:otherwise>undefined</c:otherwise>
		    </c:choose>
		    <input type="hidden" name="email" value="${client.email}" />
		    <input type="hidden" name="coin" value="${client.divisa}" />
  			<input type="text" class="form-control" aria-label="Amount" name="withdrawAmount">
  		<button type="submit" class="btn btn-outline-secondary" type="button" action="WithdrawServlet" method="post">Whitdraw</button>
		</div>
	</div>
	</shiro:guest>
    </jsp:body>
</t:layout>