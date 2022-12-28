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

	if(session.getAttribute("id") == null){
		response.sendRedirect("login");
	} else {
		String id = (String)session.getAttribute("id");
		UserDao userDao = UserDao.getInstance();
		UserDto user = userDao.getUserById(id);
	%>
	<h2>회원 정보</h2>
	<div class = "table-container">
			<table border = "1" class = "mytable">
			<thead>
				<tr>
					<th>회원 아아디</th>
					<th>회원 이름</th>
					<th>회원 닉네임</th>
					<th>회원 성별</th>
					<th>회원 핸드폰번호</th>
					<th>회원 이메일</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getNickname()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getPhone()%></td>
				<td><%=user.getEmail() %></td>
			</tr>
		 <form>	
		  <% if(!(Boolean)request.getSession().getAttribute("manager")) { %>
		 <input type="button" value="나의 예약" class="button" onclick="location.href='myReservation'"/>&nbsp; | &nbsp;
		 <% } %>
		 <input type="button" value="회원 정보수정" class ="button" onclick="location.href='modify?value=<%=id%>'">&nbsp; | &nbsp;
		 <input type="button" value="회원 탈퇴 "class ="button" onclick="location.href='delete?value=<%=id%>'" >&nbsp; | &nbsp;
		 <input type="button" value='작성글 모음' class="button" onclick="location.href='writeReview'"/>
		 <% if((Boolean) request.getSession().getAttribute("manager")) { %>
		  &nbsp; | &nbsp; <input type="button" value='관리자' class="button" onclick="location.href='admin_mypage'"/>
		 <% } %>
		</form>
		</tbody>
		</table>
		</div>
<%		
		}
%>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>