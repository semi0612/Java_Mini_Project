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

<title>로그인 처리</title>
</head>
<body>
	<%
		String cus_id = null;
		if(session.getAttribute("cus_id") != null) {
			cus_id = (String) session.getAttribute("cus_id");		
		}
		
		if(cus_id != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인되어있습니다.')"); 
			script.println("location.href = 'store.jsp'"); 
			script.println("</script>");
		}
		
		
		UserDAO userDAO = new UserDAO();
		
		
		int result = userDAO.login(user.getCus_id(), user.getCus_pw());
		
		
		if(result == 1) {
			session.setAttribute("cus_id", user.getCus_id());//cus_id로 세션값을 부여
			session.setAttribute("cus_pw", user.getCus_pw());//cus_pw로 세션값을 부여
			PrintWriter script = response.getWriter();
			script.println("<script>"); 
			script.println("location.href = 'store.jsp'"); //로그인이 성공했으니 처음 store.jsp로 이동함
			script.println("</script>");
			
		} else if(result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')"); 
			script.println("history.back()"); //이전페이지로 돌아감 login.jsp
			script.println("</script>");
		} else if(result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')"); 
			script.println("history.back()"); //이전페이지로 돌아감 login.jsp
			script.println("</script>");
		} else if(result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')"); 
			script.println("history.back()"); //이전페이지로 돌아감 login.jsp
			script.println("</script>");
		} 
		
		
		
		
	
	
	%>


</body>
</html>