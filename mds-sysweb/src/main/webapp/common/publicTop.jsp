<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<%--<link rel="stylesheet" href="/css/init.css">
<link rel="stylesheet" href="/css/base.css">--%>
<link rel="stylesheet" href="/library/bootstrap/css/bootstrap.min.css">
<link href="/library/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="/library/bootstrap-table/css/bootstrap-table.css" rel="stylesheet" />

<script type="text/javascript" src="/library/jquery/jquery-3.1.1.min.js" charset="UTF-8"></script>  <%--引入js标签库--%>
<script type="text/javascript" src="/library/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="/library/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/library/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="/library/bootstrap-table/js/bootstrap-table.js" charset="UTF-8"></script>
<script type="text/javascript" src="/library/bootstrap-table/js/locale/bootstrap-table-zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="/library/jqueryEasyUi/jquery.easyui.min.js"></script>  <%--引入js标签库--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"
            +request.getServerName()+":"
            +request.getServerPort()+
            path;
%>