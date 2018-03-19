<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<html>
<head>
    <jsp:include page="/common/publicTop.jsp"/>
    <title>fly的魔幻城堡</title>
    <link rel="stylesheet" href="/css/base.css"/>
    <link rel="stylesheet" href="/css/util.css"/>
    <style type="text/css">
        body{min-width: 1000px;}
        body a:hover, a:visited, a:link, a:active {color:#1b9bdd;}
        .float_left{float: left;}
        .mar_left{margin-left: 0px;transition:margin-left 0.2s,transform 0.2s;}
        .my_pageBody{ width: 100%;overflow: hidden; }
        .magic_main_nav{width:100px;height:100%;position: relative; margin-left: -100px;}/*项目导航菜单*/
        .select_op{opacity: 1 !important;}
        .magic_main_pro_icon{transition: opacity 1s,transform 0.2s;cursor:pointer;margin: 10px auto;opacity: 0.1;transform: scale(0.5, 0.5);}
        .magic_main_pro_icon:hover{cursor:pointer;margin: 10px auto;transform: scale(0.7, 0.7);opacity: 1;/* box-shadow: 8px 12px 8px;*/}
        .magic_main_section{width: 100%;height:100%; position: relative;}/*项目主页*/
        .magic_main_section_div{position: relative;height: 100%;}
        .magic_main_section_div .section_title{height: 64px;}
        .magic_main_section_div .section_body{height: 100%;}
        .magic_main_section_div .section_body .magic_menu_page{width: 100%;height: 100%;position: absolute;background-color: #c7bfa9;}
        .magic_main_section_div .section_body .magic_menu_page .menu_tab_page{height: 100%;width: 100%;position: relative;}
        .magic_main_section_div .section_body .magic_menu_page .menu_tab_page .menu_page{height: 100%;width: 100%;position: absolute;background-color: #c5ad6b;}
        .magic_main_section_div .section_body .magic_menu_page .magic_menu {height: 30px;}
        .magic_main_section_div .section_body .magic_menu_page ul{width: 100%;height: 100%;padding-left: 25px;}
        .magic_main_section_div .section_body .magic_menu_page ul li{float: left;margin:0 10px;line-height: 30px;}
        .magic_main_section_shade{position:absolute;width:100%;height:100%;background-color: #ffffff;top:0px;left:0px;opacity:0.9;z-index: 999} /*项目主页 遮罩*/
        .magic_main_section_nav{height: 64px;background-color: #ffffff;position: absolute;width: 100%;}
        .magic_main_section_nav ul{float: right;height: 64px;margin-right: 50px;font-size: 20px;}
        .magic_main_section_nav ul li{display: inline;margin: auto  30px;line-height:64px;}
        .magic_main_section_nav ul li a{text-decoration:none;}
        .logo{width: 64px;height: 64px;cursor:pointer;margin-left: 20px;float: left;}
    </style>
    <script>
        $(function(){
            window.MY$ = {
                //项目导航栏
                magic_main_nav:{
                    targetId:'pro_nav',
                    nodeObj: null,
                    hideNav:function(){  //隐藏项目菜单
                       // $("#"+this.targetId).removeClass("mar_left")
                        $("#"+this.targetId).css({'margin-left': '0px'});
                    },
                    showNav:function(){  //显示项目菜单
                      //  $("#"+this.targetId).addClass("mar_left");
                        $("#"+this.targetId).css({'margin-left': '100px'});
                        this.proShadeShow();
                    },
                    reverseNav:function(){//切换项目菜单显示隐藏状态
                        var nodeClass =$("#"+this.targetId).attr('class');
                        if(nodeClass.indexOf("mar_left") >= 0){
                            this.hideNav();
                        }else{
                            this.showNav();
                        }
                    },
                    proShadeShow:function(){    //显示项目主页面遮罩
                        $("#pro_section_shade").removeClass("hidden");
                    },
                    proShadeHide:function(){  //隐藏项目主页面遮罩
                        $("#pro_section_shade").addClass("hidden");
                    },
                    clickProShade:function(){  //点击项目主页面遮罩
                        this.hideNav();
                        this.proShadeHide();
                    },
                    selectProBtn:function(proNode){  //选中项目菜单
                        /*思路
                        * 1.隐藏遮罩
                        * 2.收缩项目菜单
                        * 3.设置select属性 修改选中图标
                        *     清空所有按钮的选中状态
                        *     初始化按钮图标（全部透明）
                        *     设置选中按钮状态及图标
                        * 4.加载项目内容面板
                        * */
                       this.hideNav();
                       this.proShadeHide();
                       var proBtns = $(".magic_main_pro_btn");
                       for(var i = 0;i<proBtns.length;i++){
                           $(proBtns[i]).removeAttr("select_op");
                           $(proBtns[i]).removeClass("select_op");
                       }
                       $(proNode).attr("select_op","");
                       $(proNode).addClass("select_op");
                       this.load_magic_main_section(proNode);
                    },
                    initPage:function(){

                    },
                    load_magic_main_section:function(proNode){
                        /*思路：
                        * 判断项目内容面板是否已经存在
                        * 1.不存在
                        *    1.创建新菜单层
                        *    2.加载logo图片
                        *    3.加载菜单信息
                        * 2.存在直接显示
                        * */
                        /*初始化层号*/
                        var sections =  $(".magic_main_section_div .magic_main_section_nav");
                        for(var i = 0;i<sections.length;i++){
                            $(sections[i]).removeClass("select_index");
                        }
                        var code = $(proNode).attr("navcode");
                        var section = $(".magic_main_section_div .magic_main_section_nav[sectioncode="+code+"]");
                        $(section).addClass("select_index");
                    }

                },
                magic_OneLevel_nav:{
                    //思路：
                    /**
                     *  1 选中一级菜单
                     *  2 显示相应的子级二级菜单
                     *  2.1 如果子级二级菜单dom存在则直接显示
                     *  2.2 如果dom不存在则创建
                    */
                    /**
                    * 选中一级菜单
                    * @param node 父级菜单节点
                    */
                    selectOneLevelMenu:function(node){
                        var menuCode = $(node).attr("menuCode");
                        var menu = $(".magic_menu_page[forMenuCode="+menuCode+"]");
                        var menus = $(".magic_menu_page");
                        if(menu.length>0){
                            //存在 直接设置成展示
                            //重置所有二级菜单页面的显示级别
                            MY$.util.resetHideNode(menus);
                            this.showTwoLevelMenu(menu);
                        }else{
                            //不存在 创建node
                            //重置所有二级菜单页面的显示级别
                            MY$.util.resetHideNode(menus);
                            this.createTwoLevelMenu($(node));
                        }
                    },
                    /**
                    *  显示二级菜单
                    * @param node要显示的二级菜单
                    */
                    showTwoLevelMenu:function(node){
                        //选中菜单的子级菜单显示
                        node.addClass("select_index");
                    },
                    /**
                    * 创建项目菜单
                    * @param node 父级菜单节点
                    */
                    createTwoLevelMenu:function(node){
                        var menuCode = $(node).attr("menuCode");
                        //获取子级菜单
                        var childMenus = this.getChildMenus(node);
                        var htmlTarget = $("#magicOpPageBody");
                        var htmlStr = "";
                        htmlStr += '<div class="magic_menu_page select_index" forMenuCode="'+menuCode+'">';
                        htmlStr += '<div class="magic_menu">';
                        htmlStr += '<ul>';
                        for(var i=0;i<childMenus.length;i++){
                            htmlStr += '<a  href="javaScript:void(0);" menuCode="'+childMenus[i].code+'" parentMenuCode="'+menuCode+'" level="'+childMenus[i].level+'" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);"><li>'+childMenus[i].name+'</li></a>';
                        }
                        htmlStr += '</ul>';
                        htmlStr += '</div>';
                        htmlStr += '<div class="menu_tab_page" formenucode="'+menuCode+'">';
                        htmlStr += '</div>';
                        htmlStr += '</div>';
                        htmlTarget.append($(htmlStr));
                    },
                    /**
                    * 获取子级菜单集合
                    * @param node  父级菜单节点
                    * @returns {Array}子级菜单集合
                    */
                    getChildMenus:function(node){
                        var childMenus = [
                            {code:"004001",level:"3",name:"菜单004-1"},
                            {code:"004002",level:"3",name:"菜单004-2"},
                            {code:"004003",level:"3",name:"菜单004-3"}
                        ]
                        return childMenus;
                    }
                },
                magic_TwoLevel_nav:{
                    //思路：
                    // 1. 选中一级菜单
                    // 2. 判断菜单对应的模块页面dom是否存在
                    // 2.1 存在 显示功能模块主页面
                    // 2.2 不存在 创捷dom 并显示
                    /**
                    * 选中二级菜单
                    * @param node
                    */
                    selectTwoLevelMenu:function(node){
                        var menuCode = $(node).attr("menuCode");
                        var menu = $(".menu_tab_page .menu_page[forCode="+menuCode+"]");
                        var menus = $(".menu_tab_page .menu_page");
                        if(menu.length > 0){
                            //存在
                            alert("存在");
                            MY$.util.resetHideNode(menus);
                            this.showTwoLevelMenu(menu);
                        }else{
                            //不存在
                            alert("不存在");
                            MY$.util.resetHideNode(menus);
                            this.createContextPage(node);
                        }
                    },
                    showTwoLevelMenu:function(node){
                        //选中菜单的子级菜单显示
                        node.addClass("select_index");
                    },
                    createContextPage:function(node){
//                        <div class="menu_page" forCode="003">
//                                菜单3 内容
//                        </div>
                        var menuCode = $(node).attr("menuCode");
                        var parentMenuCode = $(node).attr("parentMenuCode");
                        var htmlStr = "";
                        htmlStr += '<div class="menu_page select_index" forCode="'+menuCode+'">';
                        htmlStr += ''+menuCode+'';
                        htmlStr += '</div>';
                        $(".menu_tab_page[forMenuCode="+parentMenuCode+"]").append(htmlStr);
                    }
                },
                util:{
                    resetHideNode:function(nodes){
                        for(var i = 0;i<nodes.length;i++){
                            $(nodes[i]).removeClass("select_index");
                        }
                    }
                }

            }
         //   MY$.magic_main_nav.hideNav();
        });
    </script>
</head>
<body>
<div class="my_pageBody">
    <div id="pro_nav" class="mar_left" style="width:auto;height:759px;position: relative;background-color: #D9C666;">
        <div id="magicProMenu" class="magic_main_nav float_left" style="background-color: #dedcdd">
            <div class="magic_main_pro_btn magic_main_pro_icon study_icon select_op" navcode="1" title="学习" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>
            <div class="magic_main_pro_btn magic_main_pro_icon game_icon" navcode="2" title="游戏" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>
            <div class="magic_main_pro_btn magic_main_pro_icon lottery_icon" navcode="3" title="彩票" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>
            <div class="magic_main_pro_btn magic_main_pro_icon photo_icon" navcode="4" title="照片" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>
            <div class="magic_main_pro_btn magic_main_pro_icon other_icon" navcode="5" title="其他" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>
        </div>
        <div id="magicProPageBody" class="magic_main_section float_left" style="background-color: #BBE8F2;">
            <div class="magic_main_section_div">
                <div id="magicOpMenu" class="section_title">
                    <div class="magic_main_section_nav select_index" sectioncode="1">
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
                    <div class="magic_main_section_nav" sectioncode="2">
                        <div class="logo" onclick="MY$.magic_main_nav.showNav()">
                            <div class="game_icon" title="游戏"></div>
                        </div>
                    </div>
                    <div class="magic_main_section_nav" sectioncode="3">
                        <div class="logo" onclick="MY$.magic_main_nav.showNav()">
                            <div class="lottery_icon" title="彩票"></div>
                        </div>
                    </div>
                    <div class="magic_main_section_nav" sectioncode="4">
                        <div class="logo" onclick="MY$.magic_main_nav.showNav()">
                            <div class="photo_icon" title="照片"></div>
                        </div>
                    </div>
                    <div class="magic_main_section_nav" sectioncode="5">
                        <div class="logo" onclick="MY$.magic_main_nav.showNav()">
                            <div class="other_icon" title="其他"></div>
                        </div>
                    </div>
                </div>
                <div id="magicOpPageBody" class="section_body position_r">
                    <div class="magic_menu_page select_index" forMenuCode="001">
                        <div class="magic_menu">
                            <ul>
                                <li><a href="javaScript:void(0);" menuCode="001" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-1</a></li>
                                <li><a href="javaScript:void(0);" menuCode="002" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-2</a></li>
                                <li><a href="javaScript:void(0);" menuCode="003" level="3" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);">菜单001-3</a></li>
                            </ul>
                        </div>
                        <div class="menu_tab_page">
                            <div class="menu_page select_index" forCode="001">
                              菜单1 内容
                            </div>
                            <div class="menu_page" forCode="002">
                                菜单2 内容
                            </div>

                        </div>
                    </div>
                    <div class="magic_menu_page" forMenuCode="002">
                        <div class="magic_menu">
                            <ul>
                                <a><li>菜单002-1</li></a>
                                <a><li>菜单002-2</li></a>
                                <a><li>菜单002-3</li></a>
                            </ul>
                        </div>
                        <div class="menu_tab_page">
                            <div class="menu_page select_index">
                                菜单1 内容
                            </div>
                            <div class="menu_page">
                                菜单2 内容
                            </div>
                            <div class="menu_page">
                                菜单3 内容
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--遮罩层--%>
            <div id="pro_section_shade" class="magic_main_section_shade hidden" onclick="MY$.magic_main_nav.clickProShade()"></div>
        </div>
    </div>
</div>
<%--<header>
    <nav class="nav navbar-default" role="navigation">
        <div class="nav">
            <div class="navbar-header col-lg-offset-1">
                <a class="navbar-brand">fly的魔幻城堡</a>
            </div>
            <div class="col-lg-offset-8">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/bootStrap/toBootStrapMainPage.htm">study</a></li>
                    <li><a href="/userManager/toUserManagerPage.htm">other</a></li>
                    <li><a href="javaScrpt:void(0);">game</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<section &lt;%&ndash;style="width: 4560px;"&ndash;%&gt;>
    <div style="width: 1520px;height:608px;overflow: hidden;">
        <div style="width:4560px;">
            <div class="float" style="width:1520px;height:608px;background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">

            </div>
            <div class="float" style="width:1520px;height:608px;background-color: #BBE8F2; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">

            </div>
            <div class="float" style="width:1520px;height:608px;background-color: #D9C666; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">

            </div>
            <br/>
        </div>
    </div>
</section>
<footer>
    <div style="width:100%;height:100px;background-color: #D9C666; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;"></div>
</footer>--%>
</body>
</html>
