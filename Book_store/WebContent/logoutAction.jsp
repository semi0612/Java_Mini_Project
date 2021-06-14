<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>로그아웃 처리</title>
</head>
<body>


	<%
		session.invalidate();//세션을 빼았는다
		
	
	%>
	<script>
		alert('로그아웃 되셨습니다.');
		location.href = 'store.jsp';
	</script>
	

</body>
</html>