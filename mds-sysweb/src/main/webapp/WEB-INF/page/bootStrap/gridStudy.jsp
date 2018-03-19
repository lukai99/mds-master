<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-5-26
  Time: 上午7:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<html>
<head>
    <%--<link type="text/css" rel="stylesheet" href="/library/bootstrap/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>

    <%--<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>  &lt;%&ndash;引入js标签库&ndash;%&gt;--%>
    <%--<script src="/library/bootstrap/js/bootstrap.min.js"></script>--%>
    <jsp:include page="/common/publicTop.jsp"/>
    <title>网格系统</title>
</head>
<body>
<div class="container">
    <div class="row" >
        <div class="col-xs-6 col-sm-3"
             style="background-color: #dedef8;
            box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
        </div>
        <div class="col-xs-6 col-sm-3"
             style="background-color: #dedef8;box-shadow:
        inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim veniam, quis nostrud exercitation ullamco laboris
                nisi ut aliquip ex ea commodo consequat.
            </p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut.
            </p>
        </div>

        <div class="clearfix visible-xs"></div>

        <div class="col-xs-6 col-sm-3"
             style="background-color: #dedef8;
        box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
                laboris nisi ut aliquip ex ea commodo consequat.
            </p>
        </div>
        <div class="col-xs-6 col-sm-3"
             style="background-color: #dedef8;box-shadow:
        inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim
            </p>
        </div>
    </div>
</div>
<h2>基本网格结构</h2>
<div class="container">
    <div class="row">
         <div class="col-lg-1" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
             col-lg-1
         </div>
        <div class="col-lg-1" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-1
        </div>
        <div class="col-lg-1" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-1
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-2" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-2
        </div>
        <div class="col-lg-2" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-2
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-3
        </div>
        <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-3
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-4
        </div>
        <div class="col-lg-4" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-4
        </div>
    </div>
</div><div class="container">
    <div class="row">
        <div class="col-lg-5" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-5
        </div>
        <div class="col-lg-5" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-5
        </div>
    </div>
</div><div class="container">
    <div class="row">
        <div class="col-lg-6" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-6
        </div>
        <div class="col-lg-6" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-6
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-7" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-7
        </div>
        <div class="col-lg-7" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-7
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-8" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-8
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-9" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-9
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-10" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-10
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-11" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-11
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-12" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-12
        </div>
    </div>
</div>
<h2>响应式的列重置</h2>
??????

<h2>偏移列</h2>
<div class="container">
    <div class="row">
        <div class="col-lg-2 col-lg-offset-11" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            col-lg-2 col-lg-offset-11
            偏移列
        </div>
    </div>
</div>
<h2>嵌套列</h2>
<div class="container">
    <div class="row">
        <div class="col-lg-4" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            第一列
            <p>子列中的col-lg-*是相对于父列表的比例</p>
        </div>
        <div class="col-lg-4" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            第二列 包含4个子列
            <div class="row">
                <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    子1列     col-lg-3
                </div>
                <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    子2列     col-lg-3
                </div>
                <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    子3列     col-lg-3
                </div>
                <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    子4列     col-lg-3
                </div>
            </div>
        </div>
    </div>
</div>
<h2>列排序</h2>
<div class="container">
    <div class="row">
        <p>排序前</p>
        <div class="col-lg-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            1
        </div>
        <div class="col-lg-6" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            2
        </div>
    </div>
    <div class="row">
        <p>排序后</p>
        <div class="col-lg-3 col-lg-push-6" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            1
        </div>
        <div class="col-lg-6 col-lg-pull-3" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
            2
        </div>
    </div>
    <div class="row">
        <p>排序实际上是使用left right 偏移实现的
        .col-lg-push-6 {
            left: 50%;
        }
        .col-lg-pull-3 {
        right: 25%;
        }</p>
    </div>
</div>


</body>
</html>