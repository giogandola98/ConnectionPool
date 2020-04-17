
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/utils/css/login_register.css" TYPE="text/css"> 
	<title>Pagina - Accesso</title>
</head>
<body>
	<article class="loginForm">
		<form method="POST" action="LoginValidatorController">
			<label>Username: </label><input type="text" name="username" placeholder="Inserisci il tuo username"/> <br>
			<label>Password: </label><input type="password" name="password" placeholder="Inserisci la tua password"/> <br>
			<input type="submit" value="Accedi">
		</form>
		<button type="submit" formaction="sign-in.jsp">Registrati</button>
	</article>	
</body>
</html>