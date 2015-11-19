<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
<title>豆你玩_用户绑定</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="中国电信-豆你玩">
<meta name="author" content="Your name">
<meta name="keywords" content="Your keywords">
<!-- Optimized mobile viewport -->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta content="telephone=no" name="format-detection">
<link rel="shortcut icon"
	href="http://wapgd.189.cn/TS/images/favicon1.ico">
<link rel="apple-touch-icon"
	href="http://wapgd.189.cn/TS/images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="http://wapgd.189.cn/TS/images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="http://wapgd.189.cn/TS/images/apple-touch-icon-114x114.png">
	<link href="css/stye.css" rel="stylesheet" type="text/css"/>
<!-- CSS -->
<!--load进同的CSS文件-->
<!--cssfile1.htm及cssfile2.htm文件为更换版本不冲突设计-->
<!--css file1-->
<link rel="stylesheet" type="text/css" media="all"
	href="css/reset-and-media.css">
<link rel="stylesheet" type="text/css" media="all"
	href="css/ctzt-page.css">
<link rel="stylesheet" type="text/css" media="all" href="css/gmu.css">
<script language="javascript" type="text/javascript"
	src="common/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/zepto.js"></script>


<!-- HTML5 IE Enabling Script -->
<!--[if lt IE 9]><script src="/TS/js/html5.js"></script>
  <![endif]-->
<style>
.gmu-media-detect {
	-webkit-transition: width 0.001ms;
	width: 0;
	position: relative;
	bottom: -999999px;
}

@media screen and (width: 1141px) {
	#gmu-media-detect0 {
		width: 100px;
	}
}
</style>
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
.title_back {
	float: left;
	position: absolute;
	top: 50%; left : 2.08333%; margin-top : -0.8em; display : inline-block;
	width : 1.8em; height : 2em; background :
	url("../img/order/ic_back.png") no-repeat scroll 0px 0px/ contain
	transparent;
	text-indent: -999em;
	top: 50%;
	left: 2.08333%;
	margin-top: -0.8em;
	display: inline-block;
	width: 1.8em;
	height: 2em;
	background: url("../img/order/ic_back.png") no-repeat scroll 0px 0px/contain
		transparent;
	left: 2.08333%;
	margin-top: -0.8em;
	display: inline-block;
	width: 1.8em;
	height: 2em;
	background: url("../img/order/ic_back.png") no-repeat scroll 0px 0px/contain
		transparent;
}
}
</style>
<script type="text/javascript">
	var InterValObj; // timer变量，控制时间
	var count = 60; // 间隔函数，1秒执行
	var curCount;// 当前剩余秒数
	jQuery(document).ready(function() {
		$("#btnSendCode").click(function() {
			sendMessage();
		});
	});
	function _validate() {
		var phonenum = document.getElementById("ipt_phone").value;
		var code = document.getElementById("ipt_smsvalidate").value;
		var zz = "^(13|15|18|17)\\d{9}$";
		if (phonenum.length == 0) {
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append("请填写手机号");
			return false;
		} else if (phonenum.match(zz) == null) {
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append("请填写正确格式的电信手机号！");
			return false;
		}
		else if (code.length == 0) {
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append("请填写验证码");
			return false;
		}
		$("#validate_form").hide();
		$("#load").show();
		$.get("${base}/binds/validate?phone=" + $("#ipt_phone").val() + "&code="
				+ $("#ipt_smsvalidate").val()+"&crm="+$("#crm").val() + "&source=" + $._urlArgument

				("src") + "&openId=" + $._urlArgument("openid")
				+ "&introducer=" + $("#ipt_tuijian").val(), function(result) {
			$("#load").hide();
			$("#validate_form").hide();
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append(result);
		});
	}
	function sendMessage() {
		$("#prompt").hide();
		var phonenum = document.getElementById("ipt_phone").value;
		var zz = "^(13|15|18|17)\\d{9}$";
		if (phonenum.length == 0) {
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append("请填写手机号");
			return false;
		} else if (phonenum.match(zz) == null) {
			$("#prompt").show();
			$("#msg").empty();
			$("#msg").append("请填写正确格式的电信手机号！");
			return false;
		} else {
			if (count == '' || count == null)
				count = 60;
			curCount = count;
			// 设置button效果，开始计时
			$("#btnSendCode").unbind("click");
			$("#btnSendCode").html("" + curCount + "秒");
			InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次
			// 向后台发送处理数据
			$.ajax({
				url : "${base}/binds/sendsms",
				type : "POST",
				data : {
					phone : $("#ipt_phone").val(),
					openId : $._urlArgument("openid"),
					source : $._urlArgument("source")
				},
				success : function(response, status, xhr) {
					if (status == "success") {
						$("#prompt").show();
						$("#msg").empty();
						$("#msg").append(response);
						curCount == 0;
						window.clearInterval(InterValObj);// 停止计时器
						$("#btnSendCode").click(function() {
							sendMessage();
						});// 启用按钮
						$("#btnSendCode").html("重新发送");
					}
				},
				error : function() {
					$("#prompt").show();
					$("#msg").empty();
					$("#msg").append("对不起，操作失败，请重试！");
					curCount == 0;
					window.clearInterval(InterValObj);// 停止计时器
					$("#btnSendCode").click(function() {
						sendMessage();
					});// 启用按钮
					$("#btnSendCode").html("重新发送");
				}
			});
		}

	}

	// timer处理函数
	function SetRemainTime() {
		if (curCount == 0) {
			window.clearInterval(InterValObj);// 停止计时器
			$("#btnSendCode").click(function() {
				sendMessage();
			});// 启用按钮
			$("#btnSendCode").html("重新发送");
		} else {
			curCount--;
			$("#btnSendCode").html("" + curCount + "秒");
		}
	}
	$.extend({
		_urlArgument : function(name) {
			//alert("进来了");
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");

			var r = window.location.search.substr(1).match(reg);

			if (r != null)
				return unescape(r[2]);
			return null;

		}
	});
</script>
</head>
<body>
 
	<div class="contain">
		
	 
		<!--间距-->
		<section>
		<div class="contain_con">
			 
			<div class="main_text h_auto">
               <span class="main_text_by bz">
                   <h5>操作步骤：</h5>
                   <p>1.点击获取验证码</p>
                   <p>2.在文本框中输入获取的短信验证码，点击取消绑定按钮即可。</p>
                </span>
           </div>
           
			<dd id="prompt" hidden="true" style="margin-bottom: 1em">
				<span class="f_20 se-3 bold " style="font-size: 1.4em">提示：</span><b
					class="se-e bold" id="msg" style="font- size: 1.4em"></b>
			</dd>
			<div id="load" class="mtb_20  tc hide">
				<img style="width: 8%" src="img/order/loading.gif" />
				<p class="tc f mt_10 se-6">正在努力办理...</p>
			</div>
			<div id="validate_form">
				<div class="search load hide"
					style="display: block; text-align: center; margin-left: 5px; margin-right: 10px">
					<input type="text" id="ipt_phone" placeholder="请输入绑定手机号码....."
						style="margin-bottom: 0.5em; width: 100%" /> <input type="text"
						id="ipt_smsvalidate" placeholder="请输入验证码....." style="width: 100%" />
				</div>
				<div class="break-line"></div>
				<!--/分隔线-->
				<div class="yzm">
				<div class="button_a" style="margin-top: 2em">
					<a id="btnSendCode"   href="#" style="color: #fff;"> 获取验证码 </a> 
					<a href="#" onclick="_validate()" style="color: #fff;"> 立即绑定 </a>
				</div>
				</div>
			</div>
		</div>
		</section>
	 
		 
			<div class="footer" style="margin-top: 20px">中国电信 | ICP证号:京ICP备09031924号</div>
	 
	 

	</div>
	<!--流式布局结束-->


	<style>
.mboxDefault {
	visibility: hidden;
}
</style>
</body>
</html>
