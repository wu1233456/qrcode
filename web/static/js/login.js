
//页面切换
$(".signin").click(function(){
    this.className="signin focus";
    $(".signup")[0].className="signup";
    $(".input_signin")[0].className="input_signin active";
    $(".input_signup")[0].className="input_signup";
});

$(".signup").click(function(){
    this.className="signup focus";
    $(".signin")[0].className="signin";
    $(".input_signup")[0].className="input_signup active";
    $(".input_signin")[0].className="input_signin";
});


$("#submit").click(function (event) {
    event.preventDefault();
    let $name = $("#user_name").val();
    let $password=$("#repassword").val();
    if ( $name.length!=0  && $password.length!=0){
        $.ajax({
            url:"/api/userlogin/register",
            type:"POST",
            data:{
                username: $name,
                password: $password
            },
            success:function (res) {
                if (res.error<0){
                    layer.msg(res.errmsg);
                }else {
                    layer.msg("注册成功", {
                        time: 1000,
                    }, function () {
                        window.location.href = "/login"
                    })
                }
            }
        })
    }else {
        layer.msg("请填写完整信息")
    }
})

$(".input_signin .button").click(function (event) {
    event.preventDefault();
    let $name = $("#login_user_name").val();
    let $password=$("#login_password").val();
    if ( $name.length!=0 && $password.length!=0){
        $.ajax({
            url:"/api/user/adminlogin",
            type:"POST",
            data:{
                username: $name,
                password: $password
            },
            success:function (res) {
                if (res.error>=0){
                    location.href='http://localhost:8080/api/admin/list'
                }else {
                    layer.msg(res.errmsg);
                }
            }
        })
    }else {
        layer.msg("请填写完整信息")
    }
})
