<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
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
	<title></title>
	<link rel="stylesheet" href="${basepath}/css/login.css"/>
</head>

<body class="main">

<div id="mainBody">
	<div id="cloud1" class="cloud"></div>
	<div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
	<span>欢迎登录金属管理系统</span>
	<ul>
		<%--<li><a href="/">回首页</a></li>--%>
	</ul>
</div>

<div class="loginbody">

	<span class="systemlogo"></span>

	<div class="loginbox">
		<DIV style="width:165px; height:96px; position:absolute;top:8px;left:-70px">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>

		<form action="${basepath}/login/userLogin.htm" method="post">
			<ul>
				<li><input name="username" type="text" class="loginuser ipt" placeholder="请输入用户名/手机号码" value="admin" /></li>
				<li><input name="password" type="password" id="password" class="loginpwd ipt" placeholder="请输入密码" value="admin" /></li>
				<li><input type="submit" class="loginbtn" value="登录"  /></li>
			</ul>
		</form>
	</div>

</div>

<div class="loginbm">版权所有 2015-2018 <%--<a href="http://www.dz580.com">Www.Dz580.com</a> 定制我帮您，玩转厨房。--%></div>
<script type="text/javascript" src="${basepath}/js/cloud.js"></script>
<script type="text/javascript">
    $(function(){
        $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        $(window).resize(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        })
    });
</script>
<script type="text/javascript">
    $(function(){
        //得到焦点
        $("#password").focus(function(){
            $("#left_hand").animate({
                left: "150",
                top: " -38"
            },{step: function(){
                    if(parseInt($("#left_hand").css("left"))>140){
                        $("#left_hand").attr("class","left_hand");
                    }
                }}, 2000);
            $("#right_hand").animate({
                right: "-64",
                top: "-38px"
            },{step: function(){
                    if(parseInt($("#right_hand").css("right"))> -70){
                        $("#right_hand").attr("class","right_hand");
                    }
                }}, 2000);
        });
        //失去焦点
        $("#password").blur(function(){
            $("#left_hand").attr("class","initial_left_hand");
            $("#left_hand").attr("style","left:100px;top:-12px;");
            $("#right_hand").attr("class","initial_right_hand");
            $("#right_hand").attr("style","right:-112px;top:-12px");
        });
        $//提示
        var message = '${message}';
        if(message!=''){
            setTimeout(function(){
                alert(message);
			}, 500 );
        }
    });
</script>
</body>
</html>
