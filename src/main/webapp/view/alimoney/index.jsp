<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">

    var ctx = '${ctx}';
    var datagrid2 = $('#datagrid2');
    var dialog = $('#dialog');
    var queryFrm = $('#queryFrm');

    var buttons = [
        {
            text: '新增记录',
            iconCls: 'icon-edit',
            handler: function(){
                save();
            }
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: function(){
                deleteRow();
            }
        }, '-'
    ];

    $(function(){
        datagrid2.datagrid({
            url: ctx+'/alimoney/queryList.do',//数据源地址
            method: 'post',
            title: '生活费列表',//标题
            pagination: true,//分页栏
            rownumbers: true,//显示行号
            pageSize: 10,//每页显示多少条数据
            pageList: [10, 20, 30],//选择每页显示数据条数
            //fit: true,//与外层宽高相同
            fitColumns: true,//自动调整各列
            resizable: true,
            nowrap: true,
            border: false,
            height: 600,
            striped: true,//奇偶行颜色不同
            collapsible: true,//可折叠
            resizable: true,
            idField: 'alimoney_no',
            columns:[[{
                checkbox: true,
                field: 'alimoney_no',
                formatter: function(value, row, index){
                    return row.alimoney_no;
                }
            }, {
                title: '标题',
                field: 'alimoney_title',
                width: 100,
                align: 'center',
                formatter: function(value, row, index){
                    return row.alimoney_title;
                }
            }, {
                title: '详细信息',
                field: 'alimoney_info',
                width: 100,
                align: 'center',
                formatter: function(value, row, index){
                    return row.alimoney_info;
                }
            }, {
                title: '价格',
                field: 'alimoney_money',
                width: 100,
                align: 'center',
                formatter: function(value, row, index){
                    return row.alimoney_money;
                }
            }, {
                title: '创建时间',
                field: 'alimoney_createtime',
                width: 100,
                align: 'center',
                formatter: function(value, row, index){
                    return row.alimoney_createtime.substring(0,10);
                }
            }]],
            toolbar: buttons
        });
    });

</script>
<script type="text/javascript" src="${ctx}/js/almoney/index.js"></script>
<%-- 条件筛选表格 --%>
<div>
    <form id="queryFrm">
    <table >
        <tr>
            <th>标题</th>
            <td>
                <input type="text" name="alimoney_title">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="查询" class="easyui-linkbutton" onclick="searchAlimoney();">
                <input type="button" value="清空" class="easyui-linkbutton">
            </td>
        </tr>
    </table>
    </form>
</div>

<%-- 显示数据表格 --%>
<table id="datagrid2"></table>

<div id="dialog"></div>


