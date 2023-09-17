<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 17.09.2023
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
  Firstname: <form:input path="firstName"/><br/>
  Lastname: <form:input path="lastName"/><br/>
  <button type="submit">Send</button>
</form:form>
</body>
</html>
