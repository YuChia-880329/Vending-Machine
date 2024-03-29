<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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