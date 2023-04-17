<!-- url : /vendingMachine/machine/backend/goodsUpdate -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-後臺</title>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">
	
		let updateMsgDivId = 'update_msg_div';
		
		let updateFormId = 'update_form';
		let goodsNameSelectId = 'goods_name_select';
		let goodsPriceInputId = 'goods_price_input';
		let goodsQuantitySpan = 'goods_quantity_span';
		let goodsAddQuantityInputId = 'goods_add_quantity_input';
		let goodsStatusRadio1Id = 'goods_status_radio_1';
		let goodsStatusRadio0Id = 'goods_status_radio_0';
		let updateBtnId = 'update_btn';
	
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + updateBtnId).click(updateBtnClicked);
			$('#' + goodsNameSelectId).change(formSelectChanged);
		}
		
		function updateBtnClicked(){
			
			var updateUrl = '/vendingMachine/machine/backend/goodsUpdate/update';
			var sentData = $('#' + updateFormId).serialize();
			
			$.ajax({
				url : updateUrl,
				method : 'PUT',
				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
				data : sentData,
				dataType : 'json',
				success : function(data){
					
					$('#' + updateMsgDivId).text(data.updateMsg.msg);
				}
			});
		}
		function formSelectChanged(){
			
			var goodsId = $('#' + goodsNameSelectId).val();
			
			if(goodsId == '0'){
				
				
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
	</script>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	
	<div class="container">
	
		<h2 class="mb-5">商品維護作業</h2>
		
		<div class="ms-4">
			<div class="text-primary mb-4" id="update_msg_div"></div>
			
			<form id="update_form">
				<div class="d-flex">
					<div>
						<div class="d-flex mb-4">
							<div class="row align-self-center justify-content-center me-3">
								<label for="goods_name_select" class="form-label mb-0 col-auto">飲料名稱：</label>
							</div>
							<div>
								<select class="form-select" name="id" id="goods_name_select" aria-label="Good Name Select">
									  <option value="0" selected>---- 請選擇 ----</option>
									<c:forEach var="goodsNameOption" items="${vo.updateForm.goodsNameOptions}">
									  	<option value="${goodsNameOption.id}">${goodsNameOption.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="d-flex mb-4">
							<div class="row align-self-center justify-content-center me-3">
								<label for="goods_price_input" class="form-label mb-0 col-auto">更改價格：</label>
							</div>
							<div>
								<input type="number" class="form-control" name="price" id="goods_price_input" min="0" max="999999" />
							</div>
						</div>
						
						<div class="mb-4 pt-2">
							商品庫存量： <span id="goods_quantity_span"></span>
						</div>
						
						<div class="d-flex mb-4">
							<div class="row align-self-center justify-content-center me-3">
								<label for="goods_add_quantity_input" class="form-label mb-0 col-auto">補貨數量：</label>
							</div>
							<div>
								<input type="number" class="form-control" name="addQuantity" id="goods_add_quantity_input" min="0" max="999999" />
							</div>
						</div>
						
						<div class="d-flex mb-4 pt-2">
							<div class="row align-content-center justify-content-center me-3">
								<label for="goods_status_radio_1" class="form-label mb-0 col-auto">商品狀態：</label>
							</div>
							<div class="form-check mb-0 me-3">
								<input type="radio" class="form-check-input" name="goodStatus" id="goods_status_radio_1" value="1" />
								<label for="goods_status_radio_1" class="m-0 form-check-label">上架</label>
							</div>
							<div class="form-check mb-0">
								<input type="radio" class="form-check-input" name="goodStatus" id="goods_status_radio_0" value="0" />
								<label for="goods_status_radio_0" class="m-0 form-check-label">下架</label>
							</div>
						</div>
						
						<div class="mb-4 pt-2">
							<button type="button" class="btn btn-outline-primary" id="update_btn">更新</button>
						</div>
						
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>