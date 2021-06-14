<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.UserDAO" %>
<%@ page import= "dao.CsDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="dto.UserDTO" scope="page" />
<jsp:setProperty name="user" property="cus_id" />
<jsp:useBean id="cs" class="dto.CsDTO" scope="page" />
<jsp:setProperty name="cs" property="cs_no" />



<!DOCTYPE html>
<html>
<head>

<title>회원탈퇴 처리</title>
</head>
<body>
	<%
		String cus_id = null;
		if(session.getAttribute("cus_id") != null) {
			cus_id = (String) session.getAttribute("cus_id");		
		}
		
	
		UserDAO userDAO = new UserDAO();
		int result = userDAO.deleteMember(cus_id);
		
		
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()"); //이전페이지로 돌아감 join.jsp
			script.println("</script>");
		} else {
			session.invalidate();//세션을 빼았는다
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('그동안 이용해주셔서 감사합니다.')");
			script.println("location.href = 'store.jsp'"); //회원탈퇴에 성공했으니 처음 store.jsp로 이동함
			script.println("</script>");
			
		}
		
		
		
		
	
	
	%>


</body>
</html>