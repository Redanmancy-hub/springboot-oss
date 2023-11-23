<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册成功</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        .success-message {
            background-color: #fff;
            border-radius: 5px;
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        p {
            margin-bottom: 10px;
        }

        a {
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
    <script type="text/javascript"
            src="../../js/jquery-3.6.0.js"></script>
</head>
<body>
<h1>注册成功</h1>

<div class="success-message">
    <p>用户名：<%= request.getAttribute("username") %></p>
    <p>年龄：<%= request.getAttribute("age") %></p>
    <p>性别：<%= request.getAttribute("sex") %></p>
    <p>出生日期：<%= request.getAttribute("birthday") %></p>
    <a href="/register">返回注册页面</a>
    <a href="${pageContext.request.contextPath}/ajax">去登录</a></div>
</body>
</html>
