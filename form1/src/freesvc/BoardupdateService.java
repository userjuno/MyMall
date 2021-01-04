package freesvc;

import java.sql.Connection;

import dao.BoardDAO3;
import fvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardupdateService {
	public boolean updateArticle(BoardBean article) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isUpdateSuccess = false;
	      int updateCount = 0;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
	      boardDAO.setConnection(con);
	      updateCount = boardDAO.updateArticle(article);
	      
	      if(updateCount > 0){
	         commit(con);
	         isUpdateSuccess = true;
	      }
	      else{
	         rollback(con);
	      }
	      
	      close(con);
	      return isUpdateSuccess;
	      
	   }
}
