<%@page import="user.UserDao"%>
<%@page import="user.UserDto"%>
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

	if(session.getAttribute("id") == null){
		response.sendRedirect("login");
	} else {
		String id = (String)session.getAttribute("id");
		UserDao userDao = UserDao.getInstance();
		UserDto user = userDao.getUserById(id);
	%>
	 <input type="button" onclick="location.href='admin_userAll'" value="전체 회원정보" class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAll'" value="전체 자동차정보"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_return'" value="렌트카 반납확인"class ="button">&nbsp; | &nbsp;
	 <input type="button" onclick="location.href='admin_carAdd'" value="자동차 추가"class ="button">&nbsp; | &nbsp;
	<!--  <input type="button" onclick="location.href='admin_carUpdate'" value="자동차 수정"class ="button">&nbsp; | &nbsp; -->
	 <input type="button" onclick="location.href='admin_carDelete'" value="자동차 삭제"class ="button">
	  <% } %>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>