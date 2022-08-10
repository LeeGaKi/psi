<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/18
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="yz-login.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
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
					<cite>管理首页</cite></a>
			</span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <a class="layui-btn layui-btn-danger" href="javaScript:if(confirm('小7提示您全部删除可就啥也没有了哦')){location.href='/psi/DelAllServlet'}"><i class="layui-icon"></i>全部删除</a>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./member-add.jsp',600,550)"><i
                class="layui-icon"></i>添加
        </button>
    </xblock>
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
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userlist}" var="list_user">
            <tr>
                <td>${list_user.id}</td>
                <td>${list_user.username}</td>
                <td>${list_user.sex}</td>
                <td>${list_user.iphone}</td>
                <td>${list_user.email}</td>
                <td>${list_user.address}</td>
                <td>${list_user.supper}</td>
                <td class="td-status">
                    <span class="layui-btn layui-btn-normal layui-btn-mini">正常</span>
                </td>
                <td class="td-manage">
                    <a onclick="x_admin_show('修改密码','/psi/FindOneServlet?&id=${list_user.id}',600,400)" title="修改密码"
                       href="javascript:;" style="margin-right: 20px;">
                        <i class="layui-icon">&#xe631;</i>
                    </a>
                    <a  href="javaScript:if(confirm('小7提示您确定删除吗?')){location.href='/psi/DelUserServlet?id=${list_user.id}'}">
                            ${list_user.id} <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
