package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dvo.ActionForward;
import daction.Action;
import daction.DogCartAddAction;
import daction.DogCartListAction;
import daction.DogCartPayAction;
import daction.DogCartQtyDownAction;
import daction.DogCartQtyUpAction;
import daction.DogCartRemoveAction;
import daction.DogCartSearchAction;
import daction.DogListAction;
import daction.DogListAction1;
import daction.DogListAction2;
import daction.DogListAction3;
import daction.DogListAction4;
import daction.DogOrderInfoAction;
import daction.DogPayAction;
import daction.DogRegistAction;
import daction.DogRegistFormAction;
import daction.DogViewAction;
import daction.DogPayFormAction;
import daction.DogOrderListAction;
import daction.DogOrderRemoveAction;

@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. ��û�ľ�
		String requestURI = request.getRequestURI();
		//��û URL : http://localhost:8088/boardProject/boardWriteFrom.bo
		//requestURI : /boardProject/boardWriteForm.bo ��ȯ
		
		String contextPath = request.getContextPath();
		//   /boardProject ��ȯ
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		//2.�� ��û���� �����Ͻ����� ȣ��
		if(command.equals("/dogList.dog")){
			action = new DogListAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogList1.dog")){
			action = new DogListAction1();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogList2.dog")){
			action = new DogListAction2();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogList3.dog")){
			action = new DogListAction3();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/dogList4.dog")){
			action = new DogListAction4();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogView.dog")){
			action = new DogViewAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogPay.dog")){
			action = new DogPayAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogPayForm.dog")){
			action = new DogPayFormAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartPay.dog")){
			action = new DogCartPayAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartAdd.dog")){
			System.out.println("addAc");
			action = new DogCartAddAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogOrderList.dog")){
			action = new DogOrderListAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogOrderInfo.dog")){
			action = new DogOrderInfoAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartList.dog")){
			action = new DogCartListAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartSearch.dog")){
			action = new DogCartSearchAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartRemove.dog")){
			action = new DogCartRemoveAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogOrderRemove.dog")){
			action = new DogOrderRemoveAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyUp.dog")){
			action = new DogCartQtyUpAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyDown.dog")){
			action = new DogCartQtyDownAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogRegist.dog")){
			action = new DogRegistAction();
			//������Ʈ�� + ��� + ����(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogRegistForm.dog")){
			action = new DogRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//3. ������
		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}
