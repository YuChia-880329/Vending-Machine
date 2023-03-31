<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-後臺</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.bundle.min.js"></script>
	
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
						<button class="btn btn-outline-primary" id="filter_btn">篩選條件</button>
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
</body>
</html>