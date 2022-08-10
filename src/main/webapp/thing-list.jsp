<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/22
  Time: 10:56
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
					<cite>科目信息</cite></a>
			</span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/psi/SeacherThing">
            <input type="text" name="thingname" placeholder="请输入科目名称" autocomplete="off" class="layui-input">
            <input class="layui-btn" type="submit" value="submit" />
        </form>
    </div>
    <xblock>
        <a class="layui-btn layui-btn-danger" href="javaScript:if(confirm('提示您全部删除可就啥也没有了哦')){location.href='/psi/DelAllThingServlet'}"><i class="layui-icon"></i>全部删除</a>
        <button class="layui-btn" onclick="x_admin_show('科目查找','/psi/FindTypeServlet')"><i
                class="layui-icon"></i>科目添加</button>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>科目名称</th>
            <th>科目类型</th>
            <th>科目满分</th>
            <th>教师数量</th>
            <th>主导教师</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${thinglist}" var="thing">
            <tr>
                <td>${thing.thingname}</td>
                <td>${thing.thingtype}</td>
                <td>${thing.price}</td>
                <td>${thing.count}</td>
                <td>${thing.shopping}</td>
                <td class="td-manage">
                    <a title="删除" href="javaScript:if(confirm('提示您确定删除嘛')){location.href='/psi/DelOneThingServler?id=${thing.id}'}">
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
