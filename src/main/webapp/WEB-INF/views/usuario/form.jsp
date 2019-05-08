<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

	
<tags:pageTemplate titulo="Cadastro de Usuários">

	<div class="container">
	
		<h1>Cadastro de Usuários</h1>
		
		<c:url value="/usuario/cadastrar" var="urlSalvar" />
		<form:form servletRelativeAction="${urlSalvar }" commandName="usuario">
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome" cssClass="alert-danger" />
			</div>
			<div class="form-group">
				<label>Email:</label>
				<form:input path="email" cssClass="form-control"/>
				<form:errors path="email" cssClass="alert-danger" />
			</div>	
			<div class="form-group">
				<label>Senha:</label>
				<form:password path="senha" cssClass="form-control"/>
				<form:errors path="senha" cssClass="alert-danger" />
			</div>
			<div class="form-group">
				<label>Permissoes:</label>
				<form:select  path="roles" cssClass="form-control">
					<c:forEach items="${roles }" var="role">
						<form:option value="${role.nome }">${role.nome }</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="roles" cssClass="alert-danger" />
			</div>
					
			
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form:form>
			
<%-- 			<form:form action="${urlSalvar }"> --%>
<!-- 				<select name="roles" multiple="multiple"> -->
<%-- 					<c:forEach items="${roles }" var="role"> --%>
<%-- 						<option value="${role.nome }">${role.nome }</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
				
<!-- 				<button type="submit">Enviar</button> -->
<%-- 			</form:form> --%>
		
	</div>
	
</tags:pageTemplate>

