<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ attribute name="titulo" required="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<title>${titulo } - Agendador de Tarefas</title>
<s:url value="/resources/" var="cssPath" />
<link rel="stylesheet" href="${cssPath }bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }font-awesome/css/font-awesome.min.css">
</head>
<body>

<%@ include file="/WEB-INF/views/cabecalho.jsp" %>

<jsp:doBody />

<%@ include file="/WEB-INF/views/rodape.jsp" %>

<script src="${cssPath }bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="${cssPath }bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
