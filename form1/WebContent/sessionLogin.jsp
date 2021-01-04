<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%session.setAttribute("id", request.getParameter("id")); %>    //파라미터를 받아서 세션값을 설정한다.
<%session.setAttribute("pwd", request.getParameter("pwd")); %>   
<html>
<head>
<title>Session Login</title>
</head>
<body>
<center>
    <h3>Login Success!!!</h3>
    <h3>Login ID : <%=(String)session.getAttribute("id") %></h3>    // 이와같이 브라우저가 유지되는동안 
    <h3>Login PASSWORD : <%=(String)session.getAttribute("pwd") %></h3>  //세션값들은 계속 유지된다.
    <a href="sessionLogout.jsp">로그아웃</a>
</center>
</body>
</html>
