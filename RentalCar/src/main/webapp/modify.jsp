<%@page import="user.UserDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/mypage.css">
</head>
<jsp:include page="header.jsp"/>
<body>
<%
request.setCharacterEncoding("utf-8");
UserDao userDao = UserDao.getInstance();
UserDto user = null;

String id = request.getParameter("value");
user = userDao.getUserById(id);
%>
	<section>
		<h2>회원 정보 수정</h2>
		<form method="post" action="/RentalCar/ModifyAction">
			<table border="1" style="border-collapse: collapse;" class="mytable">
				<tr style="background-color:#ddd;">
					<td>회원번호</td>
					<td><input type="text" id="no" name = "no" value = "<%=user.getNo()%>" readonly></td>
				</tr>
				<tr	style="background-color:#ddd;">
					<td>회원아이디</td>
					<td><input type="text" id="id" name = "id" value = "<%=user.getId()%>" readonly></td>
				</tr>
				<tr>
					<td>회원비밀번호</td>
					<td><input type="password" id="password" name = "password" value ="<%=user.getPassword()%>"></td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td><input type="text" id="name" name = "name" value = "<%=user.getName()%>"></td>
				</tr>
				<tr>
					<td>회원닉네임</td>
					<td><input type="text" id="nickname" name = "nickname" value = "<%=user.getNickname()%>"></td>
				</tr>
				<tr>
					<td>회원성별</td>
					<td><input type="text" id="gender" name = "gender" value = "<%=user.getGender()%>" readonly></td>
				</tr>
				<tr>
					<td>회원휴대폰</td>
					<td><input type="text" id="phone" name = "phone" value = "<%=user.getPhone()%>"></td>
				</tr>
				<tr>
					<td>회원이메일</td>
					<td><input type="text" id="phone" name = "phone" value = "<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" onclick="alert('회원정보수정이 완료 되었습니다.')"class ="button">&nbsp; | &nbsp; <input
						type="button" value="취소" onclick = "location.href='user_mypage.jsp'" class ="button"></td>
				</tr>
			</table>
		</form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>