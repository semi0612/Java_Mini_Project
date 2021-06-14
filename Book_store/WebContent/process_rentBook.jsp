<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>

<!-- 해당 페이지 타이틀 -->
<title>BookForest Rent</title>
<!-- css 파일적용 -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/login.css" rel="stylesheet">
<link href="./resources/css/style.css" rel="stylesheet">


<!-- 홈페이지 아이콘 -->
<link href="./resources/images/bookicon.png" rel="icon">
<!-- 폰트어썸 사용위한 코드 --> 
<script src="https://kit.fontawesome.com/0a1668e1e9.js" crossorigin="anonymous"></script>
<title>대여신청 처리</title>
</head>
<body>
   <div class="container">   
   <!-- header.jsp 파일을 불러옵니다. -->
    <%@ include file="header.jsp" %>
    
   <%
      request.setCharacterEncoding("utf-8");
      
   	  String r_name = request.getParameter("title");
      String r_catagory = request.getParameter("category");
      String r_author = request.getParameter("author");
      String r_descriptionproduct = request.getParameter("description");
   %>
   
   <sql:setDataSource var="dataSource"
      url="jdbc:mysql://localhost:3307/bookstore"
      driver="com.mysql.jdbc.Driver" user="root" password="1234" />
      
   <sql:update dataSource="${dataSource}" var="resultSet">
      Insert into rent (cus_id, r_catagory, r_name, r_author, r_descriptionproduct) values(?, ?, ?, ?, ?)
      <sql:param value="<%= cus_id %>" />
      <sql:param value="<%= r_catagory %>" />
      <sql:param value="<%= r_name %>" />
      <sql:param value="<%= r_author %>" />
      <sql:param value="<%= r_descriptionproduct %>" />
   </sql:update>
   
   <script>
   alert('대여신청이 정상적으로 처리되었습니다.')
   location.href = 'rent.jsp'
   </script>
   

</div>





<!-- footer.jsp 파일을 불러옵니다. -->
<%@ include file="footer.jsp" %>


   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
   <script src="./resources/js/bootstrap.min.js"></script>
   <!-- 이 스크립트 파일은 네비게이션바(메뉴바)의 드롭다운 기능을 가지고있습니다.-->
   <script src="./resources/js/bundle.min.js"></script>

</body>
</html>