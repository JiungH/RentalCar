<%@page import="java.sql.Date"%>
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
<jsp:include page="header.jsp" />
<body>
	<section>
		<%
		request.setCharacterEncoding("utf-8");
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login");
		} else {
			String sD = request.getParameter("startDate");
			String eD = request.getParameter("endDate");
			System.out.println(sD);
			System.out.println(eD);
			if (sD == "" || eD == "") {
		%>
		<script type="text/javascript">
			alert('날짜를 모두 입력해주세요.');
			location.href = "rental";
		</script>

		<%
		}
		CarDao carDao = CarDao.getInstance();
		ArrayList<CarDto> cars = carDao.getCarALL();
		%>
		<h2>예약 가능 차량 보기</h2>

		<div class="table-container">
			<table border="1" class="mytable">
				<thead>
					<tr>
						<th>차량 모델</th>
						<th>차량 색상</th>
						<th>차량 이미지</th>
						<th>차량 렌트비</th>
					</tr>
				</thead>
				</tbody>
				<%
				for (CarDto car : cars) {
					if (!car.isCheck()) {
				%>
				<tr>

					<td style="width: auto;"><a
						href='/RentalCar/CarBookingAction?no=<%=car.getNo()%>&sd=<%=sD%>&ed=<%=eD%>'
						onclick="return confirm('예약하시겠습니까?');"><%=car.getName()%></a></td>
					<td style="width: auto;"><%=car.getColor()%></td>
					<td><img src="<%=car.getImg()%>"
						style="width: 200px; height: 200px;"></td>
					<td style="width: auto;"><%=car.getPrice()%></td>
				</tr>
				<%
				}
				}
				}
				%>
			</table>
		</div>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>