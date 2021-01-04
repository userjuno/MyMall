package daction;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartListService;
import dsvc.DogListService;
import dsvc.DogOrderListService;
import dvo.ActionForward;
import dvo.Cart;
import dvo.Dog;
import dvo.OrderBean;

public class DogOrderListAction implements Action {

	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		DogOrderListService dogOrderListService = new DogOrderListService();
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("id");
		System.out.println("세션 아이디: " + sId);
		ArrayList<OrderBean> cartList = dogOrderListService.getCartList(sId);
		int totalMoney = 0;
		request.setAttribute("orderList", cartList);
		ActionForward forward = new ActionForward("dogOrderList.jsp",false);
		
		return forward;
		
	}

}
