<%@page import="java.util.ArrayList"%>
<%@page import="car.CarDto"%>
<%@page import="car.CarDao"%>
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
String id = (String)session.getAttribute("id");
if(id == null){
	response.sendRedirect("login");
}else{
CarDao carDao = CarDao.getInstance();
ArrayList<CarDto> carDto = new ArrayList<>();
carDto = carDao.getCarByUser(id);
if(carDto == null){
%>
<h1>현재 예약되어있는 차가 없습니다!!</h1>
<h2>지금 예약하러 가실까요??</h2>
<a href = "rental">클릭시 예약페이지로 이동합니다.</a>
<%
}else{
%>
<h1>나의 차량예약</h1>
<div class = "table-container">
	<table border ="1" class = "mytable">
		<thead>
		<tr>
			<th>차량 모델</th>
			<th>차량 번호</th>
			<th>차량 색상</th>
			<th>차량 이미지</th>
			<th>차량 가격</th>
			<th>차량 시작일</th>
			<th>차량 반납일</th>
			<th>예약 취소</th>
		</tr>
		</thead>
		<tbody>
		<% for(CarDto car : carDto) { %>
		<tr style="width:100%">
				<td style="width:auto;"><%=car.getName() %></td>
				<td style="width:auto;"><%=car.getNumber() %></td>
				<td style="width:auto;"><%=car.getColor() %></td>
				<td><img src = "<%=car.getImg() %>"style="width:200px; height:200px;"></td>
				<td style="width:auto;"><%=car.getPrice() %></td>
				<td style="width:auto;"><%=car.getRentTime()%></td>			
				<td style="width:auto;"><%=car.getReturnTime() %></td>
				<td style="width:auto;"><a href='/RentalCar/CarCancelAction?no=<%=car.getNo() %>' onclick = "return confirm('예약을 취소하시겠습니까?(환불은 최소 하루전에만 가능합니다.)');">예약취소</a></td>
							
			</tr>
			<% } %>
			</tbody>
	</table>
</div>
<%
}
}
%>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>