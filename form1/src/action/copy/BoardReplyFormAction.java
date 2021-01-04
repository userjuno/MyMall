package action.copy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usvc.BoardDetailService;
import uvo.ActionForward;
import uvo.BoardBean;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
        String nowPage = request.getParameter("page");
        int board_num=Integer.parseInt(request.getParameter("board_num"));
        BoardDetailService boardDetailService = new BoardDetailService();
        BoardBean article=boardDetailService.getArticle(board_num);   
        request.setAttribute("article", article);
        request.setAttribute("page", nowPage);
        forward.setPath("/user_board/qna_board_reply.jsp");
        return forward;
        
	}

}
