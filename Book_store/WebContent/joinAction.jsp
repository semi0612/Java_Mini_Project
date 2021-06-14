<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.UserDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="dto.UserDTO" scope="page" />
<jsp:setProperty name="user" property="*" />


<!DOCTYPE html>
<html>
<head>

<title>회원가입 처리</title>
</head>
<body>


	<%
		String cus_id = null;
		if (session.getAttribute("cus_id") != null) {
			cus_id = (String) session.getAttribute("cus_id");
		}
		
		
		
		

		if (cus_id != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인되어있습니다.')");
			script.println("location.href = 'store.jsp'");
			script.println("</script>");
		}

		UserDAO userDAO = new UserDAO();
		int result = userDAO.join(user);

		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.')");
			script.println("history.back()"); //이전페이지로 돌아감 join.jsp
			script.println("</script>");
		} else {
			session.setAttribute("cus_id", user.getCus_id());//cus_id로 세션값을 부여
			session.setAttribute("cus_pw", user.getCus_pw());//cus_pw로 세션값을 부여
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원가입을 축하드립니다!!!')");
			script.println("location.href = 'store.jsp'"); //회원가입이 성공했으니 처음 store.jsp로 이동함
			script.println("</script>");
		}
	%>


</body>
</html>