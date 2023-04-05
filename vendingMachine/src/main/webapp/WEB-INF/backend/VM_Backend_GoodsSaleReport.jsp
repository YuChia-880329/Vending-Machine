<!-- url : /vendingMachine/machine/backend/goodsSale -->
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
	
	<script type="text/javascript">
	
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
							<tr>
								<td>Andy</td>
								<td>2023-03-31</td>
								<td>drink</td>
								<td>100</td>
								<td>1</td>
								<td>100</td>
							</tr>
							<tr>
								<td>Andy</td>
								<td>2023-03-31</td>
								<td>drink</td>
								<td>100</td>
								<td>1</td>
								<td>100</td>
							</tr>
							<tr>
								<td>Andy</td>
								<td>2023-03-31</td>
								<td>drink</td>
								<td>100</td>
								<td>1</td>
								<td>100</td>
							</tr>
						</tbody>
					</table>
					
					<div>
						<div class="d-flex">
							<div class="me-auto">
								<nav aria-label="Page navigation" class="pt-4">
									<ul class="pagination">
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <li class="page-item">
								    	<a class="page-link" href="#">1</a>
								    </li>
								    <li class="page-item">
								    	<a class="page-link" href="#">2</a>
								    </li>
								    <li class="page-item">
								    	<a class="page-link" href="#">3</a>
								    </li>
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
								  </ul>
								</nav>
							</div>
							
							<div class="d-flex align-self-center">
								<button class="btn btn-outline-primary">全部報表</button>
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
			<form>
				
				<div class="mb-3">
					<label for="filter_customer_name" class="form-label">顧客姓名</label>
					<div class="d-flex">
						<div>
							<input type="text" class="form-control" id="filter_customer_name" size="50" />
						</div>
					</div>
				</div>
			
				<div class="mb-3">
					<label for="filter_date_min" class="form-label">購買日期</label>
					<div class="d-flex">
						<div>
							<input type="date" class="form-control" id="filter_date_min" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="date" class="form-control" id="filter_date_max" />
						</div>
					</div>
				</div>
				
				<div class="mb-3">
					<label for="filter_good_name" class="form-label">飲料名稱</label>
					<div class="d-flex">
						<div>
							<input type="text" class="form-control" id="filter_good_name" size="50" />
						</div>
					</div>
				</div>
				
				<div class="mb-3">
					<label for="filter_good_price_min" class="form-label">飲料價格</label>
					<div class="d-flex">
						<div>
							<input type="number" class="form-control" id="filter_good_price_min" min="1" max="999999" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="number" class="form-control" id="filter_good_price_max" min="1" max="999999" />
						</div>
					</div>
				</div>
				
				<div class="mb-3">
					<label for="filter_quantity_min" class="form-label">購買數量</label>
					<div class="d-flex">
						<div>
							<input type="number" class="form-control" id="filter_quantity_min" min="1" max="999999" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="number" class="form-control" id="filter_quantity_max" min="1" max="999999" />
						</div>
					</div>
				</div>
				
				<div class="mb-3">
					<label for="filter_total_price_min" class="form-label">購買金額</label>
					<div class="d-flex">
						<div>
							<input type="number" class="form-control" id="filter_total_price_min" min="1" max="999999" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="number" class="form-control" id="filter_total_price_max" min="1" max="999999" />
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