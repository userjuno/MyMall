package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commaction.Action;
import commaction.BoardDeleteProAction;
import commaction.BoardDetailAction;
import commaction.BoardListAction;
import commaction.BoardReplyFormAction;
import commaction.BoardReplyProAction;
import commaction.BoardUpdateFormAction;
import commaction.BoardUpdateProAction;
import commaction.BoardWriteProAction;
import uvo.ActionForward;


@WebServlet("*.cbo")
public class CommBoardFrontController extends HttpServlet {
   
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String RequestURI=request.getRequestURI();
      String contextPath=request.getContextPath();
      String command=RequestURI.substring(contextPath.length());
      ActionForward forward=null;
      Action action=null;
      System.out.println("커맨드 :" +command);
      if(command.equals("/commboardList.cbo")){
            action = new BoardListAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
      }
      else if(command.equals("/boardWriteForm.cbo")){
          forward=new ActionForward();
          forward.setPath("/board/qna_board_write.jsp");
       }
      else if(command.equals("/commboardWritePro.cbo")){
          action  = new BoardWriteProAction();
          try {
             forward=action.execute(request, response );
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
      else if(command.equals("/freeboardDetail.fbo")){
    	  
          
          action = new BoardListAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardReplyForm.cbo")){
          action = new BoardReplyFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardReplyPro.cbo")){
          action = new BoardReplyProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardUpdateForm.cbo")){
          action = new BoardUpdateFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardUpdatePro.cbo")){
          action = new BoardUpdateProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardDeletePro.cbo")){
          action = new BoardDeleteProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/boardDeleteForm.cbo")){
          String nowPage = request.getParameter("page");
          request.setAttribute("page", nowPage);
          int board_num=Integer.parseInt(request.getParameter("board_num"));
          request.setAttribute("board_num",board_num);
          forward=new ActionForward();
          forward.setPath("/board/qna_board_delete.jsp");
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