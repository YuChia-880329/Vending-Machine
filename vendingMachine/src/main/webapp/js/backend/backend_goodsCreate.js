
	let msgDivId = 'msg_div';
	
	let createFormId = 'create_form';
	let goodsNameInputId = 'goods_name_input';
	let goodsPriceInputId = 'goods_price_input';
	let goodsNumberInputId = 'goods_number_input';
	let goodsImageInputId = 'goods_image_input';
	let goodsStatusRadio1Id = 'goods_status_radio_1';
	let goodsStatusRadio0Id = 'goods_status_radio_0';
	let createBtnId = 'create_btn';
	
	
	function createBtnClicked(){
		
		confirmModal('確認要新增商品?', function(){
			
			var createURL = '/vendingMachine/machine/backend/goodsCreate/create';
			var sentData = new FormData($('#' + createFormId)[0]);
			
			if(formInputCheck()){
				
				$.ajax({
					url : createURL,
					method : 'POST',
					contentType : false,
					processData: false,
					data : sentData,
					dataType : 'json',
					success : function(data){
						
						if(data.createMsg.success == 'true')
							$('#' + msgDivId).text('已新增商品 id ' + data.createMsg.id + ', ' + data.createMsg.name);
						else
							$('#' + msgDivId).text('新增商品失敗');
					}
				});
			}
		}).show();
	}
	function formInputCheck(){
		
		return checkNotNull(goodsNameInputId, '飲料名稱')
			&& checkNotNullPositiveIntegerInput(goodsPriceInputId, '設定價格')
			&& checkNotNullNonNegativeIntegerInput(goodsNumberInputId, '初始數量')
			&& checkNotNull(goodsImageInputId, '商品圖片')
			&& checkRadio([goodsStatusRadio1Id, goodsStatusRadio0Id], '商品狀態');
	}