<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*" %>
<%@ include file = "dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>

<title>상품 삭제</title>
</head>
<body>
	<%
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String isbn = request.getParameter("id");
	
		String sql = "select * from book";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			sql = "delete from book where p_isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.executeUpdate();
		} else {
			out.print("일치하는 상품이 없습니다");
		}
		if (rs != null) rs.close();
		if (pstmt != null) rs.close();
		if (conn != null) rs.close();
		
		response.sendRedirect("editBook.jsp?edit=delete");
	%>
</body>
</html>