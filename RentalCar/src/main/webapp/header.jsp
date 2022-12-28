<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/grid.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%
		String id = (String)session.getAttribute("id");
		if(id == null){
		%>
		<ul class = "a">
			<li class = "log"><a href="login.jsp">로그인</a>
			<li class = "join"><a href="join.jsp">회원가입</a>
		</ul>
		<%}else{ %>
		<div class = "a">
			<span class = "hello"><b><%=id %></b>님이 안녕하세요.</span>
			<button class = "logout" onclick="location.href='/RentalCar/LogoutAction'">logout</button>
		</div>
		<%}%>
		<h1><a href="home">EZEN RENTAL CAR</a></h1>
	</header>
	<nav>
		<ul>
			<li><a href="guide">회사소개</a></li>
			<li><a href="rental">차량대여</a></li>
			<li><a href="board">커뮤니티</a></li>
			<li><a href="mypage">마이페이지</a></li>
		</ul>
	</nav>
	<aside>
		<a>광고 이미지 준비중입니다.</a>
	</aside>
</body>
</html>