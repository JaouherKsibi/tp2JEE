<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h1>Login </h1>
	<hr>
	<form action="Login_servlet" method="post">
		<label for="login">email:</label><input type="text" name="login" id="login" required="required">
		<label for="mdp">password:</label><input type="text" name="mdp" id="mdp" required="required">
		<input type="submit" value="login">
	</form>
	<h2>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page import="java.util.List" %>
    <%@page import="model.Compte" %>
	<c:if test="${err!=null}">
		<h3><c:out value="${err}"></c:out></h3>
 	</c:if>
	</h2>
</body>
</html>