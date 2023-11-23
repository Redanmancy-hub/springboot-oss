<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>

</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #007bff;
        color: white;
        text-align: center;
        padding: 10px 0;
    }

    .container {
        width: 80%;
        margin: 20px auto;
        overflow: hidden;
    }

    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #f0f0f0;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        text-decoration: none;
        color: #007bff;
        margin-right: 10px;
    }

    a.delete-btn {
        color: #ff0000;
    }
</style>
<body>
<header>
    <h1>用户管理</h1>
</header>

<div class="container">
    <table>
        <thead>
        <tr>
            <th>名称</th>
            <th>角色</th>
            <th>性别</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userBo" items="${userBoList}">
            <tr>
                <td>${userBo.username}</td>
                <td>
                    <c:choose>
                        <c:when test="${userBo.role == 0}">管理员</c:when>
                        <c:otherwise>普通用户</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${userBo.sex == 0}">男</c:when>
                        <c:otherwise>女</c:otherwise>
                    </c:choose>
                </td>
                <td>${userBo.age}</td>
                <td>
                    <button type="button" onclick="editUser(${userBo.id})">修改</button>
                    <a href="deleteUser.jsp?id=${userBo.id}" class="delete-btn">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
