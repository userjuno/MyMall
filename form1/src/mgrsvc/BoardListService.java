package mgrsvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MgrBoardDAO;
import mgrvo.BoardBean;

import static db.JdbcUtil.*;

public class BoardListService {

	public int getListCount() throws Exception{
	      // TODO Auto-generated method stub
	      
	      int listCount = 0;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      listCount = boardDAO.selectListCount();
	      close(con);
	      return listCount;
	      
	   }
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
	      
	      ArrayList<BoardBean> articleList = null;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectArticleList(page,limit);
	      close(con);
	      return articleList;
	      
	   }
}
