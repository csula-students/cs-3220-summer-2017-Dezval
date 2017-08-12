<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<ul>
    <c:forEach items="${list}" var="entry">
        <li>${entry.name} - ${entry.comment} - ${entry.getCurrentListSize()}
            - <a href="<c:url value='/jdbc/guestbook/update?id=${entry.getId()-1}' />"><button>Update Info</button></a>
            - <a href="<c:url value='/jdbc/guestbook/delete?id=${entry.getId()-1}' />"><button>Delete Guest</button></a></li>
    </c:forEach>
</ul>

<a href="guestbook/create">Add new comment</a>
</body>
</html>