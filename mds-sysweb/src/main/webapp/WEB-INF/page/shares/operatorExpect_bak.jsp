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
    <title>添加预期</title>
    <style>
        .t_center{text-align: center}
    </style>
    <script type="text/javascript" src="/js/shares/operatorExpect.js"></script>
</head>
<body style="margin:5px 28px">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="panel panel-primary height500">
                    <div class="panel-heading">
                        <h3 class="panel-title col-sm-11">添加预期</h3>
                        <div>关闭</div>
                    </div>
                    <div class="panel-body">
                        <form id="operatorExpectForm" class="form-horizontal" role="form" action="operatorExpect.do">
                                <input id="sharesCode" name="sharesCode" type="hidden" value="2378">
                                <input name="formulaCode" type="hidden" value="">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="enough">势能</label>
                                    <div class="col-sm-10">
                                        <select id="enough" name="enough" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="trend" class="col-sm-2 control-label">趋势</label>
                                    <div class="col-sm-10">
                                        <select id="trend" name="trend" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="1">多</option>
                                            <option value="0">空</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="highPrice" class="col-sm-2 control-label">高点价格</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="highPrice" name="highPrice" placeholder="请输入高点价格">
                                    </div>
                                </div>
                            <div class="form-group">
                                <label for="lowPrice" class="col-sm-2 control-label">低点价格</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="lowPrice" name="lowPrice" placeholder="请输入低点价格">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="expectPrice" class="col-sm-2 control-label">预期价格</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="expectPrice" name="expectPrice" readonly placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="stopPrice" class="col-sm-2 control-label">止损价格</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="stopPrice" name="stopPrice" readonly placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="actualPrice" class="col-sm-2 control-label">实际价格</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="actualPrice" name="actualPrice" placeholder="请输入实际价格">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="remark" class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" id="remark" name="remark" rows="3"></textarea>
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