package dsvc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import dvo.Cart;

public class DogCartPayService {
	
	public ArrayList<Cart> CartPayDog(String sId) {
		

		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		
		ArrayList<Cart> cartList = dogDAO.selectCartPayList(sId);
		
		return cartList;
	}
		
		
	
}