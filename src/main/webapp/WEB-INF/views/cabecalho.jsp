<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Tarefas</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href='<c:url value="/tarefa" />'>Lista de Tarefas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href='<c:url value="/tarefa/form" />'>Cadastro de Tarefas</a>
      </li>
    </ul>
    <ul class="navbar-nav mr-rigth">
		<li class="nav-item"><a class="nav-link" href="#">
			<security:authentication property="principal" var="usuario" />
			${usuario.nome }
		</a></li>
		<li class="nav-item">
		  <a class="nav-link" href='<c:url value="/logout" />'>Sair</a>
		</li>
	</ul>
  </div>
</nav>
