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

</head>
<body>

	
	
	
	<div class="container">	
	<!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>	
    
    
   
			<div class="jumbotron">
				
					<h1 class="display"> 상품 입고 공간입니다.<br> 입고하시는 관리자 분은 한번 더 확인 후 입고해 주세요.</h1>
				
			</div>
			
			<form name="newProduct" action="./process_addbook.jsp" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2"> isbn </label>
				<div class="col-sm-3">
					<input type="text" name="isbn" max="4" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 카테고리 번호 </label>
				<div class="col-sm-3">
					<input type="radio" name="category" value="100"> 로맨스
					<input type="radio" name="category" value="200"> 판타지
					<input type="radio" name="category" value="300"> 추리 <br>
					<input type="radio" name="category" value="500"> 에세이
					<input type="radio" name="category" value="600"> 자격증
					<input type="radio" name="category" value="400"> 코믹
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 제목 </label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 작가 </label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 가격 </label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 입고 수량 </label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStrock" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 책 설명 </label>
				<div class="col-sm-3">
					<textarea name="description" rows="3" cols="50" class="form-control"></textarea>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 상태 </label>
				<div class="col-sm-5">
					<input type="radio" name="state" value="New"> 신규 <input type="radio" name="state" value="Old"> 중고
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