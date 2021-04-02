package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex05 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			// 인덱스의 자리는 0부터 시작하는게 아니라 1부터 시작한다.
			pstmt.setInt(1, 7);
			pstmt.setString(2, "김보라");
			pstmt.setInt(3, 50);
			pstmt.setString(4, "광주광역시 북구 중흥동");
			pstmt.setString(5, "0000000000000");
			
			// INSERT,UPDATE,DELETE 시에 사용
			int result = pstmt.executeUpdate();
			// 만약 성공할 경우 executeUpdate에서 1을 뱉는다. 반환타입이 int임
			// 그럼 result에 1이 담겨있으니 아래 if문으로 성공 실패의 유무를 확인 할 수 있다.
			
			if (result > 0) {

				System.out.println("회원가입 성공!");

			} else {

				System.out.println("회원가입 실패!");
				
			}

		} catch (Exception e) {

		}

	}
}