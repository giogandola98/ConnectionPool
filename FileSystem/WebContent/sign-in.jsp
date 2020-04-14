<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="isRegister" scope="request" value="${registerStatus }"/> <!-- Esortazione al login in caso di registrazione andata a buon fine -->
<c:set var="isLogged" scope="request" value="${failedLogin }"/> <!-- Status dell'accesso -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pagina - Accesso</title>
</head>
<body>
	<a class="linkBack" href="<%=request.getContextPath()%>/home.html">Ritorna alla pagina iniziale</a>

	<c:choose>
	<c:when test="${isRegister == true }"> <!-- A registrazione effettuata, quando l'utente viene reindirizzato alla pagina di accesso visualizza questo messaggio -->
	<div class="registerComplete">
		<p style="color: red;"><c:out value="COMPLIMENTI, la tua registrazione è andata a buon fine!"/></p>
		<p style="color: red;"><c:out value="Inserisci le tue credenziali per entrare nel sistema"/></p>
	</div>
	</c:when>
	<c:otherwise>
	<header class="loginTitle">
		<h4>Effettua l'accesso ed esplora il tuo Cloud personale</h4>
		<h3>Inserisci i tuoi dati:</h3>
	</header>
	</c:otherwise>
	</c:choose>

	<c:if test="${isLogged == false }"> <!-- Nel caso in cui l'accesso non vada a buon fine, viene visualizzato il seguente messaggio di errore -->
	<div class="loginFailed">
		<p style="color: red;"><c:out value="SPIACENTI, le credenziali fornite in fase di accesso non sono corrette!"/></p>
		<p style="color: red"><c:out value="Perfavore inserisci nuovamente i tuoi dati e riprova"/></p>
	</div>
	</c:if>

	<article class="loginForm">
		<form method="POST" action="Login">
			<label>Username: </label><input type="text" name="username" placeholder="Inserisci il tuo username"/> <br>
			<label>Password: </label><input type="password" name="password" placeholder="Inserisci la tua password"/> <br>
			<input type="submit" value="Accedi">
		</form>
	</article>	
</body>
</html>