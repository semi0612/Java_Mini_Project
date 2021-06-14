<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="dto.CsDTO" %>
<%@ page import="dto.UserDTO" %>
<%@ page import="dao.CsDAO" %>    
<!DOCTYPE html>
<html>
<head>
  <!-- 해당 페이지 타이틀 -->
  <title>BookForest CustomerService</title>

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


  <%
  	int cs_no = 0;
  	if(request.getParameter("cs_no") != null) {
  		cs_no = Integer.parseInt(request.getParameter("cs_no"));
  	}
  	if(cs_no == 0) {
  		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다.')");
		script.println("location.href = 'customerService.jsp'");
		script.println("</script>");
  	}
    CsDTO csDTO = new CsDAO().getDTO(cs_no);
  
  %>

  <!-- 큰 하나의 컨테이너 생성 -->
  <div class="container">

    <!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>


    <!-- 콘텐츠 부분 -->
    
    <br>
    <h3 style="text-align: center; margin-top: 20px; margin-bottom: 20px; color: #afcb3d"><i class="fas fa-book"></i> BookForest CustomerService</h3>
    
    <div class="container">
	
      <div class="row">
				
					<table class="table table-striped" style="text-align: center; border: 1px solid #f4f5f2">


					<thead>
						<tr>
							<th colspan="3" style="background-color: #fcfbf8; text-align: center;"> 고객센터 QnA </th>
						</tr>		
								
						
					</thead>





					<tbody>
					
						<tr>
							<td style="width: 20%;">문의 제목</td>
							<td colspan="2">
							<%=csDTO.getCs_title().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
						</tr>
						
						<tr>
							<td>작성자</td>
							<td colspan="2"><%=csDTO.getCus_id() %></td>
						</tr>
						
						
						<tr>
							<td>작성일</td>
							<td colspan="2"><%= csDTO.getCs_date() %></td>
						</tr>
						<!-- xss 공격에 대응하기위해 replaceAll()을 사용해서 공백, 특수문자등을 치환하여 화면에 정상적으로 출력하게 한다.  -->
						<tr>
							<td>내용</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">
							<%= csDTO.getAsk().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
							
						</tr>
						
					</tbody>




				</table>
				
						
						
				</div>	
				
				<a href="customerService.jsp" class="btn btn-primary">목록</a>
				<%
					if(cus_id != null && cus_id.equals(csDTO.getCus_id())) {		
				%>
					<a href="update.jsp?cs_no=<%= cs_no %>" class="btn btn-primary">수정</a>
					<a onclick="return confirm('정말 삭제하시겠습니까?')" href="deleteAction.jsp?cs_no=<%= cs_no %>" class="btn btn-primary">삭제</a>
				<% 
					}
				%>
				
				<%
					if(cus_id.equals("admin")) {		
				%>
					<a href="managerCs.jsp" class="btn btn-primary">답변하기</a>
				
				<% 
					}
				%>



			
			
    
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