<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-12-26
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"
            +request.getServerName()+":"
            +request.getServerPort()+
            path;
    request.setAttribute("basepath", basepath);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>demo</title>
    <link rel="shortcut icon" href="/library/cfda.ico">
    <%--<link href="/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${basepath}/library/animate/animate.min.css" rel="stylesheet">
    <link href="${basepath}/library/layui/css/layui.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div style="padding: 0px 50px;padding-top: 20px;">
    <form id="dateForm" class="layui-form layui-form-pane" action="${basepath}/baseelement/addBaseElement.do">
        <input type="hidden" name="id" value="${bl.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">元素编号</label>
            <div class="layui-input-block">
                <input type="text" name="code" placeholder="请输入元素编号" class="layui-input" lay-verify="required" value="${bl.code}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">元素名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" placeholder="请输入元素名称" class="layui-input" lay-verify="required" value="${bl.name}">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input id="state" type="checkbox" name="state" lay-skin="switch" title="开关" lay-text="启用|禁用" checked="checked" value="1">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="remark" placeholder="请输入备注" class="layui-textarea">${bl.remark}</textarea>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="demo">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</div>

<%--<script src="/library/layui/layui.js"></script>--%>
<script src="${basepath}/library/layui/layui.all.js"></script>
<script src="${basepath}/library/jquery/jquery.min.js"></script>
<script>
    ;!function(){
        var form = layui.form;
        /*$("#submitBtn").click(function(){*/
        //监听提交
        form.on('submit(demo)', function(data){
            /*var data = $("#dateForm").serialize();*/
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

                    }
                },
                error: function(data) {
                }
            });

        });
    }();
</script>
</body>
</html>