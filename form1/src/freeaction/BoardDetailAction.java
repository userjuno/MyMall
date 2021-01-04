package freeaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO3;
import freesvc.BoardCommListService;
import freesvc.BoardDetailService;
import freesvc.BoardListService;
import fvo.ActionForward;
import fvo.BoardBean;
import fvo.PageInfo;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int board_num=Integer.parseInt(request.getParameter("board_num"));
	      int now_page =Integer.parseInt(request.getParameter("page"));
	   
	      BoardDetailService boardDetailService = new BoardDetailService();
	      
	      ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
	        int page=1;
	      int limit=10;
	      BoardCommListService BCLS = new BoardCommListService();
			
			  if(request.getParameter("page")!=null){
			  page=Integer.parseInt(request.getParameter("page")); }
			 
	      
			
			  
			  int  listCount=BCLS.getListCount();//총 리스트 수를 받아옴.
			 
	      articleList =BCLS.getArticleList(page, board_num); //리스트를 받아옴.
	      //총 페이지 수.
			
			  int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리.
		         //현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		         int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		         //현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		              int endPage = startPage+10-1;
			  if (endPage> maxPage) endPage= maxPage;
			  
			  PageInfo pageInfo = new PageInfo(); pageInfo.setEndPage(endPage);
			  pageInfo.setListCount(listCount);
			 
			
			  pageInfo.setMaxPage(maxPage); pageInfo.setPage(page);
			  pageInfo.setStartPage(startPage); request.setAttribute("pageInfo", pageInfo);
			 
	      request.setAttribute("articleList", articleList);
	      BoardBean article = boardDetailService.getArticle(board_num,now_page);
	      ActionForward forward = new ActionForward();
	      request.setAttribute("page", now_page);
	         request.setAttribute("article", article);
	         request.setAttribute("article", article);
	         forward.setPath("/free_board/qna_board_view.jsp");
	         return forward;
	}

}
