<%@page contentType="text/html; charset=utf-8" %>

<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mgr" class="Bean.MemberMgr"/>
<jsp:useBean id="bean" class="Bean.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
	String id = (String)session.getAttribute("id");
	System.out.println("회원정보 업데이트 세션 아이디 : " + id);
	boolean result = mgr.updateMember(bean, id);
	String msg = "회원정보에 수정에 실패 하였습니다.";
	
	if(result){
		msg = "회원정보 수정을 하였습니다.";
		
	}
%>
<script>
	alert("<%=msg%>");
	history.back();
	
</script>