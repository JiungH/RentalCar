<%@page import="java.sql.Time"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="car.CarDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.CarDao"%>
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
<%
if(session.getAttribute("id") == null){
		response.sendRedirect("login");
	} 
%>
<h2>예약 가능 차량 보기</h2>

<div class = "table-container">
		<div>
		<form method="post" action = "/RentalCar/posibleToBook.jsp">
			<a>시작 일자 : </a>
			<input type = "date" id="startDate" name ="startDate" min="today">
			<a>끝나는 일자 : </a>
			<input type = "date" id="endDate" name ="endDate" min = "today">
			<input type = "submit" value="검색">
		</form>
		</div>
</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>