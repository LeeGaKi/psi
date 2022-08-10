<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/23
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = String.valueOf(session.getAttribute("loginusername"));
    if("null".equals(name)){
        request.setAttribute("loginmsg","乖乖登录<br>小7提醒您不能越权哦");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
%>
