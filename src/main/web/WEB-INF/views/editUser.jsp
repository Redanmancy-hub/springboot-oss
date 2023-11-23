<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>修改用户信息</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
  <h2>修改用户信息</h2>
  <form action="updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}"/>

    <div class="form-group">
      <label for="username">名称:</label>
      <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
    </div>

    <div class="form-group">
      <label for="role">角色:</label>
      <select class="form-control" id="role" name="role">
        <option value="0" ${user.role == 0 ? 'selected' : ''}>管理员</option>
        <option value="1" ${user.role == 1 ? 'selected' : ''}>普通用户</option>
      </select>
    </div>

    <div class="form-group">
      <label>性别:</label>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="sex" id="male" value="0" ${user.sex == 0 ? 'checked' : ''}>
        <label class="form-check-label" for="male">男</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="sex" id="female" value="1" ${user.sex == 1 ? 'checked' : ''}>
        <label class="form-check-label" for="female">女</label>
      </div>
    </div>

    <div class="form-group">
      <label for="age">年龄:</label>
      <input type="number" class="form-control" id="age" name="age" value="${user.age}" required>
    </div>

    <button type="submit" class="btn btn-primary">提交</button>
    <a href="userManagement.jsp" class="btn btn-secondary">取消</a>
  </form>
</div>

<!-- 引入 Bootstrap JS 和依赖 -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
