<%--
  Created by IntelliJ IDEA.
  User: zhang_htao
  Date: 2019/9/8
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<% String contextPath = request.getContextPath(); %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<security:authorize access="hasAuthority('ROLE_LIST_PRODUCT')">
<h1><a href="<%=contextPath%>/product/list">查看产品</a></h1>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_ADD_PRODUCT')">
<h1><a href="<%=contextPath%>/product/add">添加产品</a></h1>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_DELETE_PRODUCT')">
<h1><a href="<%=contextPath%>/product/delete">删除产品</a></h1>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_UPDATE_PRODUCT')">
<h1><a href="<%=contextPath%>/product/update">更新产品</a></h1>
</security:authorize>
</body>
</html>
