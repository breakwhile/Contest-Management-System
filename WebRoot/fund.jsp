<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>教师后台-经费管理</title>
   <base href="<%=basePath%>">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="assets/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet" />
   <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="css/style.css" rel="stylesheet" />
   <link href="css/style-responsive.css" rel="stylesheet" />
   <link href="css/style-default.css" rel="stylesheet" id="style_color" />
<link href="css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css"/>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>    	

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
   <!-- BEGIN HEADER -->
   <div id="header" class="navbar navbar-inverse navbar-fixed-top">
       <!-- BEGIN TOP NAVIGATION BAR -->
       <div class="navbar-inner">
           <div class="container-fluid">
               <!--BEGIN SIDEBAR TOGGLE-->
               <div class="sidebar-toggle-box hidden-phone">
                   <div class="icon-reorder tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
               </div>
               <!--END SIDEBAR TOGGLE-->
               <!-- BEGIN LOGO -->
               <a class="brand" href="main_teacher.jsp">
                   <img src="img/logo.png" alt="Metro Lab" />
               </a>
               <!-- END LOGO -->
               <!-- BEGIN RESPONSIVE MENU TOGGLER -->
               <a class="btn btn-navbar collapsed" id="main_menu_trigger" data-toggle="collapse" data-target=".nav-collapse">
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="arrow"></span>
               </a>
               <!-- END RESPONSIVE MENU TOGGLER -->
               <div id="top_menu" class="nav notify-row">
                   <!-- BEGIN NOTIFICATION -->
                   <ul class="nav top-menu">
                       <!-- BEGIN SETTINGS -->
                       <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <i class="icon-tasks"></i>
                               <span class="badge badge-important">6</span>
                           </a>
                           <ul class="dropdown-menu extended tasks-bar">
                               <li>
                                   <p>You have 6 pending tasks</p>
                               </li>
                               <li>
                                   <a href="#">
                                       <div class="task-info">
                                         <div class="desc">Dashboard v1.3</div>
                                         <div class="percent">44%</div>
                                       </div>
                                       <div class="progress progress-striped active no-margin-bot">
                                           <div class="bar" style="width: 44%;"></div>
                                       </div>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <div class="task-info">
                                           <div class="desc">Database Update</div>
                                           <div class="percent">65%</div>
                                       </div>
                                       <div class="progress progress-striped progress-success active no-margin-bot">
                                           <div class="bar" style="width: 65%;"></div>
                                       </div>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <div class="task-info">
                                           <div class="desc">Iphone Development</div>
                                           <div class="percent">87%</div>
                                       </div>
                                       <div class="progress progress-striped progress-info active no-margin-bot">
                                           <div class="bar" style="width: 87%;"></div>
                                       </div>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <div class="task-info">
                                           <div class="desc">Mobile App</div>
                                           <div class="percent">33%</div>
                                       </div>
                                       <div class="progress progress-striped progress-warning active no-margin-bot">
                                           <div class="bar" style="width: 33%;"></div>
                                       </div>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <div class="task-info">
                                           <div class="desc">Dashboard v1.3</div>
                                           <div class="percent">90%</div>
                                       </div>
                                       <div class="progress progress-striped progress-danger active no-margin-bot">
                                           <div class="bar" style="width: 90%;"></div>
                                       </div>
                                   </a>
                               </li>
                               <li class="external">
                                   <a href="#">See All Tasks</a>
                               </li>
                           </ul>
                       </li>
                       <!-- END SETTINGS -->
                       <!-- BEGIN INBOX DROPDOWN -->
                       <li class="dropdown" id="header_inbox_bar">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <i class="icon-envelope-alt"></i>
                               <span class="badge badge-important">5</span>
                           </a>
                           <ul class="dropdown-menu extended inbox">
                               <li>
                                   <p>You have 5 new messages</p>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="photo"><img src="./img/avatar-mini.png" alt="avatar" /></span>
									<span class="subject">
									<span class="from">Jonathan Smith</span>
									<span class="time">Just now</span>
									</span>
									<span class="message">
									    Hello, this is an example msg.
									</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="photo"><img src="./img/avatar-mini.png" alt="avatar" /></span>
									<span class="subject">
									<span class="from">Jhon Doe</span>
									<span class="time">10 mins</span>
									</span>
									<span class="message">
									 Hi, Jhon Doe Bhai how are you ?
									</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="photo"><img src="./img/avatar-mini.png" alt="avatar" /></span>
									<span class="subject">
									<span class="from">Jason Stathum</span>
									<span class="time">3 hrs</span>
									</span>
									<span class="message">
									    This is awesome dashboard.
									</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="photo"><img src="./img/avatar-mini.png" alt="avatar" /></span>
									<span class="subject">
									<span class="from">Jondi Rose</span>
									<span class="time">Just now</span>
									</span>
									<span class="message">
									    Hello, this is metrolab
									</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">See all messages</a>
                               </li>
                           </ul>
                       </li>
                       <!-- END INBOX DROPDOWN -->
                       <!-- BEGIN NOTIFICATION DROPDOWN -->
                       <li class="dropdown" id="header_notification_bar">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                               <i class="icon-bell-alt"></i>
                               <span class="badge badge-warning">7</span>
                           </a>
                           <ul class="dropdown-menu extended notification">
                               <li>
                                   <p>You have 7 new notifications</p>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="label label-important"><i class="icon-bolt"></i></span>
                                       Server #3 overloaded.
                                       <span class="small italic">34 mins</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="label label-warning"><i class="icon-bell"></i></span>
                                       Server #10 not respoding.
                                       <span class="small italic">1 Hours</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="label label-important"><i class="icon-bolt"></i></span>
                                       Database overloaded 24%.
                                       <span class="small italic">4 hrs</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="label label-success"><i class="icon-plus"></i></span>
                                       New user registered.
                                       <span class="small italic">Just now</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">
                                       <span class="label label-info"><i class="icon-bullhorn"></i></span>
                                       Application error.
                                       <span class="small italic">10 mins</span>
                                   </a>
                               </li>
                               <li>
                                   <a href="#">See all notifications</a>
                               </li>
                           </ul>
                       </li>
                       <!-- END NOTIFICATION DROPDOWN -->

                   </ul>
               </div>
               <!-- END  NOTIFICATION -->
               <div class="top-nav ">
                   <ul class="nav pull-right top-menu" >
                       <!-- BEGIN SUPPORT -->
                       <li class="dropdown mtop5">

                           <a class="dropdown-toggle element" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Chat">
                               <i class="icon-comments-alt"></i>
                           </a>
                       </li>
                       <li class="dropdown mtop5">
                           <a class="dropdown-toggle element" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Help">
                               <i class="icon-headphones"></i>
                           </a>
                       </li>
                       <!-- END SUPPORT -->
                       <!-- BEGIN USER LOGIN DROPDOWN -->
                       <li class="dropdown">
                           <a href="main_teacher.jsp" class="dropdown-toggle" data-toggle="dropdown">
                               <img src="img/avatar1_small.jpg" alt="">
                               <span class="teachername">${sessionScope.teacher.teachername}</span>
                               <b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu extended logout">
                               <li><a href="#"><i class="icon-user"></i>我的资料</a></li>
                               <li><a href="#"><i class="icon-cog"></i>我的设置</a></li>
                               <li><a href="TeacherAction!exit"><i class="icon-key"></i>退出</a></li>
                           </ul>
                       </li>
                       <!-- END USER LOGIN DROPDOWN -->
                   </ul>
                   <!-- END TOP NAVIGATION MENU -->
               </div>
           </div>
       </div>
       <!-- END TOP NAVIGATION BAR -->
   </div>
   <!-- END HEADER -->
   <!-- BEGIN CONTAINER -->
   <div id="container" class="row-fluid">
      <!-- BEGIN SIDEBAR -->
      <div class="sidebar-scroll">
          <div id="sidebar" class="nav-collapse collapse">

              <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
              <div class="navbar-inverse">
                  <form class="navbar-search visible-phone">
                      <input type="text" class="search-query" placeholder="Search" />
                  </form>
              </div>
              <!-- END RESPONSIVE QUICK SEARCH FORM -->
              <!-- BEGIN SIDEBAR MENU -->
              <ul class="sidebar-menu">
                  <li class="sub-menu">
                      <a class="" href="main_teacher.jsp">
                          <i class="icon-dashboard"></i>
                          <span>控制台</span>
                      </a>
                  </li>
                   <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-tasks"></i>
                      <span>表单</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="form_layout.html">表单布局</a></li>
                      <li><a class="" href="form_component.html">表单组件</a></li>
                      <li><a class="" href="form_wizard.html">表单提示</a></li>
                      <li><a class="" href="form_validation.html">表单验证</a></li>
                      <li><a class="" href="dropzone.html">文件上传</a></li>
                  </ul>
              </li>
              <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-th"></i>
                      <span>数据表格</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="basic_table.html">简单表格</a></li>
                      <li><a class="" href="dynamic_table.html">动态表格</a></li>
                      <li><a class="" href="QueryAction!teacherList">教师管理</a></li>
                  </ul>
              </li>
 

                  <li class="sub-menu active">
                      <a href="javascript:;" class="">
                          <i class="icon-file-alt"></i>
                          <span>竞赛管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a class="" href="TeacherAction!query_fund">新增经费支出</a></li>
                          <li><a class="" href="QueryAction!contestInfoList">新增选手/赛事/成绩管理</a></li>
                          <li><a class="" href="QueryAction!eventsList">管理赛事信息</a></li>
                          <li><a class="" href="QueryAction!contestantList">管理选手信息</a></li>
                          <li><a class="" href="about_us.html">关于我们</a></li>
                          <li><a class="" href="contact_us.html">联系我们</a></li>
                      </ul>
                  </li>
              <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-glass"></i>
                      <span>其他</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="lock.html">锁屏</a></li>
                      <li><a class="" href="invoice.html">购物单</a></li>
                      <li><a class="" href="pricing_tables.html">价目单</a></li>
                      <li><a class="" href="search_result.html">搜索展示</a></li>
                      <li><a class="" href="faq.html">帮助页面</a></li>
                      <li><a class="" href="404.html">404错误页面</a></li>
                      <li><a class="" href="500.html">500错误页面</a></li>
                  </ul>
              </li>

              <li class="sub-menu">
                  <a class="" href="javascript:;">
                      <i class="icon-trophy"></i>
                      <span>代码片段</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a href="general_portlet.html" class="">通用片段</a></li>
                      <li><a href="draggable_portlet.html" class="">可拖拽片段</a></li>
                  </ul>
              </li>

              <li class="sub-menu">
                  <a class="" href="javascript:;">
                      <i class="icon-map-marker"></i>
                      <span>地图</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a href="vector_map.html" class="">Vector地图</a></li>
                      <li><a href="google_map.html" class="">Google地图</a></li>
                  </ul>
              </li>

              <li class="sub-menu">
                  <a href="javascript:;" class="">
                      <i class="icon-cogs"></i>
                      <span>插件</span>
                      <span class="arrow"></span>
                  </a>
                  <ul class="sub">
                      <li><a class="" href="calendar.html">日历</a></li>
                      <li><a class="" href="grids.html">网格</a></li>
                      <li><a class="" href="chartjs.html">图表统计</a></li>
                      <li><a class="" href="flot_chart.html">Flot图表</a></li>
                      <li><a class="" href="gallery.html">相册</a></li>
                  </ul>
              </li>

              <li>
             	 <a href="TeacherAction!exit"> <i class="icon-user"></i>
            	  <span></span>退出</a>
              </li>
          </ul>
              <!-- END SIDEBAR MENU -->
          </div>
      </div>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE -->
      <div id="main-content">
         <!-- BEGIN PAGE CONTAINER-->
         <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
               <div class="span12">
                   <!-- BEGIN THEME CUSTOMIZER-->
                   <div id="theme-change" class="hidden-phone">
                       <i class="icon-cogs"></i>
                        <span class="settings">
                            <span class="text">Theme Color:</span>
                            <span class="colors">
                                <span class="color-default" data-style="default"></span>
                                <span class="color-green" data-style="green"></span>
                                <span class="color-gray" data-style="gray"></span>
                                <span class="color-purple" data-style="purple"></span>
                                <span class="color-red" data-style="red"></span>
                            </span>
                        </span>
                   </div>
                   <!-- END THEME CUSTOMIZER-->
                  <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                   <h3 class="page-title">
                     Blank
                   </h3>
                   <ul class="breadcrumb">
                       <li>
                           <a href="#">Home</a>
                           <span class="divider">/</span>
                       </li>
                       <li>
                           <a href="#">Sample Pages</a>
                           <span class="divider">/</span>
                       </li>
                       <li class="active">
                           Blank
                       </li>
                       <li class="pull-right search-wrap">
                           <form action="search_result.html" class="hidden-phone">
                               <div class="input-append search-input-area">
                                   <input class="" id="appendedInputButton" type="text">
                                   <button class="btn" type="button"><i class="icon-search"></i> </button>
                               </div>
                           </form>
                       </li>
                   </ul>
                   <!-- END PAGE TITLE & BREADCRUMB-->
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
             <div class="row-fluid">
                 <div class="span12">
                     <!-- BEGIN BLANK PAGE PORTLET-->
                     <div class="widget red">
                         <div class="widget-title">
                             <h4><i class="icon-edit"></i>已使用经费情况</h4>
                           <span class="tools">
                               <a href="javascript:;" class="icon-chevron-down"></a>
                               <a href="javascript:;" class="icon-remove"></a>
                           </span>
                         </div>
                         <div class="widget-body">
                <!-- 进度条 -->
        		<div id="progress2">
        		   <font>总经费：${sessionScope.fund.total}&nbsp&nbsp&nbsp&nbsp已使用：${sessionScope.fund.spend}</font>
        		    <div class="percent"></div>
       			     <div class="pbar"></div>
            		<div class="elapsed"></div>
      	  		</div>
                  </div>
                     </div>
                    <!-- BEGIN SAMPLE FORMPORTLET-->
                    <div class="widget green">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i>添加新的经费支出</h4>
                            <span class="tools">
                            <a href="javascript:;" class="icon-chevron-down"></a>
                            <a href="javascript:;" class="icon-remove"></a>
                            </span>
                        </div>
                        <div class="widget-body">
                            <!-- BEGIN FORM-->
                            <form action="TeacherAction!add_spend" class="form-horizontal">
							<font size=3 color=red>${requestScope.tips}</font>
                            <div class="control-group">
                                <label class="control-label">费用</label>
                                <div class="controls">
                                    <div class="input-prepend input-append">
                                        <span class="add-on">￥</span><input id="addSpend" name="addSpend" type="text" /><span class="add-on">RMB</span>
                                    </div>
                                </div>
                            </div>
                                <div class="control-group">
                                    <label class="control-label">费用分类</label>
                                    <div class="controls">
                                        <select name="event_id" tabindex="1" style="width:150pt">
                                        <c:forEach items="${sessionScope.eventsList}" var="ceve" varStatus="status">
                                            <option value=${ceve.id }>${ceve.contestname }</option>
                                        </c:forEach>	
                                        </select>
                                    </div>
                                </div>
                            <div class="control-group">
                                <label class="control-label">留言板</label>
                                <div class="controls">
                                    <textarea id="spendNote" name="spendNote" class="span6 " rows="1"  placeholder="其他需求请在这里留言！"></textarea>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">Submit</button>
                                <button type="button" class="btn">Cancel</button>
                            </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    
                    <!-- END SAMPLE FORM PORTLET-->
                 </div>
             </div>
            <!-- END PAGE CONTENT-->
         </div>
         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->

   <!-- BEGIN FOOTER -->
   <div id="footer">
       2013 &copy; Metro Lab Dashboard.
   </div>
   <!-- END FOOTER -->

   <!-- BEGIN JAVASCRIPTS -->
   <!-- Load javascripts at bottom, this will reduce page load time -->
   <!-- <script src="js/jquery-1.8.3.min.js"></script> -->
   <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
   <script src="assets/bootstrap/js/bootstrap.min.js"></script>
   <script src="js/jquery.scrollTo.min.js"></script>

   <!-- ie8 fixes -->
   <!--[if lt IE 9]>
   <script src="js/excanvas.js"></script>
   <script src="js/respond.js"></script>
   <![endif]-->

   <!--common script for all pages-->
   <script src="js/common-scripts.js"></script>
   <!-- END JAVASCRIPTS -->
<script>
$(document).ready(function(){
    jQuery.fn.anim_progressbar = function (aOptions) {
        // def values
        var iCms = 1000;
        var iMms = 60 * iCms;
        var iHms = 3600 * iCms;
        var iDms = 24 * 3600 * iCms;

        // def options
        var aDefOpts = {
            start: new Date(), // now
            finish: new Date().setTime(new Date().getTime() + 60 * iCms), // now + 60 sec
            interval: 100
        }
        var aOpts = jQuery.extend(aDefOpts, aOptions);
        var vPb = this;

        // each progress bar
        return this.each(
            function() {
                var iDuration = aOpts.finish - aOpts.start;
				var per = "<%=session.getAttribute("pers")%>";
				var note;
				if (per < 70)
					note = "剩余经费充足";
				else
					note = "剩余经费不足，请申请经费！";

                // calling original progressbar
                $(vPb).children('.pbar').progressbar();

                // looping process
                var vInterval = setInterval(
                    function(){
                        var iLeftMs = aOpts.finish - new Date(); // left time in MS
                        var iElapsedMs = new Date() - aOpts.start, // elapsed time in MS
                            iDays = parseInt(iLeftMs / iDms), // elapsed days
                            iHours = parseInt((iLeftMs - (iDays * iDms)) / iHms), // elapsed hours
                            iMin = parseInt((iLeftMs - (iDays * iDms) - (iHours * iHms)) / iMms), // elapsed minutes
                            iSec = parseInt((iLeftMs - (iDays * iDms) - (iMin * iMms) - (iHours * iHms)) / iCms), // elapsed seconds
                            iPerc = (iElapsedMs > 0) ? iElapsedMs / iDuration * 100 : 0; // percentages
						if (per != 0) {
                      		  // display current positions and progress
                     		  $(vPb).children('.percent').html('<b>'+iPerc.toFixed(1)+'%</b>');
                      		  $(vPb).children('.elapsed').html(iDays+' days '+iHours+'h:'+iMin+'m:'+iSec+'s</b>');
                       		 $(vPb).children('.pbar').children('.ui-progressbar-value').css('width', iPerc+'%');

                       		 // in case of Finish
                     		   if (iPerc >= per) {
                          		  clearInterval(vInterval);
                         		   $(vPb).children('.percent').html('已使用' + per + '<b>%</b>');
                          		  $(vPb).children('.elapsed').html(note);
                     		   }
                        }
                    } ,aOpts.interval
                );
            }
        );
    }

    // default mode
    $('#progress1').anim_progressbar();

    // from second #5 till 15
    var iNow = new Date().setTime(new Date().getTime() + 5); // now plus 5 secs
    var iEnd = new Date().setTime(new Date().getTime() + 5 * 1000); // now plus 15 secs
    $('#progress2').anim_progressbar({start: iNow, finish: iEnd, interval: 100});

    // we will just set interval of updating to 1 sec
    $('#progress3').anim_progressbar({interval: 1000});
});
</script>      
</body>
<!-- END BODY -->
</html>
