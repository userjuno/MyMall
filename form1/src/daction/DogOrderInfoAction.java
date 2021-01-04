package daction;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartListService;
import dsvc.DogListService;
import dsvc. DogOrderInfoService;
import dvo.ActionForward;
import dvo.Cart;
import dvo.Dog;
import dvo.OrderBean1;

public class DogOrderInfoAction implements Action {

	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		 DogOrderInfoService dogOrderListService = new  DogOrderInfoService();
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("id");
		System.out.println("세션 아이디: " + sId);
		ArrayList<OrderBean1> cartList = dogOrderListService.getCartList();
		int totalMoney = 0;
		request.setAttribute("orderList", cartList);
		ActionForward forward = new ActionForward("dogOrderInfo.jsp",false);
		
		return forward;
		
	}

}
