package freesvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO3;
import fvo.BoardBean;

import static db.JdbcUtil.*;

public class BoardListService {

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
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
	      
	      ArrayList<BoardBean> articleList = null;
	      Connection con = getConnection();
	      BoardDAO3 boardDAO = BoardDAO3.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectArticleList(page,limit);
	      close(con);
	      return articleList;
	      
	   }
}
