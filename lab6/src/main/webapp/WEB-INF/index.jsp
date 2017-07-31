<%@ include file = "header.jsp" %>
<body>
    <h1>Menu</h1>
    <%@ include file = "navbar.jsp" %>
    <h3>List of Foods</h3>

    <table>
        <c:forEach items="${entries}" var="entry">
            <tr>
                <td>${entry.name}</td>
                <td>${entry.description}</td>
                <td>$${entry.getPrice()}</td>
                <td><a href="<c:url value='/addToCartJSP?id=${entry.getId()}' />"><button>Add to Cart</button></a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="<c:url value='/cart' />"><button>View Cart</button></a>

</body>
</html>