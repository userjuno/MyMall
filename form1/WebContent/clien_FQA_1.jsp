<%@ page language="java" contentType="text/html;charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("EUC-KR");%>
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<jsp:useBean id="user" class="Bean.MemberBean" scope="page" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="pwd" />
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
    <script type="text/javascript" src="js/modal.js" charset='utf-8'></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="script.js" charset='utf-8'></script>
</head>
<style>
  
    /* 메뉴 리스트 끝 */
    
    /* 메인 콘텐츠 영역 */
    .menu_nav{
        border-bottom: 1px solid #B5B5B5 ;
        width: 70%;
       
        margin-left: 14.3%;
      
    }
    .imgdiv{
        text-align: center;
        margin: 5%;
        margin-top: 2%;
        
    }
    .nav_p{
        
        font-family: 'Gothic A1', sans-serif;
        font-size: 1.3em;
        width: 100%;
        text-align: center;
        
    }
    .nav_p a{
        color: #807F83;
        
    }
    .faq{
        
        display: inline-block;
        padding: 12px 35px;
        border: 1px solid red;
    }
    .in{
        display: inline-block;
        padding: 12px 35px;
        border: 1px solid white;
        /* border: 1px solid red; */
    }
    .sangdam{
        display: inline-block;
        padding: 12px 35px;
        border: 1px solid white;
        /* border: 1px solid red; */
       
    }
    .sin{
        display: inline-block;
        padding: 12px 35px;
        border: 1px solid white;
        /* border: 1px solid red; */
    }
    .find{
        display: inline-block;
        padding: 12px 35px;
        border: 1px solid white;
        /* border: 1px solid red; */
    }
    #contents {
        position: relative;
        width: 1000px;
        min-height: 500px;
        margin: 0 auto;
        margin-left: 24%;
        padding: 30px 0px 50px 0px;
    }
    #faqtbl .question1 {
        background: #e6e6e6;
        height: 40px;
        color: #807F83;
        cursor: pointer;
    }
    td{
        width: 1000px;
        padding: 2px;
    }
    td, span {
        font-size: 12px;
        font-family: "Malgun Gothic","Apple SD Gothic Neo",Dotum;
        color: #807F83;
    }
    
    .pabs a{
        font-size: 12px;
        font-family: "Malgun Gothic","Apple SD Gothic Neo",Dotum;
        color: white;
        display: inline-block;
        width: 100px;
        height: 30px;
        text-align: center;
        background-color: #807F84;
        line-height: 30px;
        }
    .pabs a:active{
        font-size: 12px;
        font-family: "Malgun Gothic","Apple SD Gothic Neo",Dotum;
        color: white;
        display: inline-block;
        width: 100px;
        height: 30px;
        text-align: center;
        background-color:#F04130;
        line-height: 30px;
        }
    .h100 {
        display: block;
        height: 300px;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        
    }
    footer{
        margin-top: -5%;
    }
    /* 메인 콘텐츠 영역 끝 */
    /* 푸터영역 */
  
</style>
<body>
    <div class="modal_wrap">
        <div id="wrap">
            <a href="javascript:openModal('modal1');" class="button modal-open">모달열기1</a>
            <a href="javascript:openModal('modal5');" class="button modal-open">모달열기2</a>
        </div>
      
      <div id="modal"></div>
        <div class="modal-con modal1">
          <a href="javascript:;" class="close">X</a>
          <p class="title"></p>
          <h1 class="M_header">로그인</h1>
          <div class="con">
            <input type="text" id="M_t" class="M_id" placeholder="아이디">
            <input type="password" id="M_t" class="M_pw" placeholder="비밀번호">
            <div class="cheak_article">
                <div class="checkbox checkbox-styled">
                    <label class="form-label">
                        <input type="checkbox" class="ie" name="auto_login" data-type="use" value="ok" checked="checked">
                        <span class="agree_tit">로그인상태유지</span>
                    </label>
                </div>
            </div>
            <button class="M_login">로그인</button>
            <div class="over_h">
                <a href="javascript:;" class="float_l" id="join">회원가입</a>		
                <a href="javascript:;" class="float_r" id="find_my">아이디 · 비밀번호 찾기</a>
            </div>
            <hr>
            <button class="Belogin">비회원 배송조희</button>
          </div>
        </div>
        <div class="modal-con modal2">
            <a href="javascript:;" class="close">X</a>
          <p class="title"></p>
          <h1 class="M_header">약관동의</h1>
          <div class="con">
            <div class="input-block all-check">
                <div class="check">
                    <div class="checkbox checkbox-styled">
                        <label class="form-label">
                            <input type="checkbox" name="rdo" value="" class="_check_all ie">
                                                    <span class="agree_tit">이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</span>
                        </label>
    
                    </div>
                </div>
            </div>
            <div class="input-block term-block">
                <div class="check">
                    <div class="checkbox checkbox-styled">
                        <label class="form-label">
                            <input type="checkbox" name="policy_agree" value="ok" id="policy_agree" class="_join_agree _policy_agree ie require_agreement">
                            <span class="agree_tit">이용약관 동의<em class="alert">(필수)</em></span>
                        </label>
                    </div>
                </div>
            </div>
                <div class="input-block">
                    <div class="form-group privacy">
                        <div tabindex="0" class="" style="height: 100px; overflow-y: auto; background:#fff; color:#000;">
                            제1조 목적<br>
    <br>
    본 이용약관은 “사이트명”(이하 "사이트")의 서비스의 이용조건과 운영에 관한 제반 사항 규정을 목적으로 합니다.<br>
    <br>
    제2조 용어의 정의<br>
    <br>
    본 약관에서 사용되는 주요한 용어의 정의는 다음과 같습니다.<br>
    <br>
    ① 회원 : 사이트의 약관에 동의하고 개인정보를 제공하여 회원등록을 한 자로서, 사이트와의 이용계약을 체결하고 사이트를 이용하는 이용자를 말합니다.<br>
    ② 이용계약 : 사이트 이용과 관련하여 사이트와 회원간에 체결 하는 계약을 말합니다.<br>
    ③ 회원 아이디(이하 "ID") : 회원의 식별과 회원의 서비스 이용을 위하여 회원별로 부여하는 고유한 문자와 숫자의 조합을 말합니다.<br>
    ④ 비밀번호 : 회원이 부여받은 ID와 일치된 회원임을 확인하고 회원의 권익 보호를 위하여 회원이 선정한 문자와 숫자의 조합을 말합니다.<br>
    ⑤ 운영자 : 서비스에 홈페이지를 개설하여 운영하는 운영자를 말합니다.<br>
    ⑥ 해지 : 회원이 이용계약을 해약하는 것을 말합니다.<br>
    <br>
    제3조 약관 외 준칙<br>
    <br>
    운영자는 필요한 경우 별도로 운영정책을 공지 안내할 수 있으며, 본 약관과 운영정책이 중첩될 경우 운영정책이 우선 적용됩니다.<br>
    <br>
    제4조 이용계약 체결<br>
    <br>
    ① 이용계약은 회원으로 등록하여 사이트를 이용하려는 자의 본 약관 내용에 대한 동의와 가입신청에 대하여 운영자의 이용승낙으로 성립합니다.<br>
    ② 회원으로 등록하여 서비스를 이용하려는 자는 사이트 가입신청 시 본 약관을 읽고 아래에 있는 "동의합니다"를 선택하는 것으로 본 약관에 대한 동의 의사 표시를 합니다.<br>
    <br>
    제5조 서비스 이용 신청<br>
    <br>
    ① 회원으로 등록하여 사이트를 이용하려는 이용자는 사이트에서 요청하는 제반정보(이용자ID,비밀번호, 닉네임 등)를 제공해야 합니다.<br>
    ② 타인의 정보를 도용하거나 허위의 정보를 등록하는 등 본인의 진정한 정보를 등록하지 않은 회원은 사이트 이용과 관련하여 아무런 권리를 주장할 수 없으며, 관계 법령에 따라 처벌받을 수 있습니다.<br>
    <br>
    제6조 개인정보처리방침<br>
    <br>
    사이트 및 운영자는 회원가입 시 제공한 개인정보 중 비밀번호를 가지고 있지 않으며 이와 관련된 부분은 사이트의 개인정보처리방침을 따릅니다.<br>
    운영자는 관계 법령이 정하는 바에 따라 회원등록정보를 포함한 회원의 개인정보를 보호하기 위하여 노력합니다.<br>
    <br>
    회원의 개인정보보호에 관하여 관계법령 및 사이트가 정하는 개인정보처리방침에 정한 바에 따릅니다.<br>
    <br>
    단, 회원의 귀책 사유로 인해 노출된 정보에 대해 운영자는 일체의 책임을 지지 않습니다.<br>
    운영자는 회원이 미풍양속에 저해되거나 국가안보에 위배되는 게시물 등 위법한 게시물을 등록 · 배포할 경우 관련 기관의 요청이 있을 시 회원의 자료를 열람 및 해당 자료를 관련 기관에 제출할 수 있습니다.<br>
    <br>
    제7조 운영자의 의무<br>
    <br>
    ① 운영자는 이용회원으로부터 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 가급적 빨리 처리하여야 합니다. 다만, 개인적인 사정으로 신속한 처리가 곤란한 경우에는 사후에 공지 또는 이용회원에게 쪽지, 전자우편 등을 보내는 등 최선을 다합니다.<br>
    ② 운영자는 계속적이고 안정적인 사이트 제공을 위하여 설비에 장애가 생기거나 유실된 때에는 이를 지체 없이 수리 또는 복구할 수 있도록 사이트에 요구할 수 있습니다. 다만, 천재지변 또는 사이트나 운영자에 부득이한 사유가 있는 경우, 사이트 운영을 일시 정지할 수 있습니다.<br>
    <br>
    제8조 회원의 의무<br>
    <br>
    ① 회원은 본 약관에서 규정하는 사항과 운영자가 정한 제반 규정, 공지사항 및 운영정책 등 사이트가 공지하는 사항 및 관계 법령을 준수하여야 하며, 기타 사이트의 업무에 방해가 되는 행위, 사이트의 명예를 손상하는 행위를 해서는 안 됩니다.<br>
    ② 회원은 사이트의 명시적 동의가 없는 한 서비스의 이용 권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.<br>
    ③ 이용고객은 아이디 및 비밀번호 관리에 상당한 주의를 기울여야 하며, 운영자나 사이트의 동의 없이 제3자에게 아이디를 제공하여 이용하게 할 수 없습니다.<br>
    ④ 회원은 운영자와 사이트 및 제3자의 지적 재산권을 침해해서는 안 됩니다.<br>
    <br>
    제9조 서비스 이용 시간<br>
    <br>
    ① 서비스 이용 시간은 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴 1일 24시간을 원칙으로 합니다. 단, 사이트는 시스템 정기점검, 증설 및 교체를 위해 사이트가 정한 날이나 시간에 서비스를 일시중단 할 수 있으며 예정된 작업으로 인한 서비스 일시 중단은 사이트의 홈페이지에 사전에 공지하오니 수시로 참고하시길 바랍니다.<br>
    ② 단, 사이트는 다음 경우에 대하여 사전 공지나 예고 없이 서비스를 일시적 혹은 영구적으로 중단할 수 있습니다.<br>
    - 긴급한 시스템 점검, 증설, 교체, 고장 혹은 오동작을 일으키는 경우<br>
    - 국가비상사태, 정전, 천재지변 등의 불가항력적인 사유가 있는 경우<br>
    - 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지한 경우<br>
    - 서비스 이용의 폭주 등으로 정상적인 서비스 이용에 지장이 있는 경우<br>
    ③ 전항에 의한 서비스 중단의 경우 사이트는 사전에 공지사항 등을 통하여 회원에게 통지합니다. 단, 사이트가 통제할 수 없는 사유로 발생한 서비스의 중단에 대하여 사전공지가 불가능한 경우에는 사후공지로 대신합니다.<br>
    <br>
    제10조 서비스 이용 해지<br>
    <br>
    ① 회원이 사이트와의 이용계약을 해지하고자 하는 경우에는 회원 본인이 온라인을 통하여 등록해지 신청을 하여야 합니다. 한편, 사이트 이용 해지와 별개로 사이트에 대한 이용계약 해지는 별도로 하셔야 합니다.<br>
    ② 해지 신청과 동시에 사이트가 제공하는 사이트 관련 프로그램이 회원 관리 화면에서 자동적으로 삭제됨으로 운영자는 더 이상 해지신청자의 정보를 볼 수 없습니다.<br>
    <br>
    제11조 서비스 이용 제한<br>
    <br>
    회원은 다음 각호에 해당하는 행위를 하여서는 아니 되며 해당 행위를 한 경우에 사이트는 회원의 서비스 이용 제한 및 적법한 조치를 할 수 있으며 이용계약을 해지하거나 기간을 정하여 서비스를 중지할 수 있습니다.<br>
    ① 회원 가입시 혹은 가입 후 정보 변경 시 허위 내용을 등록하는 행위<br>
    ② 타인의 사이트 이용을 방해하거나 정보를 도용하는 행위<br>
    ③ 사이트의 운영진, 직원 또는 관계자를 사칭하는 행위<br>
    ④ 사이트, 기타 제3자의 인격권 또는 지적재산권을 침해하거나 업무를 방해하는 행위<br>
    ⑤ 다른 회원의 ID를 부정하게 사용하는 행위<br>
    ⑥ 다른 회원에 대한 개인정보를 그 동의 없이 수집, 저장, 공개하는 행위<br>
    ⑦ 범죄와 결부된다고 객관적으로 판단되는 행위<br>
    ⑧ 기타 관련 법령에 위배되는 행위<br>
    <br>
    제12조 게시물의 관리<br>
    <br>
    ① 사이트의 게시물과 자료의 관리 및 운영의 책임은 운영자에게 있습니다. 운영자는 항상 불량 게시물 및 자료에 대하여 모니터링을 하여야 하며, 불량 게시물 및 자료를 발견하거나 신고를 받으면 해당 게시물 및 자료를 삭제하고 이를 등록한 회원에게 주의를 주어야 합니다.<br>
    한편, 이용회원이 올린 게시물에 대해서는 게시자 본인에게 책임이 있으니 회원 스스로 본 이용약관에서 위배되는 게시물은 게재해서는 안 됩니다.<br>
    ② 정보통신윤리위원회 등 공공기관의 시정요구가 있는 경우 운영자는 회원의 사전동의 없이 게시물을 삭제하거나 이동 할 수 있습니다.<br>
    ③ 불량게시물의 판단기준은 다음과 같습니다.<br>
    - 다른 회원 또는 제3자에게 심한 모욕을 주거나 명예를 손상하는 내용인 경우<br>
    - 공공질서 및 미풍양속에 위반되는 내용을 유포하거나 링크 시키는 경우<br>
    - 불법 복제 또는 해킹을 조장하는 내용인 경우<br>
    - 영리를 목적으로 하는 광고일 경우<br>
    - 범죄와 결부된다고 객관적으로 인정되는 내용일 경우<br>
    - 다른 이용자 또는 제3자와 저작권 등 기타 권리를 침해하는 경우<br>
    - 기타 관계 법령에 위배된다고 판단되는 경우<br>
    ④ 사이트 및 운영자는 게시물 등에 대하여 제3자로부터 명예훼손, 지적재산권 등의 권리 침해를 이유로 게시중단 요청을 받은 경우 이를 임시로 게시 중단(전송중단)할 수 있으며, 게시중단 요청자와 게시물 등록자 간에 소송, 합의 기타 이에 준하는 관련 기관의 결정 등이 이루어져 사이트에 접수된 경우 이에 따릅니다.<br>
    <br>
    제13조 게시물의 보관<br>
    <br>
    사이트 운영자가 불가피한 사정으로 본 사이트를 중단하게 될 경우, 회원에게 사전 공지를 하고 게시물의 이전이 쉽도록 모든 조치를 하기 위해 노력합니다.<br>
    <br>
    제14조 게시물에 대한 저작권<br>
    <br>
    ① 회원이 사이트 내에 게시한 게시물의 저작권은 게시한 회원에게 귀속됩니다. 또한 사이트는 게시자의 동의 없이 게시물을 상업적으로 이용할 수 없습니다. 다만 비영리 목적인 경우는 그러하지 아니하며, 또한 서비스 내의 게재권을 갖습니다.<br>
    ② 회원은 서비스를 이용하여 취득한 정보를 임의 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.<br>
    ③ 운영자는 회원이 게시하거나 등록하는 사이트 내의 내용물, 게시 내용에 대해 제12조 각호에 해당한다고 판단되는 경우 사전통지 없이 삭제하거나 이동 또는 등록 거부할 수 있습니다.<br>
    <br>
    제15조 손해배상<br>
    <br>
    ① 본 사이트의 발생한 모든 민, 형법상 책임은 회원 본인에게 1차적으로 있습니다.<br>
    ② 본 사이트로부터 회원이 받은 손해가 천재지변 등 불가항력적이거나 회원의 고의 또는 과실로 인하여 발생한 때에는 손해배상을 하지 않습니다.<br>
    <br>
    제16조 면책<br>
    <br>
    ① 운영자는 회원이 사이트의 서비스 제공으로부터 기대되는 이익을 얻지 못하였거나 서비스 자료에 대한 취사선택 또는 이용으로 발생하는 손해 등에 대해서는 책임이 면제됩니다.<br>
    ② 운영자는 본 사이트의 서비스 기반 및 타 통신업자가 제공하는 전기통신 서비스의 장애로 인한 경우에는 책임이 면제되며 본 사이트의 서비스 기반과 관련되어 발생한 손해에 대해서는 사이트의 이용약관에 준합니다<br>
    ③ 운영자는 회원이 저장, 게시 또는 전송한 자료와 관련하여 일체의 책임을 지지 않습니다.<br>
    ④ 운영자는 회원의 귀책 사유로 인하여 서비스 이용의 장애가 발생한 경우에는 책임지지 아니합니다.<br>
    ⑤ 운영자는 회원 상호 간 또는 회원과 제3자 상호 간, 기타 회원의 본 서비스 내외를 불문한 일체의 활동(데이터 전송, 기타 커뮤니티 활동 포함)에 대하여 책임을 지지 않습니다.<br>
    ⑥ 운영자는 회원이 게시 또는 전송한 자료 및 본 사이트로 회원이 제공받을 수 있는 모든 자료들의 진위, 신뢰도, 정확성 등 그 내용에 대해서는 책임지지 아니합니다.<br>
    ⑦ 운영자는 회원 상호 간 또는 회원과 제3자 상호 간에 서비스를 매개로 하여 물품거래 등을 한 경우에 그로부터 발생하는 일체의 손해에 대하여 책임지지 아니합니다.<br>
    ⑧ 운영자는 운영자의 귀책 사유 없이 회원간 또는 회원과 제3자간에 발생한 일체의 분쟁에 대하여 책임지지 아니합니다.<br>
    ⑨ 운영자는 서버 등 설비의 관리, 점검, 보수, 교체 과정 또는 소프트웨어의 운용 과정에서 고의 또는 고의에 준하는 중대한 과실 없이 발생할 수 있는 시스템의 장애, 제3자의 공격으로 인한 시스템의 장애, 국내외의 저명한 연구기관이나 보안 관련 업체에 의해 대응 방법이 개발되지 아니한 컴퓨터 바이러스 등의 유포나 기타 운영자가 통제할 수 없는 불가항력적 사유로 인한 회원의 손해에 대하여 책임지지 않습니다.<br>
    <br>
    부칙<br>
    <br>
    이 약관은 &lt;사이트 개설일&gt;부터 시행합니다.					</div>
                    </div>
                </div>
                <div class="input-block">
                    <div class="check">
                        <div class="checkbox checkbox-styled">
                            <label class="form-label">
                                <input type="checkbox" name="privacy_agree" value="ok" id="privacy_agree" class="_join_agree _privacy_agree ie require_agreement">
                                <span class="agree_tit">개인정보 수집 및 이용<em class="alert">(필수)</em></span>
                            </label>
                        </div>
                    </div>
                    <div class="input-block">
                        <div class="form-group privacy">
                            <div tabindex="0" class="" style="height: 100px; overflow-y: auto; background:#fff; color:#000;">
                                <strong>1. 개인정보 수집목적 및 이용목적</strong><br>
        <br>
        (1) 홈페이지 회원 가입 및 관리<br>
        회원 가입 의사 확인, 회원제 서비스 제공에 따른 본인 식별․인증, 회원자격 유지․관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정 이용 방지, 만 14세 미만 아동의 개인정보 처리시 법정대리인의 동의 여부 확인, 각종 고지․통지, 고충 처리 등의 목적<br>
        <br>
        (2) 재화 또는 서비스 제공<br>
        물품 배송, 서비스 제공, 계약서․청구서 발송, 콘텐츠 제공, 맞춤 서비스 제공, 본인인증, 연령인증, 요금 결제 및 정산, 채권추심 등의 목적<br>
        <br>
        (3) 고충 처리<br>
        민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락․통지, 처리 결과 통보 등<br>
        <br>
        <strong>2. 수집하는 개인정보 항목</strong><br>
        ID, 성명, 비밀번호, 주소, 휴대폰 번호, 이메일, 14세 미만 가입자의 경우 법정대리인 정보<br>
        <br>
        <strong>3. 개인정보 보유 및 이용기간</strong><br>
        <strong>회원탈퇴 시까지</strong> (단, 관계 법령에 보존 근거가 있는 경우 해당 기간 시까지 보유, 개인정보처리방침에서 확인 가능)					</div>
                        </div>
                    </div>
                </div>
                <div class="btn-block clearfix">
                    <a href="javascript:;" data-dismiss="modal" class="float_a" id="close">취소</a>
                                <a href="javascript:;" class="float_a" id="join_on">가입하기</a>
            </div>
            
          </div>
        </div>
        <div class="modal-con modal3">
            <a href="javascript:;" class="close">X</a>
            <p class="title"></p>
            <h1 class="M_header">회원가입</h1>
            <div class="con Mo_con">
                <form name="regFrm" method="post" action="memberProc.jsp" >
                    <input name="id" style="margin: 2.5% 0;" type="text" id="M_t" class="Mo_id" placeholder="아이디" >
					<input type="button" margin: 2.5% 0;" class="M_b same"   value="ID중복확인" onClick="idCheck(this.form.id.value)">			
                    <input name ="pwd" style="margin: 2.5% 0;" type="password" id="M_t" class="Mo_pw" placeholder="비밀번호">
                    <input name ="repwd" style="margin: 2.5% 0;" type="password" id="M_t" class="Mo_cpw" placeholder="비밀번호 확인">
                     <input name="phone" style="margin: 2.5% 0;" type="text" id="M_t" class="Mo_phone" placeholder="전화번호 - 빼고 입력해주세요">
                     <input type="button" margin: 2.5% 0;" class="M_b same"   value="전화번호중복확인" onClick="phoneCheck(this.form.phone.value)">
                    <input name="name" style="margin: 2.5% 0;" type="text" id="M_t" class="Mo_name" placeholder="이름">
                   
                    <input name="zipcode" style="margin: 2.5% 0;" class="M_t zipcode"  type="text" id="sample6_postcode" placeholder="우편번호">
                    <input style="margin: 2.5% 0;" class="M_b find_zip"  type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                    <input name="address" style="margin: 2.5% 0;" class="M_t"  type="text" id="sample6_address" placeholder="주소"><br>
                    <input name="addr_more" style="margin: 2.5% 0;" class="M_t"  type="text" id="sample6_detailAddress" placeholder="상세주소">
                    <input style="margin: 2.5% 0;" class="M_t"  type="text" id="sample6_extraAddress" placeholder="참고항목">
                    <input type="button" id="M_t" style="text-align: center;" onclick="inputCheck()" class="jbtn" value="회원가입">
                </form> 
            </div>
 
          </div>
          <div class="modal-con modal4 modal-con_1">
            <a href="javascript:;" class="close">X</a>
            <p class="title"></p>
            <h1 class="M_header">비회원 주문조회</h1>
            <div class="con">
              <input type="text" id="M_t" class="M_num" placeholder="주문번호">
              <input type="text" id="M_t" class="M_phone" placeholder="연락처">
              <button class="M_login_1">조회</button>
 
            </div>
          </div>
          <div class="modal-con modal5 modal-con_1">
            <a href="javascript:;" class="close">X</a>
            <p class="title"></p>
            <h1 class="M_header F_header">아이디 찾기</h1>
            <div class="con">
               <div class="find_wrap">
               
                   <button  class="find_btn active f_id">아아디 찾기</button>
                   <button  class="find_btn f_pw">비밀번호 찾기</button>

                </div> 
                <input type="text" class="enter_info" id="M_t" placeholder="아이디 또는 이메일">
                <button class="find_find">아이디찾기</button>
            </div>
          </div> 
          <div class="modal-con modal6 modal-con_2">
            <a href="javascript:;" class="close">X</a>
            <p class="title"></p>
            <h1 class="M_header">검색</h1>
            <div class="con">
              <input type="text" id="M_t" class="M_num1" placeholder="검색어를 입력해주세요">
              
              <button class="M_login_1 M_login_2">조회</button>
 
            </div>
          </div>

    </div>
    <div class="aside_wrap">
        <button class="X">X</button>
        <div class="aside_font">
            <h1 style="font-family: 'Gugi', cursive;position: relative; left: 33%; color: white;" >TesT Shop</h1>
            <ul style="text-align: center;font-family: 'Gugi', cursive; display: block;width: 120px;color: white;left: 29%;position: relative;">
                <li style="padding: 25%;"><a style="color: white;"  href="boardList.bo">Main</a></li>
                <li style="padding: 25%;"><a style="color: white;" href="dogList.dog">Shop</a></li>
                <li style="padding: 15%;"><a style="color: white;width:80px" href="freeboardList.fbo">질문게시판</a></li>
            </ul>
        </div>
        
    </div>
       <div class="fixed">
        <div class="header">
            <div class="header1">
                <!-- <button><img src="image/list.PNG"></button> -->
                <p>New Shop party</p>
            </div>
            <div class="header2">
                <h1>TesT Shop</h1>
                <p>tes hyeng</p>
            </div>
            <div class="header3">
            <a class="login  modal-open" href="loginon.jsp"><p>Login</p></a>
            <a class="join modal-open" href="javascript:openModal('modal3');" ><p>join</p></a>
            <a class="logout" style="display: none;" href="logout.jsp"><p>Logout</p></a>
            <a class="mypage" style="display: none;" href="userboardList.ubo"><p>mypage</p></a>
            <a class="back" href="dogCartList.dog"><img src="image/back.PNG"></a>
           

        </div>
        </div> 
        <div class="menu">
            <div class="btnbox">
                <button class="open_wrap"><img src="image/list.PNG"></button>
            </div>
            <div class="listbox">
                <ul>
                    <li><a href="boardList.bo">About</a></li>
                    <li><a href="dogList.dog">Shop</a></li>
                    <li><a href="reginfo.jsp">My page</a></li>
                    
                </ul>
                <div class="under_wrap" class="hide">
                    <div class="min_main">
                   <ul >
                    	<li><a href="boardList.bo"><strong>공지사항</strong></a></li>
                        <li><a href="clien_FQA.jsp">FQA</a></li>
                        <li><a href="freeboardList.fbo">질문 게시판</a></li>
	                    <li> <a href="client_map.jsp">매장위치</a></li>
                    </ul>
                    </div>
                    <div class="min_shop">
                        <a href="dogList.dog"><strong>Shop</strong></a>
                        <ul>
                            <li><a href="dogList.dog">ALL</a></li>
                            <li><a href="dogList1.dog">Food</a></li>
                            <li><a href="dogList2.dog">Knife</a></li>
                            <li><a href="dogList3.dog">Plate</a></li>
                            <li><a href="dogList4.dog">ETC</a></li>
                        </ul>
                    </div>
                   <div class="min_FAQ">
                        <a class="mgr_strong" href="clien_FQA.jsp"><strong>고객센터</strong></a>
                        <ul>
                            
                            
                            <li><a class="mgr_info" href="regUpdate.jsp">회원정보 변경</a></li>
                            <li><a class="mgr_list" href="reginfo.jsp">회원정보 조회</a></li>
                            <li><a class="mgr_buy" href="byebye.jsp">회원탈퇴</a></li>
                            <li><a class="mgr_none" href="userboardList.ubo">mypage</a></li>
                        </ul>
                    </div>
                </div>
            </div> 
            
            
        </div>
    </div>
        <div class="contents"  style="padding-top: 70px;">
            <div class="menu_nav">
                <P class="nav_p" style="height: 53px;"><strong>고객센터 ></strong>
                   <a class="faq" href="clien_FQA.jsp">FAQ</a>
                
                <a class="find" href="client_map.jsp">매장찾기</a>
                </P>
            </div>
        </div>
        <div id="contents">

            <h1><img src="https://www.sidiz.com/img/tl1/tl1_faq.jpg" alt="FAQ"></h1>
        
            <!-- 검색 -->
        
            <form id="frm1" action="/customer/faq/search" method="post">
            
            <div class="pabs inputfix" style="right:0;top:45px;">
<!--                 
                <input type="text" name="query" value="" onfocus="this.value=''" onkeypress="onSearch(event)" class="w150" style="background:url('/img/customer/btn_search_s.jpg') no-repeat 135px center;"> -->
            </div>
            
            </form>
            
            <!-- 버튼 -->
            
            <div id="tab" class="pabs" style="margin-left: 16%; margin-bottom: -7%;">
            
                <a href="clien_FQA.jsp"  >전체</a>
                <a href="clien_FQA_1.jsp" style="background-color:#F04130;">제품문의</a>
                <a href="clien_FQA_2.jsp">주문/배송</a>    
                <a href="clien_FQA_3.jsp">교환/반품</a>
                <a href="clien_FQA_4.jsp">결제</a>
                <a href="clien_FQA_5.jsp">회원가입/탈퇴</a>    
                <a href="clien_FQA_6.jsp">A/S</a>
                <a href="clien_FQA_7.jsp">기타</a>
        
        
            </div>
            <hr>
            <div class="bar"><p></p></div>
            <h2><img style="margin-left:38%;" src="https://www.sidiz.com/img/tl2/tl2_faq_A01001.jpg" alt=""></h2>
            
            <table id="faqtbl">
                <tbody><tr id="qst_2" class="qst">
                    <td class="question1" onclick="show('2')">
                        <span style="margin:0 10px; color:#fff;">▶</span>의자 등,좌판이 더러워졌어요. 어떻게 세탁해야 하나요?</td>
                </tr>
                <tr id="ans1_2" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('2')">
                        <span style="margin:0 10px; color:red;">▼</span>의자 등,좌판이 더러워졌어요. 어떻게 세탁해야 하나요?</td>
                </tr>
                <tr id="ans2_2" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>시디즈 의자는 대부분 오염방지 가공이된 천 소재로 되어&nbsp;쉽게 오염이 되지 않지만,</p><p>실수로 인하여 오염이 되었을 경우에는 가급적 전문 세탁업체에 의뢰하시는 것이 좋습니다.</p><p>&nbsp;</p><p>T80, T55, T50, T30과&nbsp;같이 의자 좌판이 탈부착 되는 제품의 경우,</p><p>커버를 벗겨 낸 후&nbsp;<span style="font-size: 10pt;">부득이한 경우에만&nbsp;</span><span style="font-size: 10pt;">세탁하시고,</span></p><p><span style="font-size: 10pt;">A/S를 통해 등, 좌판을 교체하시는 것이 바람직합니다.</span></p><p>&nbsp;</p><p>일부 품목(링고 커버, 2단 발받침대&nbsp; 패딩커버)의 경우 40℃의 물에서 세탁 가능합니다.&nbsp;</p><p><br></p><p><span style="font-size: 10pt;"><br></span></p><p><span style="font-size: 10pt;">※ T50과 링고의 교체좌판은 시디즈 쇼핑몰의 액세서리 카테고리에서 구매하실 수 있습니다.</span><br></p><p><span >※
            T60</span><span style="font-size: 10pt; color: rgb(140, 140, 140);">시리즈의 </span><span style="font-size: 10pt; color: rgb(140, 140, 140);"> 제품은 소재 특성상 전문 업체를 통한 세탁이 어렵습니다</span><span style="font-size: 10pt; color: rgb(140, 140, 140); ">.</span><br></p><p>&nbsp;</p><p style="text-align: left; margin-top: 0pt; margin-bottom: 0pt; unicode-bidi: embed; direction: ltr; ">&nbsp;</p><p>&nbsp;</p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_41" class="qst">
                    <td class="question1" onclick="show('41')">
                        <span style="margin:0 10px; color:#fff;">▶</span>좌판교체가 가능한 제품에는 어떤것들이 있나요?</td>
                </tr>
                <tr id="ans1_41" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('41')">
                        <span style="margin:0 10px; color:red;">▼</span>좌판교체가 가능한 제품에는 어떤것들이 있나요?</td>
                </tr>
                <tr id="ans2_41" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>&nbsp;</p><p>&nbsp;</p><p><span style="font-size: 10pt;">좌판 교체가 가능한 제품 목록은 다음과 같습니다.</span><span style="font-size: 10pt;"><strong></strong></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">T80</span></strong></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><span><span style="color: rgb(255, 0, 0);"><span style="color: rgb(0, 85, 255);"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0);"><a class="tx-link" href="http://www.sidiz.com/product/T800HLDAS_LEATHER/L096" target="_top"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800HLDAS 천연가죽</span></u></a></span></span></span></span></span></span></p><p><span style="font-size: 12pt;"><span><span style="color: rgb(9, 0, 255);"><a></a><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDAS_A-LEATHER/A095A" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800HLDAS </span></a></u></span></span></span></span><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDAS_A-LEATHER/A095A" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">인조가죽</span></a></u></span></p><p><span style="font-size: 12pt;"><span><span style="color: rgb(9, 0, 255);"><a></a><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDA_FABRIC/451" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800HLDA </span></a></u></span></span></span></span><span style="color: rgb(51, 51, 51); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDA_FABRIC/451" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">패브릭</span></a></u></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(0, 85, 255);"><span><a class="tx-link" href="http://www.sidiz.com/product/T800HLDA_MESH/detail/rep" target="_top"></a><font color="#0066cc"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDA_MESH/484" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800HLDA </span></a></u></span></span></font></span></span></span><span style="color: rgb(51, 51, 51); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800HLDA_MESH/484" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">메쉬</span></a></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(0, 85, 255);"><span style="color: rgb(9, 0, 255);"><a></a><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800LDA_FABRIC/371" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800LDA </span></a></u></span></span></span></span><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="color: rgb(51, 51, 51);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800LDA_FABRIC/371" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">패브릭</span></a></u></span></span></span></p><p><span style="font-size: 12pt;"><span><span style="color: rgb(9, 0, 255);"><a></a><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800LDA_MESH/481" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T800LDA </span></a></u></span></span></span></span><span style="color: rgb(51, 51, 51); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T800LDA_MESH/481" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">메쉬</span></a></u></span></span></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">T55</span></strong></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(0, 85, 255);"><span style="color: rgb(9, 0, 255);"><u></u></span></span></span><span style="font-size: 10pt;">&nbsp;</span></p><p><span style="font-size: 12pt;"><span style="color: rgb(51, 51, 51); font-size: 11pt;"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="font-size: 11pt;"><font color="#333333" size="2"><span style="font-size: 11pt;"><u><span style="color: rgb(0, 0, 0);"><a class="tx-link" href="http://www.sidiz.com/product/T550HLDAS/L096" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T550HLDAS 천연가죽</span></a></span></u></span></font></span></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(51, 51, 51); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T550HLDA/733" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T550HLDA</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(51, 51, 51); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T550HLDA-DR/743" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T550HLDA 더블라셀</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(51, 51, 51); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/TN550HLDA/576" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T550HLDA 블랙에디션</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 12pt;"><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 12pt;"><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/T550LDA/734" target="_top"><span style="color: rgb(51, 51, 51); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T550LDA</span></u></span></a></span></span></span></span></span></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 12pt;"><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 12pt;"><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0);"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T550LDA-DR/744" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500LDA</span></a></span></u></span></span></span></span><span><span style="color: rgb(0, 0, 0);"><span style="color: rgb(0, 0, 0);"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T550LDA-DR/744" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;"> </span></a></span></u></span></span><span style="color: rgb(0, 0, 0); font-size: 11pt;"><span style="color: rgb(0, 0, 0);"><span style="color: rgb(0, 0, 0);"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T550LDA-DR/744" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">더블라셀</span></a></span></u></span></span></span></span></span></span></span></span></span></span></span></p><p><span style="font-size: 12pt;"><strong></strong></span><span style="color: rgb(51, 51, 51);">&nbsp;</span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">T50</span></strong></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><u></u></span></span>&nbsp;</p><p><span style="font-size: 11pt;"><u><a class="tx-link" href="http://www.sidiz.com/product/T500HDAS/571" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500HLDAS 천연가죽</span></a></u></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T500HDAS/571" target="_top"><span style="color: rgb(0, 0, 0);"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T5</span><span style="color: rgb(0, 0, 0); font-size: 10pt;">0</span></span></a><a class="tx-link" href="http://www.sidiz.com/product/T500HDAS/571" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">0HDAS 더블라셀</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/TN500HLDA/758" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T50</span></a><a class="tx-link" href="http://www.sidiz.com/product/TN500HLDA/758" target="_blank"></a><a class="tx-link" href="http://www.sidiz.com/product/TN500HLDA/758" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">0HLDA 화이트쉘</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T500HLDA/553B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500HLDA</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/TN500HDA/754" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500HDA 화이트쉘</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/TN500LDA/758" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500LDA 화이트쉘</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T500LDA/554B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500LDA</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T500HDA/556B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500HDA</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 11pt;"><a class="tx-link" href="http://www.sidiz.com/product/T500DA/557B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 10pt;">T500DA</span></a></span></u></span></span></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">T30</span></strong></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN300HLDA/837B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T300HLDA</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN300HDA/834" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T300HDA</span></u></span></a></span><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;"> </span></u></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN300LDA/831" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T300LDA</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN300DA/837B" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T300DA</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN302HLA/834" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T302HLA</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/TN302HF/836" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">T302HF</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">RINGO</span></strong></span></p><p>&nbsp;</p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/S500AV/F573L" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">링고 회전형</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/S500ACF/F574L" target="_top"><span style="color: rgb(0, 0, 0); font-size: 11pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">링고 고정형</span></u></span></a></span></span></p><p><span style="font-size: 12pt;"><strong></strong></span>&nbsp;</p><p><span style="font-size: 12pt;"><strong></strong></span><span style="font-size: 11pt;">&nbsp;</span></p><p><span style="font-size: 12pt;"><strong><span style="font-size: 11pt;">PILLO</span></strong></span></p><p>&nbsp;</p><p><span style="font-size: 12pt;"><span style="color: rgb(9, 0, 255);"><a class="tx-link" href="http://www.sidiz.com/product/M090/838" target="_top"><span style="color: rgb(0, 0, 0); font-size: 12pt;"><u><span style="color: rgb(0, 0, 0); font-size: 10pt;">M090</span></u></span></a></span></span></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p><span style="font-size: 12pt;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">※ 좌판교체가 가능한 모든 제품 보기</span><span style="font-size: 10pt;"> </span><span style="color: rgb(255, 0, 0);"><u><a class="tx-link" href="http://www.sidiz.com/product/smart?price1=N&amp;price2=N&amp;price3=N&amp;price4=N&amp;price5=N&amp;usage1=N&amp;usage2=N&amp;usage3=N&amp;usage4=N&amp;usage5=N&amp;back1=N&amp;back2=N&amp;back3=N&amp;back4=N&amp;back5=N&amp;back6=N&amp;seat1=N&amp;seat2=N&amp;seat3=N&amp;seat4=N&amp;seat5=N&amp;seat6=N&amp;age1=N&amp;age2=N&amp;age3=N&amp;age4=N&amp;age5=N&amp;func1=N&amp;func2=N&amp;func3=N&amp;func4=N&amp;func5=N&amp;func6=Y&amp;hour1=N&amp;hour2=N&amp;hour3=N&amp;hour4=N&amp;hour5=N&amp;color1=N&amp;color2=N&amp;color3=N&amp;color4=N&amp;color5=N&amp;color6=N&amp;color7=N&amp;color8=N&amp;color9=N&amp;color10=N&amp;order=" target="_top"><span style="color: rgb(255, 0, 0); font-size: 10pt;">바로가기</span></a></u></span></span></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_42" class="qst">
                    <td class="question1" onclick="show('42')">
                        <span style="margin:0 10px; color:#fff;">▶</span>천연가죽에 결함이 있는 것 같아요.</td>
                </tr>
                <tr id="ans1_42" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('42')">
                        <span style="margin:0 10px; color:red;">▼</span>천연가죽에 결함이 있는 것 같아요.</td>
                </tr>
                <tr id="ans2_42" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>&nbsp;</p><p>&nbsp;<span style="color: rgb(140, 140, 140);">◆<strong> <span style="font-size: 10pt;">천연가죽의 특징</span></strong></span></p><p>&nbsp;</p><p><span style="font-size: 12pt;"><span style="color: rgb(255, 0, 0);"><span style="color: rgb(255, 0, 0); font-size: 11pt;"><span style="font-size: 12pt;"><span style="color: rgb(255, 0, 0);"><span style="color: rgb(255, 0, 0); font-size: 11pt;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">시디즈 가죽은 코팅의 두께가 얇아 이러한 자국을 많이 보실 수 있는데, 이것은 결함이 아니라 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">가죽 원피의 </span></span></span></span></span></span></span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">천연적인 자연미를 살리자는 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">시디즈의 의도입니다. </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">천연가죽은 원피상태에서 벌레물린 자국, 혈관자국 등 </span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">독특한 자국을 가지고 있습니다.</span><span style="color: rgb(140, 140, 140); font-size: 10pt;">이러한 자국들은 그 가축이 오랜 세월 동안 살아온 과정을 보여주며, </span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">이 자국으로 인하여 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">가죽의 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">내구성이 떨어진다거나 잘 찢어지는 등 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">결점을 보이지는 않습니다.</span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">또한, 이러한 자국들이 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">인조가죽 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">혹은 기타 모조품이 아니라는 증거라고 할 수 있습니다. </span></p><p style="line-height: 1;"></p><p style="line-height: 1.2;">&nbsp;</p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140);">◆ <strong><span style="color: rgb(140, 140, 140); font-size: 10pt;">시디즈의 천연가죽</span></strong></span></p><p style="line-height: 1.2;">&nbsp;</p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">시디즈는 전통적인 방법으로 100년 넘게 방목을 해온 목장이자 세계수준으로 성장한 회사의 </span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">원피를 사용하며, 원피의 특성을 가장 잘 나타낼 수 있는 가공방법으로 가공된 가죽을 사용합니다. </span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">또한 오염으로부터 보호 받을 수 있는 코팅 가공을 하며 이로인해 가죽 표면이 매우 부드러우며 </span></p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">매끄럽고 </span><span style="color: rgb(140, 140, 140); font-size: 10pt;">내구성이 뛰어나 관리하기에 편리합니다. </span></p><p style="line-height: 1;"></p><p style="line-height: 1.2;">&nbsp;</p><p style="line-height: 1.2;"><span style="color: rgb(140, 140, 140);">◆ <strong><span style="color: rgb(140, 140, 140); font-size: 10pt;">천연가죽 관리법</span></strong></span></p><p style="line-height: 1.2;">&nbsp;</p><p style="line-height: 1.2;"><span style="font-size: 11pt;"><font color="#333333" size="2"><span style="color: rgb(140, 140, 140); font-size: 10pt;">일상적인 먼지는 마른 걸레로 닦아 주시고, 물이 닿을 시 즉시 닦아주세요. </span></font></span></p><p style="line-height: 1.2;"><span style="font-size: 11pt;"><font color="#333333" size="2"><span style="color: rgb(140, 140, 140); font-size: 10pt;">열로부터 가죽을 보호하고 부드러운 터치감을 위해 적절한 습도를 유지하세요. </span></font></span></p><p>&nbsp;</p><p><span style="font-size: 11pt;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">◆ <strong><span style="font-size: 10pt;">천연가죽 관리시 주의사항</span></strong></span></span></p><p>&nbsp;</p><p><span style="font-size: 11pt;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">※ 얼룩 제거제, 솔벤트, 비누, 신발이나 마루 광택제 등 전용 가죽 클리너 이외 다른 제품을 사용하지 마세요. </span></span></p><p><span style="font-size: 11pt;"><span style="color: rgb(140, 140, 140); font-size: 10pt;">잦은 세척은 표면의 코팅을 제거하며, 자국 수명을 단축시킬 수 있습니다.</span></span><br></p><p>&nbsp;</p><p>&nbsp;</p><p><span style="font-size: 10pt;"></span>&nbsp;</p><p><span style="font-size: 10pt;">&gt;</span><span style="font-size: 10pt;">&nbsp;천연가죽의 특징 및 관리법 자세히보기&nbsp;</span><span style="color: rgb(255, 0, 0); font-size: 10pt;"> </span><span style="color: rgb(255, 0, 0);"><u><a class="tx-link" href="http://www.sidiz.com/product/E500FP_BLACK/detail/leather-features" target="_top"><span style="color: rgb(255, 0, 0); font-size: 10pt;">바로가기</span></a></u></span></p><p>&nbsp;</p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_1" class="qst">
                    <td class="question1" onclick="show('1')">
                        <span style="margin:0 10px; color:#fff;">▶</span>바퀴 달린 의자를 사용하고 있는데 의자를 고정 시킬 수는 없나요?</td>
                </tr>
                <tr id="ans1_1" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('1')">
                        <span style="margin:0 10px; color:red;">▼</span>바퀴 달린 의자를 사용하고 있는데 의자를 고정 시킬 수는 없나요?</td>
                </tr>
                <tr id="ans2_1" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>바퀴가 달린 의자를 구입하셨다고 해도 '의자 고정용 번즈'를 구입하시면, 고정의자로 사용할 수 있습니다. <br></p>
            <p><br></p>
            <p>※ 제품코드 : S209G, T509G / 제품 사양별로 적용되는 번즈가 다르니 주의하세요! </p>
            <p><br></p>
            <p>교체방법은 제품의 원래 바퀴를 빼고, 의자 번즈를 끼워넣기만 하면 되니 어렵지 않게 하실 수 있습니다. <br>빼낸 바퀴는 보관하고 계시다가 추후에 바퀴가 필요하실 때 다시 교체하여 사용하시면 됩니다. </p>
            <p><br></p>
            <p>참고로 ‘싯브레이크 캐스터’(제품코드 : S209V)를 구매하셔서 교체하시면 앉았을 때는 바퀴가 고정되고, <br>다시 일어나서 의자를 이동시키시고자 할 때는 굴러가게 됩니다. <br></p>
            <p><br></p>
            <p>※ 단, 체중이 25KG 이하일 때는 브레이크가 작동되지 않습니다.</p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_3" class="qst">
                    <td class="question1" onclick="show('3')">
                        <span style="margin:0 10px; color:#fff;">▶</span>제품 사용기한은 얼마나 되나요?</td>
                </tr>
                <tr id="ans1_3" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('3')">
                        <span style="margin:0 10px; color:red;">▼</span>제품 사용기한은 얼마나 되나요?</td>
                </tr>
                <tr id="ans2_3" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>제품의 수명은 사용하시는 분의 사용조건에 따라 차이가 발생합니다.  <br>과도한 힘을 주어 사용하시다 보면 제품에 문제가 생길 수 있습니다. <br><br>의자의 경우, 핵심 시스템인 틸트(Tilt)의 실험은 30만회 반복시험을 실시하고 있습니다.  <br>하루 200회 정도 틸팅을 해도 4~5년 이상을 이상 없이 사용할 수 있다는 뜻입니다. <br><br>하지만 사용자가 앉아있는 자세를 기준으로 생각한 것이므로 의자를 무리하게 젖혀 사용한다거나 <br>의자를 이용해 장난을 하는 경우에는 의자의 수명이 줄어들 수 있습니다.<br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_4" class="qst">
                    <td class="question1" onclick="show('4')">
                        <span style="margin:0 10px; color:#fff;">▶</span>제품관련 문의는 어디로 하면 될까요?</td>
                </tr>
                <tr id="ans1_4" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('4')">
                        <span style="margin:0 10px; color:red;">▼</span>제품관련 문의는 어디로 하면 될까요?</td>
                </tr>
                <tr id="ans2_4" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>홈페이지에 글을 남겨 문의하시거나 고객센터(<span>1899-3176</span>)로 연락하시면 상담을 받으실 수 있습니다.  <br>※ 상담가능시간 / (Mon-Fri) 09:00~18:00 <br><br>다만, 본사에서는 제품을 구입하실 수 없기 때문에 제품문의와 구입까지 함께 고려하신다면  <br>홈페이지에 안내되어 있는 대리점으로 연락하시는 것을 권해드립니다.<br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_5" class="qst">
                    <td class="question1" onclick="show('5')">
                        <span style="margin:0 10px; color:#fff;">▶</span>시디즈 제품에는 어떤 조절기능이 있나요?</td>
                </tr>
                <tr id="ans1_5" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('5')">
                        <span style="margin:0 10px; color:red;">▼</span>시디즈 제품에는 어떤 조절기능이 있나요?</td>
                </tr>
                <tr id="ans2_5" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>☞ 제품 사양별로 제공 가능한 시디즈 의자의 대표적인 기능은 다음과 같습니다. <br><br>◇헤드레스트 조절 <br>긴 시간 동안 의자에 앉아 있어야 할 때 목과 머리를 편안한 상태로 지지할 수 있도록  <br>넥레스트의 높이와 각도를 조절하여 피로감을 줄일 수 있습니다. <br><br>◇암레스트 조절 <br>사용자의 체형에 따라 편안한 자세를 만들 수 있도록 높이를 조절할 수 있습니다.  <br>또한, 3단계의 회전 기능을 이용하여 팔의 각도를 자연스럽게 지지할 수 있습니다. <br><br>◇싱크로나이즈드 틸팅 <br>등판과 좌판이 각기 다른 각도로 동시에 움직이는 틸팅 기술로써,  <br>어떤 자세에서도 인체에 무리가 가지 않는 편안한 상태를 유지할 수 있습니다. <br><br>◇틸팅 강도 조절 <br>체중에 상관없이 사용자가 가장 안락한 상태를 느낄 수 있도록 틸팅의 강도를 조절할 수 있습니다.  <br>좌판 하부의 손잡이를 돌려 적절한 틸팅 강도를 사용자가 직접 설정할 수 있습니다. <br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_6" class="qst">
                    <td class="question1" onclick="show('6')">
                        <span style="margin:0 10px; color:#fff;">▶</span>어떤 의자가 좋은 의자인가요?</td>
                </tr>
                <tr id="ans1_6" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('6')">
                        <span style="margin:0 10px; color:red;">▼</span>어떤 의자가 좋은 의자인가요?</td>
                </tr>
                <tr id="ans2_6" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>좋은 의자란 의자의 존재를 인식하지 못한 채 오랫동안 앉아 있을 수 있는 의자입니다.  <br><br>사람은 각자에 따라 다양한 신체조건을 가지며, 앉아 있는 동안 다양한 자세를 취하게 되는데  <br>의자의 존재를 인식하지 못하려면 이러한 다양성이 완벽하게 수용되어야 합니다. <br><br>즉, 사람에 따라 각각 다른 신체조건에 맞도록 각종 조절이 가능한가,  <br>그리고 다양한 자세를 편안하게 수용할 수 있는가 하는 두 가지 측면을 점검해 보아야 하겠습니다.<br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_7" class="qst">
                    <td class="question1" onclick="show('7')">
                        <span style="margin:0 10px; color:#fff;">▶</span>어떤 자세로 앉아야 허리에 좋은 자세인가요?</td>
                </tr>
                <tr id="ans1_7" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('7')">
                        <span style="margin:0 10px; color:red;">▼</span>어떤 자세로 앉아야 허리에 좋은 자세인가요?</td>
                </tr>
                <tr id="ans2_7" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>☞ 척추가 S자 형태를 유지하고 체중이 요추부에 집중되지 않도록 해야 허리 통증과 질환을 <br>예방할 수 있습니다. <br><br>◇ 뒤로 기대어 앉아주세요! <br>등판을 뒤로 젖힐수록 척추는 이상적인 S자형에 점차 가까워지고 요추 디스크에 실리던 체중도 <br>크게 줄어드는 일석이조의 효과가 있습니다.  <br>등판을 젖혀 기대고 일하시는 게 익숙하지 않으시더라도 이제 습관을 바꿔보십시오. <br><br>◇ 자세를 자주 바꿔주세요! <br>자주 움직여주시는 것이 무엇보다 중요합니다.  <br>사람이 움직일 때마다 스폰지 같은 조직으로 이루어진 디스크는 펌핑작용을 하여 영양분을 흡수하고  <br>노폐물을 방출합니다. <br>또한 디스크의 한 곳을 집중하여 누르던 체중도 허리를 움직일 때 분산됩니다.  <br>디스크가 건강해지도록 몸을 뒤로 젖히면서 움직여주십시오.  <br><br>◇ 요추를 확실하게 받쳐주세요! <br>허리 디스크는 대부분 3~5번 요추 사이에 있는 디스크에서 발생합니다.  <br>따라서 허리의 오목한 곳, 즉 요추를 등판에 밀착되게 받쳐주어, 디스크에 가해지는 압력을  <br>감소시키는 것이 중요합니다.  <br>의자의 등판이 요추와 밀착되어 있는지 확인하고, 만약 그렇지 않다면 쿠션을 활용해서라도  <br>확실히 받쳐주십시오.  <br><br>◇ 엉덩이를 좌판 끝까지 밀어 앉으세요! <br>엉덩이를 좌판 끝까지 밀어 앉지 않으면, 등판이 요추에 완전히 밀착되지 않아 체중을 제대로  <br>받쳐줄 수 없습니다. <br>특히 뒤로 젖힐 때 엉덩이가 앞으로 미끄러지지 않도록 하시고, 항상 엉덩이를 좌판 끝까지 넣어 <br>허리가 등판에 완전히 밀착되게 해주십시오. <br><br>◇ 앞으로 숙여 앉을 때 좌판을 같이 앞으로 기울여주세요! <br>뒤로 기댈 수 없다면 숙일 대 좌판을 같이 앞으로 기울여주세요.  <br>앞으로 숙여 앉는 자세는 피해야 할 자세입니다.  <br>체중이 요추에 집중적으로 실리고, 척추가 앞으로 굽기 때문에 요추 디스크에 가해지는 압박이 <br>최대 3배까지 증대됩니다.  <br>하지만 서류 업무가 많은 사람들이나 학생들은 어쩔 수 없이 앞으로 숙여 앉게 됩니다.  <br>이런 경우라면 포워드 틸트 혹은 좌판 각도 조절 기능이 있는 의자를 사용하시는 것이 바람직합니다. <br><br>◇ 좌판의 높이를 키에 맞춥니다! <br>좌판의 높이가 너무 높아 발바닥이 지면에서 뜨게 되면 대퇴부 전반에 가해지는 압력이 증가해  <br>혈액순환에 장애가 생길 수 있습니다.  <br>그렇게 되면 장시간 앉을 경우 불편함을 느끼게 됩니다.  <br>또한 좌판의 높이가 너무 낮으면 좌판 전체에 체중을 골고루 분산시키지 못하게 됩니다. <br>따라서 좌판의 높이를 오금높이(발바닥에서 무릎 아래까지의 높이)에 맞춰 앉는 것이 중요합니다. <br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                <tr id="qst_8" class="qst">
                    <td class="question1" onclick="show('8')">
                        <span style="margin:0 10px; color:#fff;">▶</span>틸팅이 뭔가요?</td>
                </tr>
                <tr id="ans1_8" style="display:none;" class="ans1">	
                    <td class="question2" onclick="show('8')">
                        <span style="margin:0 10px; color:red;">▼</span>틸팅이 뭔가요?</td>
                </tr>
                <tr id="ans2_8" style="display:none;" class="ans2">		
                    <td style="padding:10px 35px;">
                    <p>인간은 앉아 있는 동안 자세를 평균적으로 1시간에 53번이나 바꾼다고 합니다.  <br>자연적으로 인간의 몸은 걷고 뛰는 수렵과 채집에 적합하게 되어 있기 때문입니다.  <br><br>하지만 컴퓨터를 사용하는 업무가 늘어날수록 인간은 일하는 시간을 주로 앉아있기만 합니다.  <br>게다가 의자가 다양한 자세를 수용하지 못한다면 근로자의 허리 통증이 심해져 장기결근을  <br>유발하기도 합니다.  <br><br>이 때, 근로자의 허리 통증을 완화하기 위해 사무용 의자에 틸트가 개발되었습니다. <br>틸트는 주로 사람이 의자에 앉아 등판에 기댈 때 젖혀지고 일어나기 쉽게 반동을 주어  <br>다시 등판을 세워주는 역할을 합니다.  <br>특히 척추에 큰 영향을 미치는 만큼 사용자의 작업 유형을 고려하고 사용자가 유연하게 작업 자세를  <br>변경할 수 있어야 하며, 사용자의 신체 치수와 만족도에 최대한 맞게 조절 가능하도록 고려되어야 합니다.  <br><br>그래서 시디즈에서는 그레이드별 틸트를 자체개발하여 보유하고 있으며,  <br>다양한 기능의 틸트를 제품 사양별로 맞추어 적용하고 있습니다.<br></p></td>
                </tr>
                <tr><td class="h5"></td></tr>	
                </tbody></table>
        
            <p class="h100"></p>
                
        </div>
        
        
    </div>
    <div>
        <footer>
            <p><strong>Site Name</strong></p>
            <p>Company: STORE | CEO: Oh</p>
            <p>Business License: 000-00-000000 | Communication Sales Business Report: 0000-yeonhei-0000</p>
            <p>Addr: Incheon, Korea</p>
            <p>CS : +82 (0)0-000-0000(AM.10 - PM.5, Lunch PM.1 - PM.2, Weekend and Red-day Off)</p>
            <p>Hosting by I'MWEB</p>
            <p>이용약관 <strong>개인정보처리방침</strong></p>
        </footer>
    </div>
    
</body>
<script>
$(".my_power").css('display','none');
$(".mypage p").attr('class','My');
$(".back").click(function(){
	<%
	
	if (session.getAttribute("id") == null){%>
		
		alert("로그인해주세요");
		
		return false;
	<%}
	%>
	
})
<%

String userID = null;
	String a = (String)session.getAttribute("id");
	System.out.println("e"+ a);
  if (session.getAttribute("id") != null) {
  	userID = (String) session.getAttribute("id");
  	
  	System.out.println("e"+ a);
	PrintWriter script = response.getWriter();
	script.println("<script>");
	
	script.println("</script>");
  	
  }
%>
<%

if (session.getAttribute("id") != null) {
	if (session.getAttribute("id").equals("admin")) {
		
%>		$(".My").text("MGR");
		$('.mgr_strong').text("관리 페이지");
		$(".mypage").attr('href','boardList.mo');
		$(".mgr_info").text("1:1문의 관리");
		$(".mgr_list").text("회원 리스트");
		$(".mgr_buy").text("회원 구매 리스트");
		$(".mgr_info").attr('href','boardList.mo');
		$(".mgr_list").attr('href','boardInfoList.mo');
		$(".mgr_buy").attr('href','dogOrderInfo.dog');
		$(".mgr_none").css('display','none');
	<%}else{%>
			$(".My").text("mypage");
			$(".mypage").attr('href','userboardList.ubo');
			$(".mgr_info").text("회원정보 변경");
			$(".mgr_list").text("회원정보 조회");
			$(".mgr_buy").text("회원 탈퇴");
			$(".mgr_info").attr('href','regUpdate.jsp');
			$(".mgr_list").attr('href','reginfo.jsp');
			$(".mgr_buy").attr('href','byebye.jsp');
			$(".mgr_none").css('display','');
		<%}%>
	$(".join").css('display','none');
	$(".login").css('display','none');
	$(".logout").css('display','block');
	$(".mypage").css('display','block');
	
  <%} else{%>
  $(".join").css('display','block');
	$(".login").css('display','block');
	$(".logout").css('display','none');
	$(".mypage").css('display','none');
  
  <%}%>

		<%
		
		
	    
	    %>
	   

		$(document).ready(function(){
			 $(".logout").click(function(){
		    	
		    	alert("로그아웃되었습니다");
		    	
		    	
		    	$(".join").css('display','block');
		    	$(".login").css('display','block');
		    	$(".logout").css('display','none');
		    	$(".mypage").css('display','none');
		    	 location.reload();
		    })
		});
</script>
</html>