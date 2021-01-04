package usvc;

import java.sql.Connection;

import dao.BoardDAO2;
import uvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardReplyProService {
	public boolean replyArticle(BoardBean article,int q_num) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isReplySuccess = false;
	      int insertCount = 0;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
	      boardDAO.setConnection(con);
	      insertCount = boardDAO.insertReplyArticle(article,q_num);
	      
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
