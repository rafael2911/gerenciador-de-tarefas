<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Tarefas</title>
</head>
<body>
	<h1>Cadastro de Tarefas</h1>
	
	<s:url value="/tarefa/cadastrar" var="urlSalvar" />
	<form:form servletRelativeAction="${urlSalvar }" commandName="tarefa">
		<div>
			<label>Descrição:</label>
			<form:textarea path="descricao" rows="5" cols="20"/>
		</div>	
		
		<button type="submit">Salvar</button>
	</form:form>
</body>
</html>