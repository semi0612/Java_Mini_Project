<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    
    <!-- 해당 페이지 타이틀 -->
    <title>BookForest Mypage</title>
    <!-- css 파일적용 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/mypage.css" rel="stylesheet" >
    <link href="./resources/css/style.css" rel="stylesheet" > 
    
    
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
</style>



</head>
<body>
	





    <!-- 큰 하나의 컨테이너 생성 -->
    <div class="container">
    
    	
    	<!-- header.jsp 파일을 불러옵니다. -->
    	<%@ include file="header.jsp" %>	
    
        <!-- mypage 콘텐츠 부분  -->
   		 <div class="container">

      		<form class="form-signin" action="pwConfirmAction.jsp">
        		<h2 class="form-signin-heading">MyPage</h2>
        		<br>
       			<p class="mypageMent"><b>고객님의 소중한 개인정보를 위해 <br> 비밀번호를 확인해주세요!</b></p>
        		<label for="inputPassword" class="sr-only">비밀번호</label>
       			<input type="password" id="cus_pw" name="cus_pw" class="form-control" placeholder="비밀번호를 입력해주세요." required>
				<p></p>
        		<button class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 확인</button>
        	</form>
     	 

    	</div> <!-- mypage /container -->

                  
  


</div><!-- 큰 컨테이너닫는 /div -->

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