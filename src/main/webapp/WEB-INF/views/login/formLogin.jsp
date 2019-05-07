<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<s:url value="/resources/" var="cssPath" />
<link rel="stylesheet" href="${cssPath }bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }login.css">
<title>Login - GD Tarefas</title>
</head>
<body>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="${cssPath }img/bootstrap-solid.svg" id="icon" alt="User Icon" style="width: 70px" />
			</div>

			<!-- Login Form -->
			<form:form servletRelativeAction="/login" method="post">
				<input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
				<input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form:form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>

<script src="${cssPath }bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="${cssPath }bootstrap/js/bootstrap.min.js"></script>

</body>
</html>