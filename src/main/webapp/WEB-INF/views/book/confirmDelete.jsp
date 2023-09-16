<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 15.09.2023
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Are you sure to delete this book?<br/>
    ${book}<br/>
    <button onclick="javascript:location.href='delete?id=${book.id}'">Yes</button>
    <button onclick="javascript:location.href='list'">No</button>
</body>
</html>
