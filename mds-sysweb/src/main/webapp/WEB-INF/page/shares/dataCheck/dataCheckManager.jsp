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
<%--    <script type="text/javascript" src="/js/shares/sharesManager.js"></script>--%>
</head>
<body style="margin:5px 28px">
    <div class="page_body" style="width: 1500px;heigth:100%;">
        <div style="width:20%;min-width: 450;height: 100%;float: left;">
            <div class="queryPart">
                <button id="addBtn" type="button" class="btn btn-default">添加</button>
                <button id="updateBtn" type="button" class="btn btn-primary">修改</button>
                <button id="deleteBtn" type="button" class="btn btn-success">删除</button>
            </div>
            <table id="shareTable" class="table table-hover">
                <caption style="text-align: center;">股票列表</caption>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>代码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${shareList}" var="share">
                    <tr shareid="${share.id}">
                        <td>${share.name}</td>
                        <td>${share.code}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="width:80%;min-width: 800px;height: 100%;float: left;">
            <iframe id="dataCheckPart" width="100%" height="100%" src=""></iframe>
        </div>
       <%-- <div style="width: 450;height: 100%;float: left;">
            <iframe id="dataCheckInput" width="100%" height="100%" src=""></iframe>
        </div>--%>
        <br style="clear: both;"/>
    </div>
</body>
<script type="text/javascript">
    $(".table").find("tbody tr").click(function(){
        $tr = $(this);
        //样式操作
        $tr.parent().children().removeClass("active");
        $tr.addClass("active");
        selectTr($tr);
    });
    /*选中一个tr*/
    function selectTr($tr){
        var dataId = $tr.attr("shareid");
        $("#dataCheckPart").attr("src","toShareDataCheckPage.do?shareDataId="+dataId);
        $("#dataCheckInput").attr("src","");
    }
    /**
    *获取表格所选中的股票
     */
    function getCheckSharesCode(){
        var shares = $(".table tbody tr.active").find("td:eq(1)");
        if(shares!=null){
           return  shares.text();
        }
        return null;
    }
</script>
</html>