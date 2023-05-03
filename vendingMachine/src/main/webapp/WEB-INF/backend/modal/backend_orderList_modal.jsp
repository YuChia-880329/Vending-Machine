<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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