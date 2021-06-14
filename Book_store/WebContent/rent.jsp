<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>

<!-- 해당 페이지 타이틀 -->
<title>BookForest Rent</title>
<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/login.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">


<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 -->
<script src="https://kit.fontawesome.com/0a1668e1e9.js"
	crossorigin="anonymous"></script>


</head>
<style>

body {
  	background-image: url(resources/images/background.jpg);
  	min-height: 100%;
  	background-repeat : no-repeat;
    background-size : cover;
}
.col-md-4 > img {
	padding-top: 20px;
	float: right;
}
.left {
	float: left;
}
</style>
<body>
	<div class="container">
		<!-- header.jsp 파일을 불러옵니다. -->
		<%@ include file="header.jsp"%>
		<%@ include file="dbconn.jsp"%>

		<img src="./resources/images/read.jpg" style="width: 30%">

		<div class="left">
			<h3 style="padding-top: 20px; padding-left: 20px;">빌리세요!</h3>

			<p style="padding-top: 20px; padding-left: 20px;">
				E북도 좋지만 팔랑팔랑 손으로 넘기는 책장이 그리울 때가 있진 않으셨나요?<br> 그렇다고 매번 구매하기에는 좀
				부담스럽지 않으셨나요? <br> 대여할 수 있는 도서관마저 가까이에 없다면?<br> <br>
				이제 포레스트를 통해 책을 대여 해보세요!<br> 전국 어디든 원하는 책을 택배로 편리하게!<br>
				적은 금액으로 도서 구입에 대한 부담은 줄이고, 그 만큼 더 많은 독서를 즐겨보세요!
			</p>
			<br> <a class="nav-link" href="rentBook.jsp"> >> 대여 신청하러 가기 </a>
		</div>
	</div>


	<!-- footer.jsp 파일을 불러옵니다. -->
	<%@ include file="footer.jsp"%>


	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>
	<!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
	<script src="./resources/js/bundle.min.js"></script>
</body>
</html>