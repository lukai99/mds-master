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
    <form id="dateForm" class="layui-form layui-form-pane" action="${basepath}/goodsDetail/operatorGoodsDetail.do">
        <input type="hidden" name="id" value="${detailsinfoObj.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">请选择物品</label>
            <div class="layui-input-block">
                <select name="goodsinfoid" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${goodslist}" var="goods">
                        <option value="${goods.id}" ${detailsinfoObj.goodsinfoid eq goods.id ? 'selected' : ''}>${goods.goodsname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-block">
                <input type="text" name="syscode" placeholder="请输入编号" class="layui-input" lay-verify="required" value="${detailsinfoObj.syscode}">
            </div>
        </div>
        <%--毛重--%>
        <div class="layui-form-item">
            <label class="layui-form-label">毛重</label>
            <div class="layui-input-block">
                <input type="text" name="grossweight" placeholder="请输入毛重" class="layui-input" lay-verify="required" value="${detailsinfoObj.grossweight}">
            </div>
        </div>
        <%--特征编号--%>
        <div class="layui-form-item">
            <label class="layui-form-label">特征编号</label>
            <div class="layui-input-block">
                <input type="text" name="trait" placeholder="请输入特征编号" class="layui-input" lay-verify="required" value="${detailsinfoObj.trait}">
            </div>
        </div>
        <%--车型--%>
        <div class="layui-form-item">
            <label class="layui-form-label">车型</label>
            <div class="layui-input-block">
                <input type="text" name="cartype" placeholder="请输入车型" class="layui-input" lay-verify="required" value="${detailsinfoObj.cartype}">
            </div>
        </div>
        <%--品牌--%>
        <div class="layui-form-item">
            <label class="layui-form-label">品牌</label>
            <div class="layui-input-block">
                <input type="text" name="brand" placeholder="请输入品牌" class="layui-input" lay-verify="required" value="${detailsinfoObj.brand}">
            </div>
        </div>
        <%--货源位置--%>
        <div class="layui-form-item">
            <label class="layui-form-label">货源位置</label>
            <div class="layui-input-block">
                <input type="text" name="sougl" placeholder="请输入货源位置" class="layui-input" lay-verify="required" value="${detailsinfoObj.sougl}">
            </div>
        </div>
        <%--产地--%>
        <div class="layui-form-item">
            <label class="layui-form-label">产地</label>
            <div class="layui-input-block">
                <input type="text" name="place" placeholder="请输入产地" class="layui-input" lay-verify="required" value="${detailsinfoObj.place}">
            </div>
        </div>
        <%--上传文件--%>
        <div class="layui-upload">
            <button type="button" class="layui-btn" id="upload">图片上传</button>
            <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                预览图：
                <div class="layui-upload-list" id="imgqueue">
                    <c:forEach items="${filelist}" var="file">
                        <img src="<%=PropertiesUtil.getImgUrl() %>/${file.dir}/${file.uploadname}" >
                    </c:forEach>
                </div>
            </blockquote>
            <textarea class="layui-hide" id="realnames" name="realnames">${realnames}</textarea>
            <textarea class="layui-hide" id="uploadnames" name="uploadnames">${uploadnames}</textarea>
            <textarea class="layui-hide" id="dirname" name="dirname">${dirnames}</textarea>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="remark" placeholder="请输入备注" class="layui-textarea">${detailsinfoObj.remark}</textarea>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="demo">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
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
            if($("#realnames").val()=="" ||
                $("#uploadnames").val()=="" ||
                $("#dirname").val()==""){
                layer.msg("请上传图片信息");
                return;
            }
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
            size: 5120, //上传图片最大为5M
            multiple:true,
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#imgqueue').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                });
            },
            done: function(res){ //上传后的回调
                $("#realnames").val($("#realnames").val()+res.realname+",");
                $("#uploadnames").val($("#uploadnames").val()+res.uploadname+",");
                $("#dirname").val($("#dirname").val()+res.dirname+",");

            },
        });

        $('#upload').on('click', function(){
            $("#imgqueue").empty();
            $("#realnames").val("");
            $("#uploadnames").val("");
            $("#dirname").val("");
        });
    }();
</script>
</body>
</html>