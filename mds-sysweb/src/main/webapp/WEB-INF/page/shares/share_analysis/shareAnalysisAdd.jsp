<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-11-5
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<jsp:include page="/common/publicTop.jsp"/>
<html>
<head>
    <title>点位分析</title>
    <style type="text/css">
        .pageBody {min-width: 900px; }
        .pageBody > div{width: 100%;height: 600px;}
        .pageBody > div{border: 1px solid #aca2a2;border-radius: 10px;float: left;margin: 9px;}
        .pageBody .part1{width: 28%;}
        .pageBody .part2{width: 68%;}
        .input_part .input_parameter{float: left;}
        .input_part{margin: 10px;padding: 5px;border: 1px solid red; border-radius: 25px;}
        .input_part .input_parameter > label{width: 90px;text-align: center;}
        .dataList{width: 100%;}
        .selected{background-color: #5796a9 !important;}
    </style>
    <script type="text/javascript">
        $(function(){
            $(".part2 .input_part .input_parameter input[name=high]").blur(function(){
                compute(this);
            });
            $(".part2 .input_part .input_parameter input[name=expectTzl]").blur(function(){
                compute(this);
            });
            $(".part2 .input_part .input_parameter input[name=tzJg]").blur(function(){
                compute(this);
            });
            $(".part2 .input_part .input_parameter input[name=low]").blur(function(){
                compute(this);
            });
            $(".part2 .input_part .input_parameter input[name=expectTzJg]").blur(function(){
                compute(this);
            });
            $(".part2 .input_part .input_parameter input[name=tzl]").blur(function(){
                compute(this);
            });
            $("#addBtn").click(function(){

            });
            $("#resetBtn").click(function(){

            });
            function compute(node){
                var high = $(node).parent().parent().find(".input_parameter input[name=high]").val();
                var low = $(node).parent().parent().find(".input_parameter input[name=low]").val();
                var expectTzl = $(node).parent().parent().find(".input_parameter input[name=expectTzl]").val();
                var tzJg = $(node).parent().parent().find(".input_parameter input[name=tzJg]").val();
                //高点 低点 预期调率 = 预期点位
                if(high&&low&&expectTzl){
                    //预期调整点 = 高点 - （高点-低点）*预期调整率
                    var expectTzJg = high - (high - low) * expectTzl;
                    $(node).parent().parent().find(".input_parameter input[name=expectTzJg]").val(expectTzJg);
                }
                //高点 低点 实际点位 = 实际调整率
                if(high&&low&&tzJg){
                    //实际调整率 = (高点-实际点)/(高点-低点)
                    var tzl = (high - tzJg)/(high - low);
                    $(node).parent().parent().find(".input_parameter input[name=tzl]").val(tzl);
                }
            }
            $("#shareTable tbody tr").click(function(){
                if(!$(this).hasClass("selected")){
                    $("#shareTable tbody tr").removeClass("selected");
                    $(this).addClass("selected");
                }
            });
        });
    </script>
</head>
<body>
    <div class="pageBody">
        <div class="part1">
            <table id="shareTable" class="table table-striped table-hover">
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
            <div class="input_part">
                <input type="hidden" name="shareCode">
                <div class="input_parameter">
                    <label>高点</label><input name="high" type="text">
                </div>
                <div class="input_parameter">
                    <label>预期调整率</label><input name="expectTzl" type="text" value="0.5">
                </div>
                <div class="input_parameter">
                    <label>实际调整率</label><input name="tzl" type="text">
                </div>
                <div class="input_parameter">
                    <label>低点</label><input name="low" type="text">
                </div>
                <div class="input_parameter">
                    <label>预期调整点</label><input name="expectTzJg" type="text">
                </div>
                <div class="input_parameter">
                    <label>实际点</label><input name="tzJg" type="text">
                </div>
                <div class="input_parameter" style="width: 805px;">
                    <label style="height: 10px; float: left;">备注</label><textarea name="remark" style="width:715px;"></textarea>
                </div>
                <div style="clear: both;"></div>
                <div style="width: 100%;padding: 10px 0px;text-align: center;">
                    <button id="addBtn" type="button" class="btn btn-default">添加</button>
                    <button id="resetBtn" type="button" class="btn btn-default">清空</button>
                </div>
            </div>
            <div class="dataList">
                <table id="analysisTable" class="table table-striped table-hover">
                    <caption style="text-align: center;">分析列表</caption>
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
        </div>
    </div>
</body>
</html>