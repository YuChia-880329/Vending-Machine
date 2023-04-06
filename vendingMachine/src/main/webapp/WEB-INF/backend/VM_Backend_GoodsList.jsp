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
	
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">

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
						<c:forEach var="good" items="${vo.goodsTable.goods}">
							<tr>
								<th scope="row">${good.id}</th>
								<td>${good.name}</td> 
								<td>${good.price}</td>
								<td>${good.quantity}</td>
								<td>${good.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<c:set var="url" value=""></c:set>
				<div class="d-flex">
					<div class="me-auto">
						<nav aria-label="Page navigation" class="pt-4">
							<ul class="pagination">
								<c:if test="${vo.pagination.hasPreviousPage}">
									<li class="page-item">
								      	<a class="page-link" href="#" aria-label="Previous">
								        	<span aria-hidden="true">&laquo;</span>
								      	</a>
								    </li>
								</c:if>
							    <c:forEach var="p" items="${vo.pagination.pages}">
							    	<li class="page-item">
								    	<a class="page-link" href="#">${p.page}</a>
								    </li>
							    </c:forEach>
							    <c:if test="${vo.pagination.hasNextPage}">
									<li class="page-item">
								    	<a class="page-link" href="#" aria-label="Next">
									        <span aria-hidden="true">&raquo;</span>
										</a>
								    </li>
								</c:if>
						  	</ul>
						</nav>
					</div>
					
					<div class="d-flex">
						<button class="btn btn-outline-primary align-self-center">全部商品</button>
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
						<form>
							<div class="mb-3">
								<label for="filter_id_min" class="form-label">商品編號</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterIdMin" id="filter_id_min" min="1" max="999999" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterIdMax" id="filter_id_max" min="1" max="999999" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_name" class="form-label">商品名稱</label>
								<div class="d-flex">
									<div>
										<input type="text" class="form-control" name="filterName" id="filter_name" size="50" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_price_min" class="form-label">商品價格</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterPriceMin" id="filter_price_min" min="1" max="999999" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterPriceMax" id="filter_price_max" min="1" max="999999" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
								<label for="filter_quantity_min" class="form-label">現有庫存</label>
								<div class="d-flex">
									<div>
										<input type="number" class="form-control" name="filterQuantityMin" id="filter_quantity_min" min="1" max="999999" />
									</div>
									<div class="mx-3">
										<p>~</p>
									</div>
									<div>
										<input type="number" class="form-control" name="filterQuantityMax" id="filter_quantity_max" min="1" max="999999" />
									</div>
								</div>
							</div>
								
							<div class="mb-3">
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
										<button class="btn btn-outline-primary">reset</button>
									</div>
								</div>
							</div>
						</form>
					</div>
	      		</div>
	      		<div class="modal-footer">
	      			<button class="btn btn-primary me-auto">清空</button>
	        		<button class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
	        		<button class="btn btn-primary" data-bs-dismiss="modal">搜尋</button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
</body>
</html>