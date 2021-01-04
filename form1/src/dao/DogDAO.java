package dao;

import static db.JdbcUtil.*;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import dvo.Dog;
import dvo.OrderBean;
import dvo.OrderBean1;
import dvo.Cart;
public class DogDAO {
	
	Connection con;
	private static DogDAO boardDAO;
	
	private DogDAO() {
		
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static DogDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new DogDAO();
		}
		
		return boardDAO;
	}
	
	public ArrayList<Dog> selectDogList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("item_name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("made")
							,rs.getString("category")
							,rs.getInt("trans_pay")
							,rs.getString("content")
							,rs.getInt("readcount")));
					
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	public ArrayList<Dog> selectDogList1() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods where category='Food'");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("item_name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("made")
							,rs.getString("category")
							,rs.getInt("trans_pay")
							,rs.getString("content")
							,rs.getInt("readcount")));
					
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	public ArrayList<Dog> selectDogList2() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods where category='Knife'");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("item_name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("made")
							,rs.getString("category")
							,rs.getInt("trans_pay")
							,rs.getString("content")
							,rs.getInt("readcount")));
					
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	public ArrayList<Dog> selectDogList3() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods where category='Plate'");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("item_name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("made")
							,rs.getString("category")
							,rs.getInt("trans_pay")
							,rs.getString("content")
							,rs.getInt("readcount")));
					
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	public ArrayList<Dog> selectDogList4() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods where category='ETC'");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("item_name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("made")
							,rs.getString("category")
							,rs.getInt("trans_pay")
							,rs.getString("content")
							,rs.getInt("readcount")));
					
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	
	public ArrayList<Cart> selectCartList(String a) {
		PreparedStatement pstmt = null;
		PreparedStatement sump = null;
		ResultSet rs= null;
		ResultSet sumr= null;
		ArrayList<Cart> cartList = null;
		String order = a;
		System.out.println("a :" +a );
		try {
			pstmt = con.prepareStatement("SELECT * FROM tblcart where order_id = ?");
			pstmt.setString(1, order);
			rs = pstmt.executeQuery();
			System.out.println("!");
			System.out.println("pstmt : " +pstmt);
			System.out.println("rs : " + rs);
			if(rs.next()){
				cartList = new ArrayList<Cart>();
				
				do {
					cartList.add(new Cart(
							rs.getString("c_name"),
							rs.getInt("c_price"),
							rs.getInt("c_count"),
							rs.getString("image"),
							rs.getString("order_id"),
							rs.getInt("c_count")*rs.getInt("c_price")
							));
					
				} while (rs.next());
				
				
			}
			else {
				cartList=null;
				System.out.println("널 발동");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		System.out.println("카트리스트 : " + cartList);
		return cartList;
	}

	public ArrayList<Cart> selectCartPayList(String a) {
		PreparedStatement pstmt = null;
		PreparedStatement sump = null;
		ResultSet rs= null;
		ResultSet sumr= null;
		ArrayList<Cart> cartList = null;
		String order = a;
		System.out.println("a :" +a );
		try {
			pstmt = con.prepareStatement("SELECT * FROM tblcart where order_id = ?");
			pstmt.setString(1, order);
			rs = pstmt.executeQuery();
			System.out.println("!");
			System.out.println("pstmt : " +pstmt);
			System.out.println("rs : " + rs);
			if(rs.next()){
				cartList = new ArrayList<Cart>();
				
				do {
					cartList.add(new Cart(
							rs.getString("c_name"),
							rs.getInt("c_price"),
							rs.getInt("c_count"),
							rs.getString("image"),
							rs.getString("order_id"),
							rs.getInt("c_count")*rs.getInt("c_price")
							));
					
				} while (rs.next());
				
				
			}
			else {
				cartList=null;
				System.out.println("널 발동");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		System.out.println("카트리스트 : " + cartList);
		return cartList;
	}
	public ArrayList<OrderBean> selectOrderList(String a) {
		PreparedStatement pstmt = null;
		PreparedStatement sump = null;
		ResultSet rs= null;
		ResultSet sumr= null;
		ArrayList<OrderBean> cartList = null;
		String order = a;
		System.out.println("a :" +a );
		try {
			pstmt = con.prepareStatement("SELECT * FROM order_table where order_id = ?");
			pstmt.setString(1, order);
			rs = pstmt.executeQuery();
			System.out.println("!");
			System.out.println("pstmt : " +pstmt);
			System.out.println("rs : " + rs);
			if(rs.next()){
				cartList = new ArrayList<OrderBean>();
				
				do {
					cartList.add(new OrderBean(
							
							rs.getString("goods_name"),
							rs.getString("buyer"),
							rs.getString("addr"),
							rs.getString("addr_more"),
							rs.getString("zipcode"),
							rs.getString("phone"),
							rs.getString("memo"),
							rs.getInt("price"),
							rs.getInt("trans_pay"),
							rs.getInt("or_count"),
							rs.getInt("totalmoney"),
							rs.getString("img"),
							rs.getString("order_date")
							));
					System.out.println("구쯔 네임" + rs.getString("goods_name"));
					
				} while (rs.next());
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return cartList;
	}
	public ArrayList<OrderBean1> selectOrderInfo() {
		PreparedStatement pstmt = null;
		PreparedStatement sump = null;
		ResultSet rs= null;
		ResultSet sumr= null;
		ArrayList<OrderBean1> cartList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM mgr_order");
			
			rs = pstmt.executeQuery();
			System.out.println("!");
			System.out.println("pstmt : " +pstmt);
			System.out.println("rs : " + rs);
			if(rs.next()){
				cartList = new ArrayList<OrderBean1>();
				
				do {
					cartList.add(new OrderBean1(
							
							rs.getString("good_name"),
							rs.getString("buyer"),
							rs.getString("addr"),
							rs.getString("phone"),
							rs.getString("memo"),
							rs.getInt("price"),
							rs.getInt("or_count"),				
							rs.getString("img"),
							rs.getString("order_id"),
						    rs.getInt("totalmoney"),
							rs.getString("order_date"),
							rs.getString("order_state")
							));
					System.out.println("구쯔 네임" + rs.getString("good_name"));
					
				} while (rs.next());
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return cartList;
	}
	public Dog selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog dog = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dog = new Dog(
						rs.getInt("id")
						,rs.getString("item_name")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("made")
						,rs.getString("category")
						,rs.getInt("trans_pay")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return dog;
	}
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE goods SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int insertDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			String a = dog.getCategory();
			System.out.println("DAO : " + a);
			sql = "INSERT INTO goods VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, dog.getCategory());
			pstmt.setInt(3, dog.getPrice());
			pstmt.setString(4, dog.getImage());
			pstmt.setString(5, dog.getContent());
			pstmt.setInt(6, dog.getReadcount());
			pstmt.setString(7, dog.getItem_name());
			pstmt.setString(8, dog.getMade());		
			pstmt.setInt(9, 2500);
			
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int insertPay(OrderBean dog) {
		PreparedStatement pstmt = null;
		PreparedStatement mgr_pstmt = null;
		String mgr_sql = "";
		int insertCount = 0;
		String sql = "";
		
		
		try {
			sql = "INSERT INTO order_table VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
			mgr_sql = "INSERT INTO mgr_order VALUES(?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			mgr_pstmt = con.prepareStatement(mgr_sql);
			mgr_pstmt.setString(1,null);
			mgr_pstmt.setString(2, dog.getGoods_name());
			mgr_pstmt.setString(3, dog.getBuyer());
			mgr_pstmt.setString(4, dog.getAddr());
			mgr_pstmt.setString(5, dog.getPhone());
			mgr_pstmt.setInt(6, dog.getPrice());
			mgr_pstmt.setInt(7, dog.getOr_count());
			mgr_pstmt.setString(8, dog.getImg());
			mgr_pstmt.setInt(9, dog.getPrice()*dog.getOr_count());
			mgr_pstmt.setString(10, dog.getOrder_id());
			mgr_pstmt.setString(11, "구매");
			mgr_pstmt.setString(12,dog.getMemo());
			
			System.out.println("관리자 전용: " +mgr_pstmt);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, dog.getGoods_name());
			pstmt.setString(3, dog.getBuyer());
			pstmt.setString(4, dog.getAddr());
			pstmt.setString(5, dog.getAddr_more());
			pstmt.setString(6, dog.getZipcode());
			pstmt.setString(7, dog.getPhone());
			pstmt.setString(8, dog.getMemo());
			pstmt.setInt(9, dog.getPrice());
			pstmt.setString(10, null);
			pstmt.setInt(11, dog.getOr_count());
			pstmt.setString(12, dog.getImg());
			pstmt.setInt(13, dog.getOr_count()*dog.getPrice()+2500);
			pstmt.setString(14, dog.getOrder_id());
			System.out.println("=전용: " +pstmt);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(mgr_pstmt);
		}
		
		return insertCount;
	}
	public int updateCount(String a, int b, String c) {

		int updateCount = 0;
		String sql = "";
		ResultSet sel_rs = null;
		String order = c;
		PreparedStatement sel_pstmt = null;
		PreparedStatement up_pstmt = null;
		System.out.print("B 값 : " + b);
		
		try {
			if(b==1) {
				sel_pstmt = con.prepareStatement("SELECT * FROM tblcart WHERE c_name=? and order_id=?");
				String c_name = a;
				sel_pstmt.setString(1, c_name);
				sel_pstmt.setString(2, order);
				sel_rs = sel_pstmt.executeQuery();
				
				
				if(sel_rs.next()){
					int cnt = sel_rs.getInt("c_count");
					System.out.print("남은 수량 : "+ cnt);
					if(cnt>1) {
						sql = "UPDATE tblcart SET c_count = c_count - 1 WHERE c_name=? and order_id=?" ;
						up_pstmt = con.prepareStatement(sql);
						System.out.println("update : " + up_pstmt);
						up_pstmt.setString(1, c_name);
						up_pstmt.setString(2, order);
						updateCount = up_pstmt.executeUpdate();
						System.out.print("업데이트 + "+updateCount);	
						
						
						close(up_pstmt);
					}
					else if(cnt==1){
						sql ="delete from tblcart where c_name=? and order_id=?";
						System.out.println("delete : " + up_pstmt);
						up_pstmt.setString(1, c_name);
						up_pstmt.setString(2, order);
						updateCount = up_pstmt.executeUpdate();
						System.out.print("업데이트 + "+updateCount);	
					}
				}
				
				close(sel_rs);
				close(sel_pstmt);
			}
			else {
				String c_name = a;
				sql = "UPDATE tblcart SET c_count = c_count + 1 WHERE c_name=? and order_id=?";
				up_pstmt = con.prepareStatement(sql);
				System.out.println("update : " + up_pstmt);
				up_pstmt.setString(1, c_name);
				up_pstmt.setString(2, c);
				updateCount = up_pstmt.executeUpdate();
				System.out.print("업데이트 + "+updateCount);	
				
				
				close(up_pstmt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return updateCount;
	}
	//////////////현재 장바구니에 order_id 컬럼 추가 해당 컬럼은 구매자 아이디임
	public int in_up_Cart(String a,String b) {
		PreparedStatement sel_pstmt = null;
		PreparedStatement sel_pstmt1 = null;
		PreparedStatement up_pstmt = null;
		PreparedStatement in_pstmt = null;
		ResultSet sel_rs = null;
		ResultSet sel_rs1 = null;
		
		String sql = "";	
		int price=0;
		String image="";
		int count = 0;
		try {
			String c_name = a;
			String order = b;
			sel_pstmt = con.prepareStatement("SELECT * FROM tblcart WHERE c_name=? and order_id=?");
			sel_pstmt.setString(1, c_name);
			sel_pstmt.setString(2, order);
			
			sel_rs = sel_pstmt.executeQuery();
			System.out.println("select : " + sel_pstmt);
			
			if(sel_rs.next()) {
				
				sql = "UPDATE tblcart SET c_count = c_count + 1,c_price = c_count * (c_price/(c_count-1)) WHERE c_name=? and order_id=?";
				up_pstmt = con.prepareStatement(sql);
				System.out.println("update : " + up_pstmt);
				up_pstmt.setString(1, c_name);
				up_pstmt.setString(2, order);
				count = up_pstmt.executeUpdate();
				System.out.print("업데이트 + "+count);	
				close(sel_rs);
				close(sel_pstmt);
				close(up_pstmt);
				
			}
			
			else {
				close(sel_rs);
				sel_pstmt1 = con.prepareStatement("SELECT * FROM goods WHERE item_name=?");
				
				sel_pstmt1.setString(1,c_name);
				sel_rs1 = sel_pstmt1.executeQuery();
		
				if(sel_rs1.next()){

					String item_name = sel_rs1.getString("item_name");
					price = sel_rs1.getInt("price");
					image =sel_rs1.getString("image");	
					sql = "INSERT INTO tblcart VALUES(?,?,?,?,?)";
					in_pstmt = con.prepareStatement(sql);
					
					in_pstmt.setString(1, item_name);
					in_pstmt.setInt(2, price);
					in_pstmt.setInt(3, 1);
					in_pstmt.setString(4, image);
					in_pstmt.setString(5, order);
					System.out.println("인서트 : " +in_pstmt);
					count = in_pstmt.executeUpdate();
					System.out.print("인서트 + "+count);
					close(in_pstmt);	
					}
					close(sel_rs1);
					close(sel_pstmt1);	
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			
		}
		return count;
		
	}
	public int remove_Cart(String a, String b) {
		PreparedStatement sel_pstmt = null;
		
		int count = 0;
		try {
			String c_name = a;
			String order = b;
			
			sel_pstmt = con.prepareStatement("delete  FROM tblcart WHERE c_name=? and order_id=?");
			
			sel_pstmt.setString(1, c_name);
			sel_pstmt.setString(2, order);
			System.out.println("select : " + sel_pstmt);
			count = sel_pstmt.executeUpdate();
			System.out.print("삭제 + "+count);	
		;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			
			close(sel_pstmt);
		}
		return count;
		
	}
	
	
	public int remove_Order(String a, String b) {
		PreparedStatement sel_pstmt = null;
		PreparedStatement mgr_pstmt = null;
		String mgr_sql = "";
		PreparedStatement idx_pstmt = null;
	
		ResultSet rs = null;
		int count = 0;
		try {
			String c_name = a;
			String order = b;
			idx_pstmt = con.prepareStatement("select * from order_table where goods_name=? and order_id=?");
			idx_pstmt.setString(1, c_name);
			idx_pstmt.setString(2, order);
			rs = idx_pstmt.executeQuery();
			
			if(rs.next()) {
				mgr_sql = "INSERT INTO mgr_order VALUES(?,?,?,?,?,?,?,?,?,?,now(),?,?)";
				
				mgr_pstmt = con.prepareStatement(mgr_sql);
				mgr_pstmt.setString(1,null);
				mgr_pstmt.setString(2, rs.getString("goods_name"));
				mgr_pstmt.setString(3, rs.getString("buyer"));
				mgr_pstmt.setString(4, rs.getString("addr"));
				mgr_pstmt.setString(5, rs.getString("phone"));
				mgr_pstmt.setInt(6, rs.getInt("price"));
				mgr_pstmt.setInt(7, rs.getInt("or_count"));
				mgr_pstmt.setString(8, rs.getString("img"));
				mgr_pstmt.setInt(9, rs.getInt("totalMoney"));
				mgr_pstmt.setString(10, rs.getString("order_id"));
				mgr_pstmt.setString(11, "환불");
				mgr_pstmt.setString(12,rs.getString("memo"));
				
				System.out.println("관리자 전용: " +mgr_pstmt);
				
				
				sel_pstmt = con.prepareStatement("delete FROM order_table WHERE goods_name=? and order_id=? and order_date <= Date_sub(now(),interval -3 day)");
				sel_pstmt.setString(1, c_name);
				sel_pstmt.setString(2, order);
				
				
				
				System.out.println("select : " + sel_pstmt);
				count = sel_pstmt.executeUpdate();
				System.out.print("삭제 + "+count);	
				
			}
			
		;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(idx_pstmt);
			close(mgr_pstmt);
			close(sel_pstmt);
			close(rs);
		}
		return count;
		
	}
}
