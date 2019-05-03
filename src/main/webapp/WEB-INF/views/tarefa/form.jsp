<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<s:url value="/resources/bootstrap/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">

<title>Cadastro de Tarefas</title>
</head>
<body>
	
	<div class="container">
	
		<h1>Cadastro de Tarefas</h1>
		
		<s:url value="/tarefa/cadastrar" var="urlSalvar" />
		<form:form servletRelativeAction="${urlSalvar }" commandName="tarefa">
			<div class="form-group">
				<label>Descrição:</label>
				<form:textarea path="descricao" cssClass="form-control"/>
				<form:errors path="descricao" cssClass="alert-danger" />
			</div>	
			
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form:form>
		
	</div>

</body>
</html>