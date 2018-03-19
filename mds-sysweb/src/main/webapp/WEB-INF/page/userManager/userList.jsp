<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-5-21
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<jsp:include page="/common/publicTop.jsp"/>
<html>
<head>
    <style type="text/css">
        .operatePart div{
            float: right;
        }
    </style>
    <title>用户管理</title>
</head>
<body>
    <div class="queryPart">
        查询部分
    </div>
    <div class="operatePart">
        <div><input type="button" value="新建用户"></div>
        <div><input type="button" value="修改用户"></div>
        <div><input type="button" value="删除用户"></div>
    </div>
    <div class="contextPart">
          <div class="dataList"></div>
    </div>

</body>
</html>