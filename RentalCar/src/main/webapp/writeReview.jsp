<%@page import="board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/table.css">
</head>
<jsp:include page="header.jsp"/>
<body>
<section>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String id = (String)session.getAttribute("id");
	BoardDao dao = BoardDao.getInstance();
	ArrayList<BoardDto>list = dao.getBoardById(id);
	%>
	<h2>나의 리뷰</h2>
	<div class = "table-container">
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th width="200px">title</th>
                <th>regDate</th>
                <th>modDate</th>
                <th>view</th>
			</tr>
		</thead>
		<tbody>
			<%for(BoardDto board : list) {%>
                <tr>
                    <td><%=board.getNo() %></td>
                    <td><a href="boardView?no=<%=board.getNo()%>"><%=board.getTitle() %></a></td>
                    <td><%=board.getRegDate() %></td>
                    <td><%=board.getModDate() %></td>
                    <td><%=board.getViewCnt() %></td>
                </tr>
            <%} %>
		</tbody>
	</table>
</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>