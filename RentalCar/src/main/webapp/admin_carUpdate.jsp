<%@page import="car.CarDto"%>
<%@page import="car.CarDao"%>
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
<section>
	<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
		CarDao carDao = CarDao.getInstance();
		CarDto carDto = null;
		carDto = carDao.getCarByNo(no);
	%>
	 <input type="button" onclick="location.href='admin_userAll'" value="전체 회원정보" class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAll'" value="전체 자동차정보"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_return'" value="렌트카 반납확인"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAdd'" value="자동차 추가"class ="button">&nbsp; | &nbsp;
	<!--  <input type="button" onclick="location.href='admin_carUpdate'" value="자동차 수정"class ="button">&nbsp; | &nbsp; -->
	 <input type="button" onclick="location.href='admin_carDelete'" value="자동차 삭제"class ="button">
	<h2>차량 정보수정</h2>
	<div class ="joinForm">
	<form method= "POST" action="/RentalCar/CarModifyAction">
	<table>
		<tr>
			<td id="title">차량 고유번호</td>
			<td><input type="text" id="no" name = "no" value ="<%=carDto.getNo()%>" readonly ></td>
		</tr>
		<tr>
			<td id="title">차량 모델</td>
			<td><input type="text" id="name" name = "name" value ="<%=carDto.getName()%>" readonly ></td>
		</tr>
		<tr>
			<td id="title">차량 타입</td>
			<td><input type="text" id="type" name = "type" value ="<%=carDto.getType()%>" readonly ></td>
		</tr>
		<tr>
			<td id="title">차량 번호</td>
			<td><input type="text" id="number" name = "number" value ="<%=carDto.getNumber()%>" readonly ></td>
		</tr>
		<tr>
			<td id="title">차량 색상</td>
			<td><input type="text" id="color" name = "color" value ="<%=carDto.getColor()%>"  ></td>
		</tr>
		<tr>
			<td id="title">차량 이미지</td>
			<td><input type="text" id="img" name = "img" value ="<%=carDto.getImg()%>"  ></td>
		</tr>
		<tr>
			<td id="title">차량 렌트비</td>
			<td><input type="text" id="price" name = "price" value ="<%=carDto.getPrice()%>"  ></td>
		</tr>
		<tr>
			<td id="title">차량 점검일</td>
			<td><input type="date" id="carCheckDate" name = "carCheckDate"></td>
		</tr>
		<tr>
			<td id = "btnWarp" colspan="2" style="text-align: center">
			<input type="submit" value="등록">
			<input type="button" onclick="/RentalCar/admin_carAll" value="취소">
		</tr>
	</table>
	</form>
	</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>