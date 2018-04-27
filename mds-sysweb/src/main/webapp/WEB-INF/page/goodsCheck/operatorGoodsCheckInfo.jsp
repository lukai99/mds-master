<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/common/publicTop.jsp"/>
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
    <form id="dateForm" class="layui-form layui-form-pane" action="${basepath}/goodsCheck/operatorGoodsCheck.do">
        <input type="hidden" name="id" value="${detailsinfoObj.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">请选择编号</label>
            <div class="layui-input-block">
                <select name="id" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${detaillist}" var="detail">
                        <option value="${detail.id}" ${detailsinfoObj.id eq detail.id ? 'selcted' : ''}>${detail.syscode}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--载体形状--%>
        <div class="layui-form-item">
            <label class="layui-form-label">载体形状</label>
            <div class="layui-input-block">
                <input type="text" name="carriershape" placeholder="请输入载体形状" class="layui-input" lay-verify="required" value="">
            </div>
        </div>
        <%--蜂窝形状--%>
        <div class="layui-form-item">
            <label class="layui-form-label">蜂窝形状</label>
            <div class="layui-input-block">
                <input type="text" name="honeycombshape" placeholder="请输入蜂窝形状" class="layui-input" lay-verify="required" value="">
            </div>
        </div>
        <%--净重--%>
        <div class="layui-form-item">
            <label class="layui-form-label">净重</label>
            <div class="layui-input-block">
                <input type="text" name="netweight" placeholder="请输入净重" class="layui-input" lay-verify="required" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">元素名称</label>
            <div class="layui-input-block">
                <select name="elname" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${baseElementVoList}" var="baseElement">
                        <option value="${baseElement.id}" >${baseElement.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">含量</label>
            <div class="layui-input-block">
                <input type="text" name="elcontent" placeholder="请输入含量" class="layui-input" lay-verify="required|number" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">元素名称</label>
            <div class="layui-input-block">
                <select name="elname" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${baseElementVoList}" var="baseElement">
                        <option value="${baseElement.id}" >${baseElement.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">含量</label>
            <div class="layui-input-block">
                <input type="text" name="elcontent" placeholder="请输入含量" class="layui-input" lay-verify="required|number" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">元素名称</label>
            <div class="layui-input-block">
                <select name="elname" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${baseElementVoList}" var="baseElement">
                        <option value="${baseElement.id}" >${baseElement.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">含量</label>
            <div class="layui-input-block">
                <input type="text" name="elcontent" placeholder="请输入含量" class="layui-input" lay-verify="required|number" value="">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="checkremark" placeholder="请输入备注" class="layui-textarea">${detailsinfoObj.remark}</textarea>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="demo">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</div>

<%--<script src="/library/layui/layui.js"></script>--%>
<script src="/library/layui/layui.all.js"></script>
<script src="/library/jquery/jquery.min.js"></script>
<script>
    ;!function(){
        var form = layui.form;
        /*$("#submitBtn").click(function(){*/
        //监听提交
        form.on('submit(demo)', function(data){
            /*var data = $("#dateForm").serialize();*/
            var elnames =  $("select[name='elname']").map(function(){return $(this).val()}).get().join(",");  //$("select[name='elname']").val();
            var elcontents = $("input[name='elcontent']").map(function(){return $(this).val()}).get().join(",");

            var url = $("#dateForm").attr("action");
            $.ajax({
                type: "POST",
                dataType: "json",
                url: url,
                data: {elname:elnames,elcontent:elcontents,
                    id:$("select[name='id']").val(),
                    carriershape:$("input[name='carriershape']").val(),
                    honeycombshape:$("input[name='honeycombshape']").val(),
                    netweight:$("input[name='netweight']").val(),
                    checkremark:$("textarea[name='checkremark']").val()
                },
                success: function (result) {
                    if(result.state == '200'){
                        parent.reloadDataTable();
                        //当你在iframe页面关闭自身时
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    }else{
                        layer.msg(result.message);
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