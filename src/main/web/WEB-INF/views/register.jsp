<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
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

        form {
            background-color: #fff;
            border-radius: 5px;
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-bottom: 20px;
        }

        input[type="radio"] {
            margin-right: 10px;
        }

        button[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>注册界面</h1>

<form action="/registerAll" method="post" onsubmit="return validateAge()">
    <label>用户名：</label>
    <input type="text" name="username" required><br>
    <label>密码：</label>
    <input type="password" name="password" required><br>
    <label>年龄：</label>
    <input type="text" name="age" required><br>
    <label>性别：</label>
    <input type="radio" name="sex" value="男" required>男
    <input type="radio" name="sex" value="女" required>女<br>
    <label>生日：</label>
    <input type="date" name="birthday" required><br>
    <button type="submit">注册</button>
</form>

<script>
    function validateAge() {
        const ageInput = document.getElementsByName("age")[0];
        const age = parseInt(ageInput.value);

        if (age <= 0 || age > 150) {
            alert("年龄输入无效，请重新输入。");
            return false;
        }

        return true;
    }
</script>
</body>
</html>
