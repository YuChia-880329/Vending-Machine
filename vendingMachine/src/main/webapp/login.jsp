<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-登入</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/common.css">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/util.js"></script>
	<script src="js/login.js"></script>
	
	<script type="text/javascript">

		$(document).ready(readyFctn);

		function readyFctn(){

			showMsg();
			$('#' + loginBtnId).click(loginBtnClicked);
		}

	</script>
	<style type="text/css">
		.html-body{
		
			background-image: url('${vo.background.imagePath}');
		}
	</style>
</head>
<body class="html-body">
	
	<div class="position-absolute top-50 start-50 translate-middle">
		<div>
			<form id="loginForm">
				<div class="mb-4">
					<label for="loginForm_accountInput" class="form-label">帳號</label>
					<input type="text" class="form-control" name="account" id="loginForm_accountInput" size="50" />
				</div>
				<div class="mb-4">
					<label for="loginForm_passwordInput" class="form-label">密碼</label>
					<input type="password" class="form-control" name="pwd" id="loginForm_passwordInput" size="50" />
				</div>
				<div>
					<button type="button" class="btn btn-outline-primary" id="loginBtn">登入</button>
				</div>
			</form>
		</div>
	</div>
	
	<input type="hidden" id="notLoginMsg_input" value="${vo.notLoginMsg.hasMsg}" />
	

	<%@ include file="login_modal.jsp" %>
	<%@ include file="modal.jsp" %>
</body>
</html>