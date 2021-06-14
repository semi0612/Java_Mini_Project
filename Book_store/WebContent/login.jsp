<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    
    <!-- 해당 페이지 타이틀 -->
    <title>BookForest Login</title>
    <!-- css 파일적용 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/login.css" rel="stylesheet" >
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
    	
        <!-- 로그인 콘텐츠 부분  -->
        <div class="container">
        
        

            <form class="form-signin" method="post" action="loginAction.jsp">
              <h2 class="form-signin-heading">회원 로그인</h2>
              <label for="inputEmail" class="sr-only">아이디</label>
              <input type="text" id="cus_id" name="cus_id" class="form-control" placeholder="아이디" required autofocus>
              <label for="inputPassword" class="sr-only">비밀번호</label>
              <input type="password" id="inputPassword" name="cus_pw" class="form-control" placeholder="비밀번호" required>
              <div class="checkbox">
                <label for="idSaveCheck">
                  <input type="checkbox" name="remember" id="idSaveCheck" value="remember-me"> 아이디 저장
                </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>
      
          </div> <!-- 로그인 폼 /container -->

                  
  


</div><!-- 큰 컨테이너닫는 /div -->

	<!-- footer.jsp 파일을 불러옵니다. -->
    <%@ include file="footer.jsp" %> 




    

  


  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
  <script src="./resources/js/bootstrap.min.js"></script>
  <!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
  <script src="./resources/js/bundle.min.js"></script>
  <!-- 이 스크립트 파일은 아이디 저장 기능을 가지고있습니다.-->
  <script src="./resources/js/login.js"></script>	 




    
    
</body>
</html>