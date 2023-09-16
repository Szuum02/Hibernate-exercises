<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 14.09.2023
  Time: 00:23
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
  <form:form method="post" modelAttribute="book">
    Title: <form:input path="title"/><br/>
    Author: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/><br/>
    Rating: <form:input type="number" path="rating"/><br/>
    Description: <form:textarea path="description"/><br/>
    Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/><br/>
    <input type="submit" value="Send">
  </form:form>
</body>
</html>
