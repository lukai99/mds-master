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
        .magic_form-group{margin-left: 0px !important;margin-right: 0px !important;}
        .page_header{height: 100px;}
        .page_header .info{padding-top: 10px;}
        .info{text-align: center;}
        .page_footer .operationBtn{text-align: center;}
    </style>
</head>
<body style="">
    <div class="page_header">
        <div class="info">
            <label >操作窗口</label>-----<span>添加数据</span>
        </div>
    </div>
    <div class="page_body" style="">
        <div class="">
            <form id="dataFrom" class="form-horizontal" role="form" action="saveDataCheck.do" method="post">
                <input name="shareCode" type="hidden" value="${shareCode}">
                <div class="form-group magic_form-group">
                    <label for="low" class="col-xs-3 control-label">低点</label>
                    <div class="col-xs-8">
                        <input id="low"  name="low" type="text" class="form-control" placeholder="请输入低点">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="low" class="col-xs-3 control-label">低点日期</label>
                    <div class="col-xs-8">
                        <input id="lowDate"  name="lowDate" type="text" class="form-control formDate" placeholder="请选择低点日期">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="high" class="col-xs-3 control-label">高点</label>
                    <div class="col-xs-8">
                        <input id="high"  name="high" type="text" class="form-control" placeholder="请输入高点">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="highDate" class="col-xs-3 control-label">高点日期</label>
                    <div class="col-xs-8">
                        <input id="highDate"  name="highDate" type="text" class="form-control formDate" placeholder="请选择高点日期">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="tz" class="col-xs-3 control-label">调整</label>
                    <div class="col-xs-8">
                        <input id="tz"  name="tz" type="text" class="form-control" placeholder="请输入调整点">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="tzDate" class="col-xs-3 control-label">调整日期</label>
                    <div class="col-xs-8">
                        <input id="tzDate"  name="tzDate" type="text" class="form-control formDate" placeholder="请选择调整日期">
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="tzl" class="col-xs-3 control-label">调整率</label>
                    <div class="col-xs-8">
                        <input id="tzl"  name="tzl" type="text" class="form-control" placeholder="" readonly>
                    </div>
                </div>
                <div class="form-group magic_form-group">
                    <label for="remark" class="col-xs-3 control-label">备注</label>
                    <div class="col-xs-8">
                        <textarea id="remark"  name="remark" class="form-control" rows="3"></textarea>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="page_footer">
        <div class="operationBtn">
            <button id="subBtn" type="button" class="btn btn-primary">提交</button>
            <button id="resetBtn" type="button" class="btn btn-primary">重置</button>
        </div>
        <div class="info">
        </div>
    </div>
</body>
<script type="text/javascript">
    $("#low,#high,#tz").blur(function(){
        if(validateInput()){
            computeTzl();
        }
    });
    $("#subBtn").click(function(){
          $("#dataFrom").submit();
    });
    //验证录入框
    function validateInput(){
        var low = Number($("#low").val());
        var high = Number($("#high").val());
        var tz = Number($("#tz").val());
        if(low==""||high==""||tz==""){
             return false;
        }
        if(low>=high){
            console.log("请检查低点与高点！");
            return false;
        }
        if(tz>=high){
            console.log("请检查调整点与高点！");
            return false;
        }
        if(low>=tz){
            console.log("请检查低点与调整点！");
            return false;
        }
        return true;
    }
    //计算回调率
    function computeTzl(){
        var low = Number($("#low").val());
        var high = Number($("#high").val());
        var tz = Number($("#tz").val());
        if(low&&high&&tz){
            var tzl = (high-tz)/(high-low);
            $("#tzl").val(tzl);
        }
    }
    //初始化日期控件
    $(".formDate").datetimepicker({
        format:'yyyy-mm-dd',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: true,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
</html>