<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/3/17
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="utf-8">
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.2/themes/default/easyui.css">
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.2/plugins/jquery.datagrid.js"></script>
    <%--<script type="text/javascript">
        var ctx = ${ctx};
    </script>--%>
    <style>
        * {
            margin: 0px;
            font-size: 12px;
        }
    </style>
</head>
<body class="easyui-layout">
    <%--<div data-options="region:'north',title:'North Title'" style="height:50px;"></div>--%>
    <div id="layout" data-options="region:'west',title:'管理'" style="width:200px;">
        <!-- 信息管理开始 -->
        <div id="aa" class="easyui-accordion" data-options="fit:true">
            <div title="生活费管理" class="panel-body accordion-body" data-options="iconCls:'icon-reload', selected:true">
                <ul>
                    <li class="selected" sizset="true">
                        <a href="javascript: addTab('生活费管理', '${ctx}/view/alimoney/index.jsp');">
                            <span class="icon-tip">&nbsp;</span>
                            <span class="nav">生活费列表</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div title="个人设置" class="panel-body accordion-body" data-options="iconCls:'icon-reload',selected:false">

            </div>
            <div title="个人设置2" class="panel-body accordion-body" data-options="iconCls:'icon-reload',selected:false">

            </div>
        </div>
        <!-- 信息管理结束 -->
    </div>
    <div id="center" class="easyui-tabs" data-options="region:'center',title:'center title'" style="background:#eee; overflow: hidden;">
        <div title="首页" class="easyui-tabs" data-options="fit:true,border:false,plain:true,closable:true,href:'${ctx}/view/core/index.jsp'"></div>
    </div>
</body>
</html>
<script type="text/javascript">

    //var center = $('#center');

    function addTab(title, url){
        if($('#center').tabs('exists', title)){
            $('#center').tabs('select', title);
        }else{
            $('#center').tabs('add',{
                title: title,
                href: url,
                closable: true
            });
        }
    }

</script>