<!-- url : /vendingMachine/machine/backend/goodsCreate -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-後臺</title>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	<script src="../../js/util.js"></script>
	
	<script type="text/javascript">
	
		let msgDivId = 'msg_div';
		
		let createFormId = 'create_form';
		let goodsNameInputId = 'goods_name_input';
		let goodsPriceInputId = 'goods_price_input';
		let goodsNumberInputId = 'goods_number_input';
		let goodsImageInputId = 'goods_image_input';
		let goodsStatusRadio1Id = 'goods_status_radio_1';
		let goodsStatusRadio0Id = 'goods_status_radio_0';
		let createBtnId = 'create_btn';
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + createBtnId).click(createBtnClicked);
		}
		
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
							
							$('#' + msgDivId).text(data.createMsg.msg);
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
	</script>
</head>
<body>
	
	<%@ include file="navbar.jsp" %>
	
	
	<div class="container">
		<h2 class="mb-5">商品新增上架</h2>
		<div class="ms-4">
			<div class="text-primary mb-4" id="msg_div"></div>
			<form id="create_form">
				<div class="d-flex">
					<div>
						<div class="mb-4 d-flex">
							<div class="row align-self-center justify-content-center me-3">
								<label for="goods_name_input" class="form-label mb-0 col-auto">飲料名稱：</label>
							</div>
							<div>
								<input type="text" class="form-control" name="name" id="goods_name_input" size="15" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-self-center justify-content-center me-3">
								<label for="goods_description_input" class="form-label mb-0 col-auto">飲料敘述：</label>
							</div>
							<div>
								<input type="text" class="form-control" name="description" id="goods_description_input" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="goods_price_input" class="form-label mb-0 col-auto">設定價格：</label>
							</div>
							<div>
								<input type="number" class="form-control" name="price" id="goods_price_input" size="5" min="0" max="1000" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="goods_number_input" class="form-label mb-0 col-auto">初始數量：</label>
							</div>
							<div>
								<input type="number" class="form-control" name="quantity" id="goods_number_input" size="5" min="0" max="1000" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="goods_image_input" class="form-label mb-0 col-auto">商品圖片：</label>
							</div>
							<div>
								<input type="file" class="form-control" name="image" id="goods_image_input" accept="image/*" />
							</div>
						</div>
						
						
						<div class="mb-4 d-flex pt-1">
							<div class="row align-content-center justify-content-center me-3">
								<label for="goods_status_radio_1" class="form-label mb-0 col-auto">商品狀態：</label>
							</div>
							<div class="form-check mb-0 me-3">
								<input type="radio" class="form-check-input" name="status" id="goods_status_radio_1" value="1" />
								<label for="goods_status_radio_1" class="m-0 form-check-label">上架</label>
							</div>
							<div class="form-check mb-0">
								<input type="radio" class="form-check-input" name="status" id="goods_status_radio_0" value="0" />
								<label for="goods_status_radio_0" class="m-0 form-check-label">下架</label>
							</div>
						</div>
						
						<div class="mb-4">
							<button type="button" class="btn btn-outline-primary" id="create_btn">新增</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<%@ include file="../../modal.jsp" %>
	
</body>
</html>