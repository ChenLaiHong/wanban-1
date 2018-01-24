<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/23
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反馈管理</title>
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

        function deleteFeedback(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].questionId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/feedback/delete.do",{ids:ids},function(result){
                        if(result.success){
                            $.messager.alert("系统提示","数据已成功删除！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                    },"json");
                }
            });
        }


        function formatState(val,row){
            if(val==0){
                return "待审核";
            }else if(val==1){
                return "审核通过";
            }else if(val==2){
                return "审核未通过";
            }
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="反馈信息管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/status/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="questionId" width="20" align="center" hidden>编号</th>
        <th field="user" width="30" align="center" formatter="formatUser">用户名</th>
        <th field="questionContent" width="200" align="center">反馈内容</th>
        <th field="questionTime" width="50" align="center">反馈日期</th>
        <th field="questionStatus" width="50" align="center" formatter="formatState">反馈状态</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:deleteFeedback()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>

</body>
</html>
