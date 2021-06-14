<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.CsDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="customerService" class="dto.CsDTO" scope="page" />
<jsp:setProperty name="customerService" property="cs_title" />
<jsp:setProperty name="customerService" property="ask" />



<!DOCTYPE html>
<html>
<head>

<title>문의 처리</title>
</head>
<body>


	<%
		String cus_id = null;
		if (session.getAttribute("cus_id") != null) {
			cus_id = (String) session.getAttribute("cus_id");
		}
		
		if (cus_id == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		} else {
			
			
			if(customerService.getCs_title() == null || customerService.getAsk() == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안 된 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				CsDAO csDAO = new CsDAO();
				int result = csDAO.write(customerService.getCs_title(), cus_id , customerService.getAsk());
				
				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('글쓰기에 실패했습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('고객님의 문의사항이 정상 처리되었습니다.')");
					script.println("location.href = 'customerService.jsp'");
					script.println("</script>");
				}
				
			}
			
			
			
			
		}
		
		
		

		

		
	%>


</body>
</html>