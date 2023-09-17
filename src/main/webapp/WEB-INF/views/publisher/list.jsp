<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 17.09.2023
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
  <c:forEach items="${publishers}" var="publisher">
    <li>
      ${publisher.name}
      <button onclick="javascript:location.href='form?id=${publisher.id}'">Edit</button>
      <button onclick="javascript:location.href='confirmDelete?id=${publisher.id}'">Delete</button>
    </li>
  </c:forEach>
</ul>
<button onclick="javascript:location.href='form'">Add publisher</button>
</body>
</html>
