<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 2018/2/22
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sharesDealSimulationManager</title>
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
                    <label class="layui-form-label">记录编号</label>
                    <div class="layui-input-inline">
                        <input id="gamecode" type="text" name="gamecode" placeholder="请输入记录编号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="width: 310px;float:left;clear: none;">
                    <label class="layui-form-label">游戏状态</label>
                    <div class="layui-input-block" style="width:190px;">
                        <select id="gamestate" name="gamestate">
                            <option value="" selected=""></option>
                            <option value="1" >正在进行</option>
                            <option value="0">已结束</option>
                        </select>
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
                <button id="addBtn" class="layui-btn layui-btn-normal layui-btn-sm">新游戏</button>
               <%-- <button id="updateBtn" class="layui-btn layui-btn-normal layui-btn-sm">编辑</button>
                <button id="deleteBtn" class="layui-btn layui-btn-normal layui-btn-sm">删除</button>--%>
            </div>
        </div>
        <table class="layui-hide" id="dataTable" lay-filter="dealgameTable"></table>
    </div>
</div>
<%--<script src="/library/layui/layui.js"></script>--%>
<script type="text/javascript" src="/library/layui/layui.all.js"></script>
<script type="text/javascript" src="/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/common/common_layui.js"></script>
<script>
    ;!function(){
        var form = layui.form;
        var table = layui.table;
        var dataTableObj = table.render({
            id:'dataTable',
            elem: '#dataTable',
            height: 'full-200',
            method:'post',
            url:'/shares/getSharesDealSimulationList.do',
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {type:'checkbox'},
                {field:'gamecode', width:200, title: '编号', align:'center'},
                {field:'gamestate', width:100, title: '状态', align:'center'},
                {field:'createtime', width:200, title: '创建时间', align:'center',templet:'<div>{{ layui.laytpl.toDateString(d.createtime) }}</div>'},
                {field:'operator', width:400, title: '操作', align:'center',templet:'#operatorBar'}

            ]],
            page: true,
            request: {
                pageName: 'page', //页码的参数名称，默认：page
                limitName: 'limit' //每页数据量的参数名，默认：limit
            },
            response: {
                statusName: 'resultCode', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                msgName: 'msg', //状态信息的字段名称，默认：msg
                countName: 'count', //数据总数的字段名称，默认：count
                dataName: 'data', //数据列表的字段名称，默认：data
            }
        });

//    });
        /*事件绑定*/
        $("#resetBtn").click(resetQueryForm);
        $("#queryBtn").click(queryQueryForm);
        //重置查询项
        function resetQueryForm(){
            $("#queryForm input[type='text']").val("");
            $("#queryForm select").val("");
        }
        //条件查询
        function queryQueryForm(){
            dataTableObj.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    gamecode:$("#gamecode").val(),
                    gamestate:$("#gamestate option:selected").val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
        //新建游戏
        $('#addBtn').on('click', function(){
            $.ajax({
                url:"/shares/generatorSharesDealGame.do",
                type:"POST",
                async:false,
                data:{},
                dataType:"json",
                success:function(data){
                    reloadDataTable();
                }
            });
        });
        //监听工具条
        table.on('tool(dealgameTable)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'startgame'){ //查看
                //do somehing
                window.top.createTab("/shares/toSharesDealSimulationPage.do?gameCode="+data.gamecode,data.gamecode,"游戏编号:"+data.gamecode);
            } else if(layEvent === 'lookoperatornode'){ //操作记录
            }
        });
        /*//修改字典项
        $('#updateBtn').on('click', function(){
            var checkStatus = table.checkStatus('dataTable'); //test即为基础参数id对应的值
            if(checkStatus.data.length==0){
                alert("请选择需要改的数据");
                return false;
            }
            if(checkStatus.data.length > 1){
                alert("只能选择一条数据进行修改");
                return false;
            }
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll ) //表格是否全选
            layer.open({
                type: 2,
                title: '修改字典项',
                maxmin: true,
                shadeClose: false, //点击遮罩关闭层
                area : ['800px' , '520px'],
                content: '/dictionary/toOperatorDictionaryPage.do?id='+checkStatus.data[0].id
            });
        });
        //删除字典项
        $("#deleteBtn").on('click', function(){
            var checkStatus = table.checkStatus('dataTable'); //test即为基础参数id对应的值
            if(checkStatus.data.length==0){
                alert("请选择需要删除的数据");
                return false;
            }
            //得到要删除的数据的id
            var ids = "";
            for(var i=0;i<checkStatus.data.length;i++){
                ids += checkStatus.data[i].id+",";
            }
            ids = ids.substr(0,ids.length-1);
            layer.msg('确定要删除此数据？', {
                shade:0.3,
                time: 0 //不自动关闭
                ,btn: ['确定', '取消']
                ,yes: function(index){
                    layer.close(index);
                    $.ajax({
                        url:"/dictionary/toDeleteDictionaryPage.do",
                        type:"POST",
                        async:false,
                        data:{dictionaryIds:ids},
                        dataType:"json",
                        success:function(data){
                            reloadDataTable();
                        }
                    });
                }
            });
        });*/
        //刷新数据表格
        window.reloadDataTable = function reloadDataTable(){
            $("#queryBtn").click();
        }
    }();
</script>
<script type="text/html" id="operatorBar">
    {{#  if(d.gamestate == 1){ }}
        <a class="layui-btn layui-btn-xs" lay-event="startgame">继续游戏</a>
        <a class="layui-btn layui-btn-xs" lay-event="lookoperatornode">查看操作记录</a>
    {{#  } }}
    {{#  if(d.gamestate == 0){ }}
        <a class="layui-btn layui-btn-xs" lay-event="startgame">查看游戏</a>
        <a class="layui-btn layui-btn-xs" lay-event="lookoperatornode">查看操作记录</a>
    {{#  } }}
</script>
</body>
</html>
