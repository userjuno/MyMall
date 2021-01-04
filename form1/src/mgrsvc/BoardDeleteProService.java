package mgrsvc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MgrBoardDAO;

public class BoardDeleteProService {
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
	      // TODO Auto-generated method stub
	      
	      boolean isArticleWriter = false;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
	      close(con);
	      return isArticleWriter;
	      
	   }

	   public boolean removeArticle(int board_num) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isRemoveSuccess = false;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      int deleteCount = boardDAO.deleteArticle(board_num);
	      
	      if(deleteCount > 0){
	         commit(con);
	         isRemoveSuccess=true;
	      }
	      else{
	         rollback(con);
	      }
	      
	      close(con);
	      return isRemoveSuccess;
	   }
}