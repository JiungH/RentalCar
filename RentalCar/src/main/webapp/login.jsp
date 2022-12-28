<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/login.css">
</head>
<jsp:include page="header.jsp"/>
<body>
<section>
	<div class = "inner" >
		<form method="post" action = "/RentalCar/LoginAction">
			<h2>LOGIN</h2>
				<input type="text" id = "id" name = "id" placeholder= "아이디를 입력해주세요"/>
				<input type="password" id = "password" name = "password" placeholder= "비밀번호를 입력해주세요"/>
				<input id="submitBtn" type="submit" value="login"/>
		</form>
	</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>