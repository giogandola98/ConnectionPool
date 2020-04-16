<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="selectedDocumentInfo" scope="request" value="${docInfo }"/> <!-- Documento candito all'ispezione del contenuto -->

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Informazioni documento</title>
</head>
<body>
	<a class="linkBack" href="<%=request.getContextPath()%>/home_page.jsp">Ritorna alla tua Home Page</a>

	<h3>Informazioni del documento selezionato</h3> <!-- Mostra i dati del documento selezionato -->
	<div class="documentInfo">
		<p>NOME: <b>${selectedDocumentInfo.getName() }</b></p>
		<p>TIPO: <b>${selectedDocumentInfo.getType() }</b></p>
		<p>DATA CREAZIONE: <b>${selectedDocumentInfo.getDateCreation() }</b></p>
		<p>DATA MODIFICA: <b>${selectedDocumentInfo.getDateCreation() }</b></p>
		<p>SOMMARIO: <b>${selectedDocumentInfo.getSummary() }</b></p>
	</div>
		
	<a class="linkBack" href="<%=request.getContextPath()%>/documents.jsp">Indietro</a>
</body>
</html>