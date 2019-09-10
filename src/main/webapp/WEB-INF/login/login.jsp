<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhang_htao
  Date: 2019/9/8
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<% String contextPath = request.getContextPath(); %>
<%
    System.out.println(request.getContextPath());
    System.out.println(request.getServletPath());
%>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
</head>
<body>
<h3>请先进行登录</h3>
<c:if test="${not empty param.error}">
    <font color="red">用户名密码不匹配</font>
</c:if>
<form id="loginForm" action="${pageContext.request.contextPath}/securityLogin" method="post">
    用户名：<input type="text" name="username"><br>
    密&nbsp;&nbsp;码：<input type="password" name="password"><br>
    验证码：<input type="text" name="imageCode" /><img src="randomCode"><br>
    记住用户名和密码:<input type="checkbox" name="remember-me" value="true"><br>
    <input type="button" id="login" value="登录">
</form>
<script type="text/javascript">
    $(function () {
        $("#login").click(function () {
            $.post("${pageContext.request.contextPath}/securityLogin",$("#loginForm").serialize(),function (data) {
                if(data.statusCode == '1') {
                    window.location.href = "${pageContext.request.contextPath}/loginSuccess";
                }else {
                    alert(data.msg);
                }
            },"json");
        })
    })
</script>
</body>
</html>
