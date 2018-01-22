<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/18
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>一级管理页面</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css"
          href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${APP_PATH}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        var url;

        function deleteFirstLevel(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].firstId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/firstLevel/delete.do",{ids:ids},function(result){
                        if(result.success){
                            if(result.exist){
                                $.messager.alert("系统提示",result.exist);
                            }else{
                                $.messager.alert("系统提示","数据已成功删除！");
                            }
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                    },"json");
                }
            });
        }
        function openFirstLevelAddDialog(){

            $("#dlg").dialog("open").dialog("setTitle","添加一级信息");
            url="${APP_PATH}/admin/firstLevel/save.do";
        }

        function openFirstLevelModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            getImageName(row);
            $("#dlg").dialog("open").dialog("setTitle","编辑一级信息");
            $("#fm").form("load",row);
            url="${APP_PATH}/admin/firstLevel/save.do?firstId="+row.firstId;
        }

        //加载图片
        function getImageName(row) {
            $.ajax({
                url:"${APP_PATH}/admin/firstLevel/Image.do?firstId="+row.firstId,
                type:"POST",
                success:function (result) {
                    console.log(result);
                    var url = '${APP_PATH}/static/levelImages/'+result.extend.imageName;
                    upload.src = url;
                }
            });

        }

        function saveFirstLevel(){
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
            $("#firstName").val("");
            $("#imageFile").val("");
        }
        function closeFirstLevelDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }
        function formatImg(val,row){
            if(val){
                return '<img src=static/levelImages/'+val+' style=width:80px;height:50px;>'
            }else{
                return ''
            }
        }
    </script>
</head>
<body style="margin: 1px">


<table id="dg" title="一级管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/firstLevel/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="firstId" width="20" align="center">编号</th>
        <th field="firstName" width="100" align="center">一级名称</th>
        <th field="firstImageName" width="30" align="center" data-options="formatter:formatImg">图片</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openFirstLevelAddDialog()"
           class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:openFirstLevelModifyDialog()"
            class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteFirstLevel()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog"
     style="width:500px;height:280px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="firstImageName" value="${firstImageName}">
        <table cellspacing="8px">
            <tr>
                <td>一级名称：</td>
                <td><input type="text" id="firstName" name="firstName"
                           class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>图片：</td>
                <td><input type="file" id="imageFile" name="imageFile" value="firstImageName"
                           class="easyui-validatebox"/>
                    <img id="upload" src="" alt=" " style="height: 50px;width: 50px"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveFirstLevel()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeFirstLevelDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>
