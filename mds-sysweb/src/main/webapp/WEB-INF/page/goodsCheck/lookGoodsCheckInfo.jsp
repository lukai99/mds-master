<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>demo</title>
    <link rel="shortcut icon" href="/library/cfda.ico">
    <%--<link href="/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/library/animate/animate.min.css" rel="stylesheet">
    <link href="/library/layui/css/layui.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div style="padding: 0px 50px;padding-top: 20px;">
    <table class="layui-table" lay-even>
        <colgroup>
            <col width="50">
            <col width="100">
            <col width="100">
            <col width="150">
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>元素名称</th>
            <th>含量(ppm)</th>
            <th>录入时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${checklist}" var="check" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${check.name}</td>
                <td>${check.content}</td>
                <td><fmt:formatDate value="${check.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>