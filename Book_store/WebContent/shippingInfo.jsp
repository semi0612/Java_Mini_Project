<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!-- 해당 페이지 타이틀 -->
<title>BookForest 배송</title>
<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/login.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">


<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 --> 
<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>

<!-- 주소 API 활용 코드 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// 사용할 function명 적어주기
function findAddr() {
	daum.postcode.load(function() {
		new daum.Postcode({
			oncomplete: function(data){
				// 각 주소의 규칙에 따라 주소 조합
				// 가져올 변수가 없을때는 공백을 가지기 때문에 이를 참고해 분기한다고 한다
				var addr = ''; //주소 변수
				
				
				// 사용자가 선택한 주소타입(도로명/지번)에 따라 해당 값 가져오기
				// 만약 사용자가 도로명 주소를 선택했을 때
				if (data.userSelectedType == 'R') {
					addr = data.roadAddress;
				// 만약 사용자가 구주소를 선택했을 때
				} else {
					addr = data.jibunaddress;
				}
				
				// 우편번호
				document.getElementById('userZipcode').value = data.zonecode;
				// 주소정보
				document.getElementById('userAddress').value = addr;
				}
		}).open();
	});
}
</script>
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
					<h1 class="display"> 배송 정보를 입력해주세요 <br> 전송 전 입력 내용을 다시 한번 확인해주세요! </h1>
			</div>
	
		<form action="./processShippingInfo.jsp" class="form-horizontal" method="post">
			<input type="hidden" name="cartId" value="<%=request.getParameter("cartId") %>" />
			<div class="form-group row">
				<label class="col-sm-2"> 받으시는 분 </label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 배송일 </label>
				<div class="col-sm-3">
					<input name="shippingDate" type="text" class="form-control" />(yyyy/mm/dd)
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 국가명 </label>
				<div class="col-sm-3">
					<input name="country" type="text" class="form-control" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 우편 번호 </label>
				<div class="col-sm-3">
					<input name="zipCode" type="text" class="form-control" />
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2"> 주소 </label>
				<div class="col-sm-5">
					<input type="text" name="addressName" id="userZipcode" placeholder="우편번호 입력" readonly class='box' /> <input type="button" value="주소 검색" onclick="findAddr()"><br>
					<input type="text" name="addressName1" id="userAddress" placeholder="주소를 입력" readonly class='box' /> <br>
					<input type="text" name="addressName2" class="form-control" placeholder="상세 주소를 입력하세요"/> <br>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="./cart.jsp?cartId=<%= request.getParameter("cartId") %>"
						class = "btn btn-secondary" role="button"> 이전 </a>
						
					<input type="submit" class="btn btn-primary" value="등록" />
					<a href="./checkOutCancelled.jsp" class="btn btn-secondary" role="button"> 취소 </a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>