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

public class BoardDAO2 {
	private static final String  SAVEFOLDER = "C:/Jsp/myapp/WebContent/ch15/fileupload";
	private static final String ENCTYPE = "EUC-KR";
	private static int MAXSIZE = 5*1024*1024;

   DataSource ds;
   Connection con;
   private static BoardDAO2 boardDAO;

   private BoardDAO2() {
      // TODO Auto-generated constructor stub
   }

   public static BoardDAO2 getInstance(){
      if(boardDAO == null){
         boardDAO = new BoardDAO2();
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
         pstmt=con.prepareStatement("select count(*) from user_board");
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
         pstmt=con.prepareStatement("select max(board_num) from user_board");
         rs = pstmt.executeQuery();

         if(rs.next())
            num =rs.getInt(1)+1;
         else
            num=1;
         System.out.println("세션 : "+ id);
         sql="insert into user_board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
         sql+="BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
               "BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
               "BOARD_DATE,Q_NAEM) values(?,?,?,?,?,?,?,?,?,?,now(),?)";

         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, num);
         pstmt.setString(2, id);
         pstmt.setString(3, article.getBOARD_PASS());
         pstmt.setString(4, article.getBOARD_SUBJECT());
         pstmt.setString(5, article.getBOARD_CONTENT());
         pstmt.setString(6, article.getBOARD_FILE());
         pstmt.setInt(7, num);
         pstmt.setInt(8, 0);
         pstmt.setInt(9, 0);
         pstmt.setInt(10, 0);
         pstmt.setString(11, id);
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
	    	  pstmt=con.prepareStatement("select max(board_num) from user_board");
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
	         String sql="update user_board set board_pass=?,board_subject=?,board_content=?,board_date=now() where board_num=?";
	         
	         pstmt = con.prepareStatement(sql);
;
	         pstmt.setString(1, article.getBOARD_PASS());
	         pstmt.setString(2, article.getBOARD_SUBJECT());
	         pstmt.setString(3, article.getBOARD_CONTENT());
	        
	         pstmt.setInt(4, article.getBOARD_NUM());
	         
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
   public ArrayList<BoardBean> selectArticleList(int page,int limit,String id){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String board_list_sql="select * from user_board where q_name=? order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
	      ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
	      BoardBean board = null;
	      int startrow=(page-1)*10; //읽기 시작할 row 번호..   

	      try{
	         pstmt = con.prepareStatement(board_list_sql);
	         pstmt.setString(1, id);
	         pstmt.setInt(2, startrow);
	         rs = pstmt.executeQuery();

	         while(rs.next()){
	            board = new BoardBean();
	            board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
	            board.setBOARD_NAME(rs.getString("BOARD_NAME"));
	            board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
	            board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
	            board.setBOARD_FILE(rs.getString("BOARD_FILE"));
	            board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
	            board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
	            board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
	            board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
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
	      String sql="update user_board set BOARD_READCOUNT = "+
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
	               "select * from user_board where BOARD_NUM = ?");
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
   public int insertReplyArticle(BoardBean article,int q_num){

	      PreparedStatement pstmt = null;
	      PreparedStatement q_pstmt = null;
	      ResultSet rs = null;
	      
	      ResultSet q_rs = null;
	     
	      String board_max_sql="select max(board_num) from user_board";
	      String sql="";
	      int num=0;
	      int insertCount=0;
	      int re_ref=article.getBOARD_RE_REF();
	      int re_lev=article.getBOARD_RE_LEV();
	      int re_seq=article.getBOARD_RE_SEQ();
	      String q_name="";
	      try{
	         pstmt=con.prepareStatement(board_max_sql);
	         rs = pstmt.executeQuery();
	         if(rs.next())num =rs.getInt(1)+1;
	         else num=1;
	         String q_sql="select * from user_board where board_num=?";
	         q_pstmt = con.prepareStatement(q_sql);
		     q_pstmt.setInt(1,q_num);
		     q_rs=q_pstmt.executeQuery();
	         sql="update user_board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
	         sql+="and BOARD_RE_SEQ>?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1,re_ref);
	         pstmt.setInt(2,re_seq);
	         int updateCount=pstmt.executeUpdate();

	         if(updateCount > 0){
	            commit(con);
	         }
	         if(q_rs.next()) {
	        	 q_name=q_rs.getString("BOARD_NAME");
	         }
	         System.out.println(q_name);
	         re_seq = re_seq + 1;
	         re_lev = re_lev+1;
	         sql="insert into user_board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
	         sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
	         sql+="BOARD_READCOUNT,BOARD_DATE,Q_NAME) values(?,?,?,?,?,?,?,?,?,?,now(),?)";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         pstmt.setString(2, article.getBOARD_NAME());
	         pstmt.setString(3, article.getBOARD_PASS());
	         pstmt.setString(4, article.getBOARD_SUBJECT());
	         pstmt.setString(5, article.getBOARD_CONTENT());
	         pstmt.setString(6, ""); //답장에는 파일을 업로드하지 않음.
	         pstmt.setInt(7, re_ref);
	         pstmt.setInt(8, re_lev);
	         pstmt.setInt(9, re_seq);
	         pstmt.setInt(10, 0);
	         pstmt.setString(11,q_name);
	         insertCount = pstmt.executeUpdate();
	      }catch(SQLException ex){
	         System.out.println("boardReply 에러 : "+ex);
	      }finally{
	         close(rs);
	         close(pstmt);
	         close(q_rs);
	         close(q_pstmt);
	      }

	      return insertCount;

	   }
   public boolean isArticleBoardWriter(int board_num,String pass,String id){

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String board_sql="select * from user_board where BOARD_NUM=?";
	      boolean isWriter = false;

	      try{
	         pstmt=con.prepareStatement(board_sql);
	         pstmt.setInt(1, board_num);
	         rs=pstmt.executeQuery();
	         rs.next();
	         if(id.equals(rs.getString("BOARD_NAME"))){
	        	 if(pass.equals(rs.getString("BOARD_PASS"))){
	 	            isWriter = true;
	 	         }
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
	      String board_delete_sql="delete from user_board where BOARD_num=?";
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