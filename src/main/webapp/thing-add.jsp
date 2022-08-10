<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/22
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="yz-login.jsp"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
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
<div class="x-body">
    <form class="layui-form" action="/psi/RukuServlet">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>科目名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="thingname" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>仔细检查科目名称哦
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red">*</span>科目类型</label>
            <div class="layui-input-block">
                <input type="radio" name="thingtype" lay-skin="primary" title="文学" value="文学">
                <input type="radio" name="thingtype" lay-skin="primary" title="理工" value="理工">
                <input type="radio" name="thingtype" lay-skin="primary" title="语言" value="语言">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>科目满分
            </label>
            <div class="layui-input-inline">
                <input type="text" name="price" class="layui-input" >
            </div>
            <div class="layui-form-mid layui-word-aux">
                满分自己设置哦
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red">*</span>主导教师</label>
            <div class="layui-input-block" style="width: 190px;">
                <select name="shopping">
                    <option selected disabled style="display: none">主导教师名称</option>
                    <c:forEach items="${shoplist}" var="shoptype">
                        <option value="${shoptype.shopname}">${shoptype.shopname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>教师数量
            </label>
            <div class="layui-input-inline">
                <input type="text" name="count" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <input class="layui-btn" type="submit" value="添加科目"/>
        </div>
    </form>
</div>
</body>
</html>
