document.querySelector('#user-list').GM({
    gridManagerName: 'demo-customizeCode',
    ajaxData: 'http://localhost:8080/api/user/list',
    ajaxType:'POST',
    supportAdjust: false,
    supportDrag: false,
    //解决后台返回格式不一致的问题
    responseHandler: function(response){
        return{
            data: response.data.list,
            totals: response.data.totals
        }
    },
    columnData: [
        {
            key: 'username',
            remind: 'the name',
            width: '110px',
            align: 'center',
            text: '姓名',
        },
        {
            key: 'location',
            remind: 'the name',
            width: '110px',
            align: 'center',
            text: '负责地区',
        },
        {
            key: 'id',
            width: '130px',
            text: '操作',
            template: function(id, rowObject){
                    return '<div class="btn">' +
                        '<div class="get" onclick="setLocation('+id+')">设置地区</div>' +
                        '</div>';
            }
        }
    ]
});

function setLocation(id) {
    console.log("弹出来了")
    layer.open({
        type: 1,
        title: false,
        closeBtn: 0,
        shadeClose: true,
        content: '<div id="set">\n' +
            '    <select>\n' +
            '        <option value="北京">北京</option>\n' +
            '        <option value="上海">上海</option>\n' +
            '        <option value="武汉">武汉</option>\n' +
            '    </select>\n' +
            '</div>',
        btn: ['确定','取消'],
        yes: function(index, layero){
            let $location = $("select").val();
            console.log($location)
            $.ajax({
                url:"/api/user/setlocation",
                type:"POST",
                data:{
                    id: id,
                    location: $location
                },
                success:function (res) {
                    if (res.error>=0){
                        location.href='http://localhost:8080/api/admin/list'
                    }else {
                        layer.msg(res.errmsg);
                    }
                }
            })

        },
        btn2:function (index,layero) {
        }
    });
}
