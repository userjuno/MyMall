package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
public class BoardupdateService {
	public boolean updateArticle(BoardBean article) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isUpdateSuccess = false;
	      int updateCount = 0;
	      Connection con = getConnection();
	      BoardDAO boardDAO = BoardDAO.getInstance();
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
