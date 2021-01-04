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

public class DogCartRemoveService {
	
	public boolean CartReMoveDog(String kind,String sId) {
		

		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		System.out.println("service : "+kind);
		int insertCount = dogDAO.remove_Cart(kind,sId);
		
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
		
		
	
}