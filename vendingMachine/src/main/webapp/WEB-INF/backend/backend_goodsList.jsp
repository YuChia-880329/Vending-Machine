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
	<script src="../../js/backend/backend_goodsList.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + allGoodsBtn).click(allGoodsBtnClicked);
			$('#' + filterBtnId).click(filterBtnClicked);
			initFilterStatus();
			$('#' + filterStatusResetBtnId).click(filterStatusResetBtnClicked);
			$('#' + filterFormResetBtnId).click(filterFormResetBtnClicked);
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
	
	
	
	<%@ include file="modal/backend_goodsList_modal.jsp" %>
	<%@ include file="../../modal.jsp" %>
</body>
</html>