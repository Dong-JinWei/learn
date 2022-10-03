<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>用户信息管理</title>
    </head>
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
        $(function () {

            //批量删除
            $('#btn-remove').click(function () {
                let arr = $('#dg').datagrid("getSelections")
                if (arr.length == 0) {
                    $.messager.alert('消息', '请选择要删除的数据', 'error')
                } else {
                    let uids = [];
                    for (let i in arr) {
                        uids.push(arr[i].uid);
                    }
                    $.post('../user/batchRemove', {'uids[]': uids}, function (flag) {
                        if (flag) {
                            $.messager.alert('消息', '删除成功', 'info');
                            $('#dg').datagrid("load");
                        }
                    })
                }
            })

            /*数据修改*/
            $("#btn-edit").click(function () {
                let arr = $("#dg").datagrid('getSelections');
                if (arr.length == 0) {
                    $.messager.alert("消息", "请选择要修改的数据！", "error");
                } else if (arr.length > 1) {
                    $.messager.alert("消息", "请选择一条记录进行修改！", "error");
                } else {
                    //填充修改表单数据
                    $("#edit-form").form('load', {
                        uid: arr[0].uid,
                        uname: arr[0].uname,
                        password: arr[0].password,
                        nickName: arr[0].nickName,
                        images: arr[0].images
                    })
                    //弹出修改的对话框
                    $("#edit-dialog").dialog({
                        closed: false,
                        buttons: [{
                            text: "保存",
                            iconCls: "icon-save",
                            handler: function () {
                                $("#edit-form").form("submit", {
                                    url: "user/edit",
                                    onSubmit: function () {
                                        return $("#edit-form").form("validate");
                                    },
                                    success: function (flag) {
                                        if (flag) {
                                            //表格刷新
                                            $("#dg").datagrid("load");
                                            //关闭修改对话框
                                            $("#edit-dialog").dialog({closed: true});
                                            $.messager.alert("消息", "修改成功！", "info");
                                        }
                                    }
                                })
                            }
                        }, {
                            text: "重置",
                            iconCls: "icon-redo",
                            handler: function () {
                                $("#edit-form").form("clear");
                            }
                        }]
                    })
                }
            })

            /*头像上传*/
            $('#btn-upload').click(function () {
                let arr = $("#dg").datagrid('getSelections');
                console.log(arr[0])
                if (arr.length == 0) {
                    $.messager.alert("消息", "请选择上传头像的用户信息！", "error");
                } else if (arr.length > 1) {
                    $.messager.alert("消息", "请选择一条记录进行头像上传！", "error");
                } else {
                    $('#upload-dialog').dialog({
                        closed: false,
                        buttons: [{
                            text: '上传',
                            iconCls: 'icon-save',
                            handler: function () {
                                $("#upload-form").form('submit', {
                                    url: "user/uploadImages?uid=" + arr[0].uid,
                                    onSubmit: function () {
                                        console.log(arr[0].uid)
                                        return $("#add-form").form();
                                    },
                                    success: function (flag) {
                                        console.log(flag)
                                        if (flag) {
                                            $("#dg").datagrid("load");
                                            $("#upload-dialog").dialog({closed: true})
                                            $.messager.alert("消息", "头像上传成功！", "info");
                                        }
                                    }
                                })
                            }
                        }]
                    })
                }
            })

            // 用户添加
            $("#btn-add").click(function () {
                $('#add-dialog').dialog({
                    closed: false,
                    buttons: [{
                        text: '保存',
                        iconCls: 'icon-save',
                        handler: function () {
                            $("#add-form").form('submit', {
                                url: 'user/save',
                                onSubmit: function () {
                                    return $('#add-form').form('validate');
                                },
                                success: function (flag) {
                                    if (flag) {
                                        $('#dg').datagrid('load');
                                        $('#add-dialog').dialog({closed: true})
                                        $.messager.alert('消息', '添加成功!', "info");
                                    }
                                }
                            })
                        }
                    }, {
                        text: '重置',
                        iconCls: 'icon-redo',
                        handler: function () {
                            $('#add-form').form('clear');
                        }
                    }]

                });

            })

            // 查询框
            $("#btn-search").click(function () {
                $("#dg").datagrid('load', {
                    uname: $("#uname").val()
                })
            })

            // 表格数据
            $('#dg').datagrid({
                url: 'user/findAll', // 远程请求
                fit: true, //适应父容器
                fitColumns: true, // 列自适应大小
                toolbar: "#tb", // 表格工具栏
                pagination: true, // 显示分页工具栏
                pagePosition: 'both', // 分页工具栏的位置，上下显示
                columns: [[ // 列
                    {field: 'uid', title: 'xxx', width: 100, checkbox: true},
                    {field: 'uname', title: '用户名称', width: 100},
                    {field: 'password', title: '密码', width: 100},
                    {field: 'nickName', title: '用户昵称', width: 100},
                    {
                        field: 'images', title: '头像', width: 100,
                        formatter: function (value, rows, index) {
                            if (value != null) {
                                return '<img src="' + value + '" style="width: 40px;height: 40px">'
                            }
                        }
                    },
                    {
                        field: 'stat', title: '状态', width: 100,
                        formatter: function (stat, tows, index) {
                            if (stat != null) {
                                if (stat == 0) {
                                    return '<div style="font-weight: bold; color: green">启用</div>'
                                } else if (stat == 1){
                                    return '<div style="font-weight: bold; color: red">禁用</div>'
                                } else {
                                    return '<div style="font-weight: bold; color: yellow">位置</div>'
                                }
                            }
                        }
                    },
                    {field: 'createTime', title: '创建时间', width: 100},
                    {field: 'modifyTime', title: '修改时间', width: 100}
                ]]
            });

        })
    </script>
    <body>
        <div id="tb">
            <!-- 查询框-->
            <table>
                <tr>
                    <td>
                        <input id="uname" class="easyui-validatebox" placeholder="请输入用户名查询">
                        <a id="btn-search" href="#" class="easyui-linkbutton"
                           data-options="iconCls:'icon-search',plain:'true'">查询</a>
                    </td>
                </tr>
            </table>
            <a id="btn-add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'">添加</a>
            <a id="btn-edit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:'true'">修改</a>
            <a id="btn-remove" href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:'true'">删除</a>
            <a id="btn-upload" href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-man',plain:'true'">上传头像</a>
        </div>

        <table id="dg"></table>

        <!--头像上传-->
        <div id="upload-dialog" data-options="closed:true" title="头像上传"
             class="easyui-dialog" style="width: auto;height: auto;">
            <form method="post" enctype="multipart/form-data" id="upload-form">
                <input class="easyui-filebox" data-options="required:true"
                       name="file" style="width:300px">
            </form>
        </div>

        <!--添加信息框-->
        <div id="add-dialog" class="easyui-dialog" title="添加用户信息" closed="true" style="width:400px;height:200px;">
            <form id="add-form" method="post">
                <table>
                    <tr>
                        <td>用户名称：</td>
                        <td>
                            <input name="uname" class="easyui-validatebox" placeholder="请输入用户名称"
                                   data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input name="password" class="easyui-validatebox" placeholder="请输入用户密码"
                                   data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td>昵称：</td>
                        <td>
                            <input name="nickName" class="easyui-validatebox" placeholder="请输入用户昵称"
                                   data-options="required:true">
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <!--修改页面-->
        <div id="edit-dialog" class="easyui-dialog" closed="true" title="修改用户信息"
             style="width: auto;height: 200px">
            <form id="edit-form" method="post">
                <!--修改的条件-->
                <input type="hidden" name="uid">
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td>
                            <input name="uname" class="easyui-validatebox" placeholder="请输入用户名称"
                                   data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input name="password" class="easyui-validatebox" placeholder="请输入密码"
                                   data-options="required:true">
                        </td>
                    </tr>
                    <tr>
                        <td>昵称：</td>
                        <td>
                            <input name="nickName" class="easyui-validatebox" placeholder="请输入昵称"
                                   data-options="required:true">
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="images">
            </form>
        </div>
    </body>
</html>