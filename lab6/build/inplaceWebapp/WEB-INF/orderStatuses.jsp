<%@ include file = "header.jsp" %>
<body>
<h1>List of Foods</h1>
<%@ include file = "navbar.jsp" %>
<h2>Admin Panel</h2>

<table>
    <tr>
        <th colspan="3">Current Orders</th>
    </tr>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${ordersList}" var="order">
        <tr>
            <td>${order.getItem().getName()}</td>
            <td>${order.description}</td>
            <td>${order.getStatus()}</td>
            <td><a href="<c:url value='/updateOrderStatus?id=${order.getId()}' />"><button>Update Status</button></a></td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="<c:url value='/createFoodJSP' />"><button>Add New Food</button></a>
<br>
<a href="<c:url value='/orderStatuses' />"><button>Check Current Orders</button></a>
</body>
<footer>
    <p>Casa de Cafe</p>
</footer>
</html>