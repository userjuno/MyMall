package daction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsvc.DogCartSearchService;
import dvo.ActionForward;
import dvo.Cart;

public class DogCartSearchAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DogCartSearchService dogCartSearchService = new DogCartSearchService();
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		ArrayList<Cart> cartList = 
		dogCartSearchService.getCartSearchList(startMoney,endMoney,request);
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getC_price()*cartList.get(i).getC_count();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}

}
