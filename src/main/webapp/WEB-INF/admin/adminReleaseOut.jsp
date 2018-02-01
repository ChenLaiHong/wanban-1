<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/24
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已下架的发布</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        function formatUser(val,row){
            return val.userName;
        }
        function searchRelease(){
            $("#dg").datagrid('load',{
                "types":$("#types").val()
            });
        }

        function formatState(val,row){
            if(val==1){
                return "已下架";
            }
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="下架信息管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/release/list.do?status = 1" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="releaseId" width="20" align="center" hidden>编号</th>
        <th field="user" width="20" align="center" formatter="formatUser">发布用户</th>
        <th field="sportPlace" width="30" align="center">运动地点</th>
        <th field="sportTime" width="50" align="center">运动时间</th>
        <th field="types" width="50" align="center">运动类型</th>
        <th field="releaseTime" width="50" align="center">发布时间</th>
        <th field="status" width="50" align="center" formatter="formatState">状态</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;标题：&nbsp;<input type="text" id="types" size="20" onkeydown="if(event.keyCode==13) searchRelease()"/>
        <a href="javascript:searchRelease()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

</body>
</html>
