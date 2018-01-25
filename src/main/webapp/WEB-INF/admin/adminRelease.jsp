<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/24
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理发布信息</title>
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
        function statusReview(status){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要下架的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].releaseId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要下架这<font color=red>"+selectedRows.length+"</font>条发布信息吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/release/status.do",{ids:ids,status:status},function(result){
                        if(result.success){
                            $.messager.alert("系统提示","提交成功！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","提交失败！");
                        }
                    },"json");
                }
            });
        }


    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="发布信息管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/release/list.do?status=0" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="releaseId" width="20" align="center" hidden>编号</th>
        <th field="user" width="30" align="center" formatter="formatUser">发布用户</th>
        <th field="sportPlace" width="50" align="center">运动地点</th>
        <th field="sportTime" width="60" align="center">运动时间</th>
        <th field="type" width="50" align="center">运动类型</th>
        <th field="releaseTime" width="60" align="center">发布时间</th>

    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:statusReview(1)" class="easyui-linkbutton" iconCls="icon-ok" plain="true">下架</a>
    </div>
</div>

</body>
</html>
