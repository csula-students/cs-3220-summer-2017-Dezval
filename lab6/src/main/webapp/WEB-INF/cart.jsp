<%@ include file = "header.jsp" %>
<body>
<%@ include file = "navbar.jsp" %>
<h1>
    Shopping Cart
</h1>

<table>
    <tr>
        <th>Name</th>

        <th>Price</th>
    </tr>
    <c:forEach items="${cartItems}" var="cartItem">
        <tr>
            <td>${cartItem.getItem().getName()}</td>
            <td>$${cartItem.getPrice()}</td>
            <td><a href="<c:url value='/removeFromCartJSP?id=${cartItem.getId()}' />"><button>Remove from Cart</button></a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/addToOrders' />"><button>Checkout</button></a>
<br><br>
<a href="<c:url value='/index' />"><button>View Menu</button></a>


</body>
</html>