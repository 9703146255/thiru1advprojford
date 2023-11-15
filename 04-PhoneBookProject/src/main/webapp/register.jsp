<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
    
    
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  
  
  <body>
 <div class="container"> 
  
  <c:if test="${not empty successMessage}">
  <h1 class="text-success">${successMessage}</h1>
   </c:if>

	<h1>User Registration</h1>
	
	
<form action="RegistrationServlet" method="post">

<!-- //rname  remail rpassword rphno -->

Name:		<input type="text"  		name="rname" 		required/><br><br>
Email:		<input type="email" 	 	name="remail"		required/><br><br>
Pswrd:	<input type="password"  	name="rpassword" 	required/><br><br>
Phnum:		<input type="phone" 		name="rphno"  		required/><br><br>

<input type="submit"  value="Submit" class="btn btn-primary"/><br><br>

<a href="login.jsp">Sign In Here</a>  <!-- //rname  remail rpassword rphno -->   


</form>





</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>