<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import= "dao.ReviewDAO" %>
<%@ page import= "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="review" class="dto.ReviewDTO" scope="page" />
<jsp:setProperty name="review" property="*" />




<!DOCTYPE html>
<html>
<head>

<title>리뷰 처리</title>
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
			
			
			if(review.getReview_title() == null || review.getP_name() == null || review.getReview() == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안 된 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				ReviewDAO reviewDAO = new ReviewDAO();
				int result = reviewDAO.reviewWrite(review.getReview_title(), cus_id, review.getP_name(), review.getReview());
				
				if (result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('리뷰쓰기에 실패했습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('고객님의 소중한 리뷰 감사드립니다.')");
					script.println("location.href = 'review.jsp'");
					script.println("</script>");
				}
				
			}
			
			
			
			
		}
		
		
		

		

		
	%>


</body>
</html>