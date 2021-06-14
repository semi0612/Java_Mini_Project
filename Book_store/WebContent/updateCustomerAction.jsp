<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.UserDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="dto.UserDTO" />
<jsp:setProperty property="*" name="user"/> 



<!DOCTYPE html>
<html>
<head>

<title>회원정보 수정처리</title>
</head>
<body>
	
       
    <%
		String cus_id = null;
		if(session.getAttribute("cus_id") != null) {
			cus_id = (String) session.getAttribute("cus_id");		
		}
		
	
		UserDAO userDAO = new UserDAO();
		int result = userDAO.updateMember(user.getCus_pw(), user.getCus_name(), user.getCus_add(), user.getCus_phone(), user.getCus_email(), cus_id);
		
		
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()"); //이전페이지로 돌아감 join.jsp
			script.println("</script>");
		} else {
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원정보가 정상적으로 수정되었습니다!')");
			script.println("location.href = 'store.jsp'"); //회원수정에 성공했으니 처음 store.jsp로 이동함
			script.println("</script>");
			
		}
		
		
		
		
	
	
	%>



</body>
</html>