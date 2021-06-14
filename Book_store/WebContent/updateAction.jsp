<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dto.CsDTO" %>
<%@ page import= "dao.CsDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>




<!DOCTYPE html>
<html>
<head>

<title>문의 수정 처리</title>
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
			} 
		
			int cs_no = 0;
		  	if(request.getParameter("cs_no") != null) {
		  		cs_no = Integer.parseInt(request.getParameter("cs_no"));
		  	}
		  	if(cs_no == 0) {
		  		PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href = 'customerService.jsp'");
				script.println("</script>");
		  	}
		  	
		  	CsDTO csDTO = new CsDAO().getDTO(cs_no);
		  	
		  	if(!cus_id.equals(csDTO.getCus_id())) {
		  		PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href = 'customerService.jsp'");
				script.println("</script>");
		  		
		  	} else {
		  		
		  		if(request.getParameter("cs_title") == null || request.getParameter("ask") == null ||
		  			request.getParameter("cs_title").equals("") ||	request.getParameter("ask").equals("")) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('입력이 안 된 사항이 있습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					CsDAO csDAO = new CsDAO();
					int result = csDAO.update(cs_no, request.getParameter("cs_title"), request.getParameter("ask"));
					
					if (result == -1) {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('글수정에 실패했습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('문의수정이 정상 처리되었습니다.')");
						script.println("location.href = 'customerService.jsp'");
						script.println("</script>");
					}
					
				}
				
				
				
				
			}
		
		
	%>	
		
		
</body>
</html>