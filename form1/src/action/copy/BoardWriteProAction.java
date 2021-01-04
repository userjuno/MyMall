package action.copy;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import usvc.BoardWriteProService;
import uvo.ActionForward;
import uvo.BoardBean;

public class BoardWriteProAction implements Action {

   
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  request.setCharacterEncoding("UTF-8");
      ActionForward forward=null;
      BoardBean boardBean = null;
      String realFolder="";
      String saveFolder="/boardUpload";
      int fileSize=5*1024*1024;
      ServletContext context = request.getServletContext();
      realFolder=context.getRealPath(saveFolder);         
      MultipartRequest multi=new MultipartRequest(request,
            realFolder,
            fileSize,
            "UTF-8",
            new DefaultFileRenamePolicy());
      boardBean = new BoardBean();
      boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
      boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
      boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
      boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
      boardBean.setBOARD_FILE(
      multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
      BoardWriteProService boardWriteProService = new BoardWriteProService();
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      boolean isWriteSuccess = boardWriteProService.registArticle(boardBean,id);
      System.out.println("네임 :" +id);
      System.out.println("제목 :" +multi.getParameter("BOARD_SUBJECT"));
      System.out.println("내용 :" +multi.getParameter("BOARD_CONTENT"));
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
         forward.setPath("userboardList.ubo");
      }

      return forward;
      
   }     
}