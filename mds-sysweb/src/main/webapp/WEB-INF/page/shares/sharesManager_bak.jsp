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
    <title>股票管理</title>
    <style>
       .container .row .part{height:100%;}
       .t_center{text-align: center;}
       .t_contextBody{border-bottom: 2px #dfd3d3 solid; border-left: 2px #dfd3d3 solid;border-right: 2px #dfd3d3 solid;border-bottom-left-radius:5px;border-bottom-right-radius: 5px;padding: 5px;height: 600px;overflow: auto;}
       .part table{font-size: 2px;font-family: "微软雅黑";}
       .marTop20{margin-top: 20px;}
       .fs9{font-size: 9px !important;}
       .btnPart{border-top: 2px #dfd3d3 solid; border-left: 2px #dfd3d3 solid;border-right: 2px #dfd3d3 solid;border-top-left-radius: 5px;border-top-right-radius:5px;text-align: center;}
       .height500{height: 500px; }
    </style>
    <script type="text/javascript" src="/js/shares/sharesManager.js"></script>
</head>
<body style="margin:5px 28px">
    <div class="container">
       <%-- <div>功能标题</div>--%>
    </div>
    <div class="container">
        <div class="row">
            <div class="part col-lg-2">
                <div class="btnPart">
                    <button id="addSharesBtn" type="button" class="btn btn-primary fs9">添加</button>
                    <button id="updateSharesBtn" type="button" class="btn btn-primary fs9">修改</button>
                    <button id="deleteSharesBtn" type="button" class="btn btn-primary fs9">删除</button>
                </div>
                <div id="sharesGrid" class="t_contextBody">
                </div>
            </div>
            <div class="part col-lg-7">
                <div class="btnPart">
                    <button id="addExpectBtn" type="button" class="btn btn-primary fs9">添加</button>
                    <button id="updateExpectBtn" type="button" class="btn btn-primary fs9">修改</button>
                    <button id="deleteExpectBtn" type="button" class="btn btn-primary fs9">删除</button>
                </div>
                <div id="expectGrid" class="t_contextBody">
                </div>
            </div>
            <div class="part col-lg-3">
                <div class="btnPart">
                    <button id="addOperatorBtn" type="button" class="btn btn-primary fs9">添加</button>
                    <button id="updateOperatorBtn" type="button" class="btn btn-primary fs9">修改</button>
                    <button id="deleteOperatorBtn" type="button" class="btn btn-primary fs9">删除</button>
                </div>
                <div id="operationGrid" class="t_contextBody">
                </div>
            </div>
        </div>
    </div>
    <div style="position: absolute;top: 0px;left: 0px;width: 100%;height:100%;opacity: 1;background-color: white;display: none;">
        <iframe id="childPage" frameborder=0 width=100% height=100% marginheight=0 marginwidth=0 scrolling=no src="" style="margin-top: 30px;"></iframe>
    </div>

</body>
</html>