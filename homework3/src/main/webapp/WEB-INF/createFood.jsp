<%@ include file = "header.jsp" %>
<body>

<%@ include file = "navbar.jsp" %>
<h2>Add New Food</h2>
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