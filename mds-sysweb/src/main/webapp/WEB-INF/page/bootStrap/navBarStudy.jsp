<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-5-26
  Time: 上午7:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<html>
<head>
    <jsp:include page="/common/publicTop.jsp"/>
    <title>导航栏</title>
</head>
<body>
<h2>导航栏</h2>
<nav class="nav navbar-default" role="navigation">
    <div class="nav">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">第一个</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">导航1</a></li>
                    <li><a href="#">导航2</a></li>
                    <li><a href="#">导航3</a></li>
                    <li><a href="#">导航4</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">导航5
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">导航5-1</a></li>
                            <li><a href="#">导航5-2</a></li>
                            <li><a href="#">导航5-3</a></li>
                            <li><a href="#">导航5-4</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<h2>响应式导航栏</h2>
<nav>
    <div class="nav navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#test-nav">
                    <span class="sr-only">切换导航</span>
                    <spam class="icon-bar"></spam>
                </button>
            </div>
        </div>
    </div>
</nav>

</body>
</html>