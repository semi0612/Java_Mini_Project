<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="dao.CsDAO" %>
<%@ page import="dto.CsDTO" %>
<%@ page import="java.util.ArrayList" %>
    
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
  
  <style type="text/css">
  	a, a:hover {
  		color: #000000;
  		text-decoration: none;
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


    <%
  
  		int pageNumber = 1;
  		if(request.getParameter("pageNumber") != null) {
  			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
  		}
  
  	%> 	

  

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
    <h3 style="text-align: center; margin-top: 20px; margin-bottom: 20px; color: #afcb3d"><i class="fas fa-book"></i> BookForest CustomerService</h3>
    <div class="container">
	
      <div class="row">
        <table class="table table-hover" style="text-align: center; border: 1px solid #f4f5f2">
        
          <thead>
            <tr>
              <th style="background-color:#fcfbf8; text-align: center;"> 번호 </th>
              <th style="background-color:#fcfbf8; text-align: center;"> 제목 </th>
              <th style="background-color:#fcfbf8; text-align: center;"> 작성자 </th>
              <th style="background-color:#fcfbf8; text-align: center;"> 작성일 </th>
            </tr>
          
          </thead>
          
          <tbody>
          	<%
          		CsDAO csDAO = new CsDAO();
          		ArrayList<CsDTO> list = csDAO.getList(pageNumber);
          		for(int i = 0; i<list.size(); i++) {
          	%>		
          		<tr>
            		<td><%= list.get(i).getCs_no() %></td>
            		<td><a href="csview.jsp?cs_no=<%= list.get(i).getCs_no() %>">
            		<%= list.get(i).getCs_title().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></a></td>
            		<td><%= list.get(i).getCus_id() %></td>
            		<td><%= list.get(i).getCs_date().substring(0,11) +  list.get(i).getCs_date().substring(11,13) + "시" + list.get(i).getCs_date().substring(14,16) + "분"%></td>
         	 	</tr>	
          		
          	<% 	
          		}
            %>
          	
          	
          	
          </tbody>
          
          
  
          
        
        
        </table>
        
        
      
      </div>
      
      <a href="write.jsp" class="btn btn-primary pull-right"> 글쓰기</a>
        <%
        	if(pageNumber != 1) {
        %>		
        	<a href="customerService.jsp?pageNumber=<%=pageNumber - 1 %>" class="btn btn-success btn-arraw-left">이전</a>
        
        
        
        <% 
        	} if(csDAO.nextPage(pageNumber + 1)) {
        %>
        
        	<a href="customerService.jsp?pageNumber=<%=pageNumber + 1 %>" class="btn btn-success btn-arraw-left">다음</a>
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