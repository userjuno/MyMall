package usvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO2;
import uvo.BoardBean;

import static db.JdbcUtil.*;

public class BoardListService {

	public int getListCount() throws Exception{
	      // TODO Auto-generated method stub
	      
	      int listCount = 0;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
	      boardDAO.setConnection(con);
	      listCount = boardDAO.selectListCount();
	      close(con);
	      return listCount;
	      
	   }
	public ArrayList<BoardBean> getArticleList(int page, int limit,String id) throws Exception{
	      
	      ArrayList<BoardBean> articleList = null;
	      Connection con = getConnection();
	      BoardDAO2 boardDAO = BoardDAO2.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectArticleList(page,limit,id);
	      close(con);
	      return articleList;
	      
	   }
}
