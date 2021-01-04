package freesvc;

import java.sql.Connection;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import dao.BoardDAO3;
import fvo.BoardBean;

public class BoardDetailService {

	public BoardBean getArticle(int board_num,int page) throws Exception{
	      // TODO Auto-generated method stub
	      
	      BoardBean article = null;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
	      boardDAO.setConnection(con);
	      int updateCount = boardDAO.updateReadCount(board_num);
	      
	      if(updateCount > 0){
	         commit(con);
	      }
	      else{
	         rollback(con);
	      }
	      
	      article = boardDAO.selectArticle(board_num);
	      ArrayList<BoardBean> articleList = null;
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectCommArticleList(page, board_num);
	      close(con);
	      return article;
	      
	   }
}
