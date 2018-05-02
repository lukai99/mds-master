<!DOCTYPE html>
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
<html>
<head>
    <jsp:include page="${basepath}/common/publicTop.jsp"/>
    <title>fly的魔幻城堡</title>
    <link rel="stylesheet" href="${basepath}/css/base.css"/>
    <link rel="stylesheet" href="${basepath}/css/util.css"/>
    <link rel="stylesheet" href="${basepath}/css/main/main.css"/>

    <script type="text/javascript" src="${basepath}/js/main/main.js"></script>
</head>
<body>
<div style="overflow: hidden;width: 100%;height: 100%;">
    <div id="pageBody" class="my_pageBody move_left">
        <div id="oneMenuNav" class="pageLeftBody">

        </div>
        <div id="onePage" class="pageRightBody">


           <%-- <div class="magic_main_section_nav select_index" sectioncode="1">
                <div class="onePageHeader">
                    <div class="logo" onclick="MY$.magic_main_nav.showNav()">
                        <div class="study_icon" title="学习"></div>
                    </div>
                    <ul>
                        <li><a href="javaScript:void(0);" menuCode="001" level="2" onclick="MY$.magic_OneLevel_nav.selectOneLevelMenu(this);">历史</a></li>
                        <li><a href="javaScript:void(0);" menuCode="002" level="2" onclick="MY$.magic_OneLevel_nav.selectOneLevelMenu(this);">java</a></li>
                        <li><a href="javaScript:void(0);" menuCode="003" level="2" onclick="MY$.magic_OneLevel_nav.selectOneLevelMenu(this);">javaScript</a></li>
                        <li><a href="javaScript:void(0);" menuCode="004" level="2" onclick="MY$.magic_OneLevel_nav.selectOneLevelMenu(this);">war3</a></li>
                    </ul>
                </div>
                <div class="onePageBody">
                    <div class="twoPage select_index" forMenuCode="001">
                        <div class="twoPageHeader">
                            <ul>
                                <li><a href="javaScript:void(0);" menuCode="001" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-1</a></li>
                                <li><a href="javaScript:void(0);" menuCode="002" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-2</a></li>
                                <li><a href="javaScript:void(0);" menuCode="003" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-3</a></li>
                            </ul>
                        </div>
                        <div class="twoPageBody">
                            <div class="menu_page select_index" forCode="001">
                                菜单1 内容
                            </div>
                            <div class="menu_page" forCode="002">
                                菜单2 内容
                            </div>

                        </div>
                    </div>
                </div>
            </div>--%>


            <%--遮罩层--%>
            <div id="pro_section_shade" class="magic_main_section_shade " onclick="MY$.magic_main_nav.clickProShade()"></div>
        </div>
    </div>
</div>
</body>
</html>
