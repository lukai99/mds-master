<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-5-21
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<jsp:include page="/common/publicTop.jsp"/>
<html>
<head>
    <title>股票画像</title>
    <style type="text/css">
        .pageBody {min-width: 900px; }
        .pageBody > div{width: 100%;height: 600px;}
        .pageBody > div{border: 1px solid #aca2a2;border-radius: 10px;float: left;margin: 9px;}
        .pageBody .part1{width: 28%;}
        .pageBody .part2{width: 68%;}

    </style>
    <script type="text/javascript" src="../library/ichartjs/ichart.1.2.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            /*表格控件*/
            $("#shareTable").find("tbody tr").click(function(){
               // console.log("dianji");
                $tr = $(this);
                //样式操作
                $tr.parent().children().removeClass("active");
                $tr.addClass("active");
                //selectTr($tr);
            });
            /*选中一个tr*/
            /*function selectTr($tr){
                var dataId = $tr.attr("shareid");
                $.ajax({
                    data:{dataId:dataId},
                    dataType:'json',
                    url:'getSharePortrait.do',
                    success:function(result){
                        basicChart.load(result.dataList);//载入新数据
                    },
                    error:function(){
                        alert('网络异常');
                    }
                });
            }*/

            /*图表*/
            /*function(){

            }*/
            var basicChart = new iChart.LineBasic2D({
                id:'lineBasicChart',
                render : 'canvasDiv',
               // data: data,
                title : '股票画像',
                width : 1000,
                height : 400,
                coordinate:{
                    height:'90%',
                    background_color:'#f6f9fa',
                    scale:[{//配置自定义值轴
                        position:'left',//配置左值轴
                        start_scale:7,//设置开始刻度为0
                        end_scale:9,//设置结束刻度为26
                       // scale_space:2,//设置刻度间距
                        listeners:{//配置事件
                            parseText:function(t,x,y){//设置解析值轴文本
                                return {text:t}
                            }
                        }
                    }]
                },
                sub_option:{
                    hollow_inside:false,//设置一个点的亮色在外环的效果
                    point_size:16
                },
                labels:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
            });
            basicChart.draw();

            /* 计算 */
            $("#btn").click(function(){
                var high = $("#high").val();
                var low = $("#low").val();
                $("#result").html("结果："+ (Number((high -  low)/2) + Number(low)));
            });
        });

    </script>
</head>
<body>
    <div class="pageBody">
        <div class="part1">
            <table id="shareTable" class="table table-hover">
                <caption style="text-align: center;">股票列表</caption>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>代码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${shareList}" var="share">
                    <tr shareid="${share.id}">
                        <td>${share.name}</td>
                        <td>${share.code}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="part2">
            <div id='canvasDiv'style="overflow: auto;"></div>
            <div>
                <input id="high" type="text">
                <input id="low" type="text">
                <button id="btn">计算</button>
                <p id="result"></p>
            </div>
        </div>
    </div>
</body>
</html>