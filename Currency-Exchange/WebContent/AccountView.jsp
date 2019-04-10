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
      <td>${client.account.wallet.usd}</td>
    </tr>
    <tr>
     <td>EUR</td>
     <td>${client.account.wallet.eur}</td>
    </tr>
    <tr>
     <td>YEN</td>
     <td>${client.account.wallet.yen}</td>
    </tr>
    <tr>
     <td>GBP</td>
     <td>${client.account.wallet.gbp}</td>
    </tr>
    <tr>
     <td>SFr</td>
     <td>${client.account.wallet.sfr}</td>
    </tr>
    <tr>
     <td>AUD</td>
     <td>${client.account.wallet.aud}</td>
    </tr>
    <tr>
     <td>CAD</td>
     <td>${client.account.wallet.cad}</td>
    </tr>
  </tbody>
</table>
	</shiro:guest>
    </jsp:body>
</t:layout>