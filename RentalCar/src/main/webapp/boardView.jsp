<%@page import="board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/form.css">
</head>
<jsp:include page="header.jsp" />
<body>
	<section>
		<%
		BoardDao dao = BoardDao.getInstance();
		BoardDto board = null;
		String id = (String)session.getAttribute("id");
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("no") != null) {
			int no = Integer.parseInt(request.getParameter("no"));
			board = dao.getBoardByNo(no);
			int cnt = board.getViewCnt();
			cnt++;
			dao.addViewCnt(cnt, no);
		%>

		<h1>EZEN BOARD</h1>
		<div class="form-container">
			<form method="post">
				<input type="text" value=" 작성자 : <%=board.getUser()%>" readonly>
				<input type="text" value="<%=board.getTitle()%>" readonly>
				<textarea rows="20" readonly><%=board.getContent()%></textarea>
				<input type="button" onclick="location.href='board'" value="글 목록">
				<% 
				if(id.equals(board.getUser())){
				%>
				<input type="button" onclick="if(confirm('수정하시겠습니까?'))location.href='boardUpdateForm?no=<%=board.getNo()%>'"value="글수정"> 
				<input type="button" onclick="if(confirm('삭제하시겠습니까?'))location.href='boardDeleteAction?no=<%=board.getNo()%>'" value="글 삭제">
				<%
				}
				%>
			</form>
		</div>
		<%
		} else {
		response.sendRedirect("index"); //borad 조회 실패 -> 페이지 이
		}
		%>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>