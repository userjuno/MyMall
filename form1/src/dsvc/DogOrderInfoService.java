package dsvc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import dvo.Cart;
import dvo.Dog;
import dvo.OrderBean1;

public class DogOrderInfoService {

	/*
	 * public ArrayList<CartList> getCartList(HttpServletRequest request) { DogDAO
	 * dogDAO = DogDAO.getInstance(); Connection con = getConnection();
	 * dogDAO.setConnection(con); ArrayList<CartList> cartList
	 * =dogDAO.selectCartList(); return cartList; }
	 */
	public  ArrayList<OrderBean1> getCartList(){
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		ArrayList<OrderBean1> cartList =dogDAO.selectOrderInfo();
		
		return cartList;
	}
}
