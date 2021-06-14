<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>



<!-- 홈페이지 타이틀명 -->
<title>BookForest Join</title>

<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/join.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">

<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 -->
<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>
	
	
<!-- 주소 API 활용 코드 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
body {
  	background-image: url(resources/images/background.jpg);
  	min-height: 100%;
  	background-repeat : no-repeat;
    background-size : cover;
}
</style>	
	


</head>

<body>

	<!-- 큰 하나의 컨테이너 생성 -->
	<div class="container">

		<!-- header.jsp 파일을 불러옵니다. -->
    	<%@ include file="header.jsp" %>
		
		
		<!-- 회원가입 콘텐츠 부분  -->
		<div class="container">
			<h2 class="join-title">
				<i class="fas fa-book"></i> Ezen Book Store Join
			</h2>
			
			<form class="join" action="joinAction.jsp" name="joinForm" method="POST" onsubmit="return joinTest();">
				
				<ul>

					<li class="option"><span class="option-title">ID</span><br>
					<input type="text" name="cus_id" id="cus_id" placeholder="아이디를 입력하세요"  class='box' maxlength="12"/> <br>
					<span class='necessary'>영문자+숫자 조합으로 6~12자리 입력</span>
					</li>
					

					<li class="option"><span class="option-title">Password</span><br>
					<input type="password" name="cus_pw" id="cus_pw" placeholder="비밀번호를 입력하세요" class='box' maxlength="15"/> <br>
					<span class='necessary'>영문자+숫자+특수문자 조합으로 8~15자리 입력</span>	
					</li>

					<li class="option"><span class="option-title">Password Confirm</span><br>
					<input type="password" name="cus_pw2" id="cus_pw2" placeholder="비밀번호를 다시 입력하세요." class='box' maxlength="15"/> <br>
					<span class='necessary'>위에서 입력한 비밀번호와 동일해야합니다.</span>
					</li>

					<li class="option"><span class="option-title">Name</span><br>
					<input type="text" name="cus_name" id="cus_name" placeholder="이름을 입력하세요" class='box' maxlength="10"/> <br>
					<span class='necessary'>한글 최대 10자리 입력</span>	
					</li>

					<li class="option"><span class="option-title">Address</span><br>
					<input type="text" name="cus_add" id="cus_add" placeholder="주소를 입력하세요" readonly class='box' /> <input type="button" value="주소 검색" onclick="findAddr()"><br>
					<input type="text" name="cus_add2" id="cus_add2" placeholder="주소를 입력하세요" readonly class='box' /> <br>
					<input type="text" name="cus_add3" id="cus_add3" placeholder="상세 주소를 입력하세요" class='box' /> <br>
					<span class='necessary'>필수 정보입니다.</span>	
					</li>

					<li class="option"><span class="option-title">Tel</span><br>
					<input type="text" name="cus_phone" id="cus_phone" placeholder="ex) 010-1111-2222"  class='box' maxlength="13"/> <br>
					<span class='necessary'>숫자와 하이픈만 입력해주세요.</span>	  
					</li>	
					
					<li class="option"><span class="option-title">Email</span><br>
					<input type="text" name="cus_email" placeholder="이메일 형식 : test@naver.com" id="cus_email" class='box'/>
					</li>
						
						
					<button type="submit" class="join-btn">회원가입</button>
					<button type="reset" class="join-btn">다시쓰기</button>
					
					
				</ul>
			</form>


		</div>
		<!-- 로그인 폼 /container -->
		
		



	</div>
	<!-- 큰 컨테이너닫는 /div -->

	<!-- footer.jsp 파일을 불러옵니다. -->
    <%@ include file="footer.jsp" %>









	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>	
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="./resources/js/bootstrap.min.js"></script>
	<!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
	<script src="./resources/js/bundle.min.js"></script>
	<!-- 이 스크립트는 회원가입 유효성 검사를 위한 스크립트입니다.-->
	<script src="./resources/js/join.js?v=<%=System.currentTimeMillis() %>"></script>





</body>
</html>