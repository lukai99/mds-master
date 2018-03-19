/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-8-10
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
$(function(){
    //股票数据列表
    window.dataGrid_shares = {
        //初始化数据
        initData:function(){
            $.ajax({
                type : "POST",  //提交方式
                url : "../shares/querySharesList.do",//路径
                data : {
                },//数据，这里使用的是Json格式进行传输
                success : function(result) {//返回数据根据结果进行相应的处理
                    if(result.length!=0){
                        var html = '<table class="table table-bordered table-hover">';
                        html += '<caption class="t_center">shares info</caption>';
                        html += '<thead>';
                        html += '<tr>';
                        html += '<th>编号</th>';
                        html += '<th>名称</th>';
                        html += '</tr>';
                        html += '</thead>';
                        html += '<tbody>';
                        for(var i=0;i<result.length;i++){
                            html += '<tr code='+result[i].code+'>';
                            html += '<td>'+result[i].code+'</td> ';
                            html += '<td>'+result[i].name+'</td>';
                            html += '</tr> ';
                        }
                        html += '</tbody>';
                        html += '</table>';
                        $("#sharesGrid").html($(html));
                        dataGrid_shares.onBind();
                    }else{
                        var html = '暂无数据';
                        $("#sharesGrid").html($(html));
                    }
                }
            });
        },
        //重新加载数据
        reloadData:function(){

        },
        //绑定点击事件
        onBind:function(){
            $("#sharesGrid table tbody tr").unbind();
            $("#sharesGrid table tbody tr td").unbind();
            $("#sharesGrid table tbody").on("click","tr",function(event){dataGrid_shares.trClick(this);});
            $("#sharesGrid table tbody tr").on("click","td",function(event){dataGrid_shares.tdClick(this);});
        },
        //点击表格tr触发
        trClick:function(element){
            var sharesCode = $(element).attr("code");
            dataGrid_expect.initData(sharesCode);
        },
        //点击表格td触发
        tdClick:function(element){
        }

    };

    //预期数据列表
    window.dataGrid_expect = {
        //初始化数据
        initData:function(sharesCode){
            $.ajax({
                type : "POST",  //提交方式
                url : "../shares/queryExpectList.do",//路径
                data : {
                    sharesCode:sharesCode
                },//数据，这里使用的是Json格式进行传输
                success : function(result) {//返回数据根据结果进行相应的处理
                    if(result.length!=0){
                        var html = '<table class="table table-bordered table-hover">';
                        html += '<caption class="t_center">expect info</caption>';
                        html += '<thead>';
                        html += '<tr>';
                        html += '<th>数据编号</th>';
                        html += '<th>势能</th>';
                        html += '<th>涨跌趋势</th>';
                        html += '<th>高点价格</th>';
                        html += '<th>低点价格</th>';
                        html += '<th>预期价格</th>';
                        html += '<th>止损价格</th>';
                        html += '<th>实际价格</th>';
                        html += '<th>公式编号</th>';
                        html += '<th>创建时间</th>';
                        html += '</tr>';
                        html += '</thead>';
                        html += '<tbody>';
                        for(var i=0;i<result.length;i++){
                            html += '<tr code='+result[i].id+'>';
                            html += '<td>'+result[i].id+'</td> ';
                            html += '<td>'+result[i].enough+'</td> ';
                            html += '<td>'+result[i].trend+'</td>';
                            html += '<td>'+result[i].highPrice+'</td>';
                            html += '<td>'+result[i].lowPrice+'</td>';
                            html += '<td>'+result[i].expectPrice+'</td>';
                            html += '<td>'+result[i].stopPrice+'</td>';
                            html += '<td>'+result[i].actualPrice+'</td>';
                            html += '<td>'+result[i].formulaCode+'</td>';
                            html += '<td>'+new Date(result[i].createTime)+'</td>';
                            html += '</tr> ';
                        }
                        html += '</tbody>';
                        html += '</table>';
                        $("#expectGrid").html($(html));
                        dataGrid_expect.onBind();
                    }else{
                        var html = '<div class="t_center marTop20">暂无数据<div>';
                        $("#expectGrid").html($(html));
                    }
                }
            });
        },
        //重新加载数据
        reloadData:function(){

        },
        //绑定点击事件
        onBind:function(){
            $("#expectGrid table tbody tr").unbind();
            $("#expectGrid table tbody tr td").unbind();
            $("#expectGrid table tbody").on("click","tr",function(event){dataGrid_expect.trClick(this);});
            $("#expectGrid table tbody tr").on("click","td",function(event){dataGrid_expect.tdClick(this);});
        },
        //点击表格tr触发
        trClick:function(element){
            //alert("记载操作记录");
        },
        //点击表格td触发
        tdClick:function(element){
        }

    };
    //操作记录数据列表
    window.dataGrid_operation = {
        //初始化数据
        initData:function(ExpectCode){
            $.ajax({
                type : "POST",  //提交方式
                url : "../shares/queryOperationList.do",//路径
                data : {
                    sharesCode:ExpectCode
                },//数据，这里使用的是Json格式进行传输
                success : function(result) {//返回数据根据结果进行相应的处理
                    if(result.length!=0){
                        var html = '<table class="table table-bordered table-hover">';
                        html += '<caption class="t_center">expect info</caption>';
                        html += '<thead>';
                        html += '<tr>';
                        html += '<th>数据编号</th>';
                        html += '<th>势能</th>';
                        html += '<th>涨跌趋势</th>';
                        html += '<th>高点价格</th>';
                        html += '<th>低点价格</th>';
                        html += '<th>预期价格</th>';
                        html += '<th>止损价格</th>';
                        html += '<th>实际价格</th>';
                        html += '<th>公式编号</th>';
                        html += '<th>创建时间</th>';
                        html += '</tr>';
                        html += '</thead>';
                        html += '<tbody>';
                        for(var i=0;i<result.length;i++){
                            html += '<tr code='+result[i].id+'>';
                            html += '<td>'+result[i].id+'</td> ';
                            html += '<td>'+result[i].enough+'</td> ';
                            html += '<td>'+result[i].trend+'</td>';
                            html += '<td>'+result[i].highPrice+'</td>';
                            html += '<td>'+result[i].lowPrice+'</td>';
                            html += '<td>'+result[i].expectPrice+'</td>';
                            html += '<td>'+result[i].stopPrice+'</td>';
                            html += '<td>'+result[i].actualPrice+'</td>';
                            html += '<td>'+result[i].formulaCode+'</td>';
                            html += '<td>'+result[i].createTime+'</td>';
                            html += '</tr> ';
                        }
                        html += '</tbody>';
                        html += '</table>';
                        $("#operationGrid").html($(html));
                        dataGrid_expect.onBind();
                    }else{
                        var html = '<div class="t_center marTop20">暂无数据<div>';
                        $("#operationGrid").html($(html));
                    }
                }
            });
        },
        //重新加载数据
        reloadData:function(){

        },
        //绑定点击事件
        onBind:function(){
            $("#operationGrid table tbody tr").unbind();
            $("#operationGrid table tbody tr td").unbind();;
            $("#operationGrid table tbody").on("click","tr",function(event){dataGrid_operation.trClick(this);});
            $("#operationGrid table tbody tr").on("click","td",function(event){dataGrid_operation.tdClick(this);});
        },
        //点击表格tr触发
        trClick:function(element){
        },
        //点击表格td触发
        tdClick:function(element){
        }

    };
    window.dataGrid_shares.initData();
    //绑定按钮点击事件
    bind();
    function bind(){
        $("#addSharesBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","addSharesPage.do");
        });
        $("#updateSharesBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","updateSharesPage.do");
        });
        $("#deleteSharesBtn").click(function(){

        });
        $("#addExpectBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","addExpectPage.do");
        });
        $("#updateExpectBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","updateExpectPage.do");
        });
        $("#deleteExpectBtn").click(function(){

        });
        $("#addOperatorBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","addOperatorPage.do");
        });
        $("#updateOperatorBtn").click(function(){
            $("#childPage").parent().show();
            $("#childPage").attr("src","updateOperatorPage.do");
        });
        $("#deleteOperatorBtn").click(function(){

        });
    }
});

function childPage(){
    $("#childPage").parent().hide();
}