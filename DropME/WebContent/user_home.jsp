<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="arrayUserFolder" scope="request" value="${folders}"/> 
<c:set var="arrayDocuments"  scope="request" value="${documents}"/>
<c:set var="userpath" scope="request" value="${path}"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home Page</title>
</head>
<body>
	
<pre>Informazioni Utente:
	<label>ID sessione: </label><c:out value="${user.getIdUser() }"/>
	<label>Nome utente: </label><c:out value="${user.getUser() }"/>
</pre>

	<table>
	<tr>
	<td>
	<table class="userFolders">
	<th>FOLDERS: </th>
	<!-- Stampa il layer corrente folders-->
		<c:forEach var="folder" items="${arrayUserFolder}"> 
			<tr> 
				<td>
					<c:url value="LayerPrinterController" var="uriFolder">
						<c:param name="nextLayer" value="${folder.getIdFolder()}"/>
						<c:param name="actual" value="${folder.getName() }"/>
						<c:param name="path" value="${userpath}"/>
					</c:url>
					<a href="${uriFolder}"> ${folder.getName()}</a> 
				</td>
			</tr>
		</c:forEach>
	</table>
	</td>
	<td>
	<table class="userDocuments">
	<!-- docs -->
	<th>FILES</th>
		<c:forEach var="document" items="${arrayDocuments}"> 
			<tr> 
				<td>
					<c:url value="/ExtractDocumentInfo" var="urlInspectDoc">
						<c:param name="name" value="${document.getName() }"/>
						<c:param name="type" value="${document.getType() }"/>
						<c:param name="dateCreat" value="${document.getDateCreation() }"/>
						<c:param name="dateUpdat" value="${document.getDateUpdate() }"/>
						<c:param name="summary" value="${document.getSummary() }"/>
					</c:url>
					<a href="${urlInspectDoc }">${document.getName() }</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</td>
	</tr>
	</table>
	
	
		
</body>
</html>