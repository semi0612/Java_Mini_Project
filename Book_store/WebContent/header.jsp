<%@ page language="java" contentType="text/html; charset=utf-8" %>


			<%
				String cus_id = null;
				if (session.getAttribute("cus_id") != null) {
					cus_id = (String) session.getAttribute("cus_id");
				}
				
				
				
				

			%>

    
          	
          	<%
          		if(cus_id == null) {
          	%>
          	
    		<div class="top_header">
      			<nav class="navbar navbar-expand w-100 navbar-light" style="background-color: #ffffff;">
        			<div class="container-fluid">
          				<div class="navbar-collapse justify-content-end" id="navbarsExample02">		
          					<ul class="navbar-nav">
              					<a class="nav-link" href="login.jsp">로그인</a>
              					<a class="nav-link" href="join.jsp">회원가입</a>	
          					</ul>
          				</div>
        			</div>
      			</nav>
    		</div>
          	<%
          		} else if(cus_id.equals("admin")) {
          		
          	%>	
          		<div class="top_header">
					<nav class="navbar navbar-expand w-100 navbar-light" style="background-color: #ffffff;">
						<div class="container-fluid">
							<div class="navbar-collapse justify-content-end" id="navbarsExample02">
								<ul class="navbar-nav">
									<a class="nav-link">[관리자님]</a>
									<a class="nav-link" href="logoutAction.jsp">로그아웃</a>
									<a class="nav-link" href="manager_customer.jsp">고객관리</a>
									<a class="nav-link" href="addbook.jsp">책 입고하기</a>
									<a class="nav-link" href="editBook.jsp?edit=update">상품 관리 하기</a>
									<a class="nav-link" href="editBook.jsp?edit=delete">상품 삭제 하기</a>
									<a class="nav-link" href="customerService.jsp">고객센터</a>
								</ul>
							</div>
						</div>
					</nav>
				</div>
          	
          		
          	
          		
          		
          	<%	
          		} else {
          	%>
          	
    		<div class="top_header">
      			<nav class="navbar navbar-expand w-100 navbar-light" style="background-color: #ffffff;">
        			<div class="container-fluid">
          				<div class="navbar-collapse justify-content-end" id="navbarsExample02">		
          					<ul class="navbar-nav">
          						<a class="nav-link">[<%= cus_id %>님]</a>
              					<a class="nav-link" href="logoutAction.jsp">로그아웃</a>
          	  					<a class="nav-link" href="mypage.jsp">마이 페이지</a>
              					<a class="nav-link" href="customerService.jsp">고객센터</a>	
          					</ul>
          				</div>
        			</div>
      			</nav>
    		</div>
          			
          	<% 		
          		}
          	%>	
          		
          		
          	
          	
          
              
              
            

    <!-- title -->
    <div class="title">
     	<img src="./resources/images/sublogo.png" alt="logo Image" width="250px" height="100px">
    </div>
    <br>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="store.jsp"><img src="./resources/images/mainlogo.png" alt="logo Image"  width="230px" height="45px"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03"
        aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav mr-auto">

          <li class="nav-item active">
            <a class="nav-link" href="store.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
              aria-expanded="false">카테고리</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="romance.jsp">로맨스</a>
              <a class="dropdown-item" href="sf.jsp">판타지</a>
              <a class="dropdown-item" href="Reasoning.jsp">추리</a>
              <a class="dropdown-item" href="comic.jsp">코믹</a>
              <a class="dropdown-item" href="essay.jsp">에세이</a>
              <a class="dropdown-item" href="certificate.jsp">자격증</a>
            </div>
          </li>



          <li class="nav-item">
            <a class="nav-link" href="rent.jsp">대여 서비스</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">추천 서비스</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="review.jsp">리뷰</a>
          </li>

        </ul>
        <form class="form-inline my-2 my-lg-0" action="reader.jsp" method="get" id="inputForm">
          <input class="form-control mr-sm-2" type="text" placeholder="도서 제목" name="code" id="code">
          <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>    