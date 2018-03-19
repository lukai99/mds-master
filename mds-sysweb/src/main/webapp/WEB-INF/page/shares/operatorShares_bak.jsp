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
    <title>添加股票</title>
    <style>
        .t_center{text-align: center}
    </style>
    <%--<script type="text/javascript" src="/js/shares/sharesManager.js"></script>--%>
</head>
<body style="margin:5px 28px">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="panel panel-primary height500">
                    <div class="panel-heading">
                        <h3 class="panel-title col-sm-11">添加股票</h3>
                        <div>关闭</div>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" action="saveShares.do">
                                <div class="form-group">
                                    <label for="code" class="col-sm-2 control-label">股票编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="code" name="code" placeholder="请输入股票编号">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="code" class="col-sm-2 control-label">股票名称</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入股票名称">
                                    </div>
                                </div>
                            <div class="t_center">
                                <button id="saveBtn" type="button" class="btn btn-default">保存</button>
                                <button id="closeBtn" type="button" class="btn btn-default">关闭</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>