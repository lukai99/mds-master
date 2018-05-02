<%@ page import="com.mds.utils.PropertiesUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="/common/publicTop.jsp"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>demo</title>
    <link rel="shortcut icon" href="${basepath}/library/cfda.ico">
    <%--<link href="${basepath}/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${basepath}/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${basepath}/library/animate/animate.min.css" rel="stylesheet">
    <link href="${basepath}/library/layui/css/layui.css" rel="stylesheet">

</head>
<body class="gray-bg">
<div style="padding: 0px 50px;padding-top: 20px;">
    <div class="layui-row">
        <div class="layui-col-xs4 layui-col-sm4 layui-col-md4">
            <div class="" style="margin: 0px 10px">
                <c:forEach items="${detailsinfoObj.fileinfoList}" var="file">
                    <img src="<%=PropertiesUtil.getImgUrl() %>/${file.dir}/${file.uploadname}" style="width: 100%;margin: 5px;">
                </c:forEach>
            </div>
        </div>
        <div class="layui-col-xs8 layui-col-sm8 layui-col-md8">
            <div class="" style="margin: 0px 10px;padding-top: 10px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="syscode" placeholder="请输入编号" class="layui-input" lay-verify="required" readonly="readonly" value="${detailsinfoObj.syscode}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">物品名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="grossweight" placeholder="请输入物品名称" class="layui-input" lay-verify="required" readonly="readonly" value="${detailsinfoObj.goodsname}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="color: red;">参考价格</label>
                    <div class="layui-input-block">
                        <input type="text" name="trait" placeholder="请输入参考价格" class="layui-input" lay-verify="required" readonly="readonly" value="${detailsinfoObj.totalreprice}">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script src="${basepath}/library/layui/layui.js"></script>--%>
<script src="${basepath}/library/layui/layui.all.js"></script>
<script src="${basepath}/library/jquery/jquery.min.js"></script>
<script>
    ;!function(){
        var form = layui.form;
        var upload = layui.upload;
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

        upload.render({
            elem: '#upload',
            field: 'upload',//控件的name名，与后台参数名称一致
            url:  '${basepath}/goodsDetail/uploadGoodsIamges.do',
            accept: 'images',//默认值就是images
            multiple: false,//是否允许多文件上传。设置 true即可开启 默认值false
            size: 5120 //上传图片最大为5M
//            done: function(res, index, upload){ //上传后的回调
//
//            },
        });
    }();
</script>
</body>
</html>