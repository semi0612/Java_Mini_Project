<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>DB연결처리</title>
</head>
<body>
	<%
	Connection conn = null;
	try {
		String url="jdbc:mysql://localhost:3306/bookstore";
		String user="root";
		String password="$^!423*^&";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		
	} catch (SQLException e) {
		out.print("데이터베이스 연결에 실패하였습니다 <br>");
		out.print("SQLException : " + e.getMessage());
	}
	%>
</body>
</html>