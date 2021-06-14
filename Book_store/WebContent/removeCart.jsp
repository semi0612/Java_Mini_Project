<%@page import="java.util.ArrayList"%>
<%@page import="dto.Book_product"%>
<%@page import="dao.BookRepository"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html >
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		if(id == null || id.trim().equals("")){
			response.sendRedirect("products.jsp");
			return;
		}
		
		// ProductRepository 전체 가져오기
		BookRepository dao = BookRepository.getInstance();
		
		Book_product product = dao.getProductById(id);
		if(product == null){
			response.sendRedirect("exceptionNoProductId.jsp");
		}
		
		ArrayList<Book_product> cartList = (ArrayList<Book_product>) session.getAttribute("cartlist");
		Book_product goodsQnt = new Book_product();
		for (int i=0; i<cartList.size(); i++){
			goodsQnt = cartList.get(i);
			if(goodsQnt.getIsbn().equals(id)) {
				cartList.remove(goodsQnt);
			}
		}
		
		response.sendRedirect("cart.jsp");
	%>
</body>
</html>