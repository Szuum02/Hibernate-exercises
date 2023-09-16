<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 13.09.2023
  Time: 23:58
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
    <form:form method="post" modelAttribute="person">
        Login: <form:input path="login" title="Podaj login"/><br/>
        Password: <form:password path="password"/><br/>
        Email: <form:input type="email" path="email"/><br/>
        <input type="submit" value="Submit">
    </form:form>

<%--    <form method="post">--%>
<%--        Login: <input type="text" name="login" /><br>--%>
<%--        Password: <input type="password" name="password"/><br>--%>
<%--        Email: <input type="email" name="email" /><br>--%>
<%--        <input type="submit" value="Send" />--%>
<%--    </form>--%>
</body>
</html>
