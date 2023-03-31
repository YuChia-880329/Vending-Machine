<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機</title>
	
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">
	</script>
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<div class="d-flex justify-content-end">
				<div>
					<form>
						<div class="d-flex">
							<div class="me-3">
								<input type="text" class="form-control" size="50" />
							</div>
							<div>
								<button class="btn btn-outline-primary">商品查詢</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="mt-5">
			<div class="row">
			
				<div class="col-4 text-center">
					<img class="mb-4" alt="VendingMachine" src="../images/vending_machine.jpg" width="200" height="200" />
				
					<h1 class="mb-4">歡迎光臨，Andy！</h1>
					
					<div class="mb-5">
						<a href="#" class="link-primary h4">後臺頁面</a>&nbsp; &nbsp;
						<a href="#" class="link-primary h4">登出</a>
					</div>
					
					<div class="mb-4">
						<form>
							<div class="d-flex justify-content-center">
								<div class="me-4 d-flex align-self-center">
									<b>投入 : </b>
								</div>
								<div class="me-4">
									<input type="number" class="form-control" max="999999" min="0" />
								</div>
								<div class="me-4 d-flex align-self-center">
									<b>元</b>
								</div>
								<div>
									<button class="btn btn-outline-primary">結帳</button>
								</div>
							</div>
						</form>
					</div>
					
					<div>
						<div class="d-flex justify-content-center">
							<div>
								<div style="border-width:3px;border-style:dashed;border-color:#FFAC55;padding:5px;width:300px;">
									<p style="color: blue;">~~~~~~~ 消費明細 ~~~~~~~</p>
									<p class="my-2">1</p>
									<p class="my-2">2</p>
									<p class="my-2">3</p>
								</div>
							</div>
						</div>
						
					</div>
					
				</div>
				
				<div class="col-8">
				
					<div class="mb-4">
						<div class="row row-cols-3 g-5">
					
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
							      	
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20130813154445805.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
							      	
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20130813155636918.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20190201101804603.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20190201101804603.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20190201101804603.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
							<div class="col">
								<div class="card text-center">
									<div class="card-header">
										<h3 class="mb-2">Drink</h3>
										<p class="text-secondary mb-0">
											<span>10</span>元/罐
										</p>
									</div>
								    <div class="card-body">
								    	<div class="mb-4">
								    		<img src="../images/20190201101804603.jpg" alt="Drink" width="150" height="150" />
								    	</div>
								    	<div class="mb-3">
								    		<div class="d-flex justify-content-center">
								    			<div class="me-3 d-flex align-self-center">
								    				<p class="m-0">購買</p>
								    			</div>
								    			<div class="me-3">
								    				<input type="number" class="form-control" min="0" max="999999" />
								    			</div>
								    			<div class="d-flex align-self-center">
								    				<p class="m-0">罐</p>
								    			</div>
								    		</div>
								    	</div>
								    	
								        <p class="card-text text-danger">
								        (庫存 <span>10</span> 罐)
								        </p>
								    </div>
							    </div>
							</div>
							
						
						</div>
					</div>
					
					
					<div class="mb-4">
						<div class="d-flex">
							<div class="me-auto">
								<button class="btn btn-outline-primary">所有飲料</button>
							</div>
							<div>
								<nav aria-label="Page navigation">
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
							
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
		
	</div>
</body>
</html>