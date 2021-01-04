package commaction;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import commsvc.BoardWriteProService;
import uvo.ActionForward;
import uvo.BoardBean;

public class BoardWriteProAction implements Action {

   
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  request.setCharacterEncoding("UTF-8");
      ActionForward forward=null;
      BoardBean boardBean = null;
      int fileSize=5*1024*1024;
      ServletContext context = request.getServletContext();

      String page = (String)request.getParameter("page");
      String boardnum = (String)request.getParameter("board_num");
      boardBean = new BoardBean();
      boardBean.setBoard_pnum(Integer.parseInt(request.getParameter("BOARD_PNUM")));
      boardBean.setBOARD_NAME(request.getParameter("BOARD_NAME"));
      boardBean.setBOARD_PASS(request.getParameter("BOARD_PASS"));
      boardBean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
      BoardWriteProService boardWriteProService = new BoardWriteProService();
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      boolean isWriteSuccess = boardWriteProService.registArticle(boardBean,id);
      System.out.println("네임 :" +id);
      System.out.println("제목 :" +request.getParameter("BOARD_SUBJECT"));
      System.out.println("내용 :" +request.getParameter("BOARD_PNUM"));
      if(!isWriteSuccess){
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         out.println("<script>");
         out.println("alert('등록실패')");
         out.println("history.back();");
         out.println("</script>");
      }
      else{
         forward = new ActionForward();
         forward.setRedirect(true);
         forward.setPath("freeboardDetail.fbo?board_num="+boardnum+ "&page="+page);
      }

      return forward;
      
   }     
}