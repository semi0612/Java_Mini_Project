<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="dto.Book_product" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    
    <!-- 해당 페이지 타이틀 -->
    <title>BookForest Detail</title>
    <!-- css 파일적용 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/login.css" rel="stylesheet" >
    <link href="./resources/css/style.css" rel="stylesheet" > 
    
    
    <!-- 홈페이지 아이콘 -->
	<link href="./resources/images/bookicon.png" rel="icon">
	<!-- 폰트어썸 사용위한 코드 -->
	<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {
			document.addForm.reset();
		}
	}
	</script>
	
	
<style>
.col-md-6 {
   padding-top: 70px;
}

body {
	background-image: url(resources/images/background.jpg);
	min-height: 100%;
    background-repeat : no-repeat;
    background-size : cover;
}

</style>


</head>
<body>


	<%@ include file="dbconn.jsp" %>
	<%
		String id = request.getParameter("id");
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select * from book where p_isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()){
	%>

<div class="container">
	<!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>
	<div class="row">
		<div class="col-md-5">
			<img src="/image/<%= rs.getString("p_fileName") %>" style="width:70%; padding-top : 20px; float : left"><br>
		</div>
		<div class="col-md-6">
			<h3><%= rs.getString("p_name") %></h3>
			<b> isbn : </b> <span class="dadge dadge-danger"><%= rs.getString("p_isbn") %></span> <br>
			<b> 필명 : </b> <%= rs.getString("p_author") %> <br>
			<b> 분류 : </b> <%= rs.getString("p_catagory") %> <br>
			<b> 재고수 : </b> <%= rs.getString("p_unitsInStrock") %> <br>
			<h4><%= rs.getString("p_unitPrice") %> 원 </h4>
			<p> <form name="addForm" action="./addCart.jsp?id=<%=rs.getString("p_isbn") %>" method="post">
					<a href="#" class="btn btn-outline-success" onclick="addToCart()"> 상품 주문 &raquo; </a>
					<a href="./cart.jsp" class="btn btn-outline-danger"> 장바구니 &raquo; </a>
			</form>
		</div>
	</div>
	<hr>
	<p><%= rs.getString("p_description") %> <br>
</div>
	<%
		}
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (conn != null) conn.close();
	
	%>



	<!-- footer.jsp 파일을 불러옵니다. -->
    <%@ include file="footer.jsp" %>  


  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
  <script src="./resources/js/bootstrap.min.js"></script>
  <!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
  <script src="./resources/js/bundle.min.js"></script>
    
</body>
</html>