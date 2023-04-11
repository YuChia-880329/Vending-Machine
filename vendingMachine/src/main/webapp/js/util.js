
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
	
	function alertModal(modalMsg){
		
		var modalId = 'alert_modal';
		var modalMsgPId = 'alert_modal_msg';
		
		$('#' + modalMsgPId).text(modalMsg);
		
		return new bootstrap.Modal('#' + modalId, {});
	}
	
	
	// check
	let noValueMsgSuffix = ' 沒有值';
	let notNumberMsgSuffix = ' 不是數字';
	let notPositiveNumberMsgSuffix = ' 必須是正數';
	let notIntegerMsgSuffix = ' 必須是整數';
	
	function checkHasValue(inputId){
		
		var inputStr = $('#' + inputId).val();
		
		if(inputStr==null)
			return false;
		
		inputStr = inputStr.trim();
		return inputStr!='';
	}
	
	function checkIsNumber(inputId){
		
		var inputStr = $('#' + inputId).val();
		
		if(inputStr.includes('e'))
			return false;
			
		if(inputStr.includes('Infinity') || inputStr.includes('-Infinity'))
			return false;
		
		return !isNaN(inputStr);
	}
	
	function checkIsPositiveNumber(inputId){
		
		var inputStr = $('#' + inputId).val();
		
		var inputNumber = parseFloat(inputStr);
			
		return inputNumber>0;
	}
	
	function checkIsInteger(inputId){
		
		var inputStr = $('#' + inputId).val();
		
		return (parseFloat(inputStr)-parseInt(inputStr))==0;
	}
	
	
	function checkIntegerInput(inputId, name){
		
		if(checkHasValue(inputId)){
			
			if(!checkIsNumber(inputId)){
				
				alertModal(name + notNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsPositiveNumber(inputId)){
				
				alertModal(name + notPositiveNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsInteger(inputId)){
				
				alertModal(name + notIntegerMsgSuffix).show();
				return false;
			}
		}
		
		return true;
	}
	
	function checkIntegerInputMinMax(minInputId, minInputName, maxInputId, maxInputName){
		
		if(checkHasValue(minInputId) && checkHasValue(maxInputId)){
			
			var minInputStr = $('#' + minInputId).val();
			var maxInputStr = $('#' + maxInputId).val();
			
			if(parseInt(minInputStr) > parseInt(maxInputStr)){
				
				alertModal(minInputName + ' 必須比 ' + maxInputName + ' 小或相等').show();
				return false;
			}
		}
		
		return true;
	}
	