		
	let allGoodsBtn = 'all_goods_btn';

	// filter
	let filterIdMinInputId = 'filter_id_min';
	let filterIdMaxInputId = 'filter_id_max';
	let filterNameInputId = 'filter_name';
	let filterPriceMinInputId = 'filter_price_min';
	let filterPriceMaxInputId = 'filter_price_max';
	let filterQuantityMinInputId = 'filter_quantity_min';
	let filterQuantityMaxInputId = 'filter_quantity_max';
	let filterStatusValueInputId = 'filter_status_value';
	let filterStatus1InputId = 'filter_status_1';
	let filterStatus0InputId = 'filter_status_0';
	
	let filterStatusResetBtnId = 'filter_status_reset_btn';
	let filterFormResetBtnId = 'filter_form_reset_btn';
	let filterBtnId = 'filter_btn';
	let filterFormId = 'filter_form';
	
	
	function filterBtnClicked(){
		
		if(filterInputCheck())
			$('#' + filterFormId).submit();
	}
	function filterInputCheck(){
		
		return checkPositiveIntegerInput(filterIdMinInputId, '商品編號(小)')
			&& checkPositiveIntegerInput(filterIdMaxInputId, '商品編號(大)')
			&& checkIntegerInputMinMax(filterIdMinInputId, '商品編號(小)', filterIdMaxInputId, '商品編號(大)')
		
			&& checkPositiveIntegerInput(filterPriceMinInputId, '商品價格(小)')
			&& checkPositiveIntegerInput(filterPriceMaxInputId, '商品價格(大)')
			&& checkIntegerInputMinMax(filterPriceMinInputId, '商品價格(小)', filterPriceMaxInputId, '商品價格(大)')
		
			&& checkPositiveIntegerInput(filterQuantityMinInputId, '現有庫存(小)')
			&& checkPositiveIntegerInput(filterQuantityMaxInputId, '現有庫存(大)')
			&& checkIntegerInputMinMax(filterQuantityMinInputId, '現有庫存(小)', filterQuantityMaxInputId, '現有庫存(大)');
	}
	function initFilterStatus(){
		
		var status = $('#' + filterStatusValueInputId).val();
		
		if(status == '1')
			$('#' + filterStatus1InputId).prop('checked', true);
		else if(status == '0')
			$('#' + filterStatus0InputId).prop('checked', true);
	}
	function filterStatusResetBtnClicked(){
		
		$('#' + filterStatus1InputId).prop('checked', false);
		$('#' + filterStatus0InputId).prop('checked', false);
	}
	
	function filterFormResetBtnClicked(){
		
		confirmModal('確定要清空篩選欄位?', function(){
			
			$('#' + filterIdMinInputId).val('');
			$('#' + filterIdMaxInputId).val('');
			$('#' + filterNameInputId).val('');
			$('#' + filterPriceMinInputId).val('');
			$('#' + filterPriceMaxInputId).val('');
			$('#' + filterQuantityMinInputId).val('');
			$('#' + filterQuantityMaxInputId).val('');
			$('#' + filterStatusValueInputId).val('');
			$('#' + filterStatus1InputId).prop('checked', false);
			$('#' + filterStatus0InputId).prop('checked', false);
		}).show();
	}
	function allGoodsBtnClicked(){
		
		confirmModal('即將更新頁面至全部商品', function(){
			
			window.location.replace("/vendingMachine/machine/backend/goodsList");
		}).show();
	}
	