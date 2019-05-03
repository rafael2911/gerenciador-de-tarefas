<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<c:url value="/resources/" var="cssPath" />
<link rel="stylesheet" href="${cssPath }bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }font-awesome/css/font-awesome.min.css">

<title>Lista de Tarefas</title>
</head>
<body>

	<div class="container">
	
		<h1>Lista de Tarefas</h1>
		<h4>${message }</h4>
	
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Abertura</th>
				<th>Encerramento</th>
				<th>Status</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${tarefas }" var="tarefa">
				<tr>
					<td>${tarefa.id }</td>
					<td>${tarefa.descricao }</td>
					<td>
						<!-- Converte a variável de LocalDate para Date (não seria necessário se o atributo dataPublicacao fosse Date ou Calendar) -->
						<fmt:parseDate var="dataAbertura" value="${tarefa.dataAbertura }"
							pattern="yyyy-MM-dd" type="date" /> <!-- Formata a exibição da data -->
						<fmt:formatDate value="${dataAbertura }" pattern="dd/MM/yyyy"
							type="date" />
					</td>
					<td>
						<!-- Converte a variável de LocalDate para Date (não seria necessário se o atributo dataPublicacao fosse Date ou Calendar) -->
						<fmt:parseDate var="dataEncerramento" value="${tarefa.dataEncerramento }"
							pattern="yyyy-MM-dd" type="date" /> <!-- Formata a exibição da data -->
						<fmt:formatDate value="${dataEncerramento }" pattern="dd/MM/yyyy"
							type="date" />
					</td>
					<td>${tarefa.status }</td>
					
					<td>
						<button type="button" class="btn btn-danger btn-sm">
							<i class="fa fa-trash-o"></i>
						</button>
						
						<button type="button" class="btn btn-success btn-sm">
							<i class="fa fa-check"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>

</body>
</html>