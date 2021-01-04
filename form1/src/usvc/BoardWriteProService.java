package usvc;

import java.sql.Connection;

import dao.BoardDAO2;
import uvo.BoardBean;
import static db.JdbcUtil.*;

public class BoardWriteProService {

   public boolean registArticle(BoardBean boardBean, String id) throws Exception{
      // TODO Auto-generated method stub
      
      boolean isWriteSuccess = false;
      Connection con = getConnection();
      BoardDAO2 boardDAO = BoardDAO2.getInstance();
      boardDAO.setConnection(con);
      int insertCount = boardDAO.insertArticle(boardBean,id);
      
      if(insertCount > 0){
         commit(con);
         isWriteSuccess = true;
      }
      else{
         rollback(con);
      }
      
      close(con);
      return isWriteSuccess;
      
   }

}