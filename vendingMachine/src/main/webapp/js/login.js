		
	let notLoginMsgInputId = 'notLoginMsg_input';
	
	let loginFormId = 'loginForm';
	let loginFormAccountInputId = 'loginForm_accountInput';
	let loginFormPasswordInputId = 'loginForm_passwordInput';
	let loginBtnId = 'loginBtn';

	let loginSuccessModalId = 'loginSuccess_modal';
	let loginSuccessOkBtnId = 'loginSuccess_okBtn';
	
	
	// not login msg
	function showMsg(){
		
		var hasMsg = $('#' + notLoginMsgInputId).val();
		
		if(hasMsg == 'true'){
			
			alertModal('請先登入', function(){}).show();
		}
	}
	
	// login
	function loginBtnClicked(){

		if(loginInputCheck()){
			
			var ajaxUrl = '/vendingMachine/loginAction';
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

	}
	
	function loginInputCheck(){
		
		return checkNotNull(loginFormAccountInputId, '帳號') 
				&& checkNotNull(loginFormPasswordInputId, '密碼');
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
	
	