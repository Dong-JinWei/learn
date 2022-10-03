<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OA办公系统</title>
    <!-- 皮肤样式-->
    <link rel="stylesheet" type="text/css" href="jeasyui/themes/bootstrap/easyui.css">
    <!-- 图片样式-->
    <link rel="stylesheet" type="text/css" href="jeasyui/themes/icon.css">
    <!-- jquery环境-->
    <script src="jeasyui/jquery.min.js"></script>
    <!-- easyui的js环境-->
    <script src="jeasyui/jquery.easyui.min.js"></script>
    <!-- 汉化js-->
    <script src="jeasyui/easyui-lang-zh_CN.js"></script>
    <script>
        function openTabs(url,text) {
            if($("#tabs").tabs('exists',text)){
                $("#tabs").tabs('select',text);
            }else{
                let myContext = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' " +
                    " src="+url+"></iframe>"
                $('#tabs').tabs('add',{
                    title: text,
                    closable:true,
                    content:myContext
                });
            }
        }

    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'OA办公系统',split:true" style="height:120px;"></div>
<div data-options="region:'west',title:'导航菜单',split:true" style="width:150px;">

    <div class="easyui-accordion" fit="true">
        <div title="系统信息管理">
            <a href="#" class="easyui-linkbutton"
               plain="true" style="width:100%" onclick="openTabs('html/user.html','用户信息管理')">用户信息管理</a>
            <a href="#" class="easyui-linkbutton"
               plain="true" style="width:100%" onclick="openTabs('html/logs.html','日志信息管理')">日志信息管理</a>
        </div>
    </div>



</div>
<div data-options="region:'center',title:'显示'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" fit="true">
        <div title="首页">
            欢迎使用OA办公管理系统
        </div>
    </div>
</div>
<%--数据显示--%>
<table id="dg"></table>

</body>
</html>
