<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@ page import="java.util.Properties" %>
<%@ page import="util.Gmail" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>

<title>문의 답변 전송처리</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");	
	String user_email = request.getParameter("user_email");
	String manager_ask = request.getParameter("manager_ask");


	String host = "http://localhost:9000/bookStore/";

	String from = "kkh97820@gmail.com";

	String to = user_email;

	String subject = "[BookForest] 고객님의 문의사항에 대한 답변입니다.";

	String content = manager_ask;

	

	// SMTP에 접속하기 위한 정보를 기입합니다.

	Properties p = new Properties();

	p.put("mail.smtp.user", from);
	p.put("mail.smtp.host", "smtp.googlemail.com");
	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");

	 

	try{

	    Authenticator auth = new Gmail();
	    Session ses = Session.getInstance(p, auth);
	    ses.setDebug(true);
	    MimeMessage msg = new MimeMessage(ses); 
	    msg.setSubject(subject);
	    Address fromAddr = new InternetAddress(from);
	    msg.setFrom(fromAddr);
	    Address toAddr = new InternetAddress(to);
	    msg.addRecipient(Message.RecipientType.TO, toAddr);
	    msg.setContent(content, "text/html;charset=UTF-8");
	    Transport.send(msg);
	    PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('문의 답변이 전송되었습니다.')");
		script.println("location.href = 'store.jsp'");
		script.println("</script>");
		script.close();

	} catch(Exception e){

	    e.printStackTrace();

		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('오류가 발생했습니다.')");
		script.println("location.href = 'store.jsp'");
		script.println("</script>");
		script.close();		

	    return;

	}






%>




</body>
</html>