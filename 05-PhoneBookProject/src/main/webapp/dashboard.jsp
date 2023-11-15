<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard Page</title>
    <!-- Include your CSS styling here -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
</head>
<body>

<div class="container">
    <c:if test="${not empty userName}">
        <h2>Welcome, ${userName}</h2>
    </c:if>

    <!-- Add your dashboard content here -->
    <hr>
    <h2>Save Your Friends/Family Contact</h2>
    <form action="UserContactsServlet" method="post">
        Name: <input type="text" name="uname" required />
        Email: <input type="email" name="uemail" required />
        Phno: <input type="tel" name="uphno" required />
        
        
        <input type="submit" name="action" value="Save" class="btn btn-primary" />
    </form>

    <hr>
    <h2>View Your Contacts</h2>
    <hr>

    <!-- Display table list of user contacts -->
    <table class="table" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact Number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.phno}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
   <a href="login.jsp" class="btn btn-danger" >Logout</a>
    

    <hr>
    
</div>
</body>
</html>