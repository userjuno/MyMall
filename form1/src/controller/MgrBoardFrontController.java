package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mgraction.Action;
import mgraction.BoardDeleteProAction;
import mgraction.BoardDetailAction;
import mgraction.BoardListAction;
import mgraction.BoardRegAction;
import mgraction.BoardReplyFormAction;
import mgraction.BoardReplyProAction;
import mgraction.BoardUpdateFormAction;
import mgraction.BoardUpdateProAction;
import mgraction.BoardWriteProAction;
import mgrvo.ActionForward;


@WebServlet("*.mo")
public class MgrBoardFrontController extends HttpServlet {
   
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String RequestURI=request.getRequestURI();
      String contextPath=request.getContextPath();
      String command=RequestURI.substring(contextPath.length());
      ActionForward forward=null;
      Action action=null;
      
      if(command.equals("/boardList.mo")){
            action = new BoardListAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
      }
      else if(command.equals("/boardWriteForm.mo")){
          forward=new ActionForward();
          forward.setPath("/mgr_board/qna_board_write.jsp");
       }
      else if(command.equals("/boardInfoList.mo")){
    	  action  = new BoardRegAction();
          try {
             forward=action.execute(request, response );
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardWritePro.mo")){
          action  = new BoardWriteProAction();
          try {
             forward=action.execute(request, response );
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardDetail.mo")){
          action = new BoardDetailAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardReplyForm.mo")){
          action = new BoardReplyFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardReplyPro.mo")){
          action = new BoardReplyProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardUpdateForm.mo")){
          action = new BoardUpdateFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardUpdatePro.mo")){
          action = new BoardUpdateProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardDeletePro.mo")){
          action = new BoardDeleteProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardDeleteForm.mo")){
          String nowPage = request.getParameter("page");
          request.setAttribute("page", nowPage);
          int board_num=Integer.parseInt(request.getParameter("board_num"));
          request.setAttribute("board_num",board_num);
          forward=new ActionForward();
          forward.setPath("/mgr_board/qna_board_delete.jsp");
       }
     
      if(forward != null){
         
         if(forward.isRedirect()){
            response.sendRedirect(forward.getPath());
         }else{
            RequestDispatcher dispatcher=
                  request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
         }
         
      }
      
      
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }

}