
	let allOrdersBtn = 'all_orders_btn';

	// filter
	let filterCustomerInputId = 'filter_customer_name';
	let filterStartDateInputId = 'filter_start_date';
	let filterEndDateInputId = 'filter_end_date';
	let filterGoodsNameInputId = 'filter_goods_name';
	let filterGoodsPriceMinInputId = 'filter_goods_price_min';
	let filterGoodsPriceMaxInputId = 'filter_goods_price_max';
	let filterBuyQantityMinInputId = 'filter_buy_quantity_min';
	let filterBuyQantityMaxInputId = 'filter_buy_quantity_max';
	let filterTotalPriceMinInputId = 'filter_total_price_min';
	let filterTotalPriceMaxInputId = 'filter_total_price_max';
	
	let filterFormResetBtnId = 'filter_form_reset_btn';
	let filterBtnId = 'filter_btn';
	let filterFormId = 'filter_form';
	
	
	function filterBtnClicked(){
		
		if(filterInputCheck())
			$('#' + filterFormId).submit();
	}
	function filterInputCheck(){
		
		return checkPositiveIntegerInput(filterGoodsPriceMinInputId, '飲料價格(小)')
			&& checkPositiveIntegerInput(filterGoodsPriceMaxInputId, '飲料價格(大)')
			&& checkIntegerInputMinMax(filterGoodsPriceMinInputId, '飲料價格(小)', filterGoodsPriceMaxInputId, '飲料價格(大)')
		
			&& checkPositiveIntegerInput(filterBuyQantityMinInputId, '購買數量(小)')
			&& checkPositiveIntegerInput(filterBuyQantityMaxInputId, '購買數量(大)')
			&& checkIntegerInputMinMax(filterBuyQantityMinInputId, '購買數量(小)', filterBuyQantityMaxInputId, '購買數量(大)')
		
			&& checkPositiveIntegerInput(filterTotalPriceMinInputId, '購買金額(小)')
			&& checkPositiveIntegerInput(filterTotalPriceMaxInputId, '購買金額(大)')
			&& checkIntegerInputMinMax(filterTotalPriceMinInputId, '購買金額(小)', filterTotalPriceMaxInputId, '購買金額(大)');
	}
	function allOrdersBtnClicked(){
		
		confirmModal('即將更新頁面至全部報表', function(){
			
			window.location.replace("/vendingMachine/machine/backend/orderList");
		}).show();
	}
	function filterFormResetBtnClicked(){
		
		confirmModal('確定要清空篩選欄位?', function(){
			
			$('#' + filterCustomerInputId).val('');
			$('#' + filterStartDateInputId).val('');
			$('#' + filterEndDateInputId).val('');
			$('#' + filterGoodsNameInputId).val('');
			$('#' + filterGoodsPriceMinInputId).val('');
			$('#' + filterGoodsPriceMaxInputId).val('');
			$('#' + filterBuyQantityMinInputId).val('');
			$('#' + filterBuyQantityMaxInputId).val('');
			$('#' + filterTotalPriceMinInputId).val('');
			$('#' + filterTotalPriceMaxInputId).val('');
		}).show();
	}