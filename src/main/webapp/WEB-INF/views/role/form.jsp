<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

	
<tags:pageTemplate titulo="Cadastro de Usuários">

	<div class="container">
	
		<h1>Cadastro de Usuários</h1>
		
		<form:form commandName="role" servletRelativeAction="/role/cadastrar" method="post">
			
			<div class="form-group">
				<label>Role</label>
				<form:input path="nome" cssClass="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">Salvar</button>
			
		</form:form>
		
	</div>
	
</tags:pageTemplate>

