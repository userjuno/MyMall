package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeaction.Action;
import freeaction.BoardDeleteProAction;
import freeaction.BoardDetailAction;
import freeaction.BoardListAction;
import freeaction.BoardReplyFormAction;
import freeaction.BoardReplyProAction;
import freeaction.BoardUpdateFormAction;
import freeaction.BoardUpdateProAction;
import freeaction.BoardWriteProAction;
import fvo.ActionForward;


  
  @WebServlet("*.fbo") 
  public class FreeBoardFrontController extends HttpServlet {
	   
	   
	   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");
	      String RequestURI=request.getRequestURI();
	      String contextPath=request.getContextPath();
	      String command=RequestURI.substring(contextPath.length());
	      ActionForward forward=null;
	      Action action=null;
	      commaction.Action action1=null;
	      
	      if(command.equals("/freeboardList.fbo")){

	            action = new BoardListAction();

	            try{
	               forward=action.execute(request, response);
	            }catch(Exception e){
	               e.printStackTrace();
	            }
	      }
	      else if(command.equals("/freeboardWriteForm.fbo")){
	          forward=new ActionForward();
	          forward.setPath("/free_board/qna_board_write.jsp");
	       }
	      else if(command.equals("/freeboardWritePro.fbo")){
	          action  = new BoardWriteProAction();
	          try {
	             forward=action.execute(request, response );
	          } catch (Exception e) {
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardDetail.fbo")){
	          action = new BoardDetailAction();
	          
	          try{
	             forward=action.execute(request, response);
	           	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardReplyForm.fbo")){
	          action = new BoardReplyFormAction();
	          try{
	             forward=action.execute(request, response);
	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardReplyPro.fbo")){
	          action = new BoardReplyProAction();
	          try{
	             forward=action.execute(request, response);
	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardUpdateForm.fbo")){
	          action = new BoardUpdateFormAction();
	          try{
	             forward=action.execute(request, response);
	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardUpdatePro.fbo")){
	          action = new BoardUpdateProAction();
	          try{
	             forward=action.execute(request, response);
	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardDeletePro.fbo")){
	          action = new BoardDeleteProAction();
	          try{
	             forward=action.execute(request, response);
	          }catch(Exception e){
	             e.printStackTrace();
	          }
	       }
	      else if(command.equals("/freeboardDeleteForm.fbo")){
	          String nowPage = request.getParameter("page");
	          request.setAttribute("page", nowPage);
	          int board_num=Integer.parseInt(request.getParameter("board_num"));
	          request.setAttribute("board_num",board_num);
	          forward=new ActionForward();
	          forward.setPath("/free_board/qna_board_delete.jsp");
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