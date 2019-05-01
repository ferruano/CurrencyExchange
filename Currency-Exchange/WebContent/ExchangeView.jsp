<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="titleHeader">
      <title>Exchange Money</title>
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
    <article class="card">
      <div class="card-body p-5">
      <h2 class="card-title">Create an exchange Request</h2>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="nav-tab-card">
            <form action="ConfirmationServlet" method="post">
            <div class="container">
				  <div class="row justify-content-md-center">
				    <div class="col-4">
				      <div class="form-group">
                  		<label for="amount">Amount </label>
                 		 <input type="number" class="form-control" name="amount">
                 		 <input type="hidden" name="email" value="${client.email}">
                	  </div> <!-- form-group.// -->
				    </div>
				    <div class="col-3">
				       <div class="form-group">
						  <label for="sel1">From:</label>
						  <select name="from" class="form-control" id="sel1">
						    <option value="1">AUD</option>
						    <option value="2">CAD</option>
						    <option value="3">EUR</option>
						    <option value="4">GBP</option>
						    <option value="5">CHF</option>
						    <option value="6">USD</option>
						    <option value="7">JPY</option>
						  </select>
						</div> 
				    </div>
				    <div class="col-1">
				    </div>
				    <div class="col-3">
				      <div class="form-group">
						  <label for="sel1">To:</label>
						  <select name="to" class="form-control" id="sel1">
						    <option value="1">AUD</option>
						    <option value="2">CAD</option>
						    <option value="3">EUR</option>
						    <option value="4">GBP</option>
						    <option value="5">CHF</option>
						    <option value="6">USD</option>
						    <option value="7">JPY</option>
						  </select>
						</div> 
				    </div>
				  </div>
				  <div class="row justify-content-md-center">
				    <div class="col-8">
				    </div>
				    <div class="col-4">
				    <button type="submit" class="btn btn-primary btn-block" type="button">Preview</button>
				    </div>
				  </div>
				</div>
            </form>
          </div> <!-- tab-pane.// -->
        </div> <!-- tab-content .// -->
      </div> <!-- card-body.// -->
    </article> <!-- card.// -->
	
	    </shiro:user>
    </jsp:body>
</t:layout>
