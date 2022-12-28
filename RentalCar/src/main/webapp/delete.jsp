<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/mypage.css">
</head>
<jsp:include page="header.jsp"/>
<body>
<section>
		<h2>회원 	탈퇴</h2>
		<div class = "delete">
		<form method="post" action="/RentalCar/DeleteAction">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td>회원 아이디</td>
					<td><input type="text" id="id" name="id" placeholder = "아이디를 입력해주세요."></td>
				</tr>
				<tr>
					<td>회원 비밀번호</td>
					<td><input type="password" id="password" name="password" placeholder = "비밀번호를 입력해주세요."></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" onclick = "return confirm('정말 탈퇴하시겠습니까?'); " onclick = "return return alert('회원탈퇴가 완료 되었습니다.');" value="탈퇴">
						<input type="button" value="취소" onclick="location.href='mypage'"></td>
				</tr>
			</table>
		</form>
		</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>