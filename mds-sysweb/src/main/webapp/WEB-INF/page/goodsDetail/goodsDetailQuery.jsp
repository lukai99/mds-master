<%@ page import="com.mds.utils.PropertiesUtil" %><%--
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
    <title>物品信息查询</title>
    <link rel="shortcut icon" href="/library/cfda.ico">
    <%--<link href="/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/library/animate/animate.min.css" rel="stylesheet">
    <link href="/library/layui/css/layui.css" rel="stylesheet">
    <style type="text/css">
        .flow-default{ height: 400px; overflow: auto; font-size: 0;margin-top: 20px;}
        .flow-default li{display: inline-block; margin: 20px 5px; font-size: 14px; width: 300px;  margin-bottom: 10px; height: 200px; line-height: 20px; text-align: center; background-color: #eee;}
        .flow-default img{width: 100%; height: 100%;}
        .site-demo-flow{width: 600px; height: 300px; overflow: auto; text-align: center;}
        .site-demo-flow img{width: 40%; height: 200px; margin: 0 2px 5px 0; border: none;}
        .goodBtn{cursor:hand}
        .textLabel{width: 100%;background-color: #cbcbcb;padding-top: 5px;}
        .layui-flow-more{margin: 25px 0px !important;}
    </style>

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
                <div class="layui-form-item" style="width: 310px;float:left;clear: none;">
                    <label class="layui-form-label">物品编号</label>
                    <div class="layui-input-block" style="width:190px;">
                        <select id="trait" name="trait">
                            <option value="" selected=""></option>
                            <option value="1" >一级</option>
                            <option value="2">二级</option>
                            <option value="3">三级</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="width: 310px;float:left;clear: none;">
                    <label class="layui-form-label">车型</label>
                    <div class="layui-input-block" style="width:190px;">
                        <select id="cartype" name="cartype">
                            <option value="" selected=""></option>
                            <option value="1" >一级</option>
                            <option value="2">二级</option>
                            <option value="3">三级</option>
                        </select>
                    </div>
                </div>
                <br style="clear:both;"/>
            </div>
            <div style="text-align: right; padding-right: 50px;">
                <button id="queryBtn" class="layui-btn layui-btn-normal layui-btn-sm" type="button">查询</button>
                <button id="resetBtn" class="layui-btn layui-btn-normal layui-btn-sm" type="reset">重置</button>
            </div>
        </form>
    </div>
    <div class="data-part">
        <div style="margin-top: 5px;">
            <div class="layui-btn-group">
              <%--  <button id="addBtn" class="layui-btn layui-btn-normal layui-btn-sm">录入</button>
                <button id="updateBtn" class="layui-btn layui-btn-normal layui-btn-sm">编辑</button>
                <button id="deleteBtn" class="layui-btn layui-btn-normal layui-btn-sm">删除</button>--%>
            </div>
        </div>
        <%--<table class="layui-hide" id="dataTable"></table>--%>
        <div>
            <ul class="flow-default" id="demo" style="height:fit-content;min-height: 400px;text-align: center;">
            </ul>
        </div>
    </div>
</div>
</body>
<script src="/library/layui/layui.all.js"></script>
<script src="/library/jquery/jquery.min.js"></script>
<script src="/common/common_layui.js"></script>
<script type="text/javascript">
    ;!function(){
        var flow = layui.flow;

        /*事件绑定*/
        $("#queryBtn").click(queryQueryForm);

        getData();

        //条件查询
        function queryQueryForm(){
            /*表格重新加载的两种方式*/
            $("#demo").empty();
            getData();
        }
        function getData(){
            flow.load({
                elem: '#demo', //流加载容器
                scrollElem: '#demo', //滚动条所在元素，一般不用填，此处只是演示需要。
                isAuto:false,
                isLazyimg: true,
                done: function(page, next){ //执行下一页的回调
                    //模拟插入
                    var lis = [];
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: '${basepath}/goodsDetail/getGoodsInfoListForQuery.do?page='+page+"&&limit="+8,
                        data: {
                            syscode:$("#syscode").val(),
                            cartype:$("#cartype option:selected").val(),
                            trait:$("#trait option:selected").val()
                        },
                        success: function (result) {
                            //假设你的列表返回在data集合中
                            layui.each(result.data, function(index, item){
                                /*lis.push('<li>'+ item.title +'</li>');*/
                                lis.push('<li class="goodBtn" data_id="'+item.id+'"><img lay-src="<%=PropertiesUtil.getImgUrl() %>/'+item.fileinfoList[0].dir+'/'+item.fileinfoList[0].uploadname+'"> <label class="textLabel">编号：<span>'+item.syscode+'</span></label></li>');
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < Math.ceil(result.total/result.limit));
                        },
                        error: function(data) {
                            alert("数据加载失败");
                        }
                    });
                }
            });

        }

        $("#demo").on('click',".goodBtn",function(){
            var id = $(this).attr("data_id");
            layer.open({
                type: 2,
                title: '物品信息详情',
                maxmin: true,
                shadeClose: false, //点击遮罩关闭层
                area : ['100%' , '100%'],
                content: '${basepath}/goodsDetail/toGoodsInfoDetailsShowPage.do?id='+id,
                success: function(layero, index){
                    layer.full(index);
                }
            });
        });

        //刷新数据表格
        window.reloadDataTable = function reloadDataTable(){
            $("#queryBtn").click();
        }
    }();


</script>
</html>
