<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="documentsOfFolder" scope="session" value="${documents }"/> <!-- Elenco dei documenti collegati a una sotto cartella -->

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Documenti cartella</title>
</head>
<body>
	<c:url value="/home_page.jsp" var="homePageUrl"/>
	<a class="linkBack" href="${homePageUrl }">Ritorna alla tua Home Page</a>

	<h3>Elenco dei documenti presenti nella cartella selezionata: </h3>

	<table border="1">
		<tr>
			<td>Nome Documento</td>
			<td>Opzioni</td>
		</tr>

		<c:forEach var="document" items="${documentsOfFolder }">
		<tr>
			<c:url value="/ExtractDocumentInfo" var="urlInspectDoc"> <!-- Mappa ogni documento con un URL che consentirà di ispezionarne le caratteristiche -->
				<c:param name="name" value="${document.getName() }"/>
				<c:param name="type" value="${document.getType() }"/>
				<c:param name="dateCreat" value="${document.getDateCreation() }"/>
				<c:param name="dateUpdat" value="${document.getDateUpdate() }"/>
				<c:param name="summary" value="${document.getSummary() }"/>
			</c:url>
			<c:url value="/DocumentMoveStart" var="urlMoveDoc"> <!-- Mappa ogni documento con un URI che consentirà di iniziare lo spostamento -->
				<c:param name="propFolder" value="${document.getPropFolder() }"/>
				<c:param name="name" value="${document.getName() }"/>
				<c:param name="type" value="${document.getType() }"/>
			</c:url>
			<td><c:out value="${document.getName() }"/></td>
			<td><a href="${urlInspectDoc }">Accedi</a> <br>
				<a href="${urlMoveDoc }">Sposta</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>