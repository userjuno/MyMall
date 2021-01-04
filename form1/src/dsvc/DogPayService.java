package dsvc;

import java.sql.Connection;

import dao.DogDAO;
import dvo.OrderBean;
import static db.JdbcUtil.*;

public class DogPayService {

	public boolean registDog(OrderBean dog) {
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		
		int insertCount = dogDAO.insertPay(dog);
		
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
