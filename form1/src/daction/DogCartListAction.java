package daction;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartListService;
import dsvc.DogListService;
import dvo.ActionForward;
import dvo.Cart;
import dvo.Dog;

public class DogCartListAction implements Action {

	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		DogCartListService dogCartListService = new DogCartListService();
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("id");
		System.out.println("세션 아이디: " + sId);
		ArrayList<Cart> cartList = dogCartListService.getCartList(sId);
		int totalMoney = 0;
		int money = 0 ;
		if(cartList==null)
		{
			request.setAttribute("cartList", null);
		}
		if(cartList!=null) {
			for (int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getC_price()*cartList.get(i).getC_count();
				totalMoney += money;
			}
			request.setAttribute("totalMoney", totalMoney);
			request.setAttribute("cartList", cartList);
		}
		
		
		ActionForward forward = new ActionForward("dogCartList.jsp",false);
		
		return forward;
		
	}

}
