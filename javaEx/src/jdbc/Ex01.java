package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex01 {
	
	// INSERT

	public static void main(String[] args) {

		// 연결 순서
		// 1번 : JDBC 드라이브 로드
		// 2번 : 데이터베이스 연결
		// 3번 : SQL문 실행
		// 4번 : 데이터베이스 연결해제

		try {
			// 오라클 드라이버 경로 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// @뒤에는 pc ip주소가 와야함
			String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
			// 데이터베이스 id/pass 입력
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			// 성공했다고 출력을 하게 함
			System.out.println("접속 성공");

			Statement st = con.createStatement();

			String sql = "INSERT INTO tblMember VALUES (6,'장보라',27,'서울시 강남구 청담동','01022222222')";

			int result = st.executeUpdate(sql);

			if (result > 0) {

				System.out.println("등록 성공");

			} else {

				System.out.println("등록 실패");

			}
			
			

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
