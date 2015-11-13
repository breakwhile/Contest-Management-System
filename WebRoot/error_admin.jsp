<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>教学秘书/管理员登陆</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="css/style.css" rel="stylesheet" />
   <link href="css/style-responsive.css" rel="stylesheet" />
   <link href="css/style-default.css" rel="stylesheet" id="style_color" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="lock">
    <div class="lock-header">
        <!-- BEGIN LOGO -->
        <a class="center" id="logo" href="login_admin.jsp">
            <img class="center" alt="logo" src="img/login_admin.png">
        </a>
        <!-- END LOGO -->
    </div>
    
    <div class="login-wrap">
        <div class="metro single-size red">
            <div class="locked">
                <i class="icon-lock"></i>
                <span>管理员登录</span>
            </div>
        </div>
        <form name="loginAdminForm" action="LoginAction!login_admin.action" method="post" onSubmit="return loginCheck()">       
        <div class="metro double-size green">
                <div class="input-append lock-input">
                    <input name="adminName" id="adminName" type="text" class="" placeholder="用户名或密码错误">
                </div>
        </div>
        <div class="metro double-size yellow">

                <div class="input-append lock-input">
                    <input name="adminPassword" id="adminPassword" type="password" class="" placeholder="Password">
                </div>

        </div>
        <div class="metro single-size terques login">

                <button type="submit" class="btn login-btn">
                    登录
                    <i class=" icon-long-arrow-right"></i>
                </button>
        </div>
        </form>
        <div class="metro double-size navy-blue ">
            <a href="index.html" class="social-link">
                <i class="icon-facebook-sign"></i>
                <span>Facebook 登录</span>
                
            </a>
        </div>
        <div class="metro single-size deep-red">
            <a href="index.html" class="social-link">
                <i class="icon-google-plus-sign"></i>
                <span>Google 登录</span>
            </a>
        </div>
        <div class="metro double-size blue">
            <a href="index.html" class="social-link">
                <i class="icon-twitter-sign"></i>
                <span>Twitter 登录</span>
            </a>
        </div>
        <div class="metro single-size purple">
            <a href="index.html" class="social-link">
                <i class="icon-skype"></i>
                <span>Skype 登录</span>
            </a>
        </div>
        <div class="login-footer">
            <div class="remember-hint pull-left">
                <input type="checkbox" id=""> 记住密码
            </div>
            <div class="forgot-hint pull-right">
                <a id="forget-password" class="" href="javascript:;">忘记密码?</a>
            </div>
        </div>
    </div>
</body>
<!-- END BODY -->
   <script language="JavaScript">
  function loginCheck(){
   if(isNull(loginAdminForm.adminName.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(loginAdminForm.adminPassword.value)){  
   alert("请输入密码！"); 
   return false;
   } 
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
} 
</script>
</html>