package commsvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO4;
import uvo.BoardBean;

import static db.JdbcUtil.*;

public class BoardListService {

	public int getListCount() throws Exception{
	      // TODO Auto-generated method stub
	      
	      int listCount = 0;
	      Connection con = getConnection();
	      BoardDAO4 boardDAO = BoardDAO4.getInstance();
	      boardDAO.setConnection(con);
	      listCount = boardDAO.selectListCount();
	      close(con);
	      return listCount;
	      
	   }
	public ArrayList<BoardBean> getArticleList(int page, int limit,int board_num) throws Exception{
	      
	      ArrayList<BoardBean> articleList = null;
	      Connection con = getConnection();
	      BoardDAO4 boardDAO = BoardDAO4.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectArticleList(page,limit,board_num);
	      close(con);
	      return articleList;
	      
	   }
}
