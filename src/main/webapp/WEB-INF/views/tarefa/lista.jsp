<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

	
<tags:pageTemplate titulo="Cadastro de Tarefas">
	<div class="container">
	
		<h1>Lista de Tarefas</h1>
		
		<form:form commandName="tarefaBeanParam" servletRelativeAction="/tarefa/busca"  method="get">
			<div class="row">
				<div class="col-sm-3 form-group">
					<label>Status</label>
					<form:select path="status" cssClass="form-control form-control-sm">
						<form:option value=""></form:option>
						<c:forEach items="${status }" var="s">
							<form:option value="${s }">${s }</form:option>
						</c:forEach>
					</form:select>
				</div>
				
				<div class="col-sm-3 form-group">
					<label>Tipo Data</label>
					<form:select path="tipoData" cssClass="form-control form-control-sm">
					<option value=""></option>
						<form:option value="dataAbertura">Abertura</form:option>
						<form:option value="dataEncerramento">Encerramento</form:option>
					</form:select>
				</div>
				<div class="col-sm-3 form-group">
					<label>Inicial</label>
					<form:input type="date" path="dtInicial" cssClass="form-control form-control-sm" />
				</div>
				<div class="col-sm-3 form-group">
					<label>Final</label>
					<form:input type="date" path="dtFinal" cssClass="form-control form-control-sm" />
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12"><button type="submit" class="btn btn-primary btn-sm">Search</button></div>
			</div>
		</form:form>
		<br>
		
		<c:if test="${ not empty message }">
			<div class="alert alert-success" role="alert">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				${message }
			</div>
		</c:if>
		<c:if test="${ not empty erro }">
			<div class="alert alert-danger" role="alert">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				${erro }
			</div>
		</c:if>
	
		<table class="table">
			<tr class="row">
				<th class="col-8">Descrição</th>
				<th class="col-1 d-none d-sm-block">Aberto</th>
				<th class="col-1 d-none d-sm-block">Encerrado</th>
				<th class="col-1 d-none d-sm-block">Status</th>
				<th class="col-4 col-md-1">Ações</th>
			</tr>
			<c:forEach items="${tarefas }" var="tarefa">
				<tr class="row">
					<td class="col-8">${tarefa.descricao }</td>
					<td class="col-1 d-none d-sm-block">
						<!-- Converte a variável de LocalDate para Date (não seria necessário se o atributo dataPublicacao fosse Date ou Calendar) -->
						<fmt:parseDate var="dataAbertura" value="${tarefa.dataAbertura }"
							pattern="yyyy-MM-dd" type="date" /> <!-- Formata a exibição da data -->
						<fmt:formatDate value="${dataAbertura }" pattern="dd/MM/yyyy"
							type="date" />
					</td>
					<td class="col-1 d-none d-sm-block">
						<!-- Converte a variável de LocalDate para Date (não seria necessário se o atributo dataPublicacao fosse Date ou Calendar) -->
						<fmt:parseDate var="dataEncerramento" value="${tarefa.dataEncerramento }"
							pattern="yyyy-MM-dd" type="date" /> <!-- Formata a exibição da data -->
						<fmt:formatDate value="${dataEncerramento }" pattern="dd/MM/yyyy"
							type="date" />
					</td>
					<td class="col-1 d-none d-sm-block">${tarefa.status }</td>
					
					<td class="col-4 col-md-1">
						<c:if test="${ tarefa.status == 'ABERTO' }">
						
							<a href='<c:url value="/tarefa/encerrar/${tarefa.id }" />' class="btn btn-danger btn-sm">
								<i class="fa fa-trash-o"></i>
							</a>
							
							<a href='<c:url value="/tarefa/concluir/${tarefa.id }" />' class="btn btn-success btn-sm">
								<i class="fa fa-check"></i>
							</a>
						
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>

</tags:pageTemplate>