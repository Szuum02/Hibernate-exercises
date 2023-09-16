<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 14.09.2023
  Time: 00:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book}</li>
        <button onclick="javascript:location.href='form?id=${book.id}'">Edit</button>
        <button onclick="javascript:location.href='confirmDelete?id=${book.id}'">Delete</button>
        <br/>
    </c:forEach>
</ul>
</body>
</html>
