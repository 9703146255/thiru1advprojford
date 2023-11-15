<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


    <div class="container">
    <c:if test="${not empty successMessage}">
        <h1 class="text-success">${successMessage}</h1>
    </c:if>
    
    
    <h2>Book Info</h2>
    <form action="BookSevlet" method="post">
        <div class="form-group">
            <label for="name">BOOK NAME:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="price">BOOK PRICE:</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="form-group">
            <label for="author">BOOK AUTHOR:</label>
            <input type="text" class="form-control" id="author" name="author">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="BookSevlet" class="btn btn-secondary">View All Books</a>
</div>





</body>
</html>
