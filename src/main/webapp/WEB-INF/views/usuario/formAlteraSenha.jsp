<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

	
<tags:pageTemplate titulo="Cadastro de Usuários">

	<div class="container">
	
		<h1>Cadastro de Usuários</h1>
		
		<c:url value="/usuario/alteraSenha" var="urlSalvar" />
		<form:form action="${urlSalvar }" method="post">
			
			<div class="form-group">
				<label>Nova Senha</label>
				<input type="password" name="senha" class="form-control">
			</div>
			
			<input type="hidden" name="email" value="${id }">
			
			<button type="submit" class="btn btn-primary">Alterar</button>
			
		</form:form>
		
	</div>
	
</tags:pageTemplate>

