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
		<h2 class="mb-5">商品新增上架</h2>
		<div class="ms-4">
			<div class="text-primary mb-4">123</div>
			<form>
				<div class="d-flex">
					<div>
						<div class="mb-4 d-flex">
							<div class="row align-self-center justify-content-center me-3">
								<label for="good_name" class="form-label mb-0 col-auto">飲料名稱：</label>
							</div>
							<div>
								<input type="text" class="form-control" id="good_name" size="15" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="good_price" class="form-label mb-0 col-auto">設定價格：</label>
							</div>
							<div>
								<input type="number" class="form-control" id="good_price" size="5" min="0" max="1000" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="good_number" class="form-label mb-0 col-auto">初始數量：</label>
							</div>
							<div>
								<input type="number" class="form-control" id="good_number" size="5" min="0" max="1000" />
							</div>
						</div>
						<div class="mb-4 d-flex">
							<div class="row align-content-center justify-content-center me-3">
								<label for="good_image" class="form-label mb-0 col-auto">商品圖片：</label>
							</div>
							<div>
								<input type="file" class="form-control" id="good_image" accept="image/*" />
							</div>
						</div>
						
						
						<div class="mb-4 d-flex pt-1">
							<div class="row align-content-center justify-content-center me-3">
								<label for="good_status_1" class="form-label mb-0 col-auto">商品狀態：</label>
							</div>
							<div class="form-check mb-0 me-3">
								<input type="radio" class="form-check-input" name="goodStatus" id="good_status_1" value="1" />
								<label for="good_status_1" class="m-0 form-check-label">上架</label>
							</div>
							<div class="form-check mb-0">
								<input type="radio" class="form-check-input" name="goodStatus" id="good_status_0" value="0" />
								<label for="good_status_0" class="m-0 form-check-label">下架</label>
							</div>
						</div>
						
						<div class="mb-4">
							<button class="btn btn-outline-primary">新增</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	
</body>
</html>