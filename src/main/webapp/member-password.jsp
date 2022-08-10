<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/18
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="yz-login.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/psi/UpUserServlet">

    用户名:<input value="${upuser.username}" readonly="readonly"><br>
    <input value="${upuser.id}" readonly="readonly" style="display: none" name="id">
    改密码:<input type="password" name="pass"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
