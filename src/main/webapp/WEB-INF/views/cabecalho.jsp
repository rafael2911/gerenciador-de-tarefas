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
      <security:authorize access="hasRole('ROLE_ADMIN')">
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Usuario
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href='<c:url value="/usuario/list" />'>Listagem</a>
	          <a class="dropdown-item" href='<c:url value="/usuario/form" />'>Cadastro</a>
	        </div>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/role/form" />'>Role</a>
	      </li>
	  </security:authorize>
    </ul>
    <ul class="navbar-nav mr-rigth">
    	<li class="nav-item dropdown dropleft">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          <security:authentication property="principal" var="usuario" />
			  ${usuario.nome }
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href='<c:url value="/logout" />'>Sair</a>
	          <a class="dropdown-item" href='<c:url value="/usuario/alteraSenha" />'>Alterar Senha</a>
	        </div>
	      </li>
	</ul>
  </div>
</nav>
