<%--
  Created by IntelliJ IDEA.
  User: wcl
  Date: 2021/1/13
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" >
</head>
<body>
<div class="total_main">
    <div class="login_cont">
        <div class="login_nav">
            <div class="nav_slider">
                <a href="#" class="signin focus">登录</a>
            </div>
        </div>
        <form>
            <div class="input_signin active">
                <input class="input" id="login_user_name" type="text" name="username"  placeholder="用户名">
                <input class="input" id="login_password" type="password" name="password"placeholder="密码">
                <input type="submit" id="button" class="button" name="button" value="登录">
            </div>
        </form>
    </div>
</div>
</body>
<script  type="text/javascript"  src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script   type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/layer.js"></script>
<script   type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js"></script>
</html>
