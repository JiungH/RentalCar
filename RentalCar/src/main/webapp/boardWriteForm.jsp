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
String id = (String)session.getAttribute("id");
if(id == null){
	response.sendRedirect("login");
}else{
%>
 <h1>EZEN BOARD</h1>
    <div class="form-container">
        <form method="post" action="boardWriteAction">
            <input type="text" name="title" placeholder="제목" required>
            <textarea name="content" rows="20" placeholder="글내용" required></textarea>
            <input type="submit" value="글등록">
            <input type="button" onclick="location.href='board'" value="취소">
        </form>
    </div>
    <%
	}
    %>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>