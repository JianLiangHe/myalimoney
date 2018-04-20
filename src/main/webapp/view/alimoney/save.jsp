<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/4/1
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>
    <form id="frm">
        <table>
            <div>
                <label>标题：</label>
                <input class="easyui-validatebox" type="text" name="alimoney_title" data-options="required:true">
            </div>
            <div>
                <label>详情：</label>
                <input class="easyui-validatebox" type="text" name="alimoney_info" data-options="required:true">
            </div>
            <div>
                <label>价格：</label>
                <input class="easyui-validatebox" type="text" name="alimoney_money" data-options="required:true">
            </div>
            <div>
                <label>状态：</label>
                <input type="radio" name="alimoney_status" value="1" checked>支出
                <input type="radio" name="alimoney_status" value="0">收入
            </div>
            <div>
                <label>日期：</label>
                <input class="easyui-datebox" type="text" name="alimoney_createtime" data-options="required:true">
            </div>
            <div>
                <input type="button" class="easyui-linkbutton" value="提交" onclick="saveAlimoney();">
            </div>
        </table>
    </form>
    <script>

        function saveAlimoney(){
            console.log('submit  okok');
            var url = '${ctx}/alimoney/save.do';
            var params = $('#frm').serialize();
            console.log('params: '+params);
            $.post(url, params, function(data){
                if(data.code==0){
                    $.messager.show({
                        title: '提示信息',
                        msg: data.message
                    });
                    dialog.dialog('close');//关闭窗口
                    datagrid2.datagrid('load');//渲染数据
                }else{
                    $.messager.alert(data.message);
                }
            }, 'json');
        }

    </script>
</body>
</html>

