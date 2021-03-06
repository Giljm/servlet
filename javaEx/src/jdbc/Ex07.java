package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex07 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "DELETE FROM tblMember " + "WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, 7);

			int result = pstmt.executeUpdate();

			if (result > 0) {

				System.out.println("정보삭제 성공!");

			} else {

				System.out.println("정보삭제 실패!");

			}

		} catch (Exception e) {

		}

	}
}