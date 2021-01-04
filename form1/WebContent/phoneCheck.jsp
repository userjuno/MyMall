<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="Bean.MemberMgr" />
<%
	request.setCharacterEncoding("EUC-KR");
	String phone = request.getParameter("phone");
	boolean result = mMgr.checkPhone(phone);
%>
<html>
<head>
<title>전화번호 중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="white">
	<div align="center">
		<br/><b><%=phone%></b>
		<%
			if (result) {
				out.println("는 이미 존재한는 전화번호입니다.<p/>");
			} else {
				out.println("는 사용 가능 합니다.<p/>");
			}
		%>
		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
</html>