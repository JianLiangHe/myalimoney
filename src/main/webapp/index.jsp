<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/3/16
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>login page</title>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.2/themes/default/easyui.css">
    <style type="text/css">

        * {margin: 0;}

        .login-box {
            width: 240px;
            height: 90px;
            margin: 0 auto;
        }

    </style>
</head>
<body>
    <!-- 登陆盒子 -->
    <div id="login_box" class="login-box">
        <form id="login_frm" action="" method="post">
            <table>
                <tr>
                    <th>账号</th>
                    <td>
                        <input type="text" id="account" name="account" class="easyui-validatebox" required="true">
                    </td>
                </tr>
                <tr>
                    <th>密码</th>
                    <td>
                        <input type="password" id="password" name="password" class="easyui-validatebox" required="true">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
<script type="text/javascript">

    var login_box;
    $(function(){
        login_box = $('#login_box').dialog({
            modal: true,
            title: '登陆/注册',
            closable: true,
            buttons: [{
                text: '注册',
                handler: function(){
                    register();
                }
            }, {
                text: '登陆',
                handler: function(){
                    login();
                }
            }]
        });
    });

    //注册
    function register(){
        if($('#login_frm').form('validate')){
            $.ajax({
                url: '${ctx}/register/register.do',
                data: $('#login_frm').serialize(),
                cache: false,
                dataType: 'json',
                success: function(r){
                    $.messager.show({
                        title: '注册信息',
                        msg: r.message
                    });
                    $('#login_frm').form('clear');
                }
            });
        }
    }

    //登陆
    function login(){
        if(check()&&$('#login_frm').form('validate')){
            var url = '${ctx}/login/login.do';
            var params = $('#login_frm').serialize();
            /*$.get(url,params,function(data){
                console.log(data);
                if(data.code==200){
                    window.location.href = '${ctx}/view/core/main.jsp';
                }else{
                    var msg = data.message;
                    $.messager.alert(msg);
                }
            });*/
            $.ajax({
                url: url,//请求路径
                data: params,//参数
                cache: false,//缓存不开启
                dataType: 'json',//返回结果类型
                success: function(r){//成功回掉函数
                    if(r.code==0){
                        window.location.href = '${ctx}/view/core/main.jsp';
                    }else{
                        $.messager.show({//右下角显示框提示
                            title: '提示',
                            msg: r.message
                        });
                    }
                }
            });
        }
    }

    //验证输入信息
    function check(){
        var reg = /\w{6,12}/;
        var account = $('#account').val();
        var password = $('#password').val();
        console.log(reg.test(account));
        if(!reg.test(account)){
            alertTips('用户名输入有误,不能有非法字符,长度范围6-12位');
            $('#account').focus();
            return false;
        }
        if(!reg.test(password)){
            alertTips('密码输入有误,不能有非法字符,长度范围6-12位');
            $('#password').focus();
            return false;
        }
        return true;
    }

    //提示错误信息
    function alertTips(msg){
        $.messager.alert({
            title: '提示',
            msg: msg
        });
    }

</script>
