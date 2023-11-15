<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Search</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Product Search</h1>
    <form action="ProductServlet" method="get">
        <input type="text" name="productId" placeholder="Enter Product ID">
        <input type="hidden" name="action" value="search">
        <button type="submit">Search</button>
    </form>

    <hr>

    <c:choose>
    
    
    <c:when test="${not empty product}">
        <h2>Product Details</h2>
        <p>ID: ${product.pId}</p>
        <p>Name: ${product.pName}</p>
        <p>Price: ${product.pprice}</p>
        <p>Quantity: ${product.pQuantity}</p>    
    </c:when>
    
    
    <c:otherwise>
    
    
        <c:choose>
            <c:when test="${empty products}">
                <p>No records found.</p>
            </c:when>
            
            
            
            
            <c:otherwise>
            
            
                <h2>All Products</h2>
                <table border="2" class="table table-hover">
                    <tr>
                        <th class="info">ID</th>
                        <th class="info">Name</th>
                        <th class="info">Price</th>
                        <th class="info">Quantity</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.pId}</td>
                            <td>${product.pName}</td>
                            <td>${product.pprice}</td>
                            <td>${product.pQuantity}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
    
    
</c:choose>
</div>
</body>
</html>
