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
	<script src="js/frontend/frontend.js"></script>

	<script type="text/javascript">

		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			showMsgModal();
			$('#' + filterBtnId).click(filterBtnClicked);
			$('#' + allGoodsBtnId).click(allGoodsBtnClicked);
			$('#' + addShoppingCartBtnId).click(addShoppingCartBtnClicked);
			$('#' + addShoppingCartOkBtnId).click(addShoppingCartOkBtnClicked);
			$('#' + clearShoppingCartBtnId).click(clearShoppingCartBtnClicked);
			$('#' + updateShoppingCartBtnId).click(updateShoppingCartBtnClicked);
			$('#' + checkoutBtnId).click(checkoutBtnClicked);
			$('#' + goBackendBtnId).click(goBackendBtnClicked);
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
						<a href="#" class="link-primary h4" id="go_backend_btn">後臺頁面</a>&nbsp; &nbsp;
						<a href="#" class="link-primary h4">登出</a>
					</div>
					
					<div class="mb-4">
						<form>
							<div class="d-flex justify-content-center">
								<div class="me-4 d-flex align-self-center">
									<b>投入 : </b>
								</div>
								<div class="me-4">
									<input type="number" class="form-control" id="checkout_paid_money_input" max="999999" min="0" />
								</div>
								<div class="me-4 d-flex align-self-center">
									<b>元</b>
								</div>
								<div>
									<button type="button" class="btn btn-outline-primary" id="checkout_btn">結帳</button>
								</div>
							</div>
						</form>
					</div>
					<form action="/vendingMachine/machine/checkout" method="POST" id="checkout_form">
						<input type="hidden" name="dataJson" id="checkout_data_input" />
					</form>
					
					<c:if test="${vo.receipt.hasReceipt}">
						<div>
							<div class="d-flex justify-content-center">
								<div>
									<div style="border-width:3px;border-style:dashed;border-color:#FFAC55;padding:5px;width:300px;">
										<p style="color: blue;">~~~~~~~ 消費明細 ~~~~~~~</p>
										<p class="my-2">投入金額  ：  ${vo.receipt.receiptContent.paidMoneyMsg.paidMoney}</p>
										<p class="my-2">購買金額  ：  ${vo.receipt.receiptContent.totalPriceMsg.totalPrice}</p>
										<c:if test="${vo.receipt.receiptContent.changeMsg.hasMsg}">
											<p class="my-2">找零金額  ：  ${vo.receipt.receiptContent.changeMsg.change}</p>
										</c:if>
										<c:forEach var="boughtGoodsMsg" items="${vo.receipt.receiptContent.boughtGoodsMsgs}">
											<p class="my-2">${boughtGoodsMsg.name}  ${boughtGoodsMsg.price} * ${boughtGoodsMsg.buyQuantity}</p>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</c:if>
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

	<%@ include file="modal/frontend_modal.jsp" %>
	<%@ include file="../../modal.jsp" %>
</body>
</html>