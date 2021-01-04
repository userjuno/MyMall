package dsvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dvo.Cart;

public class DogCartSearchService {

	public ArrayList<Cart> getCartSearchList(int start_money,int end_money,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		ArrayList<Cart> cartList = new ArrayList<>();
		
		
		for (int i = 0; i < oldCartList.size(); i++) {
			
			if(oldCartList.get(i).getC_price()>=start_money && oldCartList.get(i).getC_price()<=end_money){
				cartList.add(oldCartList.get(i));
			}
			
		}
		return cartList;
	}
}
