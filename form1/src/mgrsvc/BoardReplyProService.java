package mgrsvc;

import java.sql.Connection;

import dao.MgrBoardDAO;
import mgrvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardReplyProService {
	public boolean replyArticle(BoardBean article) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isReplySuccess = false;
	      int insertCount = 0;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      insertCount = boardDAO.insertReplyArticle(article);
	      
	      if(insertCount > 0){
	         commit(con);
	         isReplySuccess = true;
	      }
	      else{
	         rollback(con);
	      }
	      
	      close(con);
	      return isReplySuccess;
	      
	   }
}
