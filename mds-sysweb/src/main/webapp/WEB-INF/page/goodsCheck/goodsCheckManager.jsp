<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/3/22
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
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
<div class="wrapper wrapper-content animated fadeInUp" style="margin-left: 10px;">
    <div class="query-part" style="border: 1px solid #1f9fff; margin-top: 10px;padding: 5px;margin-right: 15px;">
        <form id="queryForm" class="layui-form layui-form-pane" action="">
            <div style="margin-top: 10px;">
                <div class="layui-form-item" style="width: 310px;float:left;clear: none;">
                    <label class="layui-form-label">编号</label>
                    <div class="layui-input-inline">
                        <input id="syscode" type="text" name="syscode" placeholder="请输入编号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <br style="clear:both;"/>
            </div>
            <div style="text-align: right; padding-right: 50px;">
                <button id="queryBtn" class="layui-btn layui-btn-normal layui-btn-sm" type="button">查询</button>
                <button id="resetBtn" class="layui-btn layui-btn-normal layui-btn-sm" type="button">重置</button>
            </div>
        </form>
    </div>
    <div class="data-part">
        <div style="margin-top: 5px;">
            <div class="layui-btn-group">
                <button id="addBtn" class="layui-btn layui-btn-normal layui-btn-sm">录入</button>
                <button id="updateBtn" class="layui-btn layui-btn-normal layui-btn-sm">编辑</button>
                <%--<button id="lookBtn" class="layui-btn layui-btn-normal layui-btn-sm">查看检测详情</button>--%>
            </div>
        </div>
        <table lay-filter="lookcheck" class="layui-hide" id="dataTable"></table>
    </div>
</div>
</body>
<script src="/library/layui/layui.all.js"></script>
<script src="/library/jquery/jquery.min.js"></script>
<script src="/common/common_layui.js"></script>
<script type="text/javascript">
    ;!function(){

        var table = layui.table;

        var dataTableObj = table.render({
            id: 'goodschecktable',
            elem: '#dataTable',
            height: 'full-200',
            method:'post',
            url:'/goodsCheck/getGoodsCheckList.do',
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {type:'checkbox'},
                {type:'numbers',title: '序号'},
                {field:'syscode', width:150, title: '编号', align:'center'},
                {field:'carriershape', width:150, title: '载体形状', align:'center'},
                {field:'honeycombshape', width:150, title: '蜂窝形状', align:'center'},
                {field:'netweight', width:150, title: '净重', align:'center'},
                {field:'checkremark', width:210, title: '备注', align:'center'},
                {width:210, title: '操作', align:'center',toolbar: '#barDemo'}
            ]],
            page: true,
            request: {
                pageName: 'page', //页码的参数名称，默认：page
                limitName: 'limit' //每页数据量的参数名，默认：limit
            },
            response: {
                statusName: 'resultCode', //数据状态的字段名称，默认：code
                statusCode: 0, //成功的状态码，默认：0
                msgName: 'msg', //状态信息的字段名称，默认：msg
                countName: 'count', //数据总数的字段名称，默认：count
                dataName: 'data', //数据列表的字段名称，默认：data
            }
        });

        /*事件绑定*/
        $("#resetBtn").click(resetQueryForm);
        $("#queryBtn").click(queryQueryForm);
        //重置查询项
        function resetQueryForm(){
            $("#queryForm input[type='text']").val("");
        }
        //条件查询
        function queryQueryForm(){
            /*表格重新加载的两种方式*/
            /*dataTableObj.reload({*/
            table.reload("goodschecktable",{
                where: { //设定异步数据接口的额外参数，任意设
                    syscode:$("#syscode").val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始  不设定就是还是定位到当前页
                }
            });
        }

        //添加物品信息
        $('#addBtn').on('click', function(){
            layer.open({
                type: 2,
                title: '添加物品检测详情',
                maxmin: true,
                shadeClose: false, //点击遮罩关闭层
                area : ['100%' , '100%'],
                content: '/goodsCheck/toOperatorGoodsCheckPage.do'
            });
        });

        //修改物品信息
        $('#updateBtn').on('click', function(){
            var checkStatus = table.checkStatus('goodschecktable'); //test即为基础参数id对应的值
            if(checkStatus.data.length==0){
                layer.msg("请选择需要改的数据");
                return false;
            }
            if(checkStatus.data.length > 1){
                layer.msg("只能选择一条数据进行修改");
                return false;
            }
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll ) //表格是否全选
            layer.open({
                type: 2,
                title: '修改物品检测详情',
                maxmin: true,
                shadeClose: false, //点击遮罩关闭层
                area : ['100%' , '100%'],
                content: '/goodsCheck/toUpdateGoodsCheckPage.do?id='+checkStatus.data[0].id
            });
        });


        //刷新数据表格
        window.reloadDataTable = function reloadDataTable(){
            $("#queryBtn").click();
        }

        table.on('tool(lookcheck)', function(obj){
            var id = obj.data.id;

            layer.open({
                type: 2,
                title: '查看物品检测详情',
                maxmin: true,
                shadeClose: false, //点击遮罩关闭层
                area : ['80%' , '70%'],
                content: '/goodsCheck/toLookGoodsCheckPage.do?id='+id
            });
        });
    }();



</script>
<script type="text/html" id="barDemo">
    <a class="lookbtn layui-btn layui-btn-xs" lay-event="detail">查看检测详情</a>
</script>
</html>
