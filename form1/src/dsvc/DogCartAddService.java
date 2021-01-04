package dsvc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static db.JdbcUtil.*;

import dao.DogDAO;
import dvo.Cart;
import dvo.Dog;

public class DogCartAddService {
	
public boolean CartAddDog(String kind,String sId) {
		

	DogDAO dogDAO = DogDAO.getInstance();
	Connection con = getConnection();
	dogDAO.setConnection(con);
	System.out.println("service : "+kind);
	int insertCount = dogDAO.in_up_Cart(kind,sId);
	
	boolean isRegistSucess = false;
	
	if(insertCount > 0) {
		commit(con);
		isRegistSucess = true;
	}else {
		rollback(con);
	}
	
	close(con);

	return isRegistSucess;
}
	/*
	 * public CartList getCartDog(String kind) { Connection con = getConnection();
	 * DogDAO dogDAO = DogDAO.getInstance(); dogDAO.setConnection(con); CartList
	 * cart = dogDAO.in_up_Cart(kind); close(con); return cart; }
	 * 
	 * public void addCart(HttpServletRequest request, Dog cartDog) {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
	 * 
	 * if(cartList == null) { cartList = new ArrayList<>();
	 * session.setAttribute("cartList",cartList); }
	 * 
	 * boolean isNewCart = true;
	 * 
	 * for(int i=0;i<cartList.size();i++) {
	 * if(cartDog.getKind().equals(cartList.get(i).getKind())){ isNewCart = false;
	 * cartList.get(i).setQty(cartList.get(i).getQty()+1); break; } }
	 * 
	 * if(isNewCart) { Cart cart = new Cart(); cart.setImage(cartDog.getImage());
	 * cart.setKind(cartDog.getKind()); cart.setPrice(cartDog.getPrice());
	 * cart.setQty(1);
	 * 
	 * cartList.add(cart); }
	 * 
	 * }
	 */
}
