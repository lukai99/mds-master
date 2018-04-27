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
<jsp:include page="/common/publicTop.jsp"/>
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
<div class="wrapper wrapper-content animated fadeInUp" style="margin-left: 10px;padding: 0px 50px;padding-top: 20px;">
    <form id="dateForm" class="layui-form layui-form-pane" action="${basepath}/sys/saveSysconfig.do">
        <input type="hidden" name="id" value="${config.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">折扣率</label>
            <div class="layui-input-block">
                <select name="discount" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${discountList}" var="discount">
                        <option value="${discount.val}" ${discount.val eq config.discount? 'selected':''}>${discount.val}%</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="sub">保存</button>
            <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
        </div>
    </form>
</div>

<script src="/library/layui/layui.all.js"></script>
<script src="/library/jquery/jquery.min.js"></script>
<script>
;!function(){
    var form = layui.form;
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
                    layer.msg("操作成功");
                }else{
                    layer.open({
                        title: '提示',
                        content: '操作失败！请联系管理员。'
                    });

                }
            },
            error: function(data) {
                layer.open({
                    title: '提示',
                    content: '操作失败！请联系管理员。'
                });
            }
        });
        return false;
    });
}();
</script>
</body>
</html>