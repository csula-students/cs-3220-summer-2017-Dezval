<!DOCTYPE html>
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
<h1>List of Foods</h1>

<head>
<style>
    body {}
</style>
    </head>

<table>
    <c:forEach items="${inventory}" var="item">
        <tr>
            <td>${item.getName()}</td>
            <td>${item.getDescription()}</td>
            <td>${item.getPrice()}</td>
            <td><a href="<c:url value='/foods/edit?id=${item.getId()}' />" class="button">Edit</a></td>
            <td><a href="<c:url value='/foods/delete?id=${item.getId()}' />" class="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<button><a href='createFood.jsp'>Add Food Dish</a></button>
<br>
<button><a href='../menu'>Menu View!</a></button>
<br>
<br>
<button><a href='orders'>View Orders</a></button>




</body>
<footer> © Casa de Cafe
</footer>
</html>