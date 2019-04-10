<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Deposit/Withdraw</title>
    </jsp:attribute>
    <jsp:body>
      <shiro:guest>
      <br>
    <article class="card">
      <div class="card-body p-5">
      <h2 class="card-title">Withdraw</h2>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="CreateTransactionServlet" method="post">
                <div class="form-group">
                  <label for="username">Full name </label>
                  <input type="text" class="form-control" name="username" placeholder="Firstname Surname">
                </div> <!-- form-group.// -->
              <div class="form-group">
                  <label for="cardNumber">IBAN</label>
                  <div class="input-group">
                    <input type="text" class="form-control" name="cardNumber" placeholder="ES00 0000 0000 0000 0000 0000">
                      <div class="input-group-append">
                         <span class="input-group-text text-muted">
                            <img src="${pageContext.request.contextPath}/images/bank-building.png" width="20px">
                        </span>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                  <div class="form-group">
                  <label for="cardNumber">Amount</label>
                  <div class="input-group">
                    <input type="text" class="form-control" aria-label="Amount" name="amount" placeholder="">
                      <div class="input-group-append">
                         <span class="input-group-text text-muted">
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
                        </span>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                <input type="hidden" name="transactionType" value="1" />
                <input type="hidden" name="email" value="${client.email}" />
                <br>
                <button type="submit" class="btn btn-primary btn-block" type="button">Withdraw</button>
                <br>
                <c:if test="${!correcto}">
                  <div class="alert alert-danger" role="alert">
                    No dispones de suficiente saldo.
                </div>
              </c:if>
                </form>
          </div> <!-- tab-pane.// -->
        </div> <!-- tab-content .// -->
      </div> <!-- card-body.// -->
    </article> <!-- card.// -->
	<br>
		<article class="card">
      <div class="card-body p-5">
      <h2 class="card-title">Deposit</h2>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="CreateTransactionServlet" method="post">
                <div class="form-group">
                  <label for="username">Full name (on the card)</label>
                  <input type="text" class="form-control" name="username" placeholder="Firstname Surname">
                </div> <!-- form-group.// -->
              <div class="form-group">
                  <label for="cardNumber">Card number</label>
                  <div class="input-group">
                    <input type="text" class="form-control" name="cardNumber" placeholder="0000 0000 0000 0000">
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
                              <input type="number" class="form-control" placeholder="MM" name="">
                              <input type="number" class="form-control" placeholder="YY" name="">
                           </div>
                       </div>
                  </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                          <label data-toggle="tooltip" title="" data-original-title="3 digits code on back side of the card">CVV <i class="fa fa-question-circle"></i></label>
                            <input type="number" class="form-control" required="">
                        </div> <!-- form-group.// -->
                      </div>
                  </div>
                  <div class="form-group">
                  <label for="cardNumber">Amount</label>
                  <div class="input-group">
                    <input type="text" class="form-control" aria-label="Amount" name="amount" placeholder="">
                      <div class="input-group-append">
                         <span class="input-group-text text-muted">
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
                        </span>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                <br>
                <input type="hidden" name="transactionType" value="0" />
                <input type="hidden" name="email" value="${client.email}" />
                <button type="submit" class="btn btn-primary btn-block" type="button">Deposit</button>
                </form>
          </div> <!-- tab-pane.// -->
        </div> <!-- tab-content .// -->
      </div> <!-- card-body.// -->
    </article> <!-- card.// -->
    
	<br>
	    </shiro:guest>
    </jsp:body>
</t:layout>
