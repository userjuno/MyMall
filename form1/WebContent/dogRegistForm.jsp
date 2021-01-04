<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<jsp:useBean id="user" class="Bean.MemberBean" scope="page" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="pwd" />
<!DOCTYPE html>
<html>
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
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script type="text/javascript" src="js/modal.js" charset='utf-8'></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="script.js" charset='utf-8'></script>
<title>Insert title here</title>
<style type="text/css">
   #registForm{
      width: 1200px;
      height: 900px;
      border : 1px solid black; 
      margin:auto; 
   }   
   h2{
      text-align: center;
   }
   table{
      margin:auto;
      width: 1000px;
      }
   .td_left{
      width: 100px;
      background:rgb(233,233,233);
   }
   tr{
    height:50px;
   	padding:15px;
   }
   .M_t{
   	width:400px;
   	height:10px;
   }
   .M_box{
    width:800px;
   	height:300px;
   }
   .td_right{
     
      background:skyblue;
   }
   #commandCell{
      text-align: center;
      
   }
</style>
</head>
<body onLoad="regFrm.id.focus()">
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
    <div class="contents" style="padding-top: 70px;">
       <section id = "registForm">
   <header>
      <h2>상품 정보 등록</h2>
   </header>
      <form action="dogRegist.dog" method="post" name = "writeForm" enctype="multipart/form-data">
      
   <table>
   <tr>
      <td colspan="2">
         <a href="dogList.dog">목록보기</a>
      </td>
    
   </tr>
   
   <tr>
      <td class = "td_left">
         <label for = "item_name">상품 이름 : </label>
      </td>
      <td class = "td_right">
         <input type = "text"  class = M_t name = "item_name" id ="item_name" required="required"/>
          <!-- <input type = "text" name = "itme_name" id ="kind" required="required"/> -->
      </td>
   </tr>
   
   <tr>
      <td class = "td_left">
         <label for = "category">카테고리 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" class = M_t name = "category" id ="category"/>
      </td>
   </tr>
   
   <tr>
      <td class = "td_left">
         <label for = "price">가격 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" class = M_t name = "price" id ="price"/>
      </td>
   </tr>
   <tr>
      <td class = "td_left">
         <label for = "made">원산지 : </label>
      </td>
      <td class = "td_right">
         <input type = "text" class = M_t name = "made" id ="made"/>
      </td>
   </tr>

   <tr>
      <td class = "td_left">
         <label for = "content">글내용 : </label>
      </td>
      <td class = "td_right">
         <textarea name="content" class = "M_t M_box" id="content" rows="13" cols="40" wrap="off"></textarea>
      </td>
   </tr>
   <tr>
      <td class = "td_left">
         <label for = "image">상품이미지 : </label>
      </td>
      <td class = "td_right">
         <input type = "file" class = M_t name = "image" id ="image"/>
      </td>
   </tr>
   <tr>
      <td colspan="2" id = "commandCell"> 
         <input type = "submit" value = "상품 등록"/>      
         <input type = "reset" value = "다시작성"/>      
         <input type = "button" value = "상품목록 보기" onClick="window.location.href='dogList.dog'"/>      
      </td>
   </tr>   
   </table>
   </form>
   
</section>
    </div>
    <footer>
        <p><strong>Site Name</strong></p>
        <p>Company: STORE | CEO: Oh</p>
        <p>Business License: 000-00-000000 | Communication Sales Business Report: 0000-yeonhei-0000</p>
        <p>Addr: Incheon, Korea</p>
        <p>CS : +82 (0)0-000-0000(AM.10 - PM.5, Lunch PM.1 - PM.2, Weekend and Red-day Off)</p>
        <p>Hosting by I'MWEB</p>
        <p>이용약관 <strong>개인정보처리방침</strong></p>
    </footer>
</body>
<script>
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
			var a = $("#content").val();
			console.log(a);
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