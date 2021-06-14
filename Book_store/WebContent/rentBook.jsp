<%@ page language="java" contentType="text/html; charset=utf-8"%>

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
<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>
	

<style>

body {
  	background-image: url(resources/images/background.jpg);
  	min-height: 100%;
  	background-repeat : no-repeat;
    background-size : cover;
}

.jumbotron {
	background-color:#e9ece0;
}
.display{
	font-size : 28px;
	
}
</style>

</head>
<body>
	
	
	<div class="container">	
	<!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>	

		<form name="rendBook" action="process_rentBook.jsp" class="form-horizontal" method="post">
			
			
			<div class="jumbotron">
				<div class="container">
					<h1 class="display"> 대여 신청 폼을 입력해주세요! </h1>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 제목 </label>
				<div class="col-sm-3">
					<input type="text" name="title" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 카테고리 </label>
				<select name="category" id="category">
					<option value="로맨스"> 로맨스 </option>
					<option value="판타지"> 판타지 </option>
					<option value="추리"> 추리 </option>
					<option value="에세이"> 에세이 </option>
					<option value="자격증"> 자격증 </option>
					<option value="코믹"> 코믹 </option>
				</select>
			</div>

			

			

			<div class="form-group row">
				<label class="col-sm-2"> 작가 </label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2"> 요청 사항 </label>
				<div class="col-sm-3">
					<textarea name="description" rows="3" cols="50"
						class="form-control"></textarea>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>
	<!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
	<script src="./resources/js/bundle.min.js"></script>

</body>
</html>