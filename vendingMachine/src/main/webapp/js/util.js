
// modal
function confirmModal(titleText, bodyHtml, okBtnText, okBtnFctn){
	
	var modalId = 'confirm_modal';
	var titleH5Id = 'confirm_modal_title';
	var bodyDivId = 'confirm_modal_body';
	var okBtnId = 'confirm_modal_ok_btn';
	
	$('#' + titleH5Id).text(titleText);
	$('#' + bodyDivId).html(bodyHtml);
	$('#' + okBtnId).text(okBtnText);
	$('#' + okBtnId).off('click');
	$('#' + okBtnId).click(okBtnFctn);
	
	return new bootstrap.Modal('#' + modalId, {});
}

function alertModal(titleText, bodyHtml){
	
	var modalId = 'alert_modal';
	var titleH5Id = 'alert_modal_title';
	var bodyDivId = 'alert_modal_body';
	
	$('#' + titleH5Id).text(titleText);
	$('#' + bodyDivId).html(bodyHtml);
	
	return new bootstrap.Modal('#' + modalId, {});
}