package action.copy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usvc.BoardReplyProService;
import usvc.BoardupdateService;
import uvo.ActionForward;
import uvo.BoardBean;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		request.setCharacterEncoding("UTF-8");
        String nowPage = request.getParameter("page");
        BoardBean article = new BoardBean();
        int q_num = Integer.parseInt(request.getParameter("q_name"));
        System.out.println(q_num);
        article.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
        article.setBOARD_NAME(request.getParameter("BOARD_NAME"));
        article.setBOARD_PASS(request.getParameter("BOARD_PASS"));
        article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
        article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
        article.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
        article.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
        article.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));   
        BoardReplyProService boardReplyProService = new BoardReplyProService();
        boolean isReplySuccess = boardReplyProService.replyArticle(article,q_num);
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        System.out.println("id 확인 "+ id);
        if(isReplySuccess){
           forward = new ActionForward();
           forward.setRedirect(true);
           if(id.equals("admin")) {
        	   forward.setPath("boardList.mo?page=" + nowPage);
           }
           else
           {
        	   forward.setPath("userboardList.ubo?page=" + nowPage);
           }
          
        }
        else{
           response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
           out.println("<script>");
           out.println("alert('답장실패')");
           out.println("history.back()");
           out.println("</script>");
        }
        
        return forward;
        
	}

}
