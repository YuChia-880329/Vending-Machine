<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!-- add shopping cart modal -->
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
	
	
	<!-- shopping cart modal -->
	<div class="modal fade" id="shopping_cart_modal">
		<div class="modal-dialog modal-dialog-scrollable">
  			<div class="modal-content">
    			<div class="modal-header">
      				<h4 class="modal-title">購物車</h4>
      				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    			</div>
    			<div class="modal-body common-modal-body">
    				<div class="container">
    					<input type="hidden" id="shopping_cart_goods_goods_count_input" value="${vo.shoppingCart.goodsCount}" />
    					<c:forEach var="shoppingCartGoods" items="${vo.shoppingCart.shoppingCartGoodsArray}">
    						<input type="hidden" id="shopping_cart_goods_name_input_${shoppingCartGoods.pageId}" value="${shoppingCartGoods.name}" />
    						<input type="hidden" id="shopping_cart_goods_quantity_input_${shoppingCartGoods.pageId}" value="${shoppingCartGoods.quantity}" />
    						<div class="mb-4">
     						<div class="d-flex justify-content-center">
     							<label for="shopping_cart_goods_buy_quantity_input_${shoppingCartGoods.pageId}" class="me-3 form-label">
  										<span>${shoppingCartGoods.name}</span> : 
  									</label>
  									<p class="text-secondary">
  										<span>${shoppingCartGoods.price}</span> 元/罐
  									</p>
     						</div>
     						<div class="d-flex justify-content-center">
								<div class="d-flex">
									<input type="hidden" id="shopping_cart_goods_id_input_${shoppingCartGoods.pageId}" value="${shoppingCartGoods.id}" />
    									<input type="number" class="form-control" id="shopping_cart_goods_buy_quantity_input_${shoppingCartGoods.pageId}" value="${shoppingCartGoods.buyQuantity}" max="999999" min="0" />
    									<div class="ms-3 d-flex align-self-center">
    										<p class="mb-0">罐</p>
    									</div>
    								</div>
							</div>
     					</div>
    					</c:forEach>
					</div>
    			</div>
    			<div class="modal-footer">
    			    <button type="button" class="btn btn-primary" id="update_shopping_cart_btn">更新購物車</button>
    				<button type="button" class="btn btn-danger me-auto" id="clear_shopping_cart_btn">清空購物車</button>
    				<p class="me-2">
    					總計  :  <span class="text-secondary">${vo.shoppingCart.totalPrice}</span>  元
    				</p>
 					<button type="button" class="btn btn-primary" data-bs-dismiss="modal">關閉</button>
    			</div>
  			</div>
		</div>
	</div>
	<form action="/vendingMachine/machine/updateShoppingCart" method="POST" id="update_shopping_cart_form">
		<input type="hidden" name="dataJson" id="update_shopping_cart_data_input" />
	</form>
	<form action="/vendingMachine/machine/clearShoppingCart" method="POST" id="clear_shopping_cart_form">
		<input type="hidden" name="dataJson" id="clear_shopping_cart_data_input" />
	</form>
	
	
	<!-- add shopping cart message modal -->
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
	     							已新增商品 <span class="mx-2 text-primary">${line.name}</span> <span class="mx-2 text-danger">${line.addQuantity}</span> 罐至購物車
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
	
	
	<!-- clear shopping cart message modal -->
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
	
	
	<!-- update shopping cart message modal -->
	<input type="hidden" value="${vo.updateShoppingCartIllegalMsg.hasMsg}" id="update_shopping_cart_illegal_msg_modal_exist_input" />
	<c:if test="${vo.updateShoppingCartIllegalMsg.hasMsg == 'true'}">
		<div class="modal fade" id="update_shopping_cart_illegal_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">警告</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<c:forEach var="line" items="${vo.updateShoppingCartIllegalMsg.lines}">
	     						<p>
	     							商品 <span class="text-danger">${line.name}</span> 購買數量大於庫存數量
	     						</p>
	     					</c:forEach>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="update_shopping_cart_illegal_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>
	
	<input type="hidden" value="${vo.updateShoppingCartMsg.hasMsg}" id="update_shopping_cart_msg_modal_exist_input" />
	<c:if test="${vo.updateShoppingCartMsg.hasMsg == 'true'}">
		<div class="modal fade" id="update_shopping_cart_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">訊息</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<c:forEach var="line" items="${vo.updateShoppingCartMsg.lines}">
	     						<p>
	     							已更新購物車  商品<span class="mx-2 text-primary">${line.name}</span> <span class="mx-2 text-danger">${line.buyQuantity}</span> 罐
	     						</p>
	     					</c:forEach>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="update_shopping_cart_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>
	
	
	<!-- checkout message modal -->
	<input type="hidden" value="${vo.checkoutMoneyIllegalMsg.hasMsg}" id="checkout_money_illegal_msg_modal_exist_input" />
	<c:if test="${vo.checkoutMoneyIllegalMsg.hasMsg == 'true'}">
		<div class="modal fade" id="checkout_money_illegal_msg_modal">
	 		<div class="modal-dialog msg-modal-dialog">
	   			<div class="modal-content msg-modal-content">
	     			<div class="modal-header msg-modal-header">
	       				<h4 class="modal-title">訊息</h4>
	       				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     			</div>
	     			<div class="modal-body msg-modal-body">
	     				<div class="container">
	     					<p>投入的金額不足</p>
						</div>
	     			</div>
	     			<div class="modal-footer msg-modal-footer">
	  					<button type="button" class="btn btn-primary" id="checkout_money_illegal_msg_ok_btn">確認</button>
	     			</div>
	   			</div>
	 		</div>
		</div>
	</c:if>



	<!-- goods description modal -->
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
	
	
	
	<!-- checkout add shopping cart modal -->
	<div class="modal fade" id="checkout_add_shopping_cart_modal">
	  	<div class="modal-dialog msg-modal-dialog">
	    	<div class="modal-content msg-modal-content">
	      		<div class="modal-header msg-modal-header">
	        		<h4 class="modal-title">Confirm</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body msg-modal-body">
	      			<p>有商品尚未加入購物車，是否加入購物車?</p>
	      		</div>
	      		<div class="modal-footer msg-modal-footer">
	        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="checkout_add_shopping_cart_modal_cancel_btn">取消</button>
	        		<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="checkout_add_shopping_cart_modal_ok_btn">確認</button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
	