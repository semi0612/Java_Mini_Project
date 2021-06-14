<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>

<!-- 해당 페이지 타이틀 -->
<title>BookForest edit</title>
<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/login.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">


<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 -->
<script src="https://kit.fontawesome.com/0a1668e1e9.js"
	crossorigin="anonymous"></script>

<style>
.center {
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 50px;
}

.jumbotron {
	background-color: #e9ec99;
}

.display {
	font-size: 28px;
}
</style>

</head>
<body>
<div class="container">
	<!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>

	<div class="jumbotron">
		<div class="container">
			
			<h1 class="display">
				상품 편집하는 공간입니다.<br> 관리자 분은 한번 더 확인해 주세요
			</h1>
		</div>
	</div>
	<%
		String isbn = request.getParameter("id");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from book where p_isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();

		if (rs.next()) {
	%>

	<div class="container">
		
		<div class="row">
			<div class="col-md-5">
				<img src="/image/<%= rs.getString("p_fileName") %>" style="width:70%; padding-top : 20px; float : left"><br>
			</div>

			<div class="col-md-7">
				<form name="newBook" action="./processUpdate.jsp"
					class="form-horizontal" method="post" enctype="multipart/form-data">
					
					<div class="form-group row">
						<label class="col-sm-2"> isbn </label>
						<div class="col-sm-3">
							<input type="text" name="isbn" id="isbn" max="4"
								class="form-control" value='<%=rs.getString("p_isbn")%>'>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 제목 </label>
						<div class="col-sm-3">
							<input type="text" name="name" id="name" class="form-control"
								value="<%=rs.getString("p_name")%>">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 작가 </label>
						<div class="col-sm-3">
							<input type="text" name="author" id="author" class="form-control"
								value="<%=rs.getString("p_author")%>">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 가격 </label>
						<div class="col-sm-3">
							<input type="text" name="unitPrice" id="unitPrice"
								class="form-control" value="<%=rs.getString("p_unitPrice")%>">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 수량 </label>
						<div class="col-sm-3">
							<input type="text" name="unitsInStrock" id="unitsInStrock"
								class="form-control"
								value="<%=rs.getString("p_unitsInStrock")%>">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 책 설명 </label>
						<div class="col-sm-3">
							<textarea name="description" rows="3" cols="50"
								class="form-control"><%=rs.getString("p_description")%></textarea>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 상태 </label>
						<div class="col-sm-5">
							<input type="radio" name="state" value="New"> 신규 <input
								type="radio" name="state" value="Old"> 중고
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2"> 제품 이미지 </label>
						<div class="col-sm-5">
							<input type="file" name="productImage" class="form-control">
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="등록하기">
							<input type="reset" class="btn btn-primary" value="다시 작성하기">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	%>

	<!-- footer.jsp 파일을 불러옵니다. -->
    <%@ include file="footer.jsp" %>
</div>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>
	<!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
	<script src="./resources/js/bundle.min.js"></script>

</body>
</html>