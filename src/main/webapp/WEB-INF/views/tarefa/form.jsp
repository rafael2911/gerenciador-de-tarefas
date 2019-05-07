<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

	
<tags:pageTemplate titulo="Cadastro de Tarefas">

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
	
</tags:pageTemplate>

