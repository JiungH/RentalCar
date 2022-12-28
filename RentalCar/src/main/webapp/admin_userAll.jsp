<%@page import="java.util.ArrayList"%>
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
<section >
	<%
	request.setCharacterEncoding("utf-8");
		UserDao userDao = UserDao.getInstance();
		ArrayList<UserDto> users = userDao.getUserAll();
	%>
	 <input type="button" onclick="location.href='admin_userAll'" value="전체 회원정보" class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAll'" value="전체 자동차정보"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_return'" value="렌트카 반납확인"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAdd'" value="자동차 추가"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carDelete'" value="자동차 삭제"class ="button">
	<h2>전체 매니저조회</h2>
	<div class = "table-container">
			<table border = "1" class = "mytable">
			<thead>
				<tr>
					<th>회원 번호</th>
					<th>회원 아아디</th>
					<th>회원 비밀번호</th>
					<th>회원 이름</th>
					<th>회원 닉네임</th>
					<th>회원 성별</th>
					<th>회원 핸드폰번호</th>
					<th>회원 이메일</th>
					<th>회원가입 날짜</th>
				</tr>
			</thead>
			<tbody>
			<% for(UserDto user : users) { 
			if(user.isManager() == true){
			%>
			<tr>
				<td><%=user.getNo()%></td>
				<td><%=user.getId()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getNickname()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getResDate()%></td>
			</tr>
			<%
			}
			}
			%>
			</tbody>
		</table>
		</div>
	
	
	<h2>전체 회원정보</h2>
	<div class = "table-container">
			<table border = "1" class = "mytable">
			<thead>
				<tr>
					<th>회원 번호</th>
					<th>회원 아아디</th>
					<th>회원 비밀번호</th>
					<th>회원 이름</th>
					<th>회원 닉네임</th>
					<th>회원 성별</th>
					<th>회원 핸드폰번호</th>
					<th>회원 이메일</th>
					<th>회원가입 날짜</th>
				</tr>
			</thead>
			<tbody>
			<% for(UserDto user : users) {
			if(user.isManager() == false){ %>
			<tr>
					<td><%=user.getNo()%></td>
				<td><%=user.getId()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getNickname()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getResDate()%></td>
			</tr>
			<%
			}
			}
			%>
			</tbody>
		</table>
		</div>

</section>
<jsp:include page="footer.jsp"/>
</body>
</html>