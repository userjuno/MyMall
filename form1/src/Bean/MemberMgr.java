package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Bean.ZipcodeBean;

public class MemberMgr {

	private DBConnectionMgr pool;

	public MemberMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ID 중복확인
	public boolean checkId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblreg where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			flag = pstmt.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	public MemberBean findId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean bean = null;
		String sql = null;

		try {
			con = pool.getConnection();
			sql = "select * from tblreg where phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pw"));
				bean.setName(rs.getString("name"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setAddr_more(rs.getString("addr_more"));
				bean.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	public MemberBean findPw(String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean bean = null;
		String sql = null;

		try {
			con = pool.getConnection();
			sql = "select * from tblreg where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setAddr_more(rs.getString("addr_more"));
				bean.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	public boolean checkPhone(String phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select phone from tblreg where phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			flag = pstmt.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	// 우편번호 검색
	public Vector<ZipcodeBean> zipcodeRead(String area3) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblZipcode where area3 like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + area3 + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea2(rs.getString(3));
				bean.setArea3(rs.getString(4));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// 회원가입
	public boolean insertMember(MemberBean bean) {

	      Connection con = null;
	      PreparedStatement pstmt = null;
	      String sql = null;
	      String mgr_sql = null;
	      Connection mgr_con = null;
	      PreparedStatement mgr_pstmt = null;
	      boolean flag = false;
	      try {
	         con = pool.getConnection();
	         mgr_con = pool.getConnection();
	         sql = "insert tblreg(id,pwd,name,zipcode"
	               + ",address,addr_more,phone)values(?,?,?,?,?,?,?)";
	         mgr_sql = "insert reg_mgr(id,pwd,name,zipcode"
		               + ",address,addr_more,phone,reg_date)values(?,?,?,?,?,?,?,now())";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, bean.getId());
	         pstmt.setString(2, bean.getPwd());
	         pstmt.setString(3, bean.getName());       
	         pstmt.setString(4, bean.getZipcode());
	         pstmt.setString(5, bean.getAddress());
	         pstmt.setString(6, bean.getAddr_more());
	         pstmt.setString(7, bean.getPhone());
	         
	         mgr_pstmt = mgr_con.prepareStatement(mgr_sql);
	         mgr_pstmt.setString(1, bean.getId());
	         mgr_pstmt.setString(2, bean.getPwd());
	         mgr_pstmt.setString(3, bean.getName());       
	         mgr_pstmt.setString(4, bean.getZipcode());
	         mgr_pstmt.setString(5, bean.getAddress());
	         mgr_pstmt.setString(6, bean.getAddr_more());
	         mgr_pstmt.setString(7, bean.getPhone());
	        
	        
	         if (pstmt.executeUpdate() == 1)
	            flag = true;
	 		System.out.println("1");
	         
	      }catch(Exception e) {
	         e.getMessage();
	      }finally {
	         pool.freeConnection(con, pstmt);
	         pool.freeConnection(mgr_con, mgr_pstmt);
	      }
	      
	      
	      return flag;
	      
	   }
	public boolean insertMember_mgr(MemberBean bean) {

	      Connection con = null;
	      PreparedStatement pstmt = null;
	      String sql = null;
	     
	      boolean flag = false;
	      try {
	         con = pool.getConnection();
	         
	        sql = "insert reg_mgr(id,pwd,name,zipcode"
		               + ",address,addr_more,phone,reg_date)values(?,?,?,?,?,?,?,now())";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, bean.getId());
	         pstmt.setString(2, bean.getPwd());
	         pstmt.setString(3, bean.getName());       
	         pstmt.setString(4, bean.getZipcode());
	         pstmt.setString(5, bean.getAddress());
	         pstmt.setString(6, bean.getAddr_more());
	         pstmt.setString(7, bean.getPhone());
	    
	        
	        
	         if (pstmt.executeUpdate() == 1)
	            flag = true;
	 		System.out.println("1");
	         
	      }catch(Exception e) {
	         e.getMessage();
	      }finally {
	         pool.freeConnection(con, pstmt);
	         
	      }
	      
	      
	      return flag;
	      
	   }
	// 로그인
	public boolean loginMember(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		boolean flag = false;
		String name;
		try {
			con = pool.getConnection();
			sql = "select id,name from tblreg where id = ? and pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	/*************
	 * ch17 필요한 메소드
	 * ************/

	// 회원정보가져오기
	public MemberBean getMember(String id,String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean bean = null;
		try {
			con = pool.getConnection();
			String sql = "select * from tblreg where id = ? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setAddr_more(rs.getString("addr_more"));
				bean.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		return bean;
	}

	// 회원정보수정
	public boolean updateMember(MemberBean bean, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String mgr_sql = null;
	    Connection mgr_con = null;
	    PreparedStatement mgr_pstmt = null;
	    
	    
		boolean flag = false;
		try {
			con = pool.getConnection();
			mgr_con = pool.getConnection();
			
			String sql = "update  tblreg set pwd=?,name=?,zipcode=?"
		               + ",address=?,addr_more=?,phone=? where id =?";
			mgr_sql = "insert reg_mgr(id,pwd,name,zipcode"
		               + ",address,addr_more,phone,reg_date)values(?,?,?,?,?,?,?,now())";
				 
		         pstmt = con.prepareStatement(sql);
		         
		         pstmt.setString(1, bean.getPwd());
		         pstmt.setString(2, bean.getName());       
		         pstmt.setString(3, bean.getZipcode());
		         pstmt.setString(4, bean.getAddress());
		         pstmt.setString(5, bean.getAddr_more());
		         pstmt.setString(6, bean.getPhone());
		         pstmt.setString(7, id);
		         
		         mgr_pstmt = mgr_con.prepareStatement(mgr_sql);
		         mgr_pstmt.setString(1, id);
		         mgr_pstmt.setString(2, bean.getPwd());
		         mgr_pstmt.setString(3, bean.getName());       
		         mgr_pstmt.setString(4, bean.getZipcode());
		         mgr_pstmt.setString(5, bean.getAddress());
		         mgr_pstmt.setString(6, bean.getAddr_more());
		         mgr_pstmt.setString(7, bean.getPhone());
		         
		       
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
			pool.freeConnection(mgr_con, mgr_pstmt);
		}
		return flag;
	}
	
	public boolean goodbye(String id,String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		String mgr_sql = null;
	    Connection mgr_con = null;
	    PreparedStatement mgr_pstmt = null;
	
	    ResultSet rs = null;
	    String v_sql = null;
	    Connection v_con = null;
	    PreparedStatement v_pstmt = null;
	    try {
			
			v_con = pool.getConnection();
			v_sql = "select * from tblreg where id=?";
			
			String sql = "delete from tblreg where id=? and pwd=?";
			
			mgr_sql = "insert goodbye_mgr(id,name"
		               + ",goodbye_date)values(?,?,now())";
			
				v_pstmt = v_con.prepareStatement(v_sql);
				v_pstmt.setString(1, id);
				rs = v_pstmt.executeQuery();
				 String name = "";
				if(rs.next()) {
					name = rs.getString("name");
					con = pool.getConnection();
					mgr_con = pool.getConnection();
					
				}
			   
			    System.out.println("잘 가.."+name);
		        pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				mgr_pstmt = mgr_con.prepareStatement(mgr_sql);
				mgr_pstmt.setString(1, id);
				mgr_pstmt.setString(2, name);
				
				
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
			pool.freeConnection(v_con, v_pstmt);
			pool.freeConnection(mgr_con, mgr_pstmt);
		}
		return flag;
	}
}