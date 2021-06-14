<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book_product"%>
<%@ page import="dao.BookRepository"%>
<!DOCTYPE html >
<html>
<head>
<title>장바구니에 추가하기 위해 넘겨줄 자료 처리</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		//id가 없으면 상품목록으로 페이지 이동해라 
		if(id == null || id.trim().equals("")) {
			response.sendRedirect("caregory_all.jsp");
			return;
		}
	
		//전체 상품목록의 객체 주소를 얻어온다
		BookRepository dao = BookRepository.getInstance();
		Book_product product = dao.getProductById(id);
		if(product == null) {
			response.sendRedirect("exceptionNoProductId.jsp");
		}
		
		
		ArrayList<Book_product> goodsList = dao.getAllProducts();
		// 구매하려는 정보를 담기위한 빈 객체 생성
		Book_product goods = new Book_product();
		for(int i=0;i<goodsList.size(); i++){
			goods=goodsList.get(i);
			if(goods.getIsbn().equals(id)){
				break;
			}
		}
		
		
		//"cartlist" 라는 이름으로 설정된 '섹션명'으로 '섹션값'을 가지고 옴
		ArrayList<Book_product> list =(ArrayList<Book_product>) session.getAttribute("cartlist");
		//아래의 if가 참인 경우는 session없는 경우 
		if(list == null){
			list = new ArrayList<Book_product>();
			session.setAttribute("cartlist", list);//섹션을 생성한다.
		}
		
		
		int cnt=0;//장바구니에 담긴 상품의 갯수
		Book_product goodsQnt = new Book_product();
		
		for(int i=0;i<list.size(); i++) {
			goodsQnt = list.get(i);
			if(goodsQnt.getIsbn().equals(id)){
				cnt++;
				//장바구니에 담은 갯수 + 1  ,  각 상품에 대한 구매갯수
				int orderQuantity = goodsQnt.getQuantity() + 1;
				//장바구니에 담은 갯수
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		
		if (cnt == 0) {
			goods.setQuantity(1);
			list.add(goods);
		}
		
		//장바구니에 담아 놓은 상품의 상세정보로 이동시킨다
		response.sendRedirect("book_detail.jsp?id=" + id);
	%>

</body>
</html>