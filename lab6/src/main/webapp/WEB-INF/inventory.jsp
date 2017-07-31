<%@ include file = "header.jsp" %>
<body>
    <h1>List of Foods</h1>
    <%@ include file = "navbar.jsp" %>
    <h2>Admin Panel</h2>

    <table>
        <tr>
            <th colspan="3">Current Inventory</th>
        </tr>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${entries}" var="entry">
            <tr>
                <td>${entry.name}</td>
                <td>${entry.getPrice()}</td>
                <td>${entry.description}</td>
                <td><%--<a href="<c:url value='/deleteJSP?id=${entry.getId()}' />">--%><button>Delete Food</button><%--</a>--%></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="<c:url value='/createFoodJSP' />"><button>Add New Food</button></a>
    <br>
    <a href="<c:url value='/orderStatuses' />"><button>Check Current Orders</button></a>
</body>
</html>

<%--<table>--%>
<%--for (FoodEntry entry: entries){--%>
<%--out.println(--%>
<%--"<tr>" +--%>
<%--"<td>" + entry.getName() + "</td>" +--%>
<%--"<td>" + entry.getDescription() + "</td>" +--%>
<%--"<td>$" + entry.getPrice() + "</td>" +--%>
<%--"<td><a href='foods/edit?id=" + entry.getId() + "'>Edit</a></td>" +--%>
<%--"<td><a href='foods/delete?id=" + entry.getId()+ "'>Delete</a></td>" +--%>
<%--"</tr>");--%>
<%--}--%>
<%--out.print("</table>");--%>
<%--out.println("<button><a href='../admin/foods/create'>Add Food Dish</a></button>");--%>
<%--//        out.println("<br>");--%>
<%--out.println("<button><a href='../menu'>Menu View!</a></button>");--%>
<%--out.println("<br>");--%>
<%--out.println("<br>");--%>
<%--out.println("<button><a href='orders'>View Orders</a></button>");--%>