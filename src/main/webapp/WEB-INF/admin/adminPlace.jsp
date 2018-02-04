<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/2/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运动场所</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">


        function deletePlace(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].placeId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${APP_PATH}/admin/place/delete.do",{ids:ids},function(result){
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
        function openPlaceAddDialog(){
            $("#dlg").dialog("open").dialog("setTitle","添加场所信息");
            url="${APP_PATH}/admin/place/save.do";
        }
       
       
        function openPlaceAddModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑场所信息");
            $("#fm").form("load",row);
            url="${APP_PATH}/admin/place/save.do?placeId="+row.placeId;
        }

        function savePlace(){
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
            $("#placeName").val("");
            $("#placeSports").val("");
            $("#placeLevel").val("");
            $("#longitude").val("");
            $("#latitude").val("");
        }
        function closePlaceDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }
        

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="场所管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${APP_PATH}/admin/place/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="placeId" width="20" align="center" hidden>编号</th>
        <th field="placeName" width="50" align="center">场所名称</th>
        <th field="placeSports" width="50" align="center">可进行运动</th>
        <th field="placeLevel" width="50" align="center">评价</th>
        <th field="longitude" width="50" align="center">经度</th>
        <th field="latitude" width="50" align="center">纬度</th>

    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openPlaceAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openPlaceAddModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deletePlace()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>
<div id="dlg" class="easyui-dialog"
     style="width:500px;height:280px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post" enctype="multipart/form-data">
        <table cellspacing="8px">
            <tr>
                <td>场所名称：</td>
                <td>
                    <input type="text" name="placeName" class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>可进行运动：</td>
                <td>
                    <input type="text" name="placeSports" class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>评价：</td>
                <td>
                    <input type="text" name="placeLevel" class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>经度：</td>
                <td>
                    <input type="text" name="longitude" class="easyui-validatebox" required="true" />
                </td>
            </tr>
            <tr>
                <td>纬度：</td>
                <td>
                    <input type="text" name="latitude" class="easyui-validatebox" required="true" />
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:savePlace()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closePlaceDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>
