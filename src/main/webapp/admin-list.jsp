<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/21
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="yz-login.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<div class="x-nav">
			<span class="layui-breadcrumb">
				<a href="">首页</a>
				<a href="">演示</a>
				<a>
					<cite>导航元素</cite></a>
			</span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/psi/MhFindServlet">
            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <input type="text" value="1" name="type" style="display: none">
            <input type="submit" class="layui-btn" value="search" />
        </form>
    </div>
    <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','/psi/FindAllUserServlet?shengji=1')"><i
                class="layui-icon"></i>升级用户</button>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>登录名</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>角色</th>
            <th>状态</th>

        </thead>
        <tbody>
        <c:forEach items="${userlist}" var="list_user">
            <tr>
                <td>${list_user.id}</td>
                <td>${list_user.username}</td>
                <td>${list_user.iphone}</td>
                <td>${list_user.email}</td>
                <td>
                    <c:choose>
                        <c:when test="${list_user.supper==true}">
                            <span>超级管理员</span>
                        </c:when>
                        <c:when test="${list_user.supper==false}">
                            <span>普通用户</span>
                        </c:when>
                    </c:choose>
                </td>
                <td class="td-status">
                    <span class="layui-btn layui-btn-normal layui-btn-mini">正常</span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
