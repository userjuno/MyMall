package freeaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freesvc.BoardDetailService;
import fvo.ActionForward;
import fvo.BoardBean;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		 int page =Integer.parseInt(request.getParameter("page"));
        int board_num=Integer.parseInt(request.getParameter("board_num"));
        BoardDetailService boardDetailService = new BoardDetailService();
        BoardBean article=boardDetailService.getArticle(board_num,page);   
        request.setAttribute("article", article);
        request.setAttribute("page", page);
        forward.setPath("/free_board/qna_board_update.jsp");
        return forward;
        
	}

}
