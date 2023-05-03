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
	<link rel="stylesheet" href="../../css/common.css">
	
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	<script src="../../js/util.js"></script>
	<script src="../../js/backend/backend_orderList.js"></script>
	
	<script type="text/javascript">
		
		$(document).ready(readyFctn);
		
		function readyFctn(){
			
			$('#' + filterBtnId).click(filterBtnClicked);
			$('#' + allOrdersBtn).click(allOrdersBtnClicked);
			$('#' + filterFormResetBtnId).click(filterFormResetBtnClicked);
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


	<%@ include file="modal/backend_orderList_modal.jsp" %>
	<%@ include file="../../modal.jsp" %>
</body>
</html>