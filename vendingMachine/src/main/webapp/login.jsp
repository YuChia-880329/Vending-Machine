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
	
	<script type="text/javascript">

		let loginFormId = 'loginForm';
		let loginBtnId = 'loginBtn';

		let loginSuccessModalId = 'loginSuccess_modal';
		let loginSuccessOkBtnId = 'loginSuccess_okBtn';

		$(document).ready(readyFctn);

		function readyFctn(){

			$('#' + loginBtnId).click(loginBtnClicked);
		}

		function loginBtnClicked(){

			var ajaxUrl = '/vendingMachine/login';
			var dataJson = $('#' + loginFormId).serialize();
			
			$.ajax({
				url : ajaxUrl,
				method : 'POST',
				data : dataJson,
				contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
				dataType : 'json',
				success : function(data){

					if(data.hasAccount == 'false')
						noAccount();
					else if(data.passwordCorrect == 'false')
						incorrectPassword();
					else
						loginSuccess();
				}
			});
		}

		function noAccount(){

			alertModal('沒有此帳號', function(){}).show();
		}
		function incorrectPassword(){

			alertModal('密碼輸入錯誤', function(){}).show();
		}
		function loginSuccess(){

			var redirectUrl = '/vendingMachine/machine';
			
			$('#' + loginSuccessOkBtnId).click(function(){

				window.location.href = redirectUrl;
			});

			new bootstrap.Modal('#' + loginSuccessModalId, {}).show();
		}
	</script>
</head>
<body style="background-image: url('images_symbolicLink/background.jpg');">
	
	<div class="position-absolute top-50 start-50 translate-middle">
		<div>
			<form id="loginForm">
				<div class="mb-4">
					<label for="account" class="form-label">帳號</label>
					<input type="text" class="form-control" name="account" id="account" size="50" />
				</div>
				<div class="mb-4">
					<label for="password" class="form-label">密碼</label>
					<input type="password" class="form-control" name="pwd" id="password" size="50" />
				</div>
				<div>
					<button type="button" class="btn btn-outline-primary" id="loginBtn">登入</button>
				</div>
			</form>
		</div>
	</div>
	
	<div class="modal fade" id="loginSuccess_modal">
		<div class="modal-dialog msg-modal-dialog">
	    	<div class="modal-content msg-modal-content">
	      		<div class="modal-header msg-modal-header">
	        		<h4 class="modal-title">登入成功</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body msg-modal-body"></div>
	      		<div class="modal-footer msg-modal-footer">
		  			<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="loginSuccess_okBtn">確認</button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
	<%@ include file="modal.jsp" %>
</body>
</html>