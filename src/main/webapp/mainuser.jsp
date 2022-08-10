<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/18
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="yz-login.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="layui-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>性别</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>会员</th>
        <th>状态</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${mainuser.id}</td>
            <td>${mainuser.username}</td>
            <td>${mainuser.sex}</td>
            <td>${mainuser.iphone}</td>
            <td>${mainuser.email}</td>
            <td>${mainuser.address}</td>
            <td>专属会员</td>
            <td class="td-status">
                <span class="layui-btn layui-btn-normal layui-btn-mini">正常</span>
            </td>
            <td>${mainuser.password}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
