/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-8-10
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
$(function(){
    window.MY$ = {
        //项目导航栏
        magic_main_nav:{
            targetId:'pageBody',
            nodeObj: null,
            hideNav:function(){  //隐藏项目菜单
                $("#"+this.targetId).css({'left': '0px'});
            },
            showNav:function(){  //显示项目菜单
                $("#"+this.targetId).css({'left': '100px'});
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
                this.load_magic_main_section($(proNode));
            },
            initPage:function(){

            },
            //构建一级菜单按钮
            initNavMenu:function(){
                $.ajax({
                    url:"http://localhost:8080/main/getOneMenus.do",
                    type:"POST",
                    async:false,
                    data:{ level:1},
                    dataType:"json",
                    success:function(data){
                        if(data.length>0){
                            var oneMenuNav = $("#oneMenuNav");
                            //构建一级菜单节点
                            for(var i=0;i<data.length;i++){
                                var ss = $('<div class="magic_main_pro_btn magic_main_pro_icon '+data[i].icon+'" code="'+data[i].id+'" title="'+data[i].name+'" onclick="MY$.magic_main_nav.selectProBtn(this)"></div>');
                               oneMenuNav.append(ss);
                            }
                            //设置默认选中节点
                            MY$.magic_main_nav.selectProBtn($(".magic_main_pro_btn[code='1']"));
                        }
                    }
                });
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
                 var proMenuCode  = proNode.attr('code');
                 var proPage = $(".magic_main_section_nav[parentCode='"+proMenuCode+"']");
                //存在 直接显示
                if(proPage.length>0){
                    var sections =  $("#onePage .magic_main_section_nav");
                     for(var i = 0;i<sections.length;i++){
                        $(sections[i]).removeClass("select_index");
                     }
                     var section = $("#onePage .magic_main_section_nav[parentCode="+proMenuCode+"]");
                     $(section).addClass("select_index");
                // 不存在 先创建
                }else{
                    //清空一级菜单选中状态
                    var sections =  $("#onePage .magic_main_section_nav")
                    MY$.util.resetHideNode(sections);
                    this.buildOnePage(proMenuCode);
                }
            },
            //构建一级页面
            buildOnePage:function(oneMenuCode){
                var info;
                //获取动态数据
                $.ajax({
                    type : "post",
                    url : "http://localhost:8080/main/getOnePageInfo.do",
                    data : {id:oneMenuCode},
                    async : false,//取消异步
                    success : function(data){
                        info = data;
                    }
                });
                var menu = info.menu;
                var childMenus = info.childMenu;
                //构建页面节点
                var html = '<div class="magic_main_section_nav select_index" parentCode="'+menu.id+'">';
                html += '<div class="onePageHeader">';
                html += '<div class="logo" onclick="MY$.magic_main_nav.showNav()">'
                html += '<div class="'+menu.icon+'" title="'+menu.name+'"></div> '
                html += '</div>'
                html += '<ul>'
                for(var i=0;i<childMenus.length;i++){
                    html += '<li><a href="javaScript:void(0);" menuCode="'+childMenus[i].id+'" parentCode="'+childMenus[i].parentId+'" level="'+childMenus[i].level+'" onclick="MY$.magic_OneLevel_nav.selectOneLevelMenu(this);">'+childMenus[i].name+'</a></li>'
                }
                html += '</ul>'
                html += '</div>';
                html += '<div class="onePageBody">';
                html += '</div>';
                html += '</div>';
                $("#onePage #pro_section_shade").before($(html));
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
                var menu = $(".twoPage[parentCode="+menuCode+"]");
                var menus = $(".twoPage");
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
                var parentCode = $(node).attr("parentCode");
                //获取子级菜单
                var childMenus = this.getChildMenus(menuCode);
                var htmlTarget = $(".magic_main_section_nav[parentCode="+parentCode+"] .onePageBody");
                var htmlStr = "";
                htmlStr += '<div class="twoPage select_index" parentCode="'+menuCode+'">';
                    htmlStr += '<div class="twoPageHeader">';
                        htmlStr += '<ul>';
                        if(childMenus){
                            for(var i=0;i<childMenus.length;i++){
                                htmlStr += '<a href="javaScript:void(0);" menuCode="'+childMenus[i].id+'" action="'+childMenus[i].url+'" parentMenuCode="'+menuCode+'" level="'+childMenus[i].level+'" onclick="MY$.magic_TwoLevel_nav.selectTwoLevelMenu(this);"><li>'+childMenus[i].name+'</li></a>';
                            }
                        }
                        htmlStr += '</ul>';
                    htmlStr += '</div>';
                    htmlStr += '<div class="twoPageBody">';
                    htmlStr += '</div>';
                htmlStr += '</div>';
                htmlTarget.append($(htmlStr));
            },
            /**
             * 获取子级菜单集合
             * @param menuCode  父级菜单id
             * @returns {Array}子级菜单集合
             */
            getChildMenus:function(menuCode){
                var childMenus;
                $.ajax({
                    url:"http://localhost:8080/main/getChildMenus.do",
                    type:"POST",
                    async:false,
                    data:{parentId:menuCode},
                    dataType:"json",
                    success:function(data){
                        if(data.length>0){
                            childMenus = data;
                        }
                    }
                });
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
                var parentMenuCode = $(node).attr("parentMenuCode");
                var menu = $(".twoPage[parentCode="+parentMenuCode+"] .twoPageBody .menu_page[parentCode="+menuCode+"]");
                var menus = $(".twoPage .twoPageBody .menu_page");
                if(menu.length > 0){
                    //存在
                    MY$.util.resetHideNode(menus);
                    this.showTwoLevelMenu(menu);
                }else{
                    //不存在
                    MY$.util.resetHideNode(menus);
                    this.createContextPage(node);
                }
            },
            showTwoLevelMenu:function(node){
                //选中菜单的子级菜单显示
                node.addClass("select_index");
            },
            createContextPage:function(node){
                var menuCode = $(node).attr("menuCode");
                var parentMenuCode = $(node).attr("parentMenuCode");
                var action = $(node).attr("action");
                var htmlStr = "";
                htmlStr += '<div class="menu_page select_index" parentCode="'+menuCode+'">';
                htmlStr +=  '<iframe frameborder=0 width="100%" height="100%" marginheight=0 marginwidth=0 scrolling="auto" src="'+action+'"></iframe>'
                htmlStr += '</div>';
                $(".twoPage[parentCode="+parentMenuCode+"] .twoPageBody").append(htmlStr);
            }
        },
        util:{
            resetHideNode:function(nodes){
                for(var i = 0;i<nodes.length;i++){
                    $(nodes[i]).removeClass("select_index");
                }
            },
            sendAjax:function(){

            }
        }

    }
    MY$.magic_main_nav.initNavMenu();
});