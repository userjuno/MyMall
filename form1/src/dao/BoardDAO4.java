package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.sql.DataSource;

import ch15.DBConnectionMgr;
import ch15.UtilMgr;
import uvo.BoardBean;
//댓글
public class BoardDAO4 {
	private static final String  SAVEFOLDER = "C:/Jsp/myapp/WebContent/ch15/fileupload";
	private static final String ENCTYPE = "EUC-KR";
	private static int MAXSIZE = 5*1024*1024;

   DataSource ds;
   Connection con;
   private static BoardDAO4 boardDAO;

   private BoardDAO4() {
      // TODO Auto-generated constructor stub
   }

   public static BoardDAO4 getInstance(){
      if(boardDAO == null){
         boardDAO = new BoardDAO4();
      }
      return boardDAO;
   }

   public void setConnection(Connection con){
      this.con = con;
   }
   
   public int selectListCount() {

      int listCount= 0;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try{


         System.out.println("getConnection");
         pstmt=con.prepareStatement("select count(*) from free_board");
         rs = pstmt.executeQuery();

         if(rs.next()){
            listCount=rs.getInt(1);
         }
      }catch(Exception ex){
         System.out.println("getListCount 에러: " + ex);         
      }finally{
         close(rs);
         close(pstmt);
      }

      return listCount;

   }
   
   public int insertArticle(BoardBean article, String id){
	  
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int num =0;
      String sql="";
      int insertCount=0;
      
      try{
         pstmt=con.prepareStatement("select max(board_num) from free_board");
         rs = pstmt.executeQuery();

         if(rs.next())
            num =rs.getInt(1)+1;
         else
            num=1;
         System.out.println("세션 : "+ id);
         sql="insert into comm_board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
         sql+="BOARD_RE_REF,"+
               "BOARD_RE_LEV,BOARD_RE_SEQ,"+
               "BOARD_DATE,BOARD_PNUM) values(?,?,?,?,?,?,?,now(),?)";
         
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, null);
         pstmt.setString(2, id);
         pstmt.setString(3, article.getBOARD_PASS());
         pstmt.setString(4, article.getBOARD_SUBJECT());
         pstmt.setInt(5, num);
         pstmt.setInt(6, 0);
         pstmt.setInt(7, 0);
         pstmt.setInt(8, article.getBoard_pnum());
         insertCount=pstmt.executeUpdate();

      }catch(Exception ex){
         System.out.println("boardInsert 에러 : "+ex);
      }finally{
         close(rs);
         close(pstmt);
      }

      return insertCount;

   }
   public int updateArticle(BoardBean article){
	   	  boolean result = false;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      int num =0;
	      
	      int update=0;
	     
	      try{
	    	  pstmt=con.prepareStatement("select max(board_num) from free_board");
	          rs = pstmt.executeQuery();

	          if(rs.next())
	             num =rs.getInt(1)+1;
	          else
	             num=1;
	    	  con.setAutoCommit(false);

	         if(rs.next())
	            num =rs.getInt(1)+1;
	         else
	            num=1;
	         String sql="update free_board set board_pass=?,board_subject=?,board_date=now() where board_num=?";
	         
	         pstmt = con.prepareStatement(sql);
;
	         pstmt.setString(1, article.getBOARD_PASS());
	         pstmt.setString(2, article.getBOARD_SUBJECT());
	        
	         pstmt.setInt(3, article.getBOARD_NUM());
	         
	        update=pstmt.executeUpdate();
	        if(update>0) {
	        	con.commit();
	        }
	      }catch(Exception ex){
	         System.out.println("boardupdate 에러 : "+ex);
	      }finally{
	         close(rs);
	         close(pstmt);
	      }

	      return update;

	   }
   public ArrayList<BoardBean> selectArticleList(int page,int limit,int board_num){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String board_list_sql="select * from comm_board where board_pnum=?  order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
	      ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
	      BoardBean board = null;
	      int startrow=(page-1)*10; //읽기 시작할 row 번호..   

	      try{
	         pstmt = con.prepareStatement(board_list_sql);
	         
	         pstmt.setInt(1, board_num);
	         pstmt.setInt(2, startrow);
	         rs = pstmt.executeQuery();
	         System.out.println("댓글 : "+ pstmt);
	         while(rs.next()){
	            board = new BoardBean();
	            board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
	            board.setBOARD_NAME(rs.getString("BOARD_NAME"));
	            board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
	            board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
	            board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
	            board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
	            board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
	            articleList.add(board);
	         }
	         
	      }catch(Exception ex){
	         System.out.println("getBoardList 에러 : " + ex);
	      }finally{
	         close(rs);
	         close(pstmt);
	      }

	      return articleList;

	   }
   public int updateReadCount(int board_num){

	      PreparedStatement pstmt = null;
	      int updateCount = 0;
	      String sql="update free_board set BOARD_READCOUNT = "+
	            "BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;

	      try{
	         pstmt=con.prepareStatement(sql);
	         updateCount = pstmt.executeUpdate();
	      }catch(SQLException ex){
	         System.out.println("setReadCountUpdate 에러 : "+ex);
	      }
	      finally{
	         close(pstmt);

	      }

	      return updateCount;

	   }

   public BoardBean selectArticle(int board_num){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      BoardBean boardBean = null;

	      try{
	         pstmt = con.prepareStatement(
	               "select * from free_board where BOARD_NUM = ?");
	         pstmt.setInt(1, board_num);
	         rs= pstmt.executeQuery();

	         if(rs.next()){
	            boardBean = new BoardBean();
	            boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
	            boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
	            boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
	            boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
	            boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
	            boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
	            boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
	            boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
	            boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
	            boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
	         }
	      }catch(Exception ex){
	         System.out.println("getDetail 에러 : " + ex);
	      }finally{
	         close(rs);
	         close(pstmt);
	      }

	      return boardBean;

	   }
   public int insertReplyArticle(BoardBean article){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String board_max_sql="select max(board_num) from free_board";
	      String sql="";
	      int num=0;
	      int insertCount=0;
	      int re_ref=article.getBOARD_RE_REF();
	      int re_lev=article.getBOARD_RE_LEV();
	      int re_seq=article.getBOARD_RE_SEQ();

	      try{
	         pstmt=con.prepareStatement(board_max_sql);
	         rs = pstmt.executeQuery();
	         if(rs.next())num =rs.getInt(1)+1;
	         else num=1;
	         sql="update free_board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
	         sql+="and BOARD_RE_SEQ>?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1,re_ref);
	         pstmt.setInt(2,re_seq);
	         int updateCount=pstmt.executeUpdate();

	         if(updateCount > 0){
	            commit(con);
	         }

	         re_seq = re_seq + 1;
	         re_lev = re_lev+1;
	         sql="insert into free_board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
	         sql+="BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
	         sql+="BOARD_DATE) values(?,?,?,?,?,?,?,now())";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         pstmt.setString(2, article.getBOARD_NAME());
	         pstmt.setString(3, article.getBOARD_PASS());
	         pstmt.setString(4, article.getBOARD_SUBJECT());
	         pstmt.setInt(7, re_ref);
	         pstmt.setInt(8, re_lev);
	         pstmt.setInt(9, re_seq);
	   
	         insertCount = pstmt.executeUpdate();
	      }catch(SQLException ex){
	         System.out.println("boardReply 에러 : "+ex);
	      }finally{
	         close(rs);
	         close(pstmt);
	      }

	      return insertCount;

	   }
   public boolean isArticleBoardWriter(int board_num,String pass){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String board_sql="select * from free_board where BOARD_NUM=?";
	      boolean isWriter = false;

	      try{
	         pstmt=con.prepareStatement(board_sql);
	         pstmt.setInt(1, board_num);
	         rs=pstmt.executeQuery();
	         rs.next();

	         if(pass.equals(rs.getString("BOARD_PASS"))){
	            isWriter = true;
	         }
	      }catch(SQLException ex){
	         System.out.println("isBoardWriter 에러 : "+ex);
	      }
	      finally{
	         close(pstmt);
	      }

	      return isWriter;

	   }

   public int deleteArticle(int board_num){

	      PreparedStatement pstmt = null;
	      String board_delete_sql="delete from free_board where BOARD_num=?";
	      int deleteCount=0;

	      try{
	         pstmt=con.prepareStatement(board_delete_sql);
	         pstmt.setInt(1, board_num);
	         deleteCount=pstmt.executeUpdate();
	      }catch(Exception ex){
	         System.out.println("boardDelete 에러 : "+ex);
	      }   finally{
	         close(pstmt);
	      }

	      return deleteCount;

	   }


}