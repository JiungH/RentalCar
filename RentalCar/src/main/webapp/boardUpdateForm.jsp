<%@page import="board.BoardDto"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/form.css">
</head>
<jsp:include page="header.jsp"/>
<body>
<section>
 <%
	BoardDao dao = BoardDao.getInstance();
	BoardDto board = null;
	
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("no") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		board = dao.getBoardByNo(no); %>

    <h1>EZEN BOARD</h1>
    <div class="form-container">
        <form method="post" action="boardUpdateAction">
       		<input type="text" value=" 작성자 : <%=board.getUser()%>" readonly>
        	<input type="hidden" name="no" value="<%=no%>">
            <input type="text" name="title" value="<%=board.getTitle() %>">
            <textarea name="content" rows="20"><%=board.getContent() %></textarea>
            <input type="submit" value="수정하기">
             <input type="button" onclick="location.href='board'" value="취소">
        </form>
    </div>
	<%}
	else {
		response.sendRedirect("index"); //borad 조회 실패 -> 페이지 이
	}%>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>