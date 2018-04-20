function save(){
    //加载页面
    dialog.dialog({
        title: '新增',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        href: ctx+'/view/alimoney/save.jsp',
        modal: true
    });
}

function deleteRow(){
    var rows = datagrid2.datagrid('getSelections');

    if(rows.length==0){
        $.messager.alert({
            title: '提示',
            msg: '请选择你需要删除的记录',
            icon: 'info'
        });
        return;
    }

    if(rows.length>1){
        $.messager.alert({
            title: '提示',
            msg: '只能选择一个条记录进行删除',
            icon: 'info'
        });
        return;
    }

    $.messager.confirm({
        title: '提示',
        msg: '你确定要删除吗？',
        fn: function(r){
            var alimoney_no = "";
            $.each(rows, function(i, n){
                if(i==0){
                    alimoney_no = n.alimoney_no;
                }
            });
            var url = ctx+"/alimoney/delete.do";
            var params = {"alimoney_no":alimoney_no};
            console.log(params);
            $.get(url, params, function(data){
                $.messager.show({
                    title: '提示',
                    msg: data.message
                });
                datagrid2.datagrid('reload');
            });
        }
    });
}

function searchAlimoney(){
    var params = datagrid2.datagrid('options').queryParams;
    var fields = queryFrm.serializeArray();
    console.log(fields);
    //清空上一次选中的查询条件
    for(var name in params){
        params[name] = "";
    }

    $.each(fields, function(i, v){
        if(params[n.name] != '' && params[n.name] != undefined){
            params[n.name] = params[n.name] + ',' + n.value;
        }
    });

    datagrid2.datagrid('reload');
}