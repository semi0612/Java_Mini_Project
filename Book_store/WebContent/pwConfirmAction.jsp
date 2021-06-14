<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.UserDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="dto.UserDTO" scope="page" />
<jsp:setProperty name="user" property="cus_id" />
<jsp:setProperty name="user" property="cus_pw" />


<!DOCTYPE html>
<html>
<head>

<title>비밀번호 확인처리</title>
</head>
<body>
	<%
		
		String cus_pw = (String) session.getAttribute("cus_pw");
		String confirmPw = request.getParameter("cus_pw");
		
		
		
		
		
		if(confirmPw.equals(cus_pw)) {
			
			PrintWriter script = response.getWriter();
			script.println("<script>"); 
			script.println("location.href = 'mypageIn.jsp'"); 
			script.println("</script>");
			
		} else {
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')"); 
			script.println("history.back()");
			script.println("</script>");
			
		}		
		
				
		
		
		
		
	
	
	%>


</body>
</html>