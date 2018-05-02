<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="shortcut icon" href="${basepath}/library/cfda.ico">
    <%--<link href="${basepath}/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${basepath}/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${basepath}/library/animate/animate.min.css" rel="stylesheet">
    <link href="${basepath}/library/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="${basepath}/library/zTree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${basepath}/library/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
    <form id="dateForm" class="layui-form layui-form-pane" action="/roleManage/addRoleMenu.do">
        <input id="zNodes_id"  type="hidden" value="${roleId}"/>
        <div class="layui-form-item">
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button id="submitBtn" class="layui-btn" type="button" lay-submit lay-filter="demo">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
<%--<script src="${basepath}/library/layui/layui.js"></script>--%>
<script src="${basepath}/library/layui/layui.all.js"></script>
<script src="${basepath}/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${basepath}/library/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${basepath}/library/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${basepath}/library/zTree/js/jquery.ztree.excheck.js"></script>
<script>
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    function onCheck(){
        var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            nodes=treeObj.getCheckedNodes(true),
            v="";
        for(var i=0;i<nodes.length;i++){
            v+=nodes[i].value + ",";
        }
        return v;
    }


    ;!function(){
        var form = layui.form,
            layer = layui.layer;

        var roleId = $("#zNodes_id").val();
        $.ajax({
            type : "POST",

            data : {"roleId":roleId},
            url : "${basepath}/roleManage/getTree.do",
            success : function(result){
                $.fn.zTree.init($("#treeDemo"), setting, eval(result));
            },
            error : function(data){
                layer.msg("加载错误！！");
        }
        });

        //监听提交
        form.on('submit(demo)', function(data){
            var ids = onCheck();
            /*var data = $("#dateForm").serialize();*/
            var url = $("#dateForm").attr("action");
            $.ajax({
                type: "POST",
                dataType: "json",
                url: url,
                data: {"ids":ids,"roleId":roleId},
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