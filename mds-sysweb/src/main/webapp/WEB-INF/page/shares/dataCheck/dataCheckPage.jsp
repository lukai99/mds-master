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
    <title>选点管理</title>
    <style type="text/css">
        .queryPart{padding: 5px 5px;}
    </style>
</head>
<body style="">
    <div class="page_body" style="">
        <div class="queryPart">
            <button id="addBtn" type="button" class="btn btn-default">添加</button>
            <button id="updateBtn" type="button" class="btn btn-primary">修改</button>
            <button id="deleteBtn" type="button" class="btn btn-success">删除</button>
        </div>
        <table id="dataCheckTable" class="table table-hover">
            <caption style="text-align: center;">选点数据列表</caption>
            <thead>
            <tr>
                <th>低点</th>
                <th>高点</th>
                <th>调整</th>
                <th>调整率</th>
                <th>备注</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dataCheckList}" var="dataCheck">
                <tr dataCheckId="${dataCheck.id}">
                    <td>${dataCheck.low}</td>
                    <td>${dataCheck.high}</td>
                    <td>${dataCheck.tz}</td>
                    <td>${dataCheck.tzl}</td>
                    <td>${dataCheck.remark}</td>
                    <td>${dataCheck.createTime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
<script type="text/javascript">
    $("#addBtn").click(function(){
        var sharesCode = window.parent.getCheckSharesCode();
        //$("#dataCheckInput",window.parent.document).attr("src","toOperationDataCheckPage.do?sharesCode="+sharesCode);

    });
    $("#updateBtn").click(function(){

    });
    $("#deleteBtn").click(function(){

    });
    /*$(".table").find("tbody tr").click(function(){
        $tr = $(this);
        //样式操作
        $tr.parent().children().removeClass("active");
        $tr.addClass("active");
        selectTr($tr);
    });
    *//*选中一个tr*//*
    function selectTr($tr){
        var sharesCode = window.parent.getCheckSharesCode();
        $("#dataCheckInput",window.parent.document).attr("src","toOperationDataCheckPage.do?sharesCode="+sharesCode);
    }*/
</script>
</html>