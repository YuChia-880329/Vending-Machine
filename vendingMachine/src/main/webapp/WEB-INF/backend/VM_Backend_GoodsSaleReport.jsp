<!-- url : /vendingMachine/machine/backend/orderList -->
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
	<script src="../../js/util.js"></script>
	
	<script type="text/javascript">
	
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
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + filterBtnId).click(filterBtnClicked);
			$('#' + allOrdersBtn).click(allOrdersBtnClicked);
			$('#' + filterFormResetBtnId).click(filterFormResetBtnClicked);
		}
		
		function filterBtnClicked(){
			
			if(filterInputCheck())
				$('#' + filterFormId).submit();
		}
		function filterInputCheck(){
			
			return checkIntegerInput(filterGoodsPriceMinInputId, '飲料價格(小)')
				&& checkIntegerInput(filterGoodsPriceMaxInputId, '飲料價格(大)')
				&& checkIntegerInputMinMax(filterGoodsPriceMinInputId, '飲料價格(小)', filterGoodsPriceMaxInputId, '飲料價格(大)')
			
				&& checkIntegerInput(filterBuyQantityMinInputId, '購買數量(小)')
				&& checkIntegerInput(filterBuyQantityMaxInputId, '購買數量(大)')
				&& checkIntegerInputMinMax(filterBuyQantityMinInputId, '購買數量(小)', filterBuyQantityMaxInputId, '購買數量(大)')
			
				&& checkIntegerInput(filterTotalPriceMinInputId, '購買金額(小)')
				&& checkIntegerInput(filterTotalPriceMaxInputId, '購買金額(大)')
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
	</script>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	
	<div class="container">
		<h2 class="mb-5">銷售報表</h2>
		
		<div class="ms-4">
			<div class="row">
				<div class="col-8">
					<div class="mb-4">
						<button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#filter_modal">篩選條件</button>
					</div>
					
					<table class="table table-bordered text-center">
						<thead>
							<tr>
								<th scope="col">顧客姓名</th>
								<th scope="col">購買日期</th>
								<th scope="col">飲料名稱</th>
								<th scope="col">飲料價格</th>
								<th scope="col">購買數量</th>
								<th scope="col">購買金額</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="orderTableRow" items="${vo.orderTablePage.orderTable.orderTableRows}">
								<tr>
									<td>${orderTableRow.customerName}</td>
									<td>${orderTableRow.date}</td>
									<td>${orderTableRow.goodsName}</td>
									<td>${orderTableRow.goodsPrice}</td>
									<td>${orderTableRow.buyQuantity}</td>
									<td>${orderTableRow.totalPrice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div>
						<div class="d-flex">
							<div class="me-auto">
								<nav aria-label="Page navigation" class="pt-4">
									<ul class="pagination">
								    	<c:if test="${vo.orderTablePage.pagination.previousPage.existence}">
											<li class="page-item">
										      	<a class="page-link" href="${vo.orderTablePage.pagination.previousPage.url}" aria-label="Previous">
										        	<span aria-hidden="true">&laquo;</span>
										      	</a>
										    </li>
										</c:if>
									    <c:forEach var="p" items="${vo.orderTablePage.pagination.pages}">
									    	<li class="page-item">
										    	<a class="page-link" href="${p.url}">${p.page}</a>
										    </li>
									    </c:forEach>
									    <c:if test="${vo.orderTablePage.pagination.nextPage.existence}">
											<li class="page-item">
										    	<a class="page-link" href="${vo.orderTablePage.pagination.nextPage.url}" aria-label="Next">
											        <span aria-hidden="true">&raquo;</span>
												</a>
										    </li>
										</c:if>
									</ul>
								</nav>
							</div>
							
							<div class="d-flex align-self-center">
								<button type="button" class="btn btn-outline-primary" id="all_orders_btn">全部報表</button>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="filter_modal">
	  	<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<h4 class="modal-title">篩選條件</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body">
	      			<div class="container">
						<form action="orderList/search" method="GET" id="filter_form">
							<div class="mb-3">
								<label for="filter_customer_name" class="form-label">顧客姓名</label>
								<div class="d-flex">
									<div>
										<input type="text" class="form-control" name="customerName" id="filter_customer_name" size="50" value="${vo.filterForm.customerName}" />
									</div>
								</div>
							</div>
						
							<div class="mb-3">
								<label for="filter_start_date" class="form-label">購買日期</label>
								<div class="d-flex">
									<div>
										<input type="date" class="form-control" name="startDate" id="filter_start_date" value="${vo.filterForm.startDate}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="date" class="form-control" name="endDate" id="filter_end_date" value="${vo.filterForm.endDate}" />
									</div>
								</div>
							</div>
							
							<div class="mb-3">
								<label for="filter_goods_name" class="form-label">飲料名稱</label>
								<div class="d-flex">
									<div>
										<input type="text" class="form-control" name="goodsName" id="filter_goods_name" size="50" value="${vo.filterForm.goodsName}" />
									</div>
								</div>
							</div>
							
							<div class="mb-3">
								<label for="filter_goods_price_min" class="form-label">飲料價格</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="goodsPriceMin" id="filter_goods_price_min" min="1" max="999999" value="${vo.filterForm.goodsPriceMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="goodsPriceMax" id="filter_goods_price_max" min="1" max="999999" value="${vo.filterForm.goodsPriceMax}" />
									</div>
								</div>
							</div>
							
							<div class="mb-3">
								<label for="filter_buy_quantity_min" class="form-label">購買數量</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="buyQuantityMin" id="filter_buy_quantity_min" min="1" max="999999" value="${vo.filterForm.buyQuantityMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="buyQuantityMax" id="filter_buy_quantity_max" min="1" max="999999" value="${vo.filterForm.buyQuantityMax}" />
									</div>
								</div>
							</div>
							
							<div class="mb-3">
								<label for="filter_total_price_min" class="form-label">購買金額</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="totalPriceMin" id="filter_total_price_min" min="1" max="999999" value="${vo.filterForm.totalPriceMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="totalPriceMax" id="filter_total_price_max" min="1" max="999999" value="${vo.filterForm.totalPriceMax}" />
									</div>
								</div>
							</div>
							
						</form>
					</div>
	      		</div>
	      		<div class="modal-footer">
	      			<button type="button" class="btn btn-primary me-auto" id="filter_form_reset_btn">清空</button>
	        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
	        		<button type="button" class="btn btn-primary" id="filter_btn">搜尋</button>
	      		</div>
	    	</div>
	  	</div>
	</div>


	<%@ include file="../../modal.jsp" %>
</body>
</html>