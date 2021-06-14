<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import= "java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
    
    <!-- 해당 페이지 타이틀 -->
    <title>BookForest Mypage</title>
    <!-- css 파일적용 -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/mypage.css" rel="stylesheet" >
    <link href="./resources/css/style.css" rel="stylesheet" > 
    <link href="./resources/css/join.css" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="./resources/css/default.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/component.css" />
    <script src="./resources/js/modernizr.custom.js"></script>
    
    
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
    	
    	
    	<%
	
	
			if(cus_id == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인을 해주세요.')"); 
				script.println("location.href = 'login.jsp'"); 
				script.println("</script>");
			}

		%>
	
	
		
    
        <!-- mypage 콘텐츠 부분  -->
   		 <div class="container">
   		 	<!-- Codrops top bar -->

			<div class="main clearfix">
				<nav id="menu" class="nav">					
					<ul>
						<li>
							<a href="store.jsp">
								<span class="icon">
									<i class="fas fa-home"></i>
								</span>
								<span>스토어</span>
							</a>
						</li>
						<li>
							<a href="write.jsp">
								<span class="icon"> 
									<i class="fas fa-question-circle"></i>
								</span>
								<span>문의하기</span>
							</a>
						</li>
						<li>
							<a href="rentInformation.jsp">
								<span class="icon">
									<i class="fas fa-search-location"></i>
								</span>
								<span>대여정보 조회</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="icon">
									<i class="fas fa-shopping-cart"></i>
								</span>
								<span>장바구니</span>
							</a>
						</li>
						<li>
							<a href="updateCustomer.jsp">
								<span class="icon">
									<i class="fas fa-user-edit"></i>
								</span>
								<span>회원정보 수정</span>
							</a>
						</li>
						<li>
							<a onclick="return confirm('정말 탈퇴하시겠습니까?')" href="deleteCustomer.jsp">
								<span class="icon">
									<i class="fas fa-running"></i>
								</span>
								<span>회원탈퇴</span>
							</a>
						</li>
					</ul>
				</nav>
				
    
				<img src="./resources/images/mypageCover.jpg" alt="Cover Image" width="100%" height="600px">
				
			</div>
			
			
			
   		 	 
		</div> <!-- mypage /container -->
		
		
		
		

                  
  


	</div><!-- 큰 컨테이너닫는 /div -->

	<!-- footer.jsp 파일을 불러옵니다. -->
    <%@ include file="footer.jsp" %> 


		<!-- 마이페이지 네비게이션 이벤트처리 스크립트 -->
		<script>
			
			var changeClass = function (r,className1,className2) {
				var regex = new RegExp("(?:^|\\s+)" + className1 + "(?:\\s+|$)");
				if( regex.test(r.className) ) {
					r.className = r.className.replace(regex,' '+className2+' ');
			    }
			    else{
					r.className = r.className.replace(new RegExp("(?:^|\\s+)" + className2 + "(?:\\s+|$)"),' '+className1+' ');
			    }
			    return r.className;
			};	

			
			var menuElements = document.getElementById('menu');
			menuElements.insertAdjacentHTML('afterBegin','<button type="button" id="menutoggle" class="navtoogle" aria-hidden="true"><i aria-hidden="true" class="icon-menu"> </i> Menu</button>');

			
			document.getElementById('menutoggle').onclick = function() {
				changeClass(this, 'navtoogle active', 'navtoogle');
			}

			
			document.onclick = function(e) {
				var mobileButton = document.getElementById('menutoggle'),
					buttonStyle =  mobileButton.currentStyle ? mobileButton.currentStyle.display : getComputedStyle(mobileButton, null).display;

				if(buttonStyle === 'block' && e.target !== mobileButton && new RegExp(' ' + 'active' + ' ').test(' ' + mobileButton.className + ' ')) {
					changeClass(mobileButton, 'navtoogle active', 'navtoogle');
				}
			}
		</script>
    

  


  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
  <script src="./resources/js/bootstrap.min.js"></script>
  <!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
  <script src="./resources/js/bundle.min.js"></script>
  <!-- 이 스크립트 파일은 사이드메뉴 기능을 가지고있습니다.-->
  <script src="./resources/js/ytmenu.js"></script>



    
    
</body>
</html>