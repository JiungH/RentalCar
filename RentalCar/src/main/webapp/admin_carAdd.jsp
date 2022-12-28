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
int no = carDao.getLastNo();
%>

<h2>인수차량 정보 입력</h2>
<div class ="joinForm">
	<form method="POST" action="/RentalCar/CarAddAction">
			<table>
					<tr>
						<td id="title">차량 고유번호</td>
						<td><input type="text" id="no" name="no" value="<%=no%>"
							maxlength="50" readonly>
						<td>
					</tr>
					<tr>
						<td id="title">차량 모델</td>
						<td><input type="text" id="name" name="name" maxlength="20"
							placeholder="차량 모델을 입력해주세요.">
						<td>
					</tr>
					<tr>
						<td id="title">차량 타입</td> 
						<td><select id="type" name="type">
								<option value="타입">차량 타입을 선택해주세요.</option>
								<option value="경형">경형</option>
								<option value="소형">소형</option>
								<option value="중준형">중준형</option>
								<option value="중형">중형</option>
								<option value="준대형">준대형</option>
								<option value="대형">대형</option>
								<option value="스포츠카">스포츠카</option>
						</select>
						<td>
					</tr>
					<tr>
						<td id="title">차량 번호</td>
						<td><input type="text" id="number" name="number" maxlength="20"
							placeholder="차량번호를 입력하시오.">
						<td>
					</tr>
					<tr>
						<td id="title">차량 색상</td>
						<td><input type="text" id="color" name="color" maxlength="20"
							placeholder="차량 색상을 입력하세요">
						<td>
					</tr>
					<tr>
						<td id="title">차량 이미지</td>
						<td><input type="text" id="img" name="img" placeholder="이미지 링크를 넣주세요.">
						<td>
					</tr>
					<tr>
						<td id="title">차량 렌트비</td>
						<td><input type="text" id="price" name="price" maxlength="20"
							placeholder="일일 렌트비를 입력해주세요.">
						<td>
					</tr>
					<tr>
						<td id="title">차량 저체 점검일을 선택해주세요.</td>
						<td><input type="date" id="carCheckDate" name="carCheckDate">
						<td>
					</tr>
					
					<tr>
						<td id="btnWarp" colspan="2" style="text-align: center">
						<input type="submit" value="등록"> 
						<input type="button" onclick="/RentalCar/admin_carAll" value="취소">
						</td>
					</tr>
		</table>
	</form>
	</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>