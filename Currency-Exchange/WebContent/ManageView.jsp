<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Load Money</title>
    </jsp:attribute>
    <jsp:body>
       <br>
       <div class="container">
  		<div class="row justify-content-center">
    		<div class="col-9 align-self-center">
       			<shiro:guest> 
    	<div class="alert alert-info" role="alert">
		  <h4 class="alert-heading">You are not logged in!</h4>
		  <p>Please login to access this information.</p>
		  <hr>
		  <p class="mb-0">You can do this by selecting a user at the top right of the navigation bar.</p>
		</div>
    </shiro:guest>
      <shiro:user>
      <br>
      
		<article class="card">
      <div class="card-body p-5">
      <h2 class="card-title">Load money into your Account</h2>
      <br>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="CreateTransactionServlet" method="post">
                <div class="form-group">
                  <label for="username">Full name (on the card)</label>
                  <input type="text" class="form-control" name="username" placeholder="Firstname Surname"  required>
                </div> <!-- form-group.// -->
              <div class="form-group">
                  <label for="cardNumber">Card number</label>
                  <div class="input-group">
                    <input type="number" class="form-control" name="cardNumber" placeholder="0000 0000 0000 0000"  required>
                      <div class="input-group-append">
                         <span class="input-group-text text-muted">
                            <img src="${pageContext.request.contextPath}/images/credit-card.png" width="20px">
                        </span>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                <div class="row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label><span class="hidden-xs">Expiration</span> </label>
                           <div class="input-group">
                              <input type="number" class="form-control" placeholder="MM" name="" required>
                              <input type="number" class="form-control" placeholder="YY" name="" required>
                           </div>
                       </div>
                  </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                          <label data-toggle="tooltip" title="" data-original-title="3 digits code on back side of the card">CVV <i class="fa fa-question-circle"></i></label>
                            <input type="number" class="form-control" required>
                        </div> <!-- form-group.// -->
                      </div>
                  </div>
                  <div class="form-group">
                  <label for="cardNumber">Amount</label>
                  <div class="input-group">
                    <input type="number" class="form-control" min="0" aria-label="Amount" name="amount" required>
                      <div class="input-group-append">
                            <c:choose>
                          <c:when test="${client.localCurrency == 6}"><span class="input-group-text">USD</span></c:when>
                          <c:when test="${client.localCurrency == 3}"><span class="input-group-text">EUR</span></c:when>
                          <c:when test="${client.localCurrency == 7}"><span class="input-group-text">JPY</span></c:when>
                          <c:when test="${client.localCurrency == 4}"><span class="input-group-text">GBP</span></c:when>
                          <c:when test="${client.localCurrency == 5}"><span class="input-group-text">CHF</span></c:when>
                          <c:when test="${client.localCurrency == 1}"><span class="input-group-text">AUD</span></c:when>
                          <c:when test="${client.localCurrency == 2}"><span class="input-group-text">CAD</span></c:when>
                          <c:otherwise>undefined</c:otherwise>
                        </c:choose>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                <br>
                <input type="hidden" name="transactionType" value="0" />
                <input type="hidden" name="email" value="${client.email}" />
                <button type="submit" class="btn btn-primary btn-block" type="button">Load</button>
                </form>
          </div> <!-- tab-pane.// -->
        </div> <!-- tab-content .// -->
      </div> <!-- card-body.// -->
    </article> <!-- card.// -->
    
	<br>
	    </shiro:user>
    		</div>
  		</div>
	</div>
    
    </jsp:body>
</t:layout>
