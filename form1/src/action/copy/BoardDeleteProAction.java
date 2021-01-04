package action.copy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usvc.BoardDeleteProService;
import uvo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		  HttpSession session = request.getSession();
	      String id = (String)session.getAttribute("id");
	      int board_num=Integer.parseInt(request.getParameter("board_num"));
	      String nowPage = request.getParameter("page");
	      System.out.println("아이디 : "+ id);
	      System.out.println("비밀번호 : "+request.getParameter("BOARD_PASS") );
	      BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
	      boolean isArticleWriter =boardDeleteProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"),id);
	      
	      
	        System.out.println("id 확인 "+ id);
	   
	      if(!isArticleWriter){
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out=response.getWriter();
	         out.println("<script>");
	         out.println("alert('삭제할 권한이 없습니다');");
	         out.println("history.back();");
	         out.println("</script>");
	         out.close();
	      }

	      else{
	         
	         boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);

	         if(!isDeleteSuccess){
	            response.setContentType("text/html;charset=UTF-8");
	            PrintWriter out=response.getWriter();
	            out.println("<script>");
	            out.println("alert('삭제실패');");
	            out.println("history.back();");
	            out.println("</script>");
	            out.close();
	         }
	         else{
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
	         
	      }


	      return forward;
	}

}
