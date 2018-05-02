<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
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
		<title>用户登录</title>
		<style>
			body{
				background: #FAFAFA;
			}
			.mydiv input.b{
				margin-top: 50px;
				height: 50px;
				width: 104%;
				border-radius: 25px;
				color: #898989;
				background: #DDDDDD;
				border:2px solid #fff;
				outline: none;
			}
			.mydiv input.b:hover{
				background-color: palegreen;
			}
			.mydiv{
				width:400px;
				height: 300px;
				margin:200px auto;
			}
			.mydiv input.t{
				width:100%;
				height:50px;
				border:1px solid #ddd;
				border-radius: 25px;
				padding-left: 15px;
				margin-top:40px;
				
			}
			.mydiv input.t:focus{
				border-color:#00BAFA;
				outline: none;
			}
			.mydiv input.t + label{
				margin-left: 20px;
				margin-top: -35px;
				height: 23px;
				display: block;
				background-color: #ddd;
				pointer-events: none;
				color:#CCCCCC;
			}
			.mydiv input.t + label:before{
				content: attr(alt);	
				transition-duration: .2s;			
			}
			.mydiv input.t:focus + label:before,
			.mydiv input.t:valid + label:before{
				content:attr(filed);
				display: inline-block;
				/*transition-duration: .2s;*/
				transform: translate(0,-33px);
				font-size: 20px;
				color:#00BAFA;
				background-image: linear-gradient(to bottom, #FAFAFA, #FAFAFA);
				background-size: 100% 10px;
			    background-repeat: no-repeat;
			    background-position: center;
			}
			.mydiv input.t:invalid + label:before{
				content:attr(alt);
			}
		</style>
	</head>
	<body>
        <c:if test="${not empty message}">
            提示：${message}
        </c:if>
		<div class="mydiv">
			<form action="${basepath}/login/userLogin.htm" method="post">
				<input class="t" type="text" name="username" required=""/>
				<label alt="请输入用户名" filed = "用户名"></label>
				<input class="t" type="password" name="password" required=""/>
				<label alt="请输入密码" filed = "密码"></label>
				<input class="b" type="submit" value="登录"/>
			</form>
		</div>
	</body>
</html>
