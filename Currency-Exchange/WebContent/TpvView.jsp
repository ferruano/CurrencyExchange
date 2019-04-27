<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<style>
	tr, td {
		text-align: center;
	}
	table {
		table-layout:fixed;
	} c xz
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo.jpg">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
  <body>
    <article class="card">
      <div class="card-body p-5">
      <h2 class="card-title">TPV</h2>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="CreateTransactionServlet" method="post">
                <div class="form-group">
                  <label for="email">email </label>
					<input type="text" name="email" />                </div> <!-- form-group.// -->
              <div class="form-group">
                </div> <!-- form-group.// -->
                  <div class="form-group">
                  <label for="cardNumber">Amount</label>
                  <div class="input-group">
                    <input type="number" class="form-control" min="0" aria-label="Amount" name="amount" required>
                    <div class="input-group-append">

						  <select name="currency" class="form-control" id="currency">
						    <option value="1">AUD</option>
						    <option value="2">CAD</option>
						    <option value="3">EUR</option>
						    <option value="4">GBP</option>
						    <option value="5">SFr</option>
						    <option value="6">USD</option>
						    <option value="7">YEN</option>
						  </select>
                      </div>
                  </div>
                </div> <!-- form-group.// -->
                <input type="hidden" name="transactionType" value="1" />
                <button type="submit" class="btn btn-primary btn-block" type="button">Accept</button>
                <c:if test="${!correcto}">
                  <div class="alert alert-danger" role="alert">
                    No dispones de suficiente saldo.
               	 </div>
              	</c:if>
              </form>
            </div>
          </div>
        </div>       
     </article>
  </body>
</html>