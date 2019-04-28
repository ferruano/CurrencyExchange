<%@tag description="Simple Template" pageEncoding="UTF-8"%>
<%@attribute name="titleHeader" fragment="true" %>
 
<!DOCTYPE html>
<html>
<head>
<style>
	tr, td {
		text-align: center;
	}
	table {
		table-layout:fixed;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Logo.jpg">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<jsp:invoke fragment="titleHeader"/>
</head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="PrincipalServlet"><img id="miImagen" src="${pageContext.request.contextPath}/images/Logo.jpg" width=50px></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Exchange</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ExchangeRatesServlet?email=${client.email}">Exchange rates</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="AccountServlet" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Account
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Activity</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="AccountServlet?email=${client.email}">Balance</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="ManageServlet?email=${client.email}">Deposit/Withdraw</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
	<div class="container">
  		<div class="row justify-content-center">
    		<div class="col-6 align-self-center">
       			<div id="body">
      				<jsp:doBody/>
    			</div>
    		</div>
  		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
  </body>
</html>