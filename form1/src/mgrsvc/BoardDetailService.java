package mgrsvc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MgrBoardDAO;
import mgrvo.BoardBean;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception{
	      // TODO Auto-generated method stub
	      
	      BoardBean article = null;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      int updateCount = boardDAO.updateReadCount(board_num);
	      
	      if(updateCount > 0){
	         commit(con);
	      }
	      else{
	         rollback(con);
	      }
	      
	      article = boardDAO.selectArticle(board_num);
	      close(con);
	      return article;
	      
	   }
}
