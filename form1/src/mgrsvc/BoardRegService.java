package mgrsvc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MgrBoardDAO;
import mgrvo.UserBean;

import static db.JdbcUtil.*;

public class BoardRegService {

	
	public ArrayList<UserBean> getArticleList() throws Exception{
	      
	      ArrayList<UserBean> articleList = null;
	      Connection con = getConnection();
	      MgrBoardDAO boardDAO = MgrBoardDAO.getInstance();
	      boardDAO.setConnection(con);
	      articleList = boardDAO.selectregList();
	      close(con);
	      return articleList;
	      
	   }
}
