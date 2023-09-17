<%--
  Created by IntelliJ IDEA.
  User: szuum
  Date: 17.09.2023
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Are you sure to delete publisher ${publisher.name}?<br/>
<button onclick="javascript:location.href='delete?id=${publisher.id}'">Yes</button>
<button onclick="javascript:location.href='list'">No</button>
</body>
</html>
