<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="Bean.MemberMgr" />
<%@page import="Bean.MemberBean"%>
<%
	request.setCharacterEncoding("EUC-KR");
	
%>
<html>
<head>
<title>PW 찾기</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="white">
	<div align="center">
		<br/><b></b>
		<%

		try{
			String pw = request.getParameter("pw");
			MemberBean mBean = mMgr.findPw(pw);

			if (mBean !=null) {
				out.println("회원님의 비밀번호는"+mBean.getPwd()+" 입니다<p/>");
			} else {
				out.println("아이디가 존재하지않습니다.<p/>");
			}
		}
		catch(Exception e){
			out.println("아이디가 존재하지않습니다.<p/>");
		}
			
		%>

		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
</html>