<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html >
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<%
		String id = request.getParameter("cartId");
		if (id == null || id.trim().equals("")){
			response.sendRedirect("cart.jsp");
			return;
		}
	
		session.invalidate();
		response.sendRedirect("cart.jsp");
	%>
</body>
</html>