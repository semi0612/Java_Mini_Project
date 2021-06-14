<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dto.ReviewDTO" %>
<%@ page import= "dao.ReviewDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>




<!DOCTYPE html>
<html>
<head>

<title>리뷰 삭제 처리</title>
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
		
			int review_no = 0;
		  	if(request.getParameter("review_no") != null) {
		  		review_no = Integer.parseInt(request.getParameter("review_no"));
		  	}
		  	if(review_no == 0) {
		  		PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href = 'review.jsp'");
				script.println("</script>");
		  	}
		  	
		  	ReviewDTO reviewDTO = new ReviewDAO().getDTO(review_no);
		  	
		  	if(!cus_id.equals(reviewDTO.getCus_id())) {
		  		PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href = 'review.jsp'");
				script.println("</script>");
		  		
		  	} else {
		  		
		  		
				
					ReviewDAO reviewDAO = new ReviewDAO();
					int result = reviewDAO.delete(review_no);
					
					if (result == -1) {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('리뷰 삭제를 실패했습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('작성하신 리뷰가 삭제되었습니다.')");
						script.println("location.href = 'review.jsp'");
						script.println("</script>");
					}
					
				
				
				
				
				
			}
		
		
	%>	
		
		
</body>
</html>