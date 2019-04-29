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
        <shiro:guest>
        <br>
    <div class="card">
  		<div class="card-body">  
			<h3 class="card-title" align="center">Exchange Rates</h3>
			<div class="container">
			  <div class="row" align="center">
			  				<div class="nav-item dropdown" style="margin:auto; max-width: 300px;">
					        	<a class="nav-link dropdown-toggle"  href="ExchangeRatesServlet" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          	Origin currency
					        	</a>
					        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=USD">USD</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=EUR">EUR</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=JPY">JPY</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=GBP">GBP</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=CHF">CHF</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=AUD">AUD</a>
					          			<div class="dropdown-divider"></div>
					          		<a class="dropdown-item" href="ExchangeRatesServlet?orCurrency=CAD">CAD</a>
					        	</div>
					      	</div>
			  </div>
			  <!--<div class="row">
			    <div class="col-md-4" style="margin:auto; max-width: 300px;">
			      <div class="row" style="margin:auto; max-width: 300px;">${orCurrency}</div>
			    </div>
			    <div class="col-md-4">
			      <div class="row" style="margin:auto; max-width: 300px;">${usdRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${eurRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${jpyRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${gbpRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${chfRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${audRate}</div>
			      <div class="row" style="margin:auto; max-width: 300px;">${cadRate}</div>
			    </div>
			    <div class="col-md-4">
			      <div class="row" style="margin:auto; max-width: 300px;">USD</div>
			      <div class="row" style="margin:auto; max-width: 300px;">EUR</div>
			      <div class="row" style="margin:auto; max-width: 300px;">JPY</div>
			      <div class="row" style="margin:auto; max-width: 300px;">GBP</div>
			      <div class="row" style="margin:auto; max-width: 300px;">CHF</div>
			      <div class="row" style="margin:auto; max-width: 300px;">AUD</div>
			      <div class="row" style="margin:auto; max-width: 300px;">CAD</div>
			    </div>
			  </div>-->
			  
			  	<table class="table table-striped">
				  <tbody>
				    <tr style=${usdHide}>
				      <td>${orCurrency}</td>
				      <td>${usdRate}</td>
				      <td>USD</td>
				    </tr>
				    <tr style=${eurHide}>
				      <td>${orCurrency}</td>
				      <td>${eurRate}</td>
				      <td>EUR</td>
				    </tr>
				    <tr style=${jpyHide}>
				      <td>${orCurrency}</td>
				      <td>${jpyRate}</td>
				      <td>JPY</td>
				    </tr>
				    <tr style=${gbpHide}>
				      <td>${orCurrency}</td>
				      <td>${gbpRate}</td>
				      <td>GBP</td>
				    </tr>
				    <tr style=${chfHide}>
				      <td>${orCurrency}</td>
				      <td>${chfRate}</td>
				      <td>CHF</td>
				    </tr>
				    <tr style=${audHide}>
				      <td>${orCurrency}</td>
				      <td>${audRate}</td>
				      <td>AUD</td>
				    </tr>
				    <tr style=${cadHide}>
				      <td>${orCurrency}</td>
				      <td>${cadRate}</td>
				      <td>CAD</td>
				    </tr>
				  </tbody>
				</table>
			  
			</div>
 		</div>
	</div> 
	</shiro:guest>
    </jsp:body>
</t:layout>