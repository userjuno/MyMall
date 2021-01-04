package usvc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BoardDAO2;

public class BoardDeleteProService {
	public boolean isArticleWriter(int board_num, String pass,String id) throws Exception {
	      // TODO Auto-generated method stub
	      
	      boolean isArticleWriter = false;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
	      boardDAO.setConnection(con);
	      isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass,id);
	      close(con);
	      return isArticleWriter;
	      
	   }

	   public boolean removeArticle(int board_num) throws Exception{
	      // TODO Auto-generated method stub
	      
	      boolean isRemoveSuccess = false;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
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
