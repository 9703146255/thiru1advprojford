<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container">


<h1>Login Here</h1>


<c:if test="${not empty userName}">
    <h2>Welcome, ${userName}</h2>
</c:if>


<c:if test="${not empty requestScope.errorMessage}">
    <p style="color: red">${requestScope.errorMessage}</p>
</c:if>


<c:if test="${not empty requestScope.successMessage}">
    <p style="color: green">${requestScope.successMessage}</p>
</c:if>

<hr>	
<br><br>
<form action="UserLogin" method="post">
    E-mail: <input type="email" name="lemail" required /><br><br>
    Psswrd: <input type="password" name="lpassword" required /><br><br>
    <input type="submit" value="Login" class="btn btn-primary btn-lg" /><br><br>
    <a href="register.jsp">Sign Up Here</a>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</div>
</body>
</html>