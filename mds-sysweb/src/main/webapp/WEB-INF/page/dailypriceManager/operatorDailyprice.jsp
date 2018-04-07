<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-12-26
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>每日价格</title>
    <link rel="shortcut icon" href="/library/cfda.ico">
    <%--<link href="/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/library/animate/animate.min.css" rel="stylesheet">
    <link href="/library/layui/css/layui.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div style="padding: 0px 50px;padding-top: 20px;">
    <form id="dateForm" class="layui-form layui-form-pane" action="/dailyPrice/operatorDailyPrice.do">
        <input type="hidden" name="id" value="${dailyPrice.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">请选择元素</label>
            <div class="layui-input-block">
                <select name="baseelementid" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${baseElementVoList}" var="baseElement">
                        <option value="${baseElement.id}" ${baseElement.id eq dailyPrice.baseelementid? 'selected':''}>${baseElement.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="dailyprice" placeholder="请输入今日价格" class="layui-input" lay-verify="required|number" value="${dailyPrice.dailyprice}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-block">
                <input id="inputtime" type="text" name="inputtime" placeholder="请选择日期" class="layui-input" lay-verify="required" value="<fmt:formatDate pattern='yyyy-MM-dd'
            value='${dailyPrice.inputtime}' />">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="remark" placeholder="请输入备注" class="layui-textarea">${dailyPrice.remark}</textarea>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="sub">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</div>

<script src="/library/layui/layui.all.js"></script>
<script src="/library/jquery/jquery.min.js"></script>
<script>
;!function(){
    var form = layui.form;
    var laydate = layui.laydate;
    //构建日期控件
    laydate.render({
        elem: '#inputtime',
        type: 'date' //默认，可不填
    });

    //监听提交
    form.on('submit(sub)', function(data){
        var url = $("#dateForm").attr("action");
        $.ajax({
            type: "POST",
            dataType: "json",
            url: url,
            data: data.field,
            success: function (result) {
                if(result.state == '200'){
                    parent.reloadDataTable();
                    //当你在iframe页面关闭自身时
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                }else{
                    layer.msg("操作失败，"+result.message);
                }
            },
            error: function(data) {
            }
        });
        return false;
    });
}();
</script>
</body>
</html>