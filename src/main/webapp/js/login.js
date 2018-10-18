
$(document).ready(function(){
    $("#loginErrorAlert").css("display","none")
    $("#doLoginBtn").click(function(){
        doLogin();
    });
});
function doLogin(){
    var userInfo={};
    var inputEmail=$("#inputEmail").val();
    var inputPassword=$("#inputPassword").val();
    if(inputEmail==""){
        showToolTip('inputEmail','请填写用户名','right');
        return false;
    }
    if(inputPassword==""){
    showToolTip('inputPassword','请填写密码','right');
     return false;
    }
    userInfo.emailPhone=inputEmail;
    userInfo.password=inputPassword;
    $.ajax({
        type: 'POST',
        url: "login.do",
        data: userInfo,
        dataType: "JSON",
        success: function(data){
            if(data.code=="501"){
                $("#loginErrorAlert").children("span").text(data.message);
                $("#loginErrorAlert").show(500);
                setTimeout(
                    '$("#loginErrorAlert").hide(500);',3000);
            }else if(data.code=="502"){
                $("#loginErrorAlert").children("span").text(data.message);
                $("#loginErrorAlert").show(500);
                setTimeout(
                    '$("#loginErrorAlert").hide(500);',3000);
            }else if(data.code=="200"){
                window.location.href="redirect_to_workspcae.do";
            }
        }
    });
}

