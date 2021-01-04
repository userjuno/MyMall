
 function openModal(modalname){
    document.get
    $("#modal").fadeIn(300);
    $("."+modalname).fadeIn(300);
    }
$(function(){

	
  
    var f_on = $('.qst');
    var td = $('td');
    td.attr('onclick','').unbind('click');
    f_on.click(function(){
        
        var dis1 =$(this).next();
        var dis2 = dis1.next();
        var state = dis1.css('display');
        var state1 = $('question1').css('display');
        if(state1='none'){
            $('.question1').css('display','table-cell');
            $('.ans1').css('display','none');
            $('.ans2').css('display','none');
        }
        if(state=='none'){
            $(this).children('td').css('display','none');
            dis1.css('display','block');
            dis2.css('display','block');
            dis1.children().css('font-weight','bold').css('color','black');
        }
        

    });
    
    $('.ans1').css('cursor','pointer');
    $('.ans1').children().css('cursor','pointer');
    $('.ans1').click(function(){
        var dis1 =$(this).prev()
        var dis2 =$(this).next();
        var state = $(this).css('display');
        if(state=='block'){
            dis2.css('display','none');
            dis1.css('display','block');
            $(this).css('display','none');
            dis1.children().css('display','table-cell')
            
        }
    })
    $('.listbox' ).on('mouseenter',function(){ 
        $('.under_wrap').slideDown();
    

    });
    $('.listbox').on('mouseleave',function(){ 
        
        $('.under_wrap').stop(true,true).slideUp();
    });


  
    $('.X').on('click',function(){
        $('.aside_wrap').stop(true).animate({left:-600},600,'easeOutBack');
    });
    $('.open_wrap').on('click',function(){
        $('.aside_wrap').stop(true).animate({left:-60},100);
    });

    $("#join").on('click',function(){
    $(".modal1").fadeOut(300);  
    $(".modal2").fadeIn(300);
    })

    $("#close").on('click',function(){
        $("#modal").fadeOut(300);
    $(".modal-con").fadeOut(300);
    });
    $("#modal, .close").on('click',function(){
    $("#modal").fadeOut(300);
    $(".modal-con").fadeOut(300);
    });
    $("._check_all").click(function(){
            var chk = $(this).is(":checked");//.attr('checked');
            if(chk) $("._join_agree").prop('checked', true);
            else  $("._join_agree").prop('checked', false);
        });
    $(".Belogin").click(function(){
        $(".modal1").fadeOut(300);  
        $(".modal4").fadeIn(300);
    })
    $(".float_r").click(function(){
        $(".modal1").fadeOut(300);  
        $(".modal5").fadeIn(300);
    })
    $(".search").on('click',function(){
        $("#modal").fadeIn(300);
        $("."+modalname).fadeIn(300);

    });
    $(".close").on('click',function(){
        $("#modal").fadeOut(300);
    $(".modal-con").fadeOut(300);
    });
    $("#join_on").click(function(){
        var chk = $("._join_agree").is(":checked");
        if(chk){
            $(".modal2").fadeOut(300);  
            $(".modal3").fadeIn(300);
        }
        else{
            alert("이용약관 및 개인정보 처리방침에 동의하셔야 가입이 가능합니다.");
        }
    })
    function null_ck(value){
        if(value==null) return  true;
        if (typeof value === 'string' && value === '') return true;
        if (typeof value === 'undefined') return true;
        return false;
    }
    function ck_pw(val1,val2){
        if(val1!=val2) return true;
        if(val2==null) return true;
        
        return false;
    }
	


    $("#modal").on("click",function(){
        
        $(".modal1").find('input').val("");
        $(".modal3").find('input').val("");
        $(".modal4").find('input').val("");
        $(".modal2").find('input').prop('checked', false);
        $(".modal5").find('input').val("");
        $(".modal6").find('input').val("");
        $(".same").val("ID중복확인");
        $(".reg").val("회원가입");
        $(".find_zip").val("우편번호 찾기");

    });
var count = 0;
	$(".same").click(function(){
		count++;
	});
    $(".jbtn").click(function(){
        var $null = $(".Mo_id").val();
        var $pw1 = $(".Mo_pw").val();
        var $pw2 = $(".Mo_cpw").val();
        var $name = $(".Mo_name").val();
        var $zipcode = $(".zipcode").val();
        var $phone = $(".Mo_phone").val(); 
        
        if(null_ck($null))
        {  
            alert("아이디를 입력해주세요");       
        }
        else if(null_ck($pw1)){
            alert("비밀번호를 입력해주세요");    
        }
        else if(ck_pw($pw1,$pw2)){
            alert("비밀번호 확인란과 일치하지 않습니다.");       
        }
        else if(null_ck($name)){
            alert("이름을 입력해 주세요.");       
        }
        else if(count==0){
        	alert("아이디 중복 확인을 해주세요");   
        }
        else if(null_ck($zipcode)){
        	alert("우편번호를 해주세요"); 
        }
        else if(null_ck($phone)){
        	alert("우편번호를 해주세요"); 
        }
        else{
        	document.regFrm.submit();
            
        }
    })
    $(".jbtn_1").click(function(){
        var $null = $(".Mo_id1").val();
        var $pw1 = $(".Mo_pw1").val();
        var $pw2 = $(".Mo_cpw1").val();
        var $name = $(".Mo_name1").val();
        var $zipcode1 = $(".zipcode1").val();
        var $phone = $(".Mo_phone1").val(); 
        
        
        if(null_ck($pw1)){
            alert("비밀번호를 입력해주세요");    
        }
        else if(ck_pw($pw1,$pw2)){
            alert("비밀번호 확인란과 일치하지 않습니다.");       
        }
        else if(null_ck($name)){
            alert("이름을 입력해 주세요.");       
        }
        
        else if(null_ck($zipcode1)){
        	alert("우편번호를 해주세요"); 
        }
        else if(null_ck($phone)){
        	alert("전화번호를 입력해 주세요"); 
        }
        else{
        	document.upFrm.submit();
            
        }
    })
      $(".jbtn_2").click(function(){
       ;
        var $pw1 = $(".Mo_pw2").val();
       
      
        
        if(null_ck($pw1)){
            alert("비밀번호를 입력해주세요");    
        }
    
        else{
        	document.infoFrm.submit();
            
        }
    })
     $(".jbtn_3").click(function(){
       ;
        var $pw1 = $(".Mo_pw3").val();
       
      
        
        if(null_ck($pw1)){
            alert("비밀번호를 입력해주세요");    
        }
    
        else{
        	document.byeFrm.submit();
            
        }
    })
    
    $(".M_login").click(function(){
        var $null = $(".M_id").val();
        var $pw1 = $(".M_pw").val();
    
        if(null_ck($null))
        {
            alert("아이디를 입력해주세요");
            return;
        }
        else if(null_ck($pw1)){
            alert("비밀번호를 입력해주세요");
            return;
            
        }
        else {
    		
		}
 
    })
    
  
    $(".M_login_1").click(function(){
        var $null = $(".M_num").val();
        var $pw1 = $(".M_phone").val();
    
        if(null_ck($null))
        {
            alert("주문번호를 입력해주세요");
            return;
        }
        else if(null_ck($pw1)){
            alert("연락처를 입력해주세요");
            return;
        }
        else{
            
        }
    })
    $(".find_btn").click(function(){
        var find = $(".find_btn");
        find.toggleClass('active');
    })
    $(".f_id").click(function(){
        $(".F_header").text("아이디 찾기");
        $(".enter_info").attr('placeholder','이름 또는 아이디')
        $(".find_find").text("아이디 찾기");
        
        
    })
    $(".f_pw").click(function(){
        $(".F_header").text("비밀번호 찾기");
        $(".enter_info").attr('placeholder','가입한 아이디')
        $(".find_find").text("비밀번호 찾기");
        
        
    })
    $(".find_find").click(function(){
        var text =  $(".enter_info");
        if(null_ck(text.val())){
            
            alert("입력하신 정보와 일치하는 계정이 없습니다. 다시 시도해주시거나 사이트 운영자에게 문의해주세요.")
            return;
        }
    })
    
    
    $(".header2").children('h1').css('cursor','pointer');
    $(".header1").children('p').css('width',250);
     $(".header1").children('p').css('margin-left',200);
     $(".header2").children('h1').css('z-index',99);
  	 $(".header2").children('h1').click(function(){
  	 
  	 	location.href="boardList.bo";
  	 })
	
   });
  
   function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                    console.log(extraAddr);
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
            
        }).open();
        
    }
    function sample6_execDaumPostcode_1() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress_1").value = extraAddr;
                    console.log(extraAddr);
                
                } else {
                    document.getElementById("sample6_extraAddress_1").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode_1').value = data.zonecode;
                document.getElementById("sample6_address_1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress_1").focus();
            }
            
        }).open();
        
    }   function sample6_execDaumPostcode_2() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress_2").value = extraAddr;
                    console.log(extraAddr);
                
                } else {
                    document.getElementById("sample6_extraAddress_2").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode_2').value = data.zonecode;
                document.getElementById("sample6_address_2").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress_2").focus();
            }
            
        }).open();
        
    }
    function idCheck(id) {
    
	frm = document.regFrm;
	if (id == "") {
		alert("아이디를 입력해 주세요.");
		frm.id.focus();
		return;
	}
	url = "idCheck.jsp?id=" + id;
	window.open(url, "IDCheck", "width=300,height=150");
}
 function phoneCheck(phone) {
    
	frm = document.regFrm;
	if (phone == "") {
		alert("전화번호를 입력해 주세요.");
		frm.phone.focus();
		return;
	}
	url = "phoneCheck.jsp?phone=" + phone;
	window.open(url, "PhoneCheck", "width=300,height=150");
}
 
function findId(id) {
    
	frm = document.regFrm;
	if (id == "") {
		alert("전화번호를 입력해 주세요.");
		frm.id.focus();
		return;
	}
	url = "idFind.jsp?id=" + id;
	window.open(url, "findId", "width=300,height=150");
}
 
 function findPw(pw) {
    
	frm = document.regFrm;
	if (pw == "") {
		alert("아이디를 입력해 주세요.");
		frm.pw.focus();
		return;
	}
	url = "pwFind.jsp?pw=" + pw;
	window.open(url, "findPw", "width=300,height=150");
}
 
