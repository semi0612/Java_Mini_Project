<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dto.Book_product"%>
<%@page import="com.oreilly.servlet.*" %>
<%@page import="com.oreilly.servlet.multipart.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
	
<title>addBook</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String filename="";
		String readFolder = "c:/upload/book_image"; // 사용자가 사진을 등록하면 여기에 저장되고
									// 상품 목록을 불러올 때 여기에 저장된 것을 불러오는 것이다.
		int maxSize = 50*1024*1024; // 최대 업로드 크기 = 50MB
		String enctype="utf-8";
	  	MultipartRequest multi = 
	   		   new MultipartRequest(request, readFolder, maxSize, enctype, new DefaultFileRenamePolicy());
	
		String isbn = multi.getParameter("isbn");
		String category = multi.getParameter("category");
		String name = multi.getParameter("name");
		String author = multi.getParameter("author");
		String unitPrice = multi.getParameter("unitPrice");
		String description = multi.getParameter("description");
		String unitsInStrock = multi.getParameter("unitsInStrock");
		String state = multi.getParameter("state");

		Integer price;
		if(unitPrice.isEmpty()) {
			price = 0;
		} else {
			price = Integer.valueOf(unitPrice);
		}
		
		
		long stock;
		if(unitsInStrock.isEmpty()) {
			stock = 0;
		} else {
			stock = Long.valueOf(unitsInStrock);
		}
		
		// 폼 페이지에서 전송된 요청 파라미터 중 파일을 받을 수 있도록
		// MultipartRequest 객체 타입인 getFileNames() 메소드를 작성
		Enumeration files = multi.getFileNames();
		// 폼 페이지에서 전송된 요청 파라미터 중 파일을 받을 수 있도록
		// Enumeration 객체 타입의 nextElement()메소드를 작성
		String fname = (String) files.nextElement();
		// 폼 페이지에서 전송되어 서버에 업로드된 파일을 가져오도록
		// MultipartRequest 객체 타입의 getFilesystemName() 메소드를 작성
		String fileName = multi.getFilesystemName(fname);
		
	%>
		
	<%@ include file="dbconn.jsp" %>
		
	<%
		PreparedStatement pstmt = null;	
	
		String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?, ?, ? )";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		pstmt.setString(2, category);
		pstmt.setString(3, name);
		pstmt.setString(4, author);
		pstmt.setInt(5, price);
		pstmt.setString(6, description);
		pstmt.setLong(7, stock);
		pstmt.setString(8, state);
		pstmt.setString(9, fileName);
		pstmt.executeUpdate();
		
		if (pstmt != null) pstmt.close();
		if (conn != null) pstmt.close();
		
		response.sendRedirect("category_all.jsp");
		
	%>
</body>
</html>