<!-- url : /vendingMachine/machine/backend/goodsList -->
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
		<link rel="stylesheet" href="../../css/common.css">
	
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	<script src="../../js/util.js"></script>
	
	<script type="text/javascript">
	
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
		
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + allGoodsBtn).click(allGoodsBtnClicked);
			$('#' + filterBtnId).click(filterBtnClicked);
			initFilterStatus();
			$('#' + filterStatusResetBtnId).click(filterStatusResetBtnClicked);
			$('#' + filterFormResetBtnId).click(filterFormResetBtnClicked);
		}
		
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
		
	</script>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	
	<div class="container">
		<div class="mb-5">
			<h2>商品列表</h2>
		</div>
		
		<div class="ms-4 row">
			<div class="col-8">
				<div class="mb-4">
					<button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#filter_modal">篩選條件</button>
				</div>
				
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">商品編號</th>
							<th scope="col">商品名稱</th> 
							<th scope="col">商品價格</th>
							<th scope="col">現有庫存</th>
							<th scope="col">商品狀態</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="goods" items="${vo.goodsTablePage.goodsTable.goodsTableRows}">
							<tr>
								<th scope="row">${goods.id}</th>
								<td>${goods.name}</td> 
								<td>${goods.price}</td>
								<td>${goods.quantity}</td>
								<td>${goods.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				

				<div class="d-flex">
					<div class="me-auto">
						<nav aria-label="Page navigation" class="pt-4">
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
					
					<div class="d-flex">
						<button type="button" class="btn btn-outline-primary align-self-center" id="all_goods_btn">全部商品</button>
					</div>
				</div>
				
			</div>
	  	</div>
	</div>
	
	
	<div class="modal fade" id="filter_modal">
	  	<div class="modal-dialog modal-dialog-centered">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<h4 class="modal-title">篩選條件</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body">
	      			<div class="container">
						<form action="goodsList/search" method="GET" id="filter_form">
							<div class="mb-3">
								<label for="filter_id_min" class="form-label">商品編號</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterIdMin" id="filter_id_min" min="1" max="999999" value="${vo.filterForm.idMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterIdMax" id="filter_id_max" min="1" max="999999" value="${vo.filterForm.idMax}" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_name" class="form-label">商品名稱</label>
								<div class="d-flex">
									<div>
										<input type="text" class="form-control" name="filterName" id="filter_name" size="50" value="${vo.filterForm.name}" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_price_min" class="form-label">商品價格</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterPriceMin" id="filter_price_min" min="1" max="999999" value="${vo.filterForm.priceMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterPriceMax" id="filter_price_max" min="1" max="999999" value="${vo.filterForm.priceMax}" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_quantity_min" class="form-label">現有庫存</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterQuantityMin" id="filter_quantity_min" min="1" max="999999" value="${vo.filterForm.quantityMin}" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterQuantityMax" id="filter_quantity_max" min="1" max="999999" value="${vo.filterForm.quantityMax}" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<input type="hidden" id="filter_status_value" value="${vo.filterForm.status}" />
								<label for="filter_status_1" class="form-label">商品狀態</label>
								<div class="d-flex mt-2">
									<div class="me-3 d-flex align-items-center">
										<div>
											<div class="form-check">
												<input class="form-check-input" type="radio" name="filterStatus" id="filter_status_1" value="1">
												<label class="form-check-label" for="filter_status_1">上架</label>
											</div>
										</div>
									</div>
									<div class="me-3 d-flex align-items-center">
										<div>
											<div class="form-check">
												<input class="form-check-input" type="radio" name="filterStatus" id="filter_status_0" value="0">
												<label class="form-check-label" for="filter_status_0">下架</label>
											</div>
										</div>
									</div>
									<div>
										<button type="button" class="btn btn-outline-primary" id="filter_status_reset_btn">reset</button>
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