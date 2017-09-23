<%@ include file = "header.jsp" %>
<body>
<%@ include file = "navbar.jsp" %>
<h1>Your Orders</h1>
<h2>Ordered Food</h2>

<table>
    <c:forEach items="${ordersList}" var="order">
        <tr>
            <td>${order.getItem().getName()}</td>
            <td>${order.description}</td>
            <td>${order.getStatus()}</td>
        </tr>
    </c:forEach>
</table>

<a href="<c:url value='/index' />"><button>Back to Menu</button></a>
</body>
</html>