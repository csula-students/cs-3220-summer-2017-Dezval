<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <link rel="stylesheet" href="app.css" />
    <title>New Food Item</title>
</head>
<body>
<h2>Add New Food</h2>

<tag:AdminHeader/>
<form method="post">
    <p>Dish name:<input type="text" name="name"/></p>
    </br>
    <p>Price: $<input type="text" name="price"/></p>
    <textarea name='description'></textarea>
    </br>
    <button>Add</button>
</form>




</body>
<footer> © Casa de Cafe
</footer>
</html>