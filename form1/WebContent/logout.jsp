<%@ page language="java" contentType="text/html;charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import="Bean.UserDAO" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
session.invalidate();
String url = request.getHeader("referer").toString();
int re;
int idx = url.indexOf("8");
String url2=url.substring(idx+4);
System.out.println(url2);


PrintWriter script = response.getWriter();
script.println("<script>");
script.println("location.href='"+ url2 +"'");
script.println("</script>");
%>
<body>

</body>

<script>

</script>
</html>