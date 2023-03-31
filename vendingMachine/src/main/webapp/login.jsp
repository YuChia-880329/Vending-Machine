<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-登入</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">
	</script>
</head>
<body style="background-image: url('images/background_image.jpg');">
	
	<div class="position-absolute top-50 start-50 translate-middle">
		<div>
			<form>
				<div class="mb-4">
					<label for="account" class="form-label">帳號</label>
					<input type="text" class="form-control" id="account" size="50" />
				</div>
				<div class="mb-4">
					<label for="password" class="form-label">密碼</label>
					<input type="password" class="form-control" id="password" size="50" />
				</div>
				<div>
					<button class="btn btn-outline-primary">登入</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>