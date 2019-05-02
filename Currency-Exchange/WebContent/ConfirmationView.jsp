<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Confirm Request</title>
    </jsp:attribute>
    <jsp:body>
      <shiro:user>
      <br>
    <article class="card">
      <div class="card-body p-5">
      	<h2 class="card-title">Confirm your swap request</h2>
      	<br>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="CreateTransactionServlet" method="post">
            	<div class="container">
				  <div class="col justify-content-md-center">
				    <div class="col-9">
				      <div class="form-group">
                  		<label for="amount"> You will change:  <strong>${amount} ${fromCurrency}</strong></label>
                  		<label for="amount"> Into: <strong>${newAmount} ${toCurrency} </strong></strong></label>
                	  </div> <!-- form-group.// -->
				    </div>
				    <h5>How quickly do you need the money?</h5>
				    <br>
				    <div>
				    	<div class="form-check">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
  							<label class="form-check-label" for="exampleRadios1">
    							Instant swap: 1.5%
  							</label>
						</div>
						<div class="form-check">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2" disabled>
  							<label class="form-check-label" for="exampleRadios2">
    							3 day swap: 1.3%
  							</label>
						</div>
						<div class="form-check">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3" disabled>
  							<label class="form-check-label" for="exampleRadios3">
    							6 day swap: 1.0%
  							</label>
						</div>
				    </div>
				    <br>
				    <h6>The only fee we take is a small percentage of the swap, based on how fast you need your money.</h6>
				</div>
				<br>
			  	<div >
					<div class="row justify-content-md-center">
						<div class="col-4">
					  		<a href="ExchangeServlet?email=${client.email}" class="btn btn-primary">Go back</a>
					    </div>
					    <div class="col-3">
					    </div>
					    <div class="col-4">
					    	<button type="submit" class="btn btn-primary btn-block" type="button">Create swap</button>
					    </div>
					  </div>
					</div>
					<input type="hidden" name="transactionType" value="2" >
					<input type="hidden" name="from" value="${from}" >
					<input type="hidden" name="to" value="${to}" >
					<input type="hidden" name="email" value="${client.email}" >
					<input type="hidden" name="oldAmount" value="${amount}" >
					<input type="hidden" name="newAmount" value="${newAmount}" >
				</div>
            </form>
          </div> <!-- tab-pane.// -->
        </div> <!-- tab-content .// -->
      </div> <!-- card-body.// -->
    </article> <!-- card.// -->
	
	    </shiro:user>
    </jsp:body>
</t:layout>
