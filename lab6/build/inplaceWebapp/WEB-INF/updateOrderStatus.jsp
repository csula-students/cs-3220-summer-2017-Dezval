<%@ include file = "header.jsp" %>
<body>
<%@ include file = "navbar.jsp" %>
<h2>Add New Food</h2>

<form method="post">
    <select name="status">
        <option value="IN_QUEUE">In Queue</option>
        <option value="IN_PROGRESS">In Progress</option>
        <option value="COMPLETED">Completed</option>
    </select>
    <button>Update</button>
</form>




</body>
<footer> © Casa de Cafe
</footer>
</html>