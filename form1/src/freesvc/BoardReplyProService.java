package freesvc;

import java.sql.Connection;

import dao.BoardDAO3;
import fvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardReplyProService {
	public boolean replyArticle(BoardBean article) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isReplySuccess = false;
	      int insertCount = 0;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
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
