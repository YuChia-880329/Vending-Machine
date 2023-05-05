	
	// id
	let currentUrl = window.location.href;
	let templateSuffix = 'tmpl';
	
	


	let addShoppingCartIllegalMsgModalId = 'addShoppingCart_illegalMsg_modal';
	let addShoppingCartIllegalMsgBodyDivId = 'addShoppingCart_illegalMsg_bodyDiv';
	let addShoppingCartIllegalMsgOkBtnId = 'addShoppingCart_illegalMsg_okBtn';
	let addShoppingCartIllegalMsgBodyIdPrefix = 'addShoppingCart_illegalMsg_body_';
	let addShoppingCartIllegalMsgBodyNameSpanIdPrefix = 'addShoppingCart_illegalMsg_body_nameSpan_';
	
	let addShoppingCartLegalMsgModalId = 'addShoppingCart_legalMsg_modal';
	let addShoppingCartLegalMsgBodyDivId = 'addShoppingCart_legalMsg_bodyDiv';
	let addShoppingCartLegalMsgOkBtnId = 'addShoppingCart_legalMsg_okBtn';
	let addShoppingCartLegalMsgBodyIdPrefix = 'addShoppingCart_legalMsg_body_';
	let addShoppingCartLegalMsgBodyNameSpanIdPrefix = 'addShoppingCart_legalMsg_body_nameSpan_';
	let addShoppingCartLegalMsgBodyAddQuantitySpanIdPrefix = 'addShoppingCart_legalMsg_body_addQuantitySpan_';


	let clearShoppingCartMsgModalId = 'clearShoppingCart_msg_modal';
	let clearShoppingCartMsgOkBtnId = 'clearShoppingCart_msg_okBtn';
	
	
	let updateShoppingCartIllegalMsgModalId = 'updateShoppingCart_illegalMsg_modal';
	let updateShoppingCartIllegalMsgBodyDivId = 'updateShoppingCart_illegalMsg_bodyDiv';
	let updateShoppingCartIllegalMsgOkBtnId = 'updateShoppingCart_illegalMsg_okBtn';
	let updateShoppingCartIllegalMsgBodyIdPrefix = 'updateShoppingCart_illegalMsg_body_';
	let updateShoppingCartIllegalMsgBodyNameSpanIdPrefix = 'updateShoppingCart_illegalMsg_body_nameSpan_';

	let updateShoppingCartLegalMsgModalId = 'updateShoppingCart_legalMsg_modal';
	let updateShoppingCartLegalMsgBodyDivId = 'updateShoppingCart_legalMsg_bodyDiv';
	let updateShoppingCartLegalMsgOkBtnId = 'updateShoppingCart_legalMsg_okBtn';
	let updateShoppingCartLegalMsgBodyIdPrefix = 'updateShoppingCart_legalMsg_body_';
	let updateShoppingCartLegalMsgBodyNameSpanIdPrefix = 'updateShoppingCart_legalMsg_body_nameSpan_';
	let updateShoppingCartLegalMsgBodyBuyQuantitySpanIdPrefix = 'updateShoppingCart_legalMsg_body_buyQuantitySpan_';
	
	
	let checkoutMoneyIllegalMsgModalExistInputId = 'checkout_money_illegal_msg_modal_exist_input';
	let checkoutMoneyIllegalMsgModalId = 'checkout_money_illegal_msg_modal';
	let checkoutMoneyIllegalMsgOkBtnId = 'checkout_money_illegal_msg_ok_btn';
	
	
	let filterForm = 'filter_form';
	let filterBtnId = 'filter_btn';
	let allGoodsBtnId = 'all_goods_btn';

	let goodsEntryIdInputIdPrefix = 'goods_entry_id_';
	let goodsEntryNameInputIdPrefix = 'goods_entry_name_';
	let goodsEntryPriceInputIdPrefix = 'goods_entry_price_';
	let goodsEntryBuyQuantityInputIdPrefix = 'goods_entry_buy_quantity_';
	let goodsEntryQuantityInputIdPrefix = 'goods_entry_quantity_';
	
	
	let clearShoppingCartBtnId = 'clear_shopping_cart_btn';
	let clearShoppingCartFormId = 'clear_shopping_cart_form';
	let clearShoppingCartDataInputId = 'clear_shopping_cart_data_input';
	
	
	let addShoppingCartBtnId = 'add_shopping_cart_btn';
	let addShoppingCartModalId = 'add_shopping_cart_modal';
	let addShoppingCartOkBtnId = 'add_shopping_cart_ok_btn';
	let addShoppingCartBodyContentDivId = 'add_shopping_cart_body_content_div';
	let addShoppingCartBodyContentTmplId = 'add_shopping_cart_body_content_tmpl';
	let addShoppingCartBodyContentNameSpanId = 'add_shopping_cart_body_content_name_span_';
	let addShoppingCartBodyContentBuyQuantitySpanId = 'add_shopping_cart_body_content_buy_quantity_span_';
	let addShoppingCartBodyContentPriceSpanId = 'add_shopping_cart_body_content_price_span_';
	
	
	let shoppingCartGoodsGoodsCountInputId = 'shopping_cart_goods_goods_count_input';
	let shoppingCartGoodsNameInputIdPrefix = 'shopping_cart_goods_name_input_';
	let shoppingCartGoodsQuantityInputIdPrefix = 'shopping_cart_goods_quantity_input_';
	let shoppingCartGoodsIdInputIdPrefix = 'shopping_cart_goods_id_input_';
	let shoppingCartGoodsBuyQuantityInputIdPrefix = 'shopping_cart_goods_buy_quantity_input_';
	let updateShoppingCartBtnId = 'update_shopping_cart_btn';
	
	
	let checkoutPaidMoneyInputId = 'checkout_paid_money_input';
	let checkoutBtnId = 'checkout_btn';
	let checkoutFormId = 'checkout_form';
	let checkoutDataInputId = 'checkout_data_input';
	let checkoutAddShoppingCartModalId = 'checkout_add_shopping_cart_modal';
	let checkoutAddShoppingCartModalOkBtnId = 'checkout_add_shopping_cart_modal_ok_btn';
	let checkoutAddShoppingCartModalCancelBtnId = 'checkout_add_shopping_cart_modal_cancel_btn';
	
	
	let goBackendBtnId = 'go_backend_btn';
	let logoutBtnId = 'logout_btn';
	

	
	// show message
	function showMsgModal(){
	
		modalIdObjs = [];
		
		var modalIdObjsFctn = function(existId, modalId, okBtnId){
			
			return {
				existId : existId,
				modalId : modalId,
				okBtnId : okBtnId
			};
		};
	
		modalIdObjs[0] = modalIdObjsFctn(
			checkoutMoneyIllegalMsgModalExistInputId,
			checkoutMoneyIllegalMsgModalId,
			checkoutMoneyIllegalMsgOkBtnId
		);
		showMsgModalArray(modalIdObjs);
	}
	function showMsgModalArray(modalIdObjs){
		
		var firstIndex = -1;
		var lastIndex = -1;
		modalIdObjs.forEach(function(element, index, array){
			
			if($('#' + element.existId).val() == 'true'){
				
				if(firstIndex <= -1)
					firstIndex = index;
				
				if(lastIndex <= -1){
					
					lastIndex = index;
				}else{
					
					var lastElement = array[lastIndex];
					$('#' + lastElement.okBtnId).click(function(){
						
						new bootstrap.Modal('#' + element.modalId, {}).show();
					});
				}
				
				$('#' + element.okBtnId).attr('data-bs-dismiss', 'modal');
			}
		});
	
		
		if(firstIndex >= 0)
			new bootstrap.Modal('#' + modalIdObjs[firstIndex].modalId, {}).show();
	}
	
	
	// filter
	function filterBtnClicked(){
		
		$('#' + filterForm).submit();
	}
	
	
	// all goods
	function allGoodsBtnClicked(){
		
		confirmModal('即將更新頁面至全部商品', function(){
			
			window.location.replace("/vendingMachine/machine");
		}).show();
	}
	
	
	// add shopping cart
	function addShoppingCartBtnClicked(){
	
		if(addShoppingCartInputCheck()){
			
			$('#' + addShoppingCartBodyContentDivId).empty();
			
			var addShoppingCartGoodsArray = [];
			var index = 0;
			
			for(i=1; i<=6; i++){
	
				var addQuantity = $('#' + goodsEntryBuyQuantityInputIdPrefix + i).val();
				if(addQuantity == undefined)
					break;
				
				if(addQuantity!='' && addQuantity>0){
	
					var name = $('#' + goodsEntryNameInputIdPrefix + i).val();
					var price = $('#' + goodsEntryPriceInputIdPrefix + i).val();
					var quantity = $('#' + goodsEntryQuantityInputIdPrefix + i).val();
	
					var bodyContent = $('#' + addShoppingCartBodyContentTmplId).clone()[0].content;
					$('#' + addShoppingCartBodyContentDivId).append(bodyContent);
	
					
					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentNameSpanId).attr('id', addShoppingCartBodyContentNameSpanId + i);
					$('#' + addShoppingCartBodyContentNameSpanId + i).text(name);
	
					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentBuyQuantitySpanId).attr('id', addShoppingCartBodyContentBuyQuantitySpanId + i);
					$('#' + addShoppingCartBodyContentBuyQuantitySpanId + i).text(addQuantity);
	
					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentPriceSpanId).attr('id', addShoppingCartBodyContentPriceSpanId + i);
					$('#' + addShoppingCartBodyContentPriceSpanId + i).text(price);
	
					var id = $('#' + goodsEntryIdInputIdPrefix + i).val();
					addShoppingCartGoodsArray[index] = {
						id : id,
						name : name,
						addQuantity : addQuantity,
						quantity : quantity
					}
					index++;
				}
			}
			
			var addShoppingCartVO = {
				addShoppingCartGoodsArray : addShoppingCartGoodsArray
			}
	
			
			$('#' + addShoppingCartOkBtnId).off('click');
			$('#' + addShoppingCartOkBtnId).click(function(){
				
				addShoppingCartAjax(addShoppingCartVO);
			});
			
			new bootstrap.Modal('#' + addShoppingCartModalId, {}).show();
		}
	}
	function addShoppingCartInputCheck(){
		
		var pass = true;
		
		for(i=1; i<=6; i++){
			
			var name = $('#' + goodsEntryNameInputIdPrefix + i).val();
			
			if(name == undefined)
				break;
				
			pass = checkNotNullNonNegativeIntegerInput(goodsEntryBuyQuantityInputIdPrefix + i, name + '的購買數量') && pass;
		}
		
		return pass;
	}
	function addShoppingCartAjax(addShoppingCartVO){
	
		var ajaxUrl = '/vendingMachine/machine/tempAddShoppingCart';
		var dataJson = JSON.stringify(addShoppingCartVO);
		
		$.ajax({
			url : ajaxUrl,
			method : 'POST',
			data : dataJson,
			contentType : 'text/plain',
			dataType : 'json',
			success : function(data){
				
				showAddShoppingMsgs(data.addShoppingCartIllegalMsg, data.addShoppingCartLegalMsg);
			}
		});
	}
	
	function showAddShoppingMsgs(addShoppingCartIllegalMsg, addShoppingCartLegalMsg){
		
		if(addShoppingCartIllegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<addShoppingCartIllegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					addShoppingCartIllegalMsgBodyNameSpanIdPrefix + templateSuffix,
					addShoppingCartIllegalMsgBodyNameSpanIdPrefix + i,
					addShoppingCartIllegalMsg.lines[i].name
				);
			}
			modalPrepare(addShoppingCartIllegalMsgBodyIdPrefix + templateSuffix, 
						addShoppingCartIllegalMsgBodyDivId,
						elements,
						addShoppingCartIllegalMsgOkBtnId,
						function(){
							showAddShoppingCartLegalMsg(addShoppingCartLegalMsg);
						});
						
			new bootstrap.Modal('#' + addShoppingCartIllegalMsgModalId, {}).show();
		}else{
			
			showAddShoppingCartLegalMsg(addShoppingCartLegalMsg);
		}
	}
	function showAddShoppingCartLegalMsg(addShoppingCartLegalMsg){
		
		if(addShoppingCartLegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue, oldAddQuantityId, newAddQuantityId, addQuantityValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						},
						{
							oldId : oldAddQuantityId,
							newId : newAddQuantityId, 
							value : addQuantityValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<addShoppingCartLegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					addShoppingCartLegalMsgBodyNameSpanIdPrefix + templateSuffix,
					addShoppingCartLegalMsgBodyNameSpanIdPrefix + i,
					addShoppingCartLegalMsg.lines[i].name,
					addShoppingCartLegalMsgBodyAddQuantitySpanIdPrefix + templateSuffix,
					addShoppingCartLegalMsgBodyAddQuantitySpanIdPrefix + i,
					addShoppingCartLegalMsg.lines[i].addQuantity
				);
			}
			modalPrepare(addShoppingCartLegalMsgBodyIdPrefix + templateSuffix, 
						addShoppingCartLegalMsgBodyDivId,
						elements,
						addShoppingCartLegalMsgOkBtnId,
						function(){
							window.location.href = currentUrl;
						});
			
			
			new bootstrap.Modal('#' + addShoppingCartLegalMsgModalId, {}).show();
		}else{
			
			window.location.href = currentUrl;
		}
	}


	// clear shopping cart
	function clearShoppingCartBtnClicked(){
		
		confirmModal('即將清空購物車', function(){
			
			clearShoppingCartAjax()
		}).show();
	}
	function clearShoppingCartAjax(){
		
		var ajaxUrl = '/vendingMachine/machine/tempClearShoppingCart';
		
		$.ajax({
			url : ajaxUrl,
			method : 'POST',
			success : function(){
				
				showClearShoppingMsg();
			}
		});
	}
	function showClearShoppingMsg(){
		
		$('#' + clearShoppingCartMsgOkBtnId).click(function(){
			
			window.location.href = currentUrl;
		});
		
		new bootstrap.Modal('#' + clearShoppingCartMsgModalId, {}).show();
	}
	

	
	
	// update shopping cart
	function updateShoppingCartBtnClicked(){
	
		confirmModal('即將更新購物車', function(){
	
			var goodsFctn = function(id, name, buyQuantity, quantity){
				
				return {
					id : id,
					name : name,
					buyQuantity : buyQuantity,
					quantity, quantity
				};
			};
			
			var goodsCount = $('#' + shoppingCartGoodsGoodsCountInputId).val();
		
			if(updateShoppingCartInputChecked(goodsCount)){
				
				var goodsList = [];
				for(i=1; i<=goodsCount; i++){
					
					var id = $('#' + shoppingCartGoodsIdInputIdPrefix + i).val();
					var name = $('#' + shoppingCartGoodsNameInputIdPrefix + i).val();
					var buyQuantity = $('#' + shoppingCartGoodsBuyQuantityInputIdPrefix + i).val();
					var quantity = $('#' + shoppingCartGoodsQuantityInputIdPrefix + i).val();
					
					goodsList[i-1] = goodsFctn(id, name, buyQuantity, quantity);
				}
				
				var updateShoppingCartVO = {
					updateShoppingCartGoodsArray : goodsList
				}
				
				updateShoppingCartAjax(updateShoppingCartVO);
			}
		}).show();
	}
	function updateShoppingCartInputChecked(goodsCount){
		
		var pass = true;
		
		for(i=1; i<=goodsCount; i++){
			
			var name = $('#' + shoppingCartGoodsNameInputIdPrefix + i).val();
			pass = checkNotNullNonNegativeIntegerInput(shoppingCartGoodsBuyQuantityInputIdPrefix + i, name + '的購買數量') && pass;
		}
		
		return pass;
	}
	function updateShoppingCartAjax(updateShoppingCartVO){
	
		var ajaxUrl = '/vendingMachine/machine/tempUpdateShoppingCart';
		var dataJson = JSON.stringify(updateShoppingCartVO);
		
		$.ajax({
			url : ajaxUrl,
			method : 'POST',
			data : dataJson,
			contentType : 'text/plain',
			dataType : 'json',
			success : function(data){
				
				showUpdateShoppingMsgs(data.updateShoppingCartIllegalMsg, data.updateShoppingCartLegalMsg);
			}
		});
	}
	
	function showUpdateShoppingMsgs(updateShoppingCartIllegalMsg, updateShoppingCartLegalMsg){
		
		if(updateShoppingCartIllegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<updateShoppingCartIllegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					updateShoppingCartIllegalMsgBodyNameSpanIdPrefix + templateSuffix,
					updateShoppingCartIllegalMsgBodyNameSpanIdPrefix + i,
					updateShoppingCartIllegalMsg.lines[i].name
				);
			}
			modalPrepare(updateShoppingCartIllegalMsgBodyIdPrefix + templateSuffix, 
						updateShoppingCartIllegalMsgBodyDivId,
						elements,
						updateShoppingCartIllegalMsgOkBtnId,
						function(){
							showUpdateShoppingCartLegalMsg(updateShoppingCartLegalMsg);
						});
						
			new bootstrap.Modal('#' + updateShoppingCartIllegalMsgModalId, {}).show();
		}else{
			
			showUpdateShoppingCartLegalMsg(updateShoppingCartLegalMsg);
		}
	}
	function showUpdateShoppingCartLegalMsg(updateShoppingCartLegalMsg){
		
		if(updateShoppingCartLegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue, oldBuyQuantityId, newBuyQuantityId, buyQuantityValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						},
						{
							oldId : oldBuyQuantityId,
							newId : newBuyQuantityId, 
							value : buyQuantityValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<updateShoppingCartLegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					updateShoppingCartLegalMsgBodyNameSpanIdPrefix + templateSuffix,
					updateShoppingCartLegalMsgBodyNameSpanIdPrefix + i,
					updateShoppingCartLegalMsg.lines[i].name,
					updateShoppingCartLegalMsgBodyBuyQuantitySpanIdPrefix + templateSuffix,
					updateShoppingCartLegalMsgBodyBuyQuantitySpanIdPrefix + i,
					updateShoppingCartLegalMsg.lines[i].buyQuantity
				);
			}
			modalPrepare(updateShoppingCartLegalMsgBodyIdPrefix + templateSuffix, 
						updateShoppingCartLegalMsgBodyDivId,
						elements,
						updateShoppingCartLegalMsgOkBtnId,
						function(){
							window.location.href = currentUrl;
						});
			
			
			new bootstrap.Modal('#' + updateShoppingCartLegalMsgModalId, {}).show();
		}else{
			
			window.location.href = currentUrl;
		}
	}
	
	

	// checkout
	function checkoutBtnClicked(){
	
		var needAddShoppingCart = false;
		var addShoppingCartGoodsArray = [];
		var index = 0;
		
		for(i=1; i<=6; i++){
	
			var addQuantity = $('#' + goodsEntryBuyQuantityInputIdPrefix + i).val();
			
			if(addQuantity == undefined)
				break;
			if(addQuantity!='' && addQuantity>0){
	
				needAddShoppingCart = true;
				
				var name = $('#' + goodsEntryNameInputIdPrefix + i).val();
				var quantity = $('#' + goodsEntryQuantityInputIdPrefix + i).val();
				var id = $('#' + goodsEntryIdInputIdPrefix + i).val();
	
				addShoppingCartGoodsArray[index] = {
					id : id,
					name : name,
					addQuantity : addQuantity,
					quantity : quantity
				}
				index++;
			}
		}
	
		var addShoppingCartVO = {
			addShoppingCartGoodsArray : addShoppingCartGoodsArray
		};
	
		if(needAddShoppingCart){
	
			$('#' + checkoutAddShoppingCartModalOkBtnId).click(function(){
	
				checkoutAddShoppingCartAjax(addShoppingCartVO)
			});
			
	
			$('#' + checkoutAddShoppingCartModalCancelBtnId).click(function(){
	
				showCheckoutShoppingCartModal()
			});
			
			new bootstrap.Modal('#' + checkoutAddShoppingCartModalId, {}).show();
		}else{
	
			showCheckoutShoppingCartModal();
		}
	}
	function checkoutAddShoppingCartAjax(addShoppingCartVO){
	
		var ajaxUrl = '/vendingMachine/machine/tempAddShoppingCart';
		var dataJson = JSON.stringify(addShoppingCartVO);
		
		$.ajax({
			url : ajaxUrl,
			method : 'POST',
			data : dataJson,
			contentType : 'text/plain',
			dataType : 'json',
			success : function(data){
				
				showCheckoutAddShoppingMsgs(data.addShoppingCartIllegalMsg, data.addShoppingCartLegalMsg);
			}
		});
	}
	function showCheckoutAddShoppingMsgs(addShoppingCartIllegalMsg, addShoppingCartLegalMsg){
		
		if(addShoppingCartIllegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<addShoppingCartIllegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					addShoppingCartIllegalMsgBodyNameSpanIdPrefix + templateSuffix,
					addShoppingCartIllegalMsgBodyNameSpanIdPrefix + i,
					addShoppingCartIllegalMsg.lines[i].name
				);
			}
			modalPrepare(addShoppingCartIllegalMsgBodyIdPrefix + templateSuffix, 
						addShoppingCartIllegalMsgBodyDivId,
						elements,
						addShoppingCartIllegalMsgOkBtnId,
						function(){
							showAddShoppingCartLegalMsg(addShoppingCartLegalMsg);
						});
						
			new bootstrap.Modal('#' + addShoppingCartIllegalMsgModalId, {}).show();
		}else{
			
			showAddShoppingCartLegalMsg(addShoppingCartLegalMsg);
		}
	}
	function showCheckoutAddShoppingCartLegalMsg(addShoppingCartLegalMsg){
		
		if(addShoppingCartLegalMsg.hasMsg == 'true'){
			
			var generateElement = function(oldNameId, newNameId, nameValue, oldAddQuantityId, newAddQuantityId, addQuantityValue){
				
				return {
					contents : [
						{
							oldId : oldNameId,
							newId : newNameId, 
							value : nameValue
						},
						{
							oldId : oldAddQuantityId,
							newId : newAddQuantityId, 
							value : addQuantityValue
						}
					]
				};
			}
			var elements = [];
			for(i=0; i<addShoppingCartLegalMsg.lines.length; i++){
				
				elements[i] = generateElement(
					addShoppingCartLegalMsgBodyNameSpanIdPrefix + templateSuffix,
					addShoppingCartLegalMsgBodyNameSpanIdPrefix + i,
					addShoppingCartLegalMsg.lines[i].name,
					addShoppingCartLegalMsgBodyAddQuantitySpanIdPrefix + templateSuffix,
					addShoppingCartLegalMsgBodyAddQuantitySpanIdPrefix + i,
					addShoppingCartLegalMsg.lines[i].addQuantity
				);
			}
			modalPrepare(addShoppingCartLegalMsgBodyIdPrefix + templateSuffix, 
						addShoppingCartLegalMsgBodyDivId,
						elements,
						addShoppingCartLegalMsgOkBtnId,
						function(){
							showCheckoutShoppingCartModal();
						});
			
			new bootstrap.Modal('#' + addShoppingCartLegalMsgModalId, {}).show();
		}else{
			
			showCheckoutShoppingCartModal();
		}
	}
	
	function showCheckoutShoppingCartModal(){
	
		confirmModal('即將進行結帳', function(){
			
			if(checkoutInputCheck()){
				
				var checkoutForm = {
					paidMoney : $('#' + checkoutPaidMoneyInputId).val()
				};
				
				var checkoutVO = {
					checkoutForm : checkoutForm
				};
				
				
			}
		}).show();
	}
	function checkoutAjax(checkoutVO){
		
		var ajaxUrl = '/vendingMachine/machine/tempCheckout';
		var dataJson = JSON.stringify(checkoutVO);
		
		$.ajax({
			url : ajaxUrl,
			method : 'POST',
			data : dataJson,
			contentType : 'text/plain',
			dataType : 'json',
			success : function(data){
				
				showCheckoutAjaxIllegalMoneyMsg(data.checkoutMoneyIllegalMsg);
			}
		});
	}
	function checkoutInputCheck(){
		
		return checkNotNullNonNegativeIntegerInput(checkoutPaidMoneyInputId, "結帳金額");
	}
	function showCheckoutAjaxIllegalMoneyMsg(checkoutMoneyIllegalMsg){
		
		if(checkoutMoneyIllegalMsg.hasMsg == 'true'){
			
			
		}
	}
	
	
	// go backend
	function goBackendBtnClicked(){
	
		var redirectUrl = '/vendingMachine/machine/backend/goodsList';
		var shoppingCartGoodsCount = $('#' + shoppingCartGoodsGoodsCountInputId).val();
	
		var ajaxUrl = '/vendingMachine/machine/goBackend';
		var ajaxFctn = function(){
	
			$.ajax({
				url : ajaxUrl,
				method : 'POST',
				success : function(){
					
					window.location.href = redirectUrl;
				}
			});
		}
		
		
		if(shoppingCartGoodsCount > 0){
			
			confirmModal('前往後臺將清空購物車', function(){
				
				ajaxFctn();
			}).show();
		}else{
	
			ajaxFctn();
		}
	}
	
	// logout
	function logoutBtnClicked(){
		
		confirmModal('即將登出', function(){
			
			ajaxUrl = '/vendingMachine/machine/logout';
			redirectUrl = '/vendingMachine/login';
			
			$.ajax({
				url : ajaxUrl,
				method : 'POST',
				success : function(){
					
					window.location.href = redirectUrl;
				}
			});
		}).show();
	}
	
	
	
	