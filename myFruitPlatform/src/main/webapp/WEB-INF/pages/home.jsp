<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/26 0026
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>主页</title>
    <style>*{margin:0; padding:0;}#menuContent a{text-decoration:none;color:#ffffff}</style>
</head>
<body>
欢迎你 ${user.userName}<br>
<%@ include file="menu.jsp" %>
</body>
</html>

