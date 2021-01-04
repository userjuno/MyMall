<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="Bean.MemberMgr" />
<%@page import="Bean.MemberBean"%>
<html>
<head>
<title>ID 찾기</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="white">
	<div align="center">
		
		
		<%
		
		request.setCharacterEncoding("EUC-KR");
		try{
			String id = request.getParameter("id");
			MemberBean mBean = mMgr.findId(id);
			if (mBean !=null) {
				out.println("회원님의 아이디는"+mBean.getId()+" 입니다<p/>");
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