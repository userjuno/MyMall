<%@page contentType="text/html; charset=utf-8" %>

<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="Bean.MemberMgr"/>
<jsp:useBean id="bean" class="Bean.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%@ page import="java.io.PrintWriter" %>
<%
String id = (String)session.getAttribute("id");
System.out.println("회원정보 조회 세션 아이디 : " + id);
String pw = request.getParameter("pwd");
		System.out.println("비밀번호 : "+pw);
		bean = mgr.getMember(id, pw);
		String msg = "회원정보 조회를 실패 하였습니다.";
		
		if(bean!=null){
			msg="조회 성공";
			PrintWriter script = response.getWriter();
	    	script.println("<script>");
	    	script.println("location.href='reginfo1.jsp'");
	    	script.println("</script>");
		}
		else{
			PrintWriter script = response.getWriter();
	    	script.println("<script>");
	    	script.println("history.go(-1);");
	    	script.println("</script>");
		}
%>
<script>
	alert("<%=msg%>");
	
	
</script>