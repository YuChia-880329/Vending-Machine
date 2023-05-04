	
	// id
	let currentUrl = window.location.href;
	
	let addShoppingCartIllegalMsgModalExistInputId = 'add_shopping_cart_illegal_msg_modal_exist_input';
	let addShoppingCartIllegalMsgModalId = 'add_shopping_cart_illegal_msg_modal';
	let addShoppingCartIllegalMsgOkBtnId = 'add_shopping_cart_illegal_msg_ok_btn';

	let addShoppingCartMsgModalExistInputId = 'add_shopping_cart_msg_modal_exist_input';
	let addShoppingCartMsgModalId = 'add_shopping_cart_msg_modal';
	let addShoppingCartMsgOkBtnId = 'add_shopping_cart_msg_ok_btn';
	
	let clearShoppingCartMsgModalExistInputId = 'clear_shopping_cart_msg_modal_exist_input';
	let clearShoppingCartMsgModalId = 'clear_shopping_cart_msg_modal';
	let clearShoppingCartMsgOkBtnId = 'clear_shopping_cart_msg_ok_btn';

	let updateShoppingCartIllegalMsgModalExistInputId = 'update_shopping_cart_illegal_msg_modal_exist_input';
	let updateShoppingCartIllegalMsgModalId = 'update_shopping_cart_illegal_msg_modal';
	let updateShoppingCartIllegalMsgOkBtnId = 'update_shopping_cart_illegal_msg_ok_btn';

	let updateShoppingCartMsgModalExistInputId = 'update_shopping_cart_msg_modal_exist_input';
	let updateShoppingCartMsgModalId = 'update_shopping_cart_msg_modal';
	let updateShoppingCartMsgOkBtnId = 'update_shopping_cart_msg_ok_btn';
	
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
	
	let addShoppingCartBtnId = 'add_shopping_cart_btn';
	let addShoppingCartModalId = 'add_shopping_cart_modal';
	let addShoppingCartOkBtnId = 'add_shopping_cart_ok_btn';
	
	let addShoppingCartBodyContentDivId = 'add_shopping_cart_body_content_div';
	let addShoppingCartBodyContentTmplId = 'add_shopping_cart_body_content_tmpl';
	let addShoppingCartBodyContentNameSpanId = 'add_shopping_cart_body_content_name_span_';
	let addShoppingCartBodyContentBuyQuantitySpanId = 'add_shopping_cart_body_content_buy_quantity_span_';
	let addShoppingCartBodyContentPriceSpanId = 'add_shopping_cart_body_content_price_span_';

	let addShoppingCartFormId = 'add_shopping_cart_form';
	let addShoppingCartDataInputId = 'add_shopping_cart_data_input';
	
	let clearShoppingCartBtnId = 'clear_shopping_cart_btn';
	let clearShoppingCartFormId = 'clear_shopping_cart_form';
	let clearShoppingCartDataInputId = 'clear_shopping_cart_data_input';
	
	let shoppingCartGoodsGoodsCountInputId = 'shopping_cart_goods_goods_count_input';
	let shoppingCartGoodsNameInputIdPrefix = 'shopping_cart_goods_name_input_';
	let shoppingCartGoodsQuantityInputIdPrefix = 'shopping_cart_goods_quantity_input_';
	let shoppingCartGoodsIdInputIdPrefix = 'shopping_cart_goods_id_input_';
	let shoppingCartGoodsBuyQuantityInputIdPrefix = 'shopping_cart_goods_buy_quantity_input_';
	let updateShoppingCartBtnId = 'update_shopping_cart_btn';
	let updateShoppingCartFormId = 'update_shopping_cart_form';
	let updateShoppingCartDataInputId = 'update_shopping_cart_data_input';
	
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
			addShoppingCartIllegalMsgModalExistInputId,
			addShoppingCartIllegalMsgModalId,
			addShoppingCartIllegalMsgOkBtnId
		);
		
		modalIdObjs[1] = modalIdObjsFctn(
			addShoppingCartMsgModalExistInputId,
			addShoppingCartMsgModalId,
			addShoppingCartMsgOkBtnId
		);
		modalIdObjs[2] = modalIdObjsFctn(
			clearShoppingCartMsgModalExistInputId,
			clearShoppingCartMsgModalId,
			clearShoppingCartMsgOkBtnId
		);
		modalIdObjs[3] = modalIdObjsFctn(
			updateShoppingCartIllegalMsgModalExistInputId,
			updateShoppingCartIllegalMsgModalId,
			updateShoppingCartIllegalMsgOkBtnId
		);
		
		modalIdObjs[4] = modalIdObjsFctn(
			updateShoppingCartMsgModalExistInputId,
			updateShoppingCartMsgModalId,
			updateShoppingCartMsgOkBtnId
		);
	
		modalIdObjs[5] = modalIdObjsFctn(
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
				currentUrl : currentUrl,
				addShoppingCartGoodsArray : addShoppingCartGoodsArray
			}
	
			$('#' + addShoppingCartDataInputId).val(JSON.stringify(addShoppingCartVO));
	
			
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
	
	function addShoppingCartOkBtnClicked(){
	
		$('#' + addShoppingCartFormId).submit();
	}
	
	
	// clear shopping cart
	function clearShoppingCartBtnClicked(){
		
		confirmModal('即將清空購物車', function(){
			
			var clearShoppingCartVO = {
				currentUrl : currentUrl
			}
			
			$('#' + clearShoppingCartDataInputId).val(JSON.stringify(clearShoppingCartVO));
			$('#' + clearShoppingCartFormId).submit();
		}).show();
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
					currentUrl : currentUrl,
					updateShoppingCartGoodsArray : goodsList
				}
				$('#' + updateShoppingCartDataInputId).val(JSON.stringify(updateShoppingCartVO));
				$('#' + updateShoppingCartFormId).submit();
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
	
		var checkoutAddShoppingCartVO = {
			addShoppingCartGoodsArray : addShoppingCartGoodsArray
		};
	
		if(needAddShoppingCart){
	
			var ajaxUrl = '/vendingMachine/machine/addShoppingCartAjax';
			var dataJson = JSON.stringify(checkoutAddShoppingCartVO);
	
			$('#' + checkoutAddShoppingCartModalOkBtnId).click(function(){
	
				$.ajax({
					url : ajaxUrl,
					method : 'POST',
					data : dataJson,
					contentType : 'text/plain',
					success : function(){
	
						showCheckoutShoppingCartModal();
					}
				});
			});
			
	
			$('#' + checkoutAddShoppingCartModalCancelBtnId).click(function(){
	
				showCheckoutShoppingCartModal()
			});
			
			new bootstrap.Modal('#' + checkoutAddShoppingCartModalId, {}).show();
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
					currentUrl	: currentUrl,
					checkoutForm : checkoutForm
				};
				
				$('#' + checkoutDataInputId).val(JSON.stringify(checkoutVO));
				$('#' + checkoutFormId).submit();
			}
		}).show();
	}
	function checkoutInputCheck(){
		
		return checkNotNullNonNegativeIntegerInput(checkoutPaidMoneyInputId, "結帳金額");
	}
	
	
	// go backend
	function goBackendBtnClicked(){
	
		var redirectUrl = '/vendingMachine/machine/backend/goodsList';
		var shoppingCartGoodsCount = $('#' + shoppingCartGoodsGoodsCountInputId).val();
	
		var ajaxUrl = '/vendingMachine/machine/goBackendAjax';
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
	
	