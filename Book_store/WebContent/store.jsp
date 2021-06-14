<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter" %>    

<!DOCTYPE html>
<html>
<head>
  <!-- 해당 페이지 타이틀 -->
  <title>BookForest Store</title>

  <!-- css 파일적용 -->
  <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="./resources/css/style.css" rel="stylesheet">
  <link href="./resources/css/store.css" rel="stylesheet"> 
  
  	
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
  			

    <!-- 메인 콘텐츠 슬라이드 부분 -->
    <div class="container">
      <h3 style="text-align: center; margin-top: 20px; margin-bottom: 20px; color: #afcb3d"><i class="fas fa-book"></i> BookForest Best Seller</h3>
      
      <div class="slide_wrap">
        <div class="slide_box">
          <div class="slide_list clearfix">
            <div class="slide_content slide">
              <a href="#"><img src="./resources/images/book1.jpg" alt="book1"></a>
            </div>
            <div class="slide_content slide">
              <a href="#"><img src="./resources/images/book2.jpg" alt="book2"></a>
            </div>
            <div class="slide_content slide">
              <a href="#"><img src="./resources/images/book3.jpg" alt="book3"></a>
            </div>
            <div class="slide_content slide">
              <a href="#"><img src="./resources/images/book4.jpg" alt="book4"></a>
            </div>
            <div class="slide_content slide">
              <a href="#"><img src="./resources/images/book5.jpg" alt="book5"></a>
            </div>
          </div>
          <!-- // .slide_list -->
        </div>
        <!-- // .slide_box -->
        <div class="slide_btn_box">
          <button type="button" class="slide_btn_prev">이전</button>
          <button type="button" class="slide_btn_next">다음</button>
        </div>
        <!-- // .slide_btn_box -->
        <ul class="slide_pagination"></ul>
        <!-- // .slide_pagination -->
      </div>
      <!-- // .slide_wrap -->
    </div>
    <!-- // .container -->
    
   
    



</div><!-- 큰 컨테이너 닫는 /div -->


<!-- footer.jsp 파일을 불러옵니다. -->
<%@ include file="footer.jsp" %>





  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
  <script src="./resources/js/bootstrap.min.js"></script>
  <!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
  <script src="./resources/js/bundle.min.js"></script>
  <!-- 이 스크립트 파일은 메인콘텐츠의 슬라이드 효과 기능을 가지고 있습니다.-->
  <script src="./resources/js/test.js"></script>


</body>
</html>