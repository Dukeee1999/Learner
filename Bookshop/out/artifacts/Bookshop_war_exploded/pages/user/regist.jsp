<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>

		<%@include file="/pages/common/head.jsp"%>

		<script type="text/javascript">
			$(function (){
				$("#code_img").click(function (){
					//为了保证不用缓存里的东西 每次刷新出新的验证码·
					this.src = "http://localhost:8080/Bookshop/kaptcha.jpg"+ new date();
				})
			});

			$(function(){
				$("#sub_btn").click(function(){
					var userName = $("#username").val();
					var userNamePatt = /^\w{5,12}$/
					if(!userNamePatt.test(userName)){
						$("span.errorMsg").text("用户名不合法！");
						return false;
					}
					var passWord = $("#password").val();
					var passWordPatt = /^\w{8,12}$/;
					if(!passWordPatt.test(passWord)){
						$("span.errorMsg").text("密码不合法！");
						return false;
					}
					var repass = $("#repwd").val();
					if(repass!=passWord){
						$("span.errorMsg").text("确认密码与密码不一致！");
						return false;
					}
					var mail = $("#email").val();
					var mailPatt = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
					if(!mailPatt.test(mail)){
						$("span.errorMsg").text("邮箱不合法！ ");
						return false;
					}
					var code = $("#code").val();
					code = $.trim(code);
					if(code==null||code==""){
						$("span.errorMsg").text("验证码不能为空! ");
						return false;
					}
					$("span.errorMsg").text("");

				});
			})

		</script>


	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.errorMsg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="POST">
									<input type = "hidden" name = "action" value = "regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.userName}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
									value = "${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name = "code" style="width: 80px;" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; height: 30px; ">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>