/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-24
 * Time: 下午19:52
 * To change this template use File | Settings | File Templates.
 */
$(function(){
    bind();//按钮事件绑定

    function bind(){
        $("#saveBtn").click(function(){
           $.ajax({
                type:"post",
                url:"operatorExpect.do",
                data:$("#operatorExpectForm").serialize(),
                success:function(result){
                    alert("保存成功");
                },
                error:function(){
                    alert("操作异常，请联系管理员。");
                }
            });
        });
        $("#closeBtn").click(function(){
           parent.childPage();
        });
        $("#enough").change(function(){
            createExpectPrice();
        });
        $("#trend").change(function(){
            createExpectPrice();
        });
        $("#highPrice").change(function(){
            createExpectPrice();
        });
        $("#lowPrice").change(function(){
            createExpectPrice();
        });
        $("#sharesCode").change(function(){
            createExpectPrice();
        });
    }
    //计算预期价格 和 止损价格
    function createExpectPrice(){
        var enough = $("#enough").val();
        var trend = $("#trend").val();
        var highPrice = $("#highPrice").val();
        var lowPrice = $("#lowPrice").val();
        var sharesCode = $("#sharesCode").val();
        if(highPrice!=""&&lowPrice!=""&&sharesCode!=""&&enough!=""&&trend!=""){
            $.ajax({
                type:"post",
                url:"createExpectPrice.do",
                data:{
                    highPrice:highPrice,
                    lowPrice:lowPrice,
                    sharesCode:sharesCode,
                    enough:enough,
                    trend:trend
                },
                success:function(result){
                    $("#expectPrice").val(result.data.expectPrice);
                    $("#stopPrice").val(result.data.stopPrice);
                },
                error:function(){
                    alert("操作异常，请联系管理员。");
                }
            });
        }
    }
});