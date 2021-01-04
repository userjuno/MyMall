<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="mMgr" class="Bean.MemberMgr"/>
<%@ page import="Bean.UserDAO" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<link href="<%=request.getContextPath()%>/js/modal.js">
<jsp:useBean id="user" class="Bean.MemberBean" scope="page" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="pwd" /> 
<%request.setCharacterEncoding("EUC-KR");%>
<%!
	
%>
<%
	String url;
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	UserDAO userDAO = new UserDAO(); //인스턴스생성
	int result = userDAO.login(id,pwd);
	url = request.getHeader("referer").toString();
	int re;
	int idx = url.indexOf("8");
	String url2=url.substring(idx+4);

	/* if(request.getHeader("referer")!= null){
		url = url +"?"+request.getHeader("referer");
		
	} */

	//로그인 성공

	if(result == 1){
		
		PrintWriter script = response.getWriter();

		script.println("<script>");
		script.println("alert('로그인성공')");		
		script.println("var re =" + "1");
		script.println("</script>");
		
	}

	//로그인 실패

	else if(result == 0){

		PrintWriter script = response.getWriter();

		script.println("<script>");
		
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");

		
		
	}

	//아이디 없음

	else if(result == -1){

	PrintWriter script = response.getWriter();

	script.println("<script>");

	script.println("alert('존재하지 않는 아이디 입니다.')");
	script.println("history.back()");

	script.println("</script>");

	}

	//DB오류

	else if(result == -2){

	PrintWriter script = response.getWriter();

	script.println("<script>");


	script.println("alert('DB오류가 발생했습니다.')");

	

	script.println("</script>");

	}		
	else{}
	
	

	 
%>
<script>
var url123="<%=url2%>";
if(re==1){
	
	location.href="<%=url2%>";
	
	
}
var a;
a="<%=result%>";
alert(a);
if(a==1){
	
}



	
</script>