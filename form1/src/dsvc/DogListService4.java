package dsvc;

import java.sql.Connection;
import java.util.ArrayList;
import dao.DogDAO;
import dvo.Dog;
import static db.JdbcUtil.*;

public class DogListService4 {

	
	public ArrayList<Dog> getDogList(){
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		ArrayList<Dog> dogList = dogDAO.selectDogList4();
		return dogList;
	}

}
