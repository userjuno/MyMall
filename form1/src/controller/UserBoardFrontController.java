package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.copy.Action;
import action.copy.BoardDeleteProAction;
import action.copy.BoardDetailAction;
import action.copy.BoardListAction;
import action.copy.BoardReplyFormAction;
import action.copy.BoardReplyProAction;
import action.copy.BoardUpdateFormAction;
import action.copy.BoardUpdateProAction;
import action.copy.BoardWriteProAction;
import uvo.ActionForward;


@WebServlet("*.ubo")
public class UserBoardFrontController extends HttpServlet {
   
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String RequestURI=request.getRequestURI();
      String contextPath=request.getContextPath();
      String command=RequestURI.substring(contextPath.length());
      ActionForward forward=null;
      Action action=null;
      
      if(command.equals("/userboardList.ubo")){
    	  System.out.println("1");
            action = new BoardListAction();
            System.out.println("2");
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
      }
      else if(command.equals("/userboardWriteForm.ubo")){
          forward=new ActionForward();
          forward.setPath("/user_board/qna_board_write.jsp");
       }
      else if(command.equals("/userboardWritePro.ubo")){
          action  = new BoardWriteProAction();
          try {
             forward=action.execute(request, response );
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardDetail.ubo")){
          action = new BoardDetailAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardReplyForm.ubo")){
          action = new BoardReplyFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardReplyPro.ubo")){
          action = new BoardReplyProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardUpdateForm.ubo")){
          action = new BoardUpdateFormAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardUpdatePro.ubo")){
          action = new BoardUpdateProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardDeletePro.ubo")){
          action = new BoardDeleteProAction();
          try{
             forward=action.execute(request, response);
          }catch(Exception e){
             e.printStackTrace();
          }
       }
      else if(command.equals("/userboardDeleteForm.ubo")){
          String nowPage = request.getParameter("page");
          request.setAttribute("page", nowPage);
          int board_num=Integer.parseInt(request.getParameter("board_num"));
          request.setAttribute("board_num",board_num);
          forward=new ActionForward();
          forward.setPath("/user_board/qna_board_delete.jsp");
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