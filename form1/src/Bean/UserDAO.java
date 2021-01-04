package Bean;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;



public class UserDAO {

	// dao : 데이터베이스 접근 객체의 약자로서

	// 실질적으로 db에서 회원정보 불러오거나 db에 회원정보 넣을때



	private Connection conn; // connection:db에접근하게 해주는 객체

	private PreparedStatement pstmt;

	private ResultSet rs;


	
	// mysql에 접속해 주는 부분

	public UserDAO() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함

		try {

			String dbURL = "jdbc:mysql://127.0.0.1:3306/myjh?useUnicode=true&characterEncoding=EUC_KR"; // localhost:3306 포트는 컴퓨터설치된 mysql주소

			String dbID = "root";

			String dbPassword = "1234";

			Class.forName("org.gjt.mm.mysql.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {

			e.printStackTrace(); // 오류가 무엇인지 출력

		}

	}


	public String getName(String userID, String userPassword) {
		String SQL = "SELECT pwd,name FROM tblreg WHERE id = ?";
		String message = null;
		try {
				

			// pstmt : prepared statement 정해진 sql문장을 db에 삽입하는 형식으로 인스턴스가져옴

			pstmt = conn.prepareStatement(SQL);

			// sql인젝션 같은 해킹기법을 방어하는것... pstmt을 이용해 하나의 문장을 미리 준비해서(물음표사용)

			// 물음표해당하는 내용을 유저아이디로, 매개변수로 이용.. 1)존재하는지 2)비밀번호무엇인지
			
			pstmt.setString(1, userID);
			
			// rs:result set 에 결과보관
			pstmt.execute();
			rs = pstmt.executeQuery();
			String name="";
			// 결과가 존재한다면 실행
			
			if (rs.next()) {
				
				// 패스워드 일치한다면 실행
				if (rs.getString(1).equals(userPassword)) {
					name= rs.getString(2);

					return name; // 라긴 성공

				} 
			}
		}
		catch (Exception e) {

			message="해당 사용자를 찾을 수 없습니다.";

		}
		return message;
	}
	// 로그인을 시도하는 함수****

	public int login(String userID, String userPassword) {

		String SQL = "SELECT pwd,name FROM tblreg WHERE id = ?";
		try {		
		
			pstmt = conn.prepareStatement(SQL);	
			pstmt.setString(1, userID);
			
			// rs:result set 에 결과보관
			pstmt.execute();
			rs = pstmt.executeQuery();
			String name;
			// 결과가 존재한다면 실행
			
			if (rs.next()) {
				
				// 패스워드 일치한다면 실행
				if (rs.getString(1).equals(userPassword)) {
					name= rs.getString(2);

					return 1; // 라긴 성공

				} else

					return 0; // 비밀번호 불일치

			}
			
			return -1; // 아이디가 없음 오류



		} catch (Exception e) {

			e.printStackTrace();

		}

		return -2; // 데이터베이스 오류를 의미

	}



}

