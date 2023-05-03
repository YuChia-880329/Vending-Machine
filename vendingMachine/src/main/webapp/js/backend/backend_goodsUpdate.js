
	let updateMsgDivId = 'update_msg_div';
	
	let updateFormId = 'update_form';
	let goodsNameSelectId = 'goods_name_select';
	let goodsPriceInputId = 'goods_price_input';
	let goodsQuantitySpan = 'goods_quantity_span';
	let goodsAddQuantityInputId = 'goods_add_quantity_input';
	let goodsStatusRadio1Id = 'goods_status_radio_1';
	let goodsStatusRadio0Id = 'goods_status_radio_0';
	let updateBtnId = 'update_btn';
	
	
	function updateBtnClicked(){
		
		confirmModal('確定要更新商品?', function(){
			
			var updateUrl = '/vendingMachine/machine/backend/goodsUpdate/update';
			var sentData = $('#' + updateFormId).serialize();
			
			if(formInputCheck()){
				
				$.ajax({
					url : updateUrl,
					method : 'PUT',
					contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
					data : sentData,
					dataType : 'json',
					success : function(data){
						
						if(data.updateMsg.success == 'true')
							$('#' + updateMsgDivId).text('已成功更新 id ' + data.updateMsg.id + ' 商品 : ' + data.updateMsg.name);
						else
							$('#' + updateMsgDivId).text('更新失敗');
						
						$('#' + goodsQuantitySpan).text(data.updateResultForm.quantity);
						$('#' + goodsAddQuantityInputId).val('0');
					}
				});
			}
		}).show();
	}
	function formSelectChanged(){
		
		var goodsId = $('#' + goodsNameSelectId).val();
		
		if(goodsId == '0'){
			
			formClear();
		}else{
			
			var changeUrl = '/vendingMachine/machine/backend/goodsUpdate/change';
			var sentData = {
					id :  goodsId
				};
			
			$.ajax({
				url : changeUrl,
				method : 'GET',
				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
				data : sentData,
				dataType : 'json',
				success : function(data){
					
					$('#' + goodsPriceInputId).val(data.price);
					$('#' + goodsQuantitySpan).text(data.quantity);
					$('#' + goodsAddQuantityInputId).val('0');
					if(data.status == '1')
						$('#' + goodsStatusRadio1Id).prop('checked', true);
					else if(data.status == '0')
						$('#' + goodsStatusRadio0Id).prop('checked', true);
				}
			});
		}
	}
	function formInputCheck(){
		
		if($('#' + goodsNameSelectId).val()<=0){
			
			alertModal('請選擇飲料').show();
			return false;
		}else{
			
			return checkNotNullPositiveIntegerInput(goodsPriceInputId, '更改價格')
					&& checkNotNullNonNegativeIntegerInput(goodsAddQuantityInputId, '補貨數量')
					&& checkRadio([goodsStatusRadio1Id, goodsStatusRadio0Id], '商品狀態');
		}
	}
	function formClear(){
		
		$('#' + goodsPriceInputId).val('');
		$('#' + goodsQuantitySpan).text('');
		$('#' + goodsAddQuantityInputId).val('');
		if($('#' + goodsStatusRadio1Id).prop('checked'))
			$('#' + goodsStatusRadio1Id).prop('checked', false);
		else if($('#' + goodsStatusRadio0Id).prop('checked'))
			$('#' + goodsStatusRadio0Id).prop('checked', false);
	}