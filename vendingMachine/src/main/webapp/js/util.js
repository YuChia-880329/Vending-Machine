
	// modal
	function confirmModal(modalMsg, okBtnFctn){
		
		var modalId = 'confirm_modal';
		var modalMsgPId = 'confirm_modal_msg';
		var okBtnId = 'confirm_modal_ok_btn';
		
		$('#' + modalMsgPId).text(modalMsg);
		$('#' + okBtnId).off('click');
		$('#' + okBtnId).click(okBtnFctn);
		
		return new bootstrap.Modal('#' + modalId, {});
	}
	
	function alertModal(modalMsg, okBtnFctn){
		
		var modalId = 'alert_modal';
		var modalMsgPId = 'alert_modal_msg';
		var okBtnId = 'alert_modal_ok_btn';
		
		$('#' + modalMsgPId).text(modalMsg);
		$('#' + okBtnId).off('click');
		$('#' + okBtnId).click(okBtnFctn);
		
		return new bootstrap.Modal('#' + modalId, {});
	}