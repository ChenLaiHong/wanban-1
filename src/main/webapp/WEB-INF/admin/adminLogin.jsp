<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/16
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理员登录页面</title>

    <script src="../../static/bootstrap-3.3.7-dist/js/jquery-1.11.2.min.js"></script>
    <STYLE>
        body{
            background: #ebebeb;
            font-family: "Helvetica Neue","Hiragino Sans GB","Microsoft YaHei","\9ED1\4F53",Arial,sans-serif;
            color:  #FF88C2;
            font-size: 12px;
        }
        *{padding: 0px;margin: 0px;}
        .top_div{
            background: #FFB3FF;
            width: 100%;
            height: 400px;
        }
        .ipt{
            border: 1px solid #d3d3d3;
            padding: 10px 10px;
            width: 290px;
            border-radius: 4px;
            padding-left: 35px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
        }
        .ipt:focus{
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
        }
        .u_logo{
            background: url("../../static/images/userName.png") no-repeat;
            padding: 10px 10px;
            position: absolute;
            top: 43px;
            left: 40px;

        }
        .p_logo{
            background: url("../../static/images/password.png") no-repeat;
            padding: 10px 10px;
            position: absolute;
            top: 12px;
            left: 40px;
        }
        a{
            text-decoration: none;
        }

    </STYLE>

    <SCRIPT type="text/javascript">

        function checkForm(){
            var userName=$("#userName").val();
            var password=$("#password").val();
            if(userName==null||userName==""){
                $("#error").html("用户名不能为空！");
                return false;
            }
            if(password==null||password==""){
                $("#error").html("密码不能为空！");
                return false;
            }
            return true;
        }
    </SCRIPT>
</head>
<body>
<DIV class="top_div">
</DIV>
<form action="${pageContext.request.contextPath}/admin/login" method="post" onsubmit="return checkForm()">
    <DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">

        <P style="padding: 30px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN>
            <INPUT id="userName" name="userName" class="ipt" type="text" placeholder="请输入用户名">
        </P>
        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN>
            <INPUT id="password" name="password" class="ipt"  type="password" placeholder="请输入密码">
        </P>
        <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <SPAN style="float: left;">后台管理系统</SPAN>
                <span><font color="red" id="error">${result.msg}</font></span>
                <SPAN style="float: right;">
	              <input type="submit" style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: #FFB7DD; font-weight: bold;" value="登录"/>
	         </SPAN>
            </P>
        </DIV>
    </DIV>
</form>
<div style="text-align:center;padding-top: 30px">
    Copyright © 2018 玩伴后台管理系统
</div>

</body>
</html>
