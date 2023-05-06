
	// modal
	function confirmModalId(modalMsg, okBtnFctn, cancelBtnFctn){
		
		var modalId = 'confirmModal';
		var modalMsgId = 'confirmModal_msg';
		var okBtnId = 'confirmModal_okBtn';
		var cancelBtnId = 'confirmModal_cancelBtn';
		
		$('#' + modalMsgId).text(modalMsg);
		
		if(okBtnFctn!=undefined && okBtnFctn!=null){
			
			$('#' + okBtnId).off('click');
			$('#' + okBtnId).click(okBtnFctn);
		}

		if(cancelBtnFctn != undefined){
			
			$('#' + cancelBtnId).off('click');
			$('#' + cancelBtnId).click(cancelBtnFctn);
		}
		
		return modalId;
	}
	function confirmModal(modalMsg, okBtnFctn, cancelBtnFctn){
		
		var modalId = 'confirmModal';
		var modalMsgId = 'confirmModal_msg';
		var okBtnId = 'confirmModal_okBtn';
		var cancelBtnId = 'confirmModal_cancelBtn';
		
		$('#' + modalMsgId).text(modalMsg);
		
		if(okBtnFctn!=undefined && okBtnFctn!=null){
			
			$('#' + okBtnId).off('click');
			$('#' + okBtnId).click(okBtnFctn);
		}

		if(cancelBtnFctn != undefined){
			
			$('#' + cancelBtnId).off('click');
			$('#' + cancelBtnId).click(cancelBtnFctn);
		}

		
		return new bootstrap.Modal('#' + modalId, {});
	}
	
	function alertModalId(modalMsg, okBtnFctn){
		
		var modalId = 'alertModal';
		var modalMsgId = 'alertModal_msg';
		var okBtnId = 'alertModal_okBtn';
		
		$('#' + modalMsgId).text(modalMsg);
		
		if(okBtnFctn != undefined){
			
			$('#' + okBtnId).off('click');
			$('#' + okBtnId).click(okBtnFctn);
		}
		
		return modalId;
	}
	function alertModal(modalMsg, okBtnFctn){
		
		var modalId = 'alertModal';
		var modalMsgId = 'alertModal_msg';
		var okBtnId = 'alertModal_okBtn';
		
		$('#' + modalMsgId).text(modalMsg);
		
		if(okBtnFctn != undefined){
			
			$('#' + okBtnId).off('click');
			$('#' + okBtnId).click(okBtnFctn);
		}
		
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
	
	
	// template message
	function cloneTmpl(templateId, bodyId, contents){
		
		var clonedBody = $('#' + templateId).clone()[0].content;
				
		$('#' + bodyId).append(clonedBody);
		
		contents.forEach(function(currentValue){
			
			$('#' + bodyId + ' #' + currentValue.oldId).attr('id', currentValue.newId);
			$('#' + currentValue.newId).text(currentValue.value);
		});
	}
	
	function modalPrepare(templateId, bodyId, elements, okBtnId, okBtnClickedFctn){
		
		$('#' + bodyId).empty();
		
		elements.forEach(function(currentValue){
			
			cloneTmpl(templateId, bodyId, currentValue.contents);
		});
		
		$('#' + okBtnId).off('click');
		$('#' + okBtnId).click(okBtnClickedFctn);
	}

	