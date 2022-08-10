<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/19
  Time: 11:04
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
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/font.css"/>
    <link rel="stylesheet" type="text/css" href="css/xadmin.css"/>
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
					<cite>学生信息</cite></a>
			</span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/psi/SearchOrderServlet">
            <div class="layui-input-inline">
                <select name="zhifu">
                    <option>科目选择</option>
                    <option value="语文">语文</option>
                    <option value="数学">数学</option>
                    <option value="英语">英语</option>
                </select>
            </div>
            <input class="layui-btn" type="submit" value="search" />
        </form>
    </div>
    <xblock>
        <a class="layui-btn layui-btn-danger" href="javaScript:if(confirm('提示您全部删除可就啥也没有了哦')){location.href='/psi/DelAllOrderServlet'}"><i class="layui-icon"></i>批量删除</a>
        <button class="layui-btn" onclick="x_admin_show('添加学生成绩','/psi/FindAllThingKjAddServlet')"><i
                class="layui-icon"></i>添加
        </button>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>学生姓名</th>
            <th>手机号</th>
            <th>科目</th>
            <th>得分</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderlist}" var="DD">
            <tr>
                <td>${DD.person}</td>
                <td>${DD.iphone}</td>
                <td>${DD.thingname}</td>
                <td>${DD.price}</td>
                <td class="td-manage">
                    <a title="删除" href="javaScript:if(confirm('提示您确定删除嘛')){location.href='/psi/DelOneOrderServlet?id=${DD.id}'}">
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
