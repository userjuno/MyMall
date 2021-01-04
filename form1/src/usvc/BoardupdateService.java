package usvc;

import java.sql.Connection;

import dao.BoardDAO2;
import uvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardupdateService {
	public boolean updateArticle(BoardBean article) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isUpdateSuccess = false;
	      int updateCount = 0;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
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
