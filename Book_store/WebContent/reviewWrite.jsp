<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter" %>    
<!DOCTYPE html>
<html>
<head>
  <!-- 해당 페이지 타이틀 -->
  <title>BookForest Review</title>

  <!-- css 파일적용 -->
  <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
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


    <!-- 콘텐츠 부분 -->
    
    <br>
    <h3 style="text-align: center; margin-top: 20px; margin-bottom: 20px; color: #afcb3d"><i class="fas fa-book"></i> BookForest Review</h3>
    
    <div class="container">
	
      <div class="row">
				<form method="post" action="reviewAction.jsp" style="width:100%; height:100%;">
					<table class="table table-dark" style="text-align: center; background-color: #afcb3d;">
						

						<thead>
							<tr>
								<th colspan="2" style=" text-align: center;"> 리뷰 작성 </th>
							</tr>		
						</thead>			

							

						

						<tbody>
							<tr>
								<td><input type="text" class="form-control" placeholder="리뷰 제목" name="review_title" maxlength="50"></td>
							</tr>
							
							<tr>
								<td><input type="text" class="form-control" placeholder="도서명" name="p_name" maxlength="50"></td>
							</tr>
							
							<tr>	
								<td><textarea class="form-control" placeholder="작성된 내용은 수정이 불가하니  신중하게 작성 부탁드립니다." name="review" maxlength="3000" style="height: 300px;"></textarea></td>
							</tr>	
									

						</tbody>




					</table>
					
					<input type="submit" class="btn btn-success" value="글쓰기">
					<a href="review.jsp" class="btn btn-primary">뒤로가기</a>
						
						
					</form>	
					
					




			</div>
			
			
    
    </div>
    
</div><!-- 큰 컨테이너 닫는 /div -->


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