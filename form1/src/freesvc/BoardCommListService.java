package freesvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO3;
import fvo.BoardBean;

import static db.JdbcUtil.*;

public class BoardCommListService {

	public int getListCount() throws Exception{
	      // TODO Auto-generated method stub
	      
	      int listCount = 0;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
	      boardDAO.setConnection(con);
	      listCount = boardDAO.selectListCount();
	      close(con);
	      return listCount;
	      
	   }
	public ArrayList<BoardBean> getArticleList(int page, int board_num) throws Exception{
	      
	      ArrayList<BoardBean> articleList = null;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectCommArticleList(page, board_num);
	      close(con);
	      return articleList;
	      
	   }
}
