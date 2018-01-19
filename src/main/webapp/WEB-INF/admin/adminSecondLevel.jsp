<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/19
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>二级信息管理</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        function formatFirstLevel(val,row){
            return val.firstName;
        }

        function searchSecondLevel(){
            $("#dg").datagrid('load',{
                "title":$("#s_title").val()
            });
        }

        function deleteSecondLevel(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].id);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/second/delete.do",{ids:ids},function(result){
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
        function openSecondLevelAddDialog(){
            $("#dlg").dialog("open").dialog("setTitle","添加二级信息");
            url="${APP_PATH}/admin/secondLevel/save.do";
        }

        function openSecondLevelModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑二级信息");
            $("#fm").form("load",row);
            url="${APP_PATH}/admin/secondLevel/save.do?secondId="+row.secondId;
        }

        function saveSecondLevel(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert("系统提示","保存失败！");
                        return;
                    }
                }
            });
        }
        function resetValue(){
            $("#secondName").val("");
            $("#imageFile").val("");
        }
        function closeSecondLevelDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }
        function formatImg(val,row){
            if(val){
                return '<img src=static/images/'+val+' style=width:80px;height:50px;>'
            }else{
                return '<img src='+APP_PATH+'/static/images/moren.png style=width:80px;height:50px;>'
            }
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="二级管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/secondLevel/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="secondId" width="20" align="center">编号</th>
        <th field="secondName" width="50" align="center">二级名称</th>
        <th field="firstId" width="50" align="center">所属一级</th>
        <th field="secondImageName" width="30" align="center" data-options="formatter:formatImg">图片</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openSecondLevelAddDialog()"
           class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:openSecondLevelModifyDialog()"
            class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteSecondLevel()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchSecondLevel()"/>
        <a href="javascript:searchSecondLevel()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>
<div id="dlg" class="easyui-dialog"
     style="width:500px;height:280px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post" enctype="multipart/form-data">
        <table cellspacing="8px">
            <tr>
                <td>二级名称：</td>
                <td><input type="text" id="firstName" name="secondName"
                           class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>所属一级：</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="firstId" name="firstId" editable="false" panelHeight="auto" >
                        <option value="">请选择所属一级...</option>
                        <c:forEach var="firstLevel" items="${firstLevelCountList }">
                            <option value="${firstLevel.firstId }">${firstLevel.firstName }</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>图片：</td>
                <td><input type="file" id="imageFile" name="imageFile"
                           class="easyui-validatebox" required="true"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveSecondLevel()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeSecondLevelDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>
