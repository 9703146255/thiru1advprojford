<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <c:if test="${not empty successMessage}">
       <%--  <h1 class="text-success">${successMessage}</h1> --%>
	</c:if>
    
   <h2>Product_Info</h2><br><br> <hr> <hr>
<form action="ProductServlet" method="post">


PRODUCT NAME : <input type="text" name="pname"  placeholder="Enter product name"/><br><br>
PRODUCT PRICE:<input type="text" name="pprice" placeholder="Enter product price" /><br><br>
PRODUCT PQNTY:<input type="text" name="pquantity"  placeholder="Enter product qnty"/><br><br>
<input type="submit" value="submit"><br><br>



<a href="search.jsp">Search Product</a>
 <hr> <hr>
</form>
</div>



</body>
</html>