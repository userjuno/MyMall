package dsvc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import dvo.Cart;
import dvo.Dog;

public class DogCartListService {

	/*
	 * public ArrayList<CartList> getCartList(HttpServletRequest request) { DogDAO
	 * dogDAO = DogDAO.getInstance(); Connection con = getConnection();
	 * dogDAO.setConnection(con); ArrayList<CartList> cartList
	 * =dogDAO.selectCartList(); return cartList; }
	 */
	public  ArrayList<Cart> getCartList(String sId){
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		ArrayList<Cart> cartList =dogDAO.selectCartList(sId);
		
		return cartList;
	}
}
