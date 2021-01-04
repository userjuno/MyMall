<%@ page language="java" contentType="text/html;charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.UserDAO" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<jsp:useBean id="user" class="Bean.MemberBean" scope="page" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="pwd" /> 

<%request.setCharacterEncoding("EUC-KR");
 String id = (String)session.getAttribute("idKey");%>
 <%session.setAttribute("id", request.getParameter("id")); %>   
<%session.setAttribute("pwd", request.getParameter("pwd")); %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Hi+Melody&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/modal.css">
    <script src="js/vendor/jquery-1.10.2.min.js"></script>
    <script src="js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="js/vendor/modernizr.custom.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
    <script src="js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="js/vendor/modernizr.custom.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modal.js"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="script.js"></script>
    <title>Document</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0;
        }
        .login{
            
            margin: 0 auto;
            padding-top: 5%;
            width: 30%;
            height: 30%;
            font-size: 1.3em;
        }
    </style>
</head>

<body>

<%

String url = request.getHeader("referer").toString();
int re;
int idx = url.indexOf("8");
String url2=url.substring(idx+4);
String a =(String)session.getAttribute("id");
System.out.println(url2);

%>
<script>

</script>
<div class="login" onload="msg()">
          <p class="title"></p>
          <h1 class="M_header">로그인</h1>
          <div class="con">
          	<form method="post" action="loginAction.jsp"  >
          		<input type="text" id="M_t" name="id" class="M_id" placeholder="아이디">
	            <input type="password" id="M_t" name="pwd" class="M_pw" placeholder="비밀번호">
	            <div class="cheak_article">
	                <div class="checkbox checkbox-styled">
	                    <label class="form-label" class="urlbox" >
	                    	<input type="hidden" name="url" value=<%=url2%>>
	                        <input type="checkbox" class="ie" name="auto_login" data-type="use" value="ok" checked="checked">
	                        <span class="agree_tit" name="loginChk">로그인상태유지</span>
	                    </label>
	                </div>
	            </div>
            <button class="M_login" >로그인</button>
          	</form>
            
            <div class="over_h">
                <a href="javascript:openModal('modal5');" class="float_r  modal-open" id="find_my">아이디 찾기</a>
                <a href="javascript:openModal('modal5_1');" class="float_r  modal-open" id="find_my">비밀번호 찾기</a>
            </div>
            <hr>
             <div class="modal_wrap">
     
             <div id="modal"></div>
				<div class="modal-con modal5 modal-con_1">
	            <a href="javascript:;" class="close">X</a>
	            <p class="title"></p>
	            <h1 class="M_header F_header">아이디 찾기</h1>
	            <form>
	            <div class="con">
	             
	                <input name="id" type="text" class="enter_info" id="M_t" placeholder="전화번호">
	                
	                <button class="find_find" onClick="findId(this.form.id.value)">아이디찾기</button>
	                
	            </div>
	            </form>
	          </div>
	          <div class="modal-con modal5_1 modal-con_1">
	            
	            <p class="title"></p>
	            <h1 class="M_header F_header">비밀번호 찾기</h1>
	            <form>
	            <div class="con">
	            
	               
	                <input name="pw" type="text" class="enter_info" id="M_t" placeholder="아이디">
	                
	                <button class="find_find" onClick="findPw(this.form.pw.value)">비밀번호찾기</button>
	            </div>
	            </form>
	          </div> 
          </div>
        </div>
	</div>
    
</body>

</html>