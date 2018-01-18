<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/1/18
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>管理用户</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

</head>
<body style="margin: 1px">
<table id="dg" title="注册用户管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/admin/user/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="userId" width="20" align="center">编号</th>
        <th field="userName" width="30" align="center">用户名</th>
        <th field="sex" width="20" align="center">性别</th>
        <th field="grade" width="20" align="center">等级</th>
        <th field="city" width="20" align="center">城市</th>
        <th field="phone" width="100" align="center">电话</th>
        <th field="email" width="100" align="center">邮箱</th>
        <th field="sign" width="100" align="center">个性签名</th>
        <th field="createTime" width="40" align="center">注册时间</th>
    </tr>
    </thead>
</table>
</body>
</html>
