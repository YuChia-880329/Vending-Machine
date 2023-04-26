<!-- url : /vendingMachine/machine -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/common.css">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/util.js"></script>


	<script type="text/javascript">

		let addShoppingCartIllegalMsgModalExistInputId = 'add_shopping_cart_illegal_msg_modal_exist_input';
		let addShoppingCartIllegalMsgModalId = 'add_shopping_cart_illegal_msg_modal';
		let addShoppingCartIllegalMsgOkBtnId = 'add_shopping_cart_illegal_msg_ok_btn';

		let addShoppingCartMsgModalExistInputId = 'add_shopping_cart_msg_modal_exist_input';
		let addShoppingCartMsgModalId = 'add_shopping_cart_msg_modal';
		let addShoppingCartMsgOkBtnId = 'add_shopping_cart_msg_ok_btn';
		
		let clearShoppingCartMsgModalExistInputId = 'clear_shopping_cart_msg_modal_exist_input';
		let clearShoppingCartMsgModalId = 'clear_shopping_cart_msg_modal';
		let clearShoppingCartMsgOkBtnId = 'clear_shopping_cart_msg_ok_btn';
		
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
		
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			showMsgModal();
			$('#' + filterBtnId).click(filterBtnClicked);
			$('#' + allGoodsBtnId).click(allGoodsBtnClicked);
			$('#' + addShoppingCartBtnId).click(addShoppingCartBtnClicked);
			$('#' + addShoppingCartOkBtnId).click(addShoppingCartOkBtnClicked);
			$('#' + clearShoppingCartBtnId).click(clearShoppingCartBtnClicked);
		}
		function showMsgModal(){
			
			modalIdObjs = [];
			
			modalIdObjs[0] = {
				existId : addShoppingCartIllegalMsgModalExistInputId,
				modalId : addShoppingCartIllegalMsgModalId,
				okBtnId : addShoppingCartIllegalMsgOkBtnId
			};
			
			modalIdObjs[1] = {
				existId : addShoppingCartMsgModalExistInputId,
				modalId : addShoppingCartMsgModalId,
				okBtnId : addShoppingCartMsgOkBtnId
			};
			
			modalIdObjs[2] = {
				existId	: clearShoppingCartMsgModalExistInputId,
				modalId : clearShoppingCartMsgModalId,
				okBtnId : clearShoppingCartMsgOkBtnId
			};
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
						$('#' + lastElement.okBtnId).attr('data-bs-dismiss', 'modal');
						$('#' + lastElement.okBtnId).click(function(){
							
							new bootstrap.Modal('#' + element.modalId, {}).show();
						});
					}
				}
			});
			
			if(lastIndex >= 0)
				$('#' + modalIdObjs[lastIndex].okBtnId).attr('data-bs-dismiss', 'modal');
			
			if(firstIndex >= 0)
				new bootstrap.Modal('#' + modalIdObjs[firstIndex].modalId, {}).show();
		}
		
		function filterBtnClicked(){
			
			$('#' + filterForm).submit();
		}
		function allGoodsBtnClicked(){
			
			confirmModal('即將更新頁面至全部商品', function(){
				
				window.location.replace("/vendingMachine/machine");
			}).show();
		}
		function addShoppingCartBtnClicked(){

			$('#' + addShoppingCartBodyContentDivId).empty();
			
			var addShoppingCartGoodsArray = [];
			var index = 0;
			
			for(i=1; i<=6; i++){

				var buyQuantity = $('#' + goodsEntryBuyQuantityInputIdPrefix + i).val();
				if(buyQuantity > 0){

					var name = $('#' + goodsEntryNameInputIdPrefix + i).val();
					var price = $('#' + goodsEntryPriceInputIdPrefix + i).val();
					var quantity = $('#' + goodsEntryQuantityInputIdPrefix + i).val();

					var bodyContent = $('#' + addShoppingCartBodyContentTmplId).clone()[0].content;
					$('#' + addShoppingCartBodyContentDivId).append(bodyContent);

					
					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentNameSpanId).attr('id', addShoppingCartBodyContentNameSpanId + i);
					$('#' + addShoppingCartBodyContentNameSpanId + i).text(name);

					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentBuyQuantitySpanId).attr('id', addShoppingCartBodyContentBuyQuantitySpanId + i);
					$('#' + addShoppingCartBodyContentBuyQuantitySpanId + i).text(buyQuantity);

					$('#' + addShoppingCartBodyContentDivId + ' #' + addShoppingCartBodyContentPriceSpanId).attr('id', addShoppingCartBodyContentPriceSpanId + i);
					$('#' + addShoppingCartBodyContentPriceSpanId + i).text(price);

					var id = $('#' + goodsEntryIdInputIdPrefix + i).val();
					addShoppingCartGoodsArray[index] = {
						id : id,
						name : name,
						buyQuantity : buyQuantity,
						quantity : quantity
					}
					index++;
				}
			}
			var addShoppingCartVO = {
				addShoppingCartGoodsArray : addShoppingCartGoodsArray,
				queryString : '${pageContext.request.queryString}'
			}

			$('#' + addShoppingCartDataInputId).val(JSON.stringify(addShoppingCartVO));

			
			new bootstrap.Modal('#' + addShoppingCartModalId, {}).show();
		}

		function addShoppingCartOkBtnClicked(){

			$('#' + addShoppingCartFormId).submit();
		}
		function clearShoppingCartBtnClicked(){
			
			confirmModal('即將清空購物車', function(){
				
				var clearShoppingCartVO = {
						queryString : '${pageContext.request.queryString}'
				}
				
				$('#' + clearShoppingCartDataInputId).val(JSON.stringify(clearShoppingCartVO));
				$('#' + clearShoppingCartFormId).submit();
			}).show();
		}
		

	</script>
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<div class="row">
				<div class="col-8 ms-auto">
					<div class="d-flex">
						<div class="me-2">
							<button type="button" class="btn btn-outline-primary" id="add_shopping_cart_btn">加入購物車</button>
						</div>
						<div class="me-auto">
							<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#shopping_cart_modal">購物車</button>
						</div>
						<div>
							<form action="/vendingMachine/machine/search" method="GET" id="filter_form">
								<div class="d-flex">
									<div class="me-3">
										<input type="text" class="form-control" name="name" size="50" value="${vo.filterForm.name}" />
									</div>
									<div>
										<button type="button" class="btn btn-outline-primary" id="filter_btn">商品查詢</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="mt-5">
			<div class="row">
			
				<div class="col-4 text-center">
					<img class="mb-4" alt="VendingMachine" src="${vo.welcomePart.welcomeImagePath}" width="200" height="200" />
				
					<h1 class="mb-4">歡迎光臨，${vo.welcomePart.welcomeMsg.customerName}！</h1>
					
					<div class="mb-5">
						<a href="machine/backend/goodsList" class="link-primary h4">後臺頁面</a>&nbsp; &nbsp;
						<a href="#" class="link-primary h4">登出</a>
					</div>
					
					<div class="mb-4">
						<form>
							<div class="d-flex justify-content-center">
								<div class="me-4 d-flex align-self-center">
									<b>投入 : </b>
								</div>
								<div class="me-4">
									<input type="number" class="form-control" max="999999" min="0" />
								</div>
								<div class="me-4 d-flex align-self-center">
									<b>元</b>
								</div>
								<div>
									<button class="btn btn-outline-primary">結帳</button>
								</div>
							</div>
						</form>
					</div>
					
					<div>
						<div class="d-flex justify-content-center">
							<div>
								<div style="border-width:3px;border-style:dashed;border-color:#FFAC55;padding:5px;width:300px;">
									<p style="color: blue;">~~~~~~~ 消費明細 ~~~~~~~</p>
									<p class="my-2">1</p>
									<p class="my-2">2</p>
									<p class="my-2">3</p>
								</div>
							</div>
						</div>
						
					</div>
					
				</div>
				
				<div class="col-8">
				
					<div class="mb-4">
						<div class="row row-cols-3 g-4">
							<c:forEach var="goodsTableEntry" items="${vo.goodsTablePage.goodsTable.goodsTableEntries}">
								<div class="col">
									<input type="hidden" id="goods_entry_id_${goodsTableEntry.pageId}" value="${goodsTableEntry.id}" />
									<input type="hidden" id="goods_entry_name_${goodsTableEntry.pageId}" value="${goodsTableEntry.goodsCard.name}" />
									<input type="hidden" id="goods_entry_price_${goodsTableEntry.pageId}" value="${goodsTableEntry.goodsCard.price}" />
									<input type="hidden" id="goods_entry_quantity_${goodsTableEntry.pageId}" value="${goodsTableEntry.goodsCard.quantity}" />
									<div class="card text-center">
										<div class="card-header">
											<h4 class="mb-2">${goodsTableEntry.goodsCard.name}</h4>
											<p class="text-secondary mb-0">
												<span>${goodsTableEntry.goodsCard.price}</span>元/罐
											</p>
										</div>
								      	
									    <div class="card-body">
									    	<div class="mb-4">
									    		<a href="#" data-bs-toggle="modal" data-bs-target="#goods_table_image_modal_${goodsTableEntry.id}">
									    			<img src="${goodsTableEntry.goodsCard.imagePath}" alt="${goodsTableEntry.goodsCard.name}" width="150" height="150" />
									    		</a>
									    	</div>
									    	<div class="mb-3">
									    		<div class="d-flex justify-content-center">
									    			<div class="me-3 d-flex align-self-center">
									    				<p class="m-0">購買</p>
									    			</div>
									    			<div class="me-3">
									    				<input type="number" class="form-control" id="goods_entry_buy_quantity_${goodsTableEntry.pageId}" min="0" max="999999" value="0" />
									    			</div>
									    			<div class="d-flex align-self-center">
									    				<p class="m-0">罐</p>
									    			</div>
									    		</div>
									    	</div>
									    	
									        <p class="card-text text-danger">
									        	(庫存 <span>${goodsTableEntry.goodsCard.quantity}</span> 罐)
									        </p>
									    </div>
								    </div>
								</div>
							</c:forEach>
						</div>
					</div>
					
					<div class="mb-4">
						<div class="d-flex">
							<div class="me-auto">
								<button type="button" class="btn btn-outline-primary" id="all_goods_btn">所有飲料</button>
							</div>
							<div>
								<nav aria-label="Page navigation">
									<ul class="pagination">
									    <c:if test="${vo.goodsTablePage.pagination.previousPage.existence}">
											<li class="page-item">
										      	<a class="page-link" href="${vo.goodsTablePage.pagination.previousPage.url}" aria-label="Previous">
										        	<span aria-hidden="true">&laquo;</span>
										      	</a>
										    </li>
										</c:if>
									  	<c:forEach var="p" items="${vo.goodsTablePage.pagination.pages}">
									    	<li class="page-item">
										    	<a class="page-link" href="${p.url}">${p.page}</a>
										    </li>
									    </c:forEach>
										<c:if test="${vo.goodsTablePage.pagination.nextPage.existence}">
											<li class="page-item">
										    	<a class="page-link" href="${vo.goodsTablePage.pagination.nextPage.url}" aria-label="Next">
											        <span aria-hidden="true">&raquo;</span>
												</a>
										    </li>
										</c:if>
									</ul>
								</nav>
							</div>
							
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="add_shopping_cart_modal">
 		<div class="modal-dialog modal-dialog-scrollable">
   			<div class="modal-content">
     			<div class="modal-header">
       				<h4 class="modal-title">即將加入購物車</h4>
       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
     			</div>
     			<div class="modal-body common-modal-body">
     				<div class="container text-center" id="add_shopping_cart_body_content_div"></div>
     			</div>
     			<div class="modal-footer">
     			    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
  					<button type="button" class="btn btn-primary" id="add_shopping_cart_ok_btn" data-bs-dismiss="modal">確認</button>
     			</div>
   			</div>
 		</div>
	</div>
	<form action="/vendingMachine/machine/addShoppingCart" method="POST" id="add_shopping_cart_form">
		<input type="hidden" name="dataJson" id="add_shopping_cart_data_input" />
	</form>
	
	<div class="modal fade" id="shopping_cart_modal">
 		<div class="modal-dialog modal-dialog-scrollable">
   			<div class="modal-content">
     			<div class="modal-header">
       				<h4 class="modal-title">購物車</h4>
       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
     			</div>
     			<div class="modal-body common-modal-body">
     				<div class="container">
     					<form>
	     					<c:forEach var="shoppingCartGoods" items="${vo.shoppingCart.shoppingCartGoodsArray}">
	     						<div class="mb-4">
		     						<div class="d-flex justify-content-center">
		     							<label for="shopping_cart_goods_buy_quantity_input_${shoppingCartGoods.id}" class="me-3 form-label">
	   										<span>${shoppingCartGoods.name}</span> : 
	   									</label>
	   									<p class="text-secondary">
	   										<span>${shoppingCartGoods.price}</span> 元/罐
	   									</p>
		     						</div>
		     						<div class="d-flex justify-content-center">
										<div class="d-flex">
											<input type="hidden" value="${shoppingCartGoods.id}" />
	     									<input type="number" class="form-control" id="shopping_cart_goods_buy_quantity_input_${shoppingCartGoods.id}" value="${shoppingCartGoods.buyQuantity}" max="999999" min="0" />
	     									<div class="ms-3 d-flex align-self-center">
	     										<p class="mb-0">罐</p>
	     									</div>
	     								</div>
									</div>
		     					</div>
	     					</c:forEach>
     					</form>
     					
					</div>
     			</div>
     			<div class="modal-footer">
     			    <button type="button" class="btn btn-primary">更新購物車</button>
     				<button type="button" class="btn btn-danger me-auto" id="clear_shopping_cart_btn">清空購物車</button>
  					<button type="button" class="btn btn-primary" data-bs-dismiss="modal">關閉</button>
     			</div>
   			</div>
 		</div>
	</div>
	<form action="/vendingMachine/machine/clearShoppingCart" method="POST" id="clear_shopping_cart_form">
		<input type="hidden" name="dataJson" id="clear_shopping_cart_data_input" />
	</form>
	
	
	<input type="hidden" value="${vo.addShoppingCartIllegalMsg.hasMsg}" id="add_shopping_cart_illegal_msg_modal_exist_input" />
	<c:if test="${vo.addShoppingCartIllegalMsg.hasMsg == 'true'}">
		<div class="modal fade" id="add_shopping_cart_illegal_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">警告</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<c:forEach var="line" items="${vo.addShoppingCartIllegalMsg.lines}">
	     						<p>
	     							商品 <span class="text-danger">${line.name}</span> 購買數量大於庫存數量
	     						</p>
	     					</c:forEach>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="add_shopping_cart_illegal_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>
	
	<input type="hidden" value="${vo.addShoppingCartMsg.hasMsg}" id="add_shopping_cart_msg_modal_exist_input" />
	<c:if test="${vo.addShoppingCartMsg.hasMsg == 'true'}">
		<div class="modal fade" id="add_shopping_cart_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">訊息</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<c:forEach var="line" items="${vo.addShoppingCartMsg.lines}">
	     						<p>
	     							已新增商品 <span class="text-primary">${line.name}</span> <span class="text-primary">${line.addQuantity}</span> 罐至購物車
	     						</p>
	     					</c:forEach>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="add_shopping_cart_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>
	
	<input type="hidden" value="${vo.clearShoppingCartMsg.hasMsg}" id="clear_shopping_cart_msg_modal_exist_input" />
	<c:if test="${vo.clearShoppingCartMsg.hasMsg == 'true'}">
		<div class="modal fade" id="clear_shopping_cart_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">訊息</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<p>已清空購物車</p>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="clear_shopping_cart_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>
	
	
	
	<c:forEach var="goodsTableEntry" items="${vo.goodsTablePage.goodsTable.goodsTableEntries}">
		<div class="modal fade" id="goods_table_image_modal_${goodsTableEntry.id}">
	 		<div class="modal-dialog">
	   			<div class="modal-content">
	     			<div class="modal-header">
	       				<h4 class="modal-title">${goodsTableEntry.goodsIntroduction.name}</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body">
	     				<div class="container text-center">
							<img src="${goodsTableEntry.goodsIntroduction.imagePath}" alt="Drink" width="300" height="300" />
							
							<p class="my-5">${goodsTableEntry.goodsIntroduction.description}</p>
							<div>
								<div class="row">
									<div class="col-4 text-secondary">
										價錢 : <span>${goodsTableEntry.goodsIntroduction.price}</span> 元/罐
									</div>
									<div class="col-4 text-danger">
										庫存 : <span>${goodsTableEntry.goodsIntroduction.quantity}</span> 罐
									</div>
									<div class="col-4">
										購物車內 : <span>${goodsTableEntry.goodsIntroduction.buyQuantity}</span> 罐
									</div>
								</div>
							</div>
						</div>
	     			</div>
	     			<div class="modal-footer">
	  					<button type="button" class="btn btn-primary" data-bs-dismiss="modal">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:forEach>
	
	<template id="add_shopping_cart_body_content_tmpl">
		<div>
			<div class="d-flex justify-content-evenly">
				<div>
					<p>
						<span id="add_shopping_cart_body_content_name_span_"></span> : 
						<span id="add_shopping_cart_body_content_buy_quantity_span_"></span>罐
					</p>
				</div>
				<div>
					<p class="text-secondary">
						<span id="add_shopping_cart_body_content_price_span_"></span> 元/罐
					</p>
				</div>
			</div>
		</div>
	</template>
	
	
	<%@ include file="../../modal.jsp" %>
</body>
</html>