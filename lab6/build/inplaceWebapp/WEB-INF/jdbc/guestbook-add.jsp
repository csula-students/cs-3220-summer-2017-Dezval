<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- Import the JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<c:url value='../../app.css' />" >

</head>
<body>
<form method="POST" class="addForm">
    <div>
        <label for="name">Name:</label>
        <input id="name" type="text" name="name">
    </div>
    <div>
        <label for="comment">Comment:</label>
        <textarea id="comment" name="comment" cols="30" rows="10"></textarea>
    </div>
    <button>Post</button>

</form>
</body>
</html>