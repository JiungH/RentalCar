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
if(session.getAttribute("id") == null){
	response.sendRedirect("login");
} 
int cnt = 0;
BoardDao dao = BoardDao.getInstance();
ArrayList<BoardDto> list = dao.getBoardAll();
%>
<h2>EZEN BOARD</h2>
<div class = "table-container">
	<table border="1">
		<thead>
		<button class = "button" onclick="location.href='boardWriteForm'">글쓰기</button>
			<tr>
				<th>no</th>
				<th width="200px">title</th>
                <th>user</th>
                <th>Date</th>
                <th>view</th>
			</tr>
		</thead>
		<tbody>
			<%for(BoardDto board : list) { 
				cnt++;
			%>
                <tr>
                    <td><%=cnt%></td>
                    <td><a href="boardView?no=<%=board.getNo()%>"><%=board.getTitle() %></a></td>
                    <td><%=board.getUser() %></td>
                    <%
                   	String date = "";
                    if(board.getModDate() == null){
                    	date += board.getRegDate();
                    }else{
                    	date += board.getModDate();
                    	date += "(수정)";
                    }
                    %>
                    <td><%=date %></td>
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