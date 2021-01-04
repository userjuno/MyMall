<%@page contentType="text/html; charset=utf-8" %>

<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="Bean.MemberMgr"/>
<jsp:useBean id="bean" class="Bean.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
String id = (String)session.getAttribute("id");
System.out.println("회원정보 조회 세션 아이디 : " + id);
String pw = request.getParameter("pwd");
		System.out.println("비밀번호 : "+pw);
		bean = mgr.getMember(id, pw);
		String msg= "";	
		
		
		boolean result = mgr.goodbye(id, pw);
		
		if(result){
			msg = "회원탈퇴 하였습니다.";
			session.invalidate();
			
		}
		else{
			msg="입력된 정보가 틀렸습니다, 회원 탈퇴에 실패했습니다";
		}
%>
<script>
	alert("<%=msg%>");
	location.href='main.jsp';
	
</script>