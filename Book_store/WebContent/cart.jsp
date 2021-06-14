<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.BookRepository" %>
<%@page import="dto.Book_product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- 해당 페이지 타이틀 -->
<title>BookForest Addbook</title>
<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/login.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">


<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 --> 
<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>
	

<style>
.jumbotron {
	background-color:#e9ec99;
}

.display{
	font-size : 28px;
	
}
body {
  	background-image: url(resources/images/background.jpg);
  	min-height: 100%;
  	background-repeat : no-repeat;
    background-size : cover;
}
</style>
	<script type="text/javascript">
	function deleteToCart() {
		if (confirm("상품을 삭제합니다")) {
			document.addForm.submit();
		} else {
			document.addForm.reset();
		}
	}
	</script>
</head>
<body>
	<%
	String cartId = session.getId();
	DecimalFormat dFormat = new DecimalFormat("###,###");
	%>

<div class="container">	
	<!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>	
			<div class="jumbotron">
					<h1 class="display"> 장바구니</h1>
			</div>

		
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th> 상품 </th>
					<th> 가격 </th>
					<th> 수량 </th>
					<th> 소계 </th>
					<th> 비고 </th>
				</tr>
				<%
					int sum=0;
					ArrayList<Book_product> cartList = (ArrayList<Book_product>)session.getAttribute("cartlist");
					if (cartList == null) {
						cartList = new ArrayList<Book_product>();
					}
					// 상품 리스트 하나씩 출력하기
					for (int i=0; i<cartList.size(); i++){
						Book_product product = cartList.get(i);
						int total = product.getUnitPrice()*product.getQuantity();
						sum = sum + total;
				%>
				<tr>
					<td><%= product.getIsbn() %> - <%= product.getName() %></td>
					<td><%= product.getUnitPrice() %> </td>
					<td><%= product.getQuantity() %> </td>
					<td><%= total %></td>
					<td><a href="./removeCart.jsp?id=<%=product.getIsbn()%>" class="badge badge-danger"  onclick="deleteToCart()"> 삭제</a></td>
				</tr>
				<%
					}
				%>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%= sum %></th>
					<th></th>
				</tr>
			</table>
			<a href="./category_all.jsp" class="btn btn-outline-secondary"> &laquo; 쇼핑 계속하기 </a>
	</div>
			<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
					<a href="./deleteCart.jsp?cartId=<%=cartId%>" class="btn btn-outline-danger" onclick="deleteToCart()"> 삭제하기 </a></td>
					<td align="right"><a href="./shippingInfo.jsp?cartId=<%= cartId %>" class="btn btn-outline-success"> 주문하기 </a></td>
				</tr>
			</table>
		</div>
	</div>
	<hr>
	<jsp:include page="footer.jsp" />
</body>
</html>