
	// modal
	function confirmModal(modalMsg, okBtnFctn){
		
		var modalId = 'confirm_modal';
		var modalMsgId = 'confirm_modal_msg';
		var okBtnId = 'confirm_modal_ok_btn';
		
		$('#' + modalMsgId).html(modalMsg);
		$('#' + okBtnId).off('click');
		$('#' + okBtnId).click(okBtnFctn);
		
		return new bootstrap.Modal('#' + modalId, {});
	}
	
	function alertModal(modalMsg){
		
		var modalId = 'alert_modal';
		var modalMsgPId = 'alert_modal_msg';
		
		$('#' + modalMsgPId).html(modalMsg);
		
		return new bootstrap.Modal('#' + modalId, {});
	}
	
	
	// check
	let noValueMsgSuffix = '請輸入 ';
	let notNumberMsgSuffix = ' 不是數字';
	let notNonNegativeNumberMsgSuffix = ' 必須大於等於0';
	let notPositiveNumberMsgSuffix = ' 必須大於0';
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
	
	function checkIsNonNegativeNumber(inputId){
		
		var inputStr = $('#' + inputId).val();
		
		var inputNumber = parseFloat(inputStr);
			
		return inputNumber>=0;
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
	
	
	function checkNotNull(inputId, name){
		
		if(!checkHasValue(inputId)){
			
			alertModal(noValueMsgSuffix + name).show();
			return false;
		}
		return true;
	}
	function checkNotNullNonNegativeIntegerInput(inputId, name){
		
		if(checkHasValue(inputId)){
			
			if(!checkIsNumber(inputId)){
				
				alertModal(name + notNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsNonNegativeNumber(inputId)){
				
				alertModal(name + notNonNegativeNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsInteger(inputId)){
				
				alertModal(name + notIntegerMsgSuffix).show();
				return false;
			}
		}else{
			
			alertModal(noValueMsgSuffix + name).show();
			return false;
		}
		
		return true;
	}
	function checkNonNegativeIntegerInput(inputId, name){
		
		if(checkHasValue(inputId)){
			
			if(!checkIsNumber(inputId)){
				
				alertModal(name + notNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsNonNegativeNumber(inputId)){
				
				alertModal(name + notNonNegativeNumberMsgSuffix).show();
				return false;
			}
			else if(!checkIsInteger(inputId)){
				
				alertModal(name + notIntegerMsgSuffix).show();
				return false;
			}
		}
		
		return true;
	}
	function checkNotNullPositiveIntegerInput(inputId, name){
		
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
		}else{
			
			alertModal(noValueMsgSuffix + name).show();
			return false;
		}
		
		return true;
	}
	function checkPositiveIntegerInput(inputId, name){
		
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
	function checkRadio(radioIds, radioName){
		
		var hasValue = false;
		radioIds.forEach(function(currentValue){
			
			hasValue = hasValue || $('#' + currentValue).prop('checked');
		});
		if(!hasValue){
			
			alertModal('請選擇 ' + radioName).show();
			return false;
		}else{
			
			return true;
		}
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
	
	