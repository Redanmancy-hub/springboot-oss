<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <script type="text/javascript"
            src="../../js/jquery-3.6.0.js"></script>

</head>
<style>
    form {
        width: 300px;
        margin: 0 auto;
        padding: 20px;
        background-color: #f1f1f1;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    form h2 {
        text-align: center;
        margin-bottom: 20px;
        font-size: 24px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
        font-size: 14px;
        background-color: #f9f9f9;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        outline: none;
        border-color: #4CAF50;
        box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
    }

    input[type="button"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        font-size: 14px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="button"]:hover {
        background-color: #45a049;
    }

    a {
        display: block;
        text-align: center;
        margin-top: 10px;
        font-size: 14px;
        color: #4CAF50;
        text-decoration: none;
    }

    a:hover {
        color: #45a049;
    }
</style>
<body>
<form >
    用户名：<input type="text" id="username" /><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" id="password"/>
    <br/>
    <input type="button" value="登录" onclick="sumbmitbyJSON()"/>
</form>
    <a href="${pageContext.request.contextPath}/register">去注册</a>
<script type="text/javascript">
    function sumbmit() {
        var username = $("#username").val();
        var password = $("#password").val();
        var data = {username: username, password: password}
        console.log(data)
        $.ajax({
            url: "${pageContext.request.contextPath }/ajax/login",
            type: "post",
            data: data,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            success: function (response) {
                console.log(response)
                alert(response);
            },
            error: function (response) {
                console.log(response)
                alert(response);
            }
        });
    }

    function sumbmitbyJSON() {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url: "${pageContext.request.contextPath }/ajax/loginjson",
            type: "post",
            data: JSON.stringify({username: username, password: password}),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (response) {
                console.log(response)
                if (response.code != 0 ) {

                }
                alert(response.msg);
                window.location.href="${pageContext.request.contextPath }/ajax/tohome"
            },
            error: function (response) {
                console.log(response)

                alert(response.msg);
            }
        });
    }


</script>
</body>
</html>

