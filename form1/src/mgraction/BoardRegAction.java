package mgraction;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mgrsvc.BoardListService;
import mgrsvc.BoardRegService;
import mgrvo.ActionForward;
import mgrvo.UserBean;
import mgrvo.PageInfo;

 public class BoardRegAction implements Action {
    
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
       
      ArrayList<UserBean> articleList=new ArrayList<UserBean>();
        int page=1;
      int limit=10;
      
      
      BoardRegService boardListService = new BoardRegService();
    
      articleList = boardListService.getArticleList(); //리스트를 받아옴.
      //총 페이지 수.
     
      request.setAttribute("articleList", articleList);
      ActionForward forward= new ActionForward();
         forward.setPath("/mgr_board/dogOrderInfo.jsp");
         return forward;
         
    }
    
 }