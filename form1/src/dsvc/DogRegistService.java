package dsvc;

import java.sql.Connection;

import dao.DogDAO;
import dvo.Dog;
import static db.JdbcUtil.*;

public class DogRegistService {

	public boolean registDog(Dog dog) {
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		
		int insertCount = dogDAO.insertDog(dog);
		
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
