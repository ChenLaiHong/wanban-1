<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/22
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反馈状态审核</title>
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
        function statusReview(questionStatus){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要审核的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].questionId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要审核这<font color=red>"+selectedRows.length+"</font>条评论吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/feedback/status.do",{ids:ids,questionStatus:questionStatus},function(result){
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
<table id="dg" title="反馈审核管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/status/list.do?questionStatus=0" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="questionId" width="20" align="center" hidden>编号</th>
        <th field="user" width="30" align="center" formatter="formatUser">用户名</th>
        <th field="questionContent" width="200" align="center">反馈内容</th>
        <th field="questionTime" width="50" align="center">反馈日期</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:statusReview(1)" class="easyui-linkbutton" iconCls="icon-ok" plain="true">审核通过</a>
        <a href="javascript:statusReview(2)" class="easyui-linkbutton" iconCls="icon-no" plain="true">审核不通过</a>
    </div>
</div>

</body>
</html>
