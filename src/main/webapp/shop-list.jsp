<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/22
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="yz-login.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
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
					<cite>教师信息</cite></a>
			</span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/psi/MhFindShopServlet">
            <input type="text" name="shopname" placeholder="请输入教师名称" class="layui-input">
            <input class="layui-btn" type="submit" value="search"/>
        </form>
    </div>
    <xblock>
        <a class="layui-btn layui-btn-danger" href="javaScript:if(confirm('提示您全部删除可就啥也没有了哦')){location.href='/psi/DelAllShopServlet'}"><i class="layui-icon"></i>全部删除</a>
        <button class="layui-btn" onclick="x_admin_show('添加教师','./shop-add.jsp')"><i
                class="layui-icon"></i>添加</button>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>教师名称</th>
            <th>地址</th>
            <th>教师编号</th>
            <th>引荐人</th>
            <th>教师电话</th>
            <th>教师状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${shoplist}" var="shop">
            <tr>
                <td>${shop.shopname}</td>
                <td>${shop.shopaddr}</td>
                <td>${shop.shopres}</td>
                <td>${shop.shopperson}</td>
                <td>${shop.personiphone}</td>
                <td class="td-status">
                    <span class="layui-btn layui-btn-normal layui-btn-mini">在职状态</span>
                </td>
                <td class="td-manage">
                    <a title="删除" href="javaScript:if(confirm('提示您全部删除可就啥也没有了哦')){location.href='/psi/DelOneShopServlet?id=${shop.id}'}">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
