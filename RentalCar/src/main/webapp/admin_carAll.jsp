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
<section >
	<%
	request.setCharacterEncoding("utf-8");
		CarDao carDao = CarDao.getInstance();
		ArrayList<CarDto> cars = carDao.getCarALL();
	%>
	 <input type="button" onclick="location.href='admin_userAll'" value="전체 회원정보" class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAll'" value="전체 자동차정보"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_return'" value="렌트카 반납확인"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAdd'" value="자동차 추가"class ="button">&nbsp; | &nbsp;
	 <!-- <input type="button" onclick="location.href='admin_carUpdate'" value="자동차 수정"class ="button">&nbsp; | &nbsp; -->
	 <input type="button" onclick="location.href='admin_carDelete'" value="자동차 삭제"class ="button">
	<h2>전체 차량조회</h2>
	<h2>차량 고유번호 클릭시 수정가능</h2>
	<div class = "table-container">
			<table border = "1" class = "mytable">
			<thead>
				<tr>
					<th>차량 고유번호</th>
					<th>차량 모델</th>
					<th>차량 타입</th>
					<th>차량 번호</th>
					<th>차량 색상</th>
					<th>차량 이미지</th>
					<th>차량 렌트비</th>
					<th>차량 점검일자</th>
					<th>현재 사용자 이름</th>
				</tr>
			</thead>
			<tbody>
			<% for(CarDto car : cars) { 
			%>
			<tr style="width:100%">
				<td style="width:auto;"><a href='/RentalCar/admin_carUpdate?no=<%=car.getNo() %>' onclick = "return confirm('수정하시겠습니까?');"><%=car.getNo() %></a></td>
				<td style="width:auto;"><%=car.getName() %></td>
				<td style="width:auto;"><%=car.getType() %></td>
				<td style="width:auto;"><%=car.getNumber() %></td>
				<td style="width:auto;"><%=car.getColor() %></td>
				<td><img src = "<%=car.getImg() %>"style="width:200px; height:200px;"></td>
				<td style="width:auto;"><%=car.getPrice() %></td>
				<td style="width:auto;"><%=car.getCarCheckDate() %></td>	
				<%
				if(car.getUser() != null){
				%>
				<td style="width:auto;"><%=car.getUser()%>님</td>
				 <%}else{%>
				 <td style="width:auto;">차량을 이용하는 사람이 없습니다.</td>
				 <%} %>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>