package freeaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freesvc.BoardReplyProService;
import freesvc.BoardupdateService;
import fvo.ActionForward;
import fvo.BoardBean;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		request.setCharacterEncoding("UTF-8");
        String nowPage = request.getParameter("page");
        BoardBean article = new BoardBean();        
        article.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
        article.setBOARD_NAME(request.getParameter("BOARD_NAME"));
        article.setBOARD_PASS(request.getParameter("BOARD_PASS"));
        article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
        article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
        article.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
        article.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
        article.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));            
        
        BoardupdateService boardupdateProService = new BoardupdateService();
        
        boolean isUpdateSuccess = boardupdateProService.updateArticle(article);
          if(isUpdateSuccess){
             forward = new ActionForward();
             forward.setRedirect(true);
             forward.setPath("freeboardList.fbo?page=" + nowPage);
          }
          else{
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
             out.println("<script>");
             out.println("alert('업데이트실패')");
             out.println("history.back()");
             out.println("</script>");
          }
          
          return forward;
	}

}
