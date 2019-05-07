<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tags:pageTemplate titulo="Lista de Usuários">
	<div class="container">
	
		<table class="table">
			<tr>
				<th>E-mail</th>
				<th>Nome</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${usuarios }" var="usuario">
				<tr>
					<td>${usuario.email }</td>
					<td>${usuario.nome }</td>
					<td>
						<a href='<c:url value="/usuario/remover/${usuario.email }" />' class="btn btn-danger btn-sm">
							<i class="fa fa-trash-o"></i>
						</a>
						
						<a href='<c:url value="/usuario/editar/${usuario.email }" />' class="btn btn-primary btn-sm">
							<i class="fa fa-edit"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
</tags:pageTemplate>