<!-- url : /vendingMachine/machine/backend/goodsList -->
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
	
		let filterBtnId = 'filter_btn';
		let filterModalBodyTmplId = 'filter_modal_body_tmpl';
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + filterBtnId).click(filterBtnClicked);
		}
	
		function filterBtnClicked(){
			
			var titleText = '篩選條件';
			var bodyHtml = $('#' + filterModalBodyTmplId).clone()[0].content;
			var okBtnText = '搜尋';
			var okBtnFtcn = function(){
				
				console.log('Search');
			}
			
			confirmModal(titleText, bodyHtml, okBtnText, okBtnFtcn).show();
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
					<button class="btn btn-outline-primary" id="filter_btn">篩選條件</button>
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
						<tr>
							<th scope="row">1</th>
							<td>name1</td> 
							<td>price1</td>
							<td>quantity1</td>
							<td>status1</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>name2</td> 
							<td>price2</td>
							<td>quantity2</td>
							<td>status2</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>name3</td> 
							<td>price3</td>
							<td>quantity3</td>
							<td>status3</td>
						</tr>
					</tbody>
				</table>
				
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
					
					<div class="d-flex">
						<button class="btn btn-outline-primary align-self-center">全部商品</button>
					</div>
				</div>
				
			</div>
	  	</div>
	</div>
	
	
	
	
	<%@ include file="../../modal.jsp" %>
	
	<template id="filter_modal_body_tmpl">
		<div class="container">
			<form>
				<div class="mb-3">
					<label for="filter_id_min" class="form-label">商品編號</label>
					<div class="d-flex">
						<div>
							<input type="number" class="form-control" id="filter_id_min" min="1" max="999999" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="number" class="form-control" id="filter_id_max" min="1" max="999999" />
						</div>
					</div>
				</div>
					
				<div class="mb-3">
					<label for="filter_name" class="form-label">商品名稱</label>
					<div class="d-flex">
						<div>
							<input type="text" class="form-control" id="filter_name" size="50" />
						</div>
					</div>
				</div>
					
				<div class="mb-3">
					<label for="filter_price_min" class="form-label">商品價格</label>
					<div class="d-flex">
						<div>
							<input type="number" class="form-control" id="filter_price_min" min="1" max="999999" />
						</div>
						<div class="mx-3">
							<p>~</p>
						</div>
						<div>
							<input type="number" class="form-control" id="filter_price_max" min="1" max="999999" />
						</div>
					</div>
				</div>
					
				<div class="mb-3">
					<label for="filter_quantity_min" class="form-label">現有庫存</label>
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
					<label for="filter_status_1" class="form-label">商品狀態</label>
					<div class="d-flex mt-2">
						<div class="me-3">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="filter_status" id="filter_status_1" value="1">
								<label class="form-check-label" for="filter_status_1">上架</label>
							</div>
						</div>
						<div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="filter_status" id="filter_status_0" value="0">
								<label class="form-check-label" for="filter_status_0">下架</label>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</template>
	
</body>
</html>