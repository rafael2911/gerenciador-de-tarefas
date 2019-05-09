<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<c:url value="/resources/" var="cssPath" />
<link rel="stylesheet" href="${cssPath }bootstrap/css/bootstrap.min.css">

<style>
  .bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

  @media (min-width: 768px) {
    .bd-placeholder-img-lg {
      font-size: 3.5rem;
    }
  }
</style>

<!-- Custom styles for this template -->
<link href="${cssPath }signin.css" rel="stylesheet">
<title>Login - GD Tarefas</title>
</head>

<body class="text-center">
	<form:form servletRelativeAction="/login" method="post" cssClass="form-signin">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger" role="alert">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				Usuário ou senha inválidos
			</div>        
		</c:if>
		
		<img class="mb-4" src="${cssPath }img/bootstrap-solid.svg" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">GD Tarefas</h1>
		<label for="inputEmail" class="sr-only">Email</label>
		<input type="email" name="username" class="form-control" placeholder="Email" required autofocus>
		<label for="inputPassword" class="sr-only">Senha</label>
		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Senha" required>
		<div class="checkbox mb-3">
		  <label>
		    <input type="checkbox" value="remember-me"> Remember me
		  </label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
  
	</form:form>

	<script src="${cssPath }bootstrap/js/jquery-3.2.1.min.js"></script>
	<script src="${cssPath }bootstrap/js/bootstrap.min.js"></script>

</body>
</html>