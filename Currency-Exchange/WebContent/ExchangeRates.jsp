<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Exchange Rates</title>
    </jsp:attribute>
    <jsp:body>
        <br>
    <div class="card">
  		<div class="card-body">  
			<h3 class="card-title" align="center">Exchange Rates</h3>
			<div class="container">
			  <div class="row" align="center">
			  				<div class="nav-item dropdown" style="margin:auto; max-width: 300px;">
					        	<a class="nav-link dropdown-toggle"  href="ExchangeRatesServlet" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          	Choose currency to compare
					        	</a>
					        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=USD&email=${client.email}">USD</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=EUR&email=${client.email}">EUR</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=JPY&email=${client.email}">JPY</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=GBP&email=${client.email}">GBP</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=CHF&email=${client.email}">CHF</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=AUD&email=${client.email}">AUD</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=CAD&email=${client.email}">CAD</a>
					        	</div>
					      	</div>
			  </div>
			  <br>
			  	<div class="container">	
			  	<div class="row justify-content-md-center border border-primary rounded">
			  	 <div class="col-3 align-self-center text-center">
     				1 ${orCurrency} = 
   				 </div>
   				 <div class="col border-left border-primary"> 
			  	<table class="table">
				  <tbody>
				    <tr style=${usdHide}>
				      <td>${usdRate}</td>
				      <td>USD</td>
				    </tr>
				    <tr style=${eurHide}>
				      <td>${eurRate}</td>
				      <td>EUR</td>
				    </tr>
				    <tr style=${jpyHide}>
				      <td>${jpyRate}</td>
				      <td>JPY</td>
				    </tr>
				    <tr style=${gbpHide}>
				      <td>${gbpRate}</td>
				      <td>GBP</td>
				    </tr>
				    <tr style=${chfHide}>
				      <td>${chfRate}</td>
				      <td>CHF</td>
				    </tr>
				    <tr style=${audHide}>
				      <td>${audRate}</td>
				      <td>AUD</td>
				    </tr>
				    <tr style=${cadHide}>
				      <td>${cadRate}</td>
				      <td>CAD</td>
				    </tr>
				  </tbody>
				</table>
				</div>
				</div>
				</div>
			  
			</div>
 		</div>
	</div>
	<br> 
    </jsp:body>
</t:layout>