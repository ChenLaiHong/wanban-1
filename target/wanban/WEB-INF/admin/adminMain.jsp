<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/16
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>后台主页</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        var url;

        function openTab(text,url,iconCls){
            if($("#tabs").tabs("exists",text)){
                $("#tabs").tabs("select",text);
            }else{
                var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/"+url+"'></iframe>";
                $("#tabs").tabs("add",{
                    title:text,
                    iconCls:iconCls,
                    closable:true,
                    content:content
                });
            }
        }
        function logout(){
            $.messager.confirm("系统提示","您确定要退出系统吗？",function(r){
                if(r){
                    window.location.href='${pageContext.request.contextPath}/admin/loginOut.do';
                }
            });
        }

        function openPasswordModifyDialog(){
            $("#dlg").dialog("open").dialog("setTitle","修改密码");
            url="${pageContext.request.contextPath}/admin/modifyPassword.do?adminId=${adminUser.adminId}";
        }

        function modifyPassword(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    var newPassword=$("#newPassword").val();
                    var newPassword2=$("#newPassword2").val();
                    if(!$(this).form("validate")){
                        return false;
                    }
                    if(newPassword!=newPassword2){
                        $.messager.alert("系统提示","确认密码输入错误！");
                        return false;
                    }
                    return true;
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","密码修改成功，下一次登录生效！");
                        resetValue();
                        $("#dlg").dialog("close");
                    }else{
                        $.messager.alert("系统提示","密码修改失败！");
                        return;
                    }
                }
            });
        }

        function closePasswordModifyDialog(){
            resetValue();
            $("#dlg").dialog("close");
        }

        function resetValue(){
            $("#newPassword").val("");
            $("#newPassword2").val("");
        }


    </script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td>
                <div class="col-md-8">
                    <iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
                </div>
            </td>
            <td valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${adminUser.adminName}</font>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px"><font color="red" size="10">后台信息管理</font></div>
          </div>
    </div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('注册用户管理','toAdminUser.do','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">注册用户管理</a>
            <a href="javascript:openTab('一级信息管理','toFirstLevel.do','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">一级信息管理</a>
            <a href="javascript:openTab('二级信息管理','toSecondLevel.do','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">二级信息管理</a>
        </div>
        <div title="发布管理"  data-options="iconCls:'icon-bkgl'" style="padding:10px;">
            <a href="javascript:openTab('发布信息管理','toReleases.do','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">发布信息管理</a>
            <a href="javascript:openTab('已下架信息','toReleasesOut.do','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">已下架信息</a>

        </div>
        <div title="场所管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
            <a href="javascript:openTab('场所管理','toPlace.do','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">场所管理</a>
        </div>
        <div title="反馈管理"  data-options="iconCls:'icon-plgl'" style="padding:10px">
            <a href="javascript:openTab('反馈审核','toCheckStatus.do','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">反馈审核</a>
            <a href="javascript:openTab('反馈信息管理','toFeedBack.do','icon-plgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">反馈信息管理</a>
        </div>
        <div title="管理员设置"  data-options="iconCls:'icon-system'" style="padding:10px">
            <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
            <a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
        </div>
    </div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">
    Copyright © 2018玩伴后台管理系统
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:200px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="userName" name="userName" readonly="readonly" value="${adminUser.adminName}" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" id="newPassword" name="newPassword" class="easyui-validatebox" required="true" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>确认新密码：</td>
                <td><input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox" required="true" style="width: 200px"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>
