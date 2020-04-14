<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="isRegister" scope="request" value="${registerStatus }"/> <!-- Status della registrazione -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pagina - Registrazione</title>
</head>
<body>
	<a class="linkBack" href="<%=request.getContextPath()%>/home.html">Ritorna alla pagina iniziale</a>

	<c:choose>
	<c:when test="${isRegister == false }"> <!-- Se la registrazione fallisce -->
	<div class="registerFailed">
		<p style="color: red;"><c:out value="SPIACENTI, la tua registrazione non è andata a buon fine!"/></p>
		<p style="color: red"><c:out value="Perfavore inserisci nuovamente i tuoi dati e riprova"/></p>
	</div>
	</c:when>
	<c:otherwise>
	<header class="registrationTitle">
		<h4>Benvenuto: scegli il tuo username e la tua password per essere immediamente iscritto al nostro servizio</h4>
		<h3>Inserisci i tuoi dati:</h3>
	</header>
	</c:otherwise>
	</c:choose>
	
	<article class="registrationForm">
		<form method="POST" action="Register">
			<label>Nome utente: </label><input type="text" name="user" placeholder="Scegli il tuo nome utente"/> <br>
			<label>Password: </label><input type="password" name="pass" placeholder="Scegli una password"/> <br>
			<label>Ripeti la password: </label><input type="password" name="repPass" placeholder="Ripeti la password"/> <br>
			<input type="submit" id="idSubmitButton" value="Registrati"/> 
		</form>
	</article>
</body>
</html>