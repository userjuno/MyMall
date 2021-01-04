<%@ page language="java" contentType="text/html;charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import="Bean.UserDAO" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<jsp:useBean id="user" class="Bean.MemberBean" scope="page" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="pwd" /> 

<%session.setAttribute("id", request.getParameter("id")); %>   
<%session.setAttribute("pwd", request.getParameter("pwd")); %>  
<% request.setCharacterEncoding("UTF-8"); %>




<!DOCTYPE html>

<html>

<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>jsp 게시판 웹사이트</title>

</head>

<body>

	<%

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String loginChk = request.getParameter("loginChk");
	String url = request.getParameter("url");
	
	String userID = null;
	
	if(session.getAttribute("id") != null){
		userID = (String) session.getAttribute("id");
	}
	
	
		UserDAO userDAO = new UserDAO(); //인스턴스생성

		int result = userDAO.login(id, pwd);
		String name = userDAO.getName(user.getId(), user.getPwd());
		
		System.out.println(url);



		//로그인 성공
		
		if(result == 1){
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			session.setAttribute("id", id);
			session.setAttribute("pwd",pwd);
			script.println("alert('로그인 되었습니다.')");
			script.println("alert('"+name+" 님 반갑습니다')");
			script.println("location.href='"+ url +"'");
			script.println("</script>");
			 // 체크한 경우
			
			
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
			System.out.println("6");
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

		script.println("history.back()");

		script.println("</script>");

		}		

	

	%>


<script>

</script>
</body>

