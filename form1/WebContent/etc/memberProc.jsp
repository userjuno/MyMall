<%@page contentType="text/html; charset=utf-8" %>

<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="Bean.MemberMgr"/>
<jsp:useBean id="bean" class="Bean.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
		boolean result = mgr.insertMember(bean);
		String msg = "회원가입에 실패 하였습니다.";
		
		if(result){
			msg = "회원가입을 하였습니다.";
			
		}
%>
<script>
	alert("<%=msg%>");
	history.back();
</script>