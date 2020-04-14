<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="arrayUserFolder" scope="session" value="${userFolders }"/> <!-- Cartelle dell'utente -->
<c:set var="userSession" scope="session" value="${userLogged }"/>	<!-- Parametri della sessione utente -->
<c:set var="isMoved" scope="session"/> <!-- Staimo spostando un documento? Si verifica uno "switch" del template -->
<c:set var="docMoved" scope="session" value="${docFolderMoving }"></c:set> <!-- Indicazione sul documento che si sta spostabdo -->
<c:set var="documentoX" scope="session" value="${docMoved.getName() }"/> <!-- Nome del documento che stiamo spostando -->
<c:set var="subfolderY" scope="session" /> <!-- Cartella di provenienza del documento che stiamo spostando -->

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home Page</title>
</head>
<body>
	<c:url value="/Logout" var="logoutURL"/>
	<a class="linkBack" href="${logoutURL }">Disconetti</a>

	<p>ACCESSO EFFETTUATO: Benvenuto ${userSession.getUser() }</p>
<pre>Informazioni Utente:
	<label>ID sessione: </label><c:out value="${userSession.getIdUser() }"/>
	<label>Nome utente: </label><c:out value="${userSession.getUser() }"/>
</pre>

	<p id="userFolders">CARTELLE: </p>

	<c:if test="${isMoved == true}"> <!-- Se stiamo spostando un documento mostriamo all'utente un messaggio di notifica -->
		<c:forEach var="sub" items="${arrayUserFolder }">
			<c:if test="${ sub.getIdFolder() == docMoved.getPropFolder() }">
				<c:set var="subfolderY" value="${sub.getName() }"/>
			</c:if>
		</c:forEach>
		<p><c:out value="Stai spostando il documento ${documentoX} della sottocartella ${subfolderY }. Scelgi la cartella di destinazione"/>
	</c:if>

	<c:forEach var="folder" items="${arrayUserFolder }"> <!-- Stampa dell'albero di cartelle e sottocartelle dell'utente -->
	<nav>
	<c:choose>
		<c:when test="${folder.getUpFolder() == 0 }">
			<ul> <c:out value="${folder.getName() }"/>
			<c:forEach var="subfolder" items="${arrayUserFolder }">
				<c:if test="${ folder.getIdFolder() == subfolder.getUpFolder()}">
					<c:url value="/ExtractDocuments" var="urlSubFolder">
						<c:param name="idFolder" value="${subfolder.getIdFolder() }"/>
						<!--<c:param name="propFolder" value="${subfolder.getName() }"/>-->
					</c:url>
					<c:choose>
						<c:when test="${isMoved == true && docMoved.getPropFolder()==subfolder.getIdFolder()}"> <!-- FASE SPOSTAMENTO: evidenzia la cartella di provenienza del documento e la rende non selezionabile -->
							<ul><li><a style="color:red;">${subfolder.getName() }</a></li></ul>
						</c:when>
						<c:when test="${isMoved == true && docMoved.getPropFolder() !=subfolder.getIdFolder()}"> <!-- FASE SPOSTAMENTO: mappa le sotto cartelle con un URI ad hoc che gli consenta di chiudere lo spostamento -->
							<c:url value="DocumentMoveEnd" var="urlEndMove">
								<c:param name="idPF" value="${docMoved.getPropFolder() }"/>
								<c:param name="nameDoc" value="${docMoved.getName() }"/>
								<c:param name="typeDoc" value="${docMoved.getType() }"/>
								<c:param name="docDestination" value="${subfolder.getIdFolder() }"/>
							</c:url>
							<ul><li><a href="${urlEndMove }">${subfolder.getName() }</a></li></ul>
						</c:when>
						<c:otherwise> <!-- FASE DI VISUALIZZAZIONE semplice, mappa le cartelle con un URI che consentirà di ispezionarne il contenuto in termini di documenti -->
							<ul><li><a href="${urlSubFolder }">${subfolder.getName() }</a></li></ul>
						</c:otherwise>
					</c:choose>				
				</c:if>
			</c:forEach>
			</ul>
		</c:when>
	</c:choose>
	</nav>
	</c:forEach>
</body>
</html>