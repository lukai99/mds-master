<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-12-12
  Time: 下午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>魔幻城堡</title>
    <link rel="shortcut icon" href="/library/cfda.ico">
    <link href="/library/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/library/font_awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/library/animate/animate.min.css" rel="stylesheet">
    <script src="/library/sweetalert/js/sweetalert.min.js"></script>
    <link href="/library/sweetalert/css/sweetalert.css" rel="stylesheet">
    <link href="/library/public/css/style.min.css?v=1.0.0" rel="stylesheet">
    <link href="/library/public/css/public.css?v=1.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg skin-1" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element" style="text-align: left;">
                    <span>
                        <img alt="image" class="img-circle" src="/images/cfdaLogo.png"  />
                    </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">
						<span class="clear">
							<span class="block m-t-xs"><strong class="font-bold"></strong></span>
							<span class="text-muted text-xs block"></span>
						</span>
                        </a>
                    </div>
                </li>
                <%--<li class="baosongfenlei" >
                    <a href="javascript:;"><i class="fa fa-edit"></i>
                        <span class="nav-label">计划制定</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                        <li>
                            <a class="J_menuItem" href="http://www.baidu.com?v=1.1" data-index="5">管理计划制定</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/index.php?m=Admin&c=RuleSet&a=index" data-index="5">校验规则设置</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/index.php?m=Admin&c=ImportData&a=index" data-index="5">数据导入</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;"><i class="fa fa-flag"></i>
                        <span class="nav-label">计划部署</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                        <li><a class="J_menuItem" href="/index.php?m=Admin&c=Task&a=agency" data-index="1">机构任务</a>
                        </li>
                        <li><a class="J_menuItem" href="/index.php?m=Admin&c=Task&a=lower" data-index="2">下级任务</a>
                        </li>
                        <li><a class="J_menuItem" href="/index.php?m=Admin&c=Task&a=mytask" data-index="20">我的任务</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;"><i class="fa fa-tasks"></i>
                        <span class="nav-label">任务下达</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                        <li><a class="J_menuItem" href="/index.php?m=Admin&c=TaskDown&a=index" data-index="3">任务下达</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;"><i class="fa fa-folder"></i>
                        <span class="nav-label">任务列表</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                        <li>
                            <a href="javascript:;"><i class="fa fa-folder"></i>
                                <span class="nav-label">任务列表</span>
                                <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                                <li>
                                    <a class="J_menuItem" href="/index.php?m=Admin&c=TaskList&a=index" data-index="5">任务列表</a>
                                </li>
                                <li>
                                    <a class="J_menuItem" href="/index.php?m=Admin&c=TaskList&a=dellist" data-index="5">已删除列表</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/index.php?m=Admin&c=TaskList&a=dellist" data-index="5">已删除列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/index.php?m=Admin&c=Sample&a=whitelist" data-index="4">解除限制</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="/index.php?m=Admin&c=TaskList&a=checklist" data-index="5">数据查询</a>
                        </li>
                    </ul>
                </li>  --%>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row content-tabs">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javaScript:;" class="active J_menuTab" data-id="">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight" style="right: 225px;"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group  btn-user roll-nav roll-right" style="right: 150px;">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <div class="roll-nav roll-right changepassword">
                <a href="/index.php?m=Admin&c=Index&a=changePassword" class="J_menuItem">修改密码</a>
            </div>
            <div class="btn-user roll-nav roll-right">
                <button class="dropdown J_tabClose wrapRow" data-toggle="dropdown" title="${user.netname}">
                    <i class="fa fa-user" style="margin-right: 5px;"></i>
                    ${user.netname}<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabExit"><a href="/login/logout.do">退出</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row J_mainContent" id="content-main">
            <%--<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/index.php?m=Admin&c=Index&a=main" frameborder="0" data-id="" seamless></iframe>--%>
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="http://www.layui.com/doc/element/nav.html" frameborder="0" data-id="" seamless></iframe>
        </div>
        <%--<div class="footer">
            <div class="pull-right">&copy; 2016-2017
            </div>
        </div>--%>
    </div>
    <!--右侧部分结束-->
</div>
<%--<script src="/library/jquery/jquery-3.1.1.min.js"></script>--%>
<script src="/library/jquery/jquery.min.js"></script>
<script src="/library/bootstrap/js/bootstrap.min.js"></script>
<script src="/library/jquery-metisMenu/js/jquery.metisMenu.js"></script>
<script src="/library/jquery-slimscroll/js/jquery.slimscroll.min.js"></script>
<script src="/library/layer/js/layer.min.js"></script>
<script src="/library/public/js/hplus.min.js"></script>
<script type="text/javascript" src="/library/public/js/contabs.min.js"></script>
<script src="/library/pace/js/pace.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
    $(function() {
        mini_nav();
        initMenu();
        $('.J_tabExit').click(function () {
        });
        $("#side-menu li a").click(function(){
            mini_nav();
        });
    });
    $(window).on("resize",function(){
        mini_nav();
    });
    function mini_nav(){
        var wid = $("body").width();
        if(wid<820){
            $("body").addClass("mini-navbar");
        }
    }
    function buildMenuHtml(menuItem){
        var $li = $('<li></li>');
        if(menuItem.childList!=null&&menuItem.childList.length>0){
            var $a = $('<a href="javascript:;"><i class="fa '+menuItem.icon+'"></i><span class="nav-label">'+menuItem.name+'</span><span class="fa arrow"></span></a>');
            var $ul = $('<ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;"></ul>');
            for(var i = 0;i<menuItem.childList.length;i++){
                var $childLi = buildMenuHtml(menuItem.childList[i]);
                $ul.append($childLi);
            }
            $li.append($a).append($ul);
        }else{
            var $a = $('<a class="J_menuItem" href="'+menuItem.url+'" data-level="'+menuItem.level+'" data-index="'+menuItem.id+'">'+menuItem.name+'</li>');
            $li.append($a);
        }
        return $li;
    }
    function initMenu(){
        $.ajax({
            url: "/menu/getInitMenusData.do",
            dataType: 'json',
            success: function (result) {
                console.log(result);
                if(result.state && result.state==200){
                    if(result.dataList.length>0){
                        var $menuUl = $("#side-menu");
                        for(var i = 0;i<result.dataList.length;i++){
                            var $li = buildMenuHtml(result.dataList[i]);
                            $menuUl.append($li);
                        }
                        window.initBindEvent();//初始化绑定事件
                    }
                }else{
                    alert("初始化菜单失败");
                }
            }
        });
    }

</script>
</body>
</html>