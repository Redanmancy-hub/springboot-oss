<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <script type="text/javascript"
            src="../../js/jquery-3.6.0.js"></script>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f1f1f1;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .container h1 {
        font-size: 28px;
        font-weight: bold;
        margin-bottom: 20px;
    }

    .container p {
        font-size: 18px;
        color: #4CAF50;
        margin-bottom: 20px;
    }

    form {
        display: inline-block;
    }

    input[type="submit"] {
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        font-size: 14px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

</style>
<body>
<p> ${userinfo.username} 已登录</p><br>
<form action="${pageContext.request.contextPath}/ajax/remove" method="post">
    <input type="submit" value="退出登录"/>
</form>
</body>
</html>

