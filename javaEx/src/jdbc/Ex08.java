package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex08 {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "SELECT * " + "FROM tblMember";

			PreparedStatement pstmt = con.prepareStatement(sql);

			// 조회할때 executeQuery를 사용
			ResultSet rs = pstmt.executeQuery();
			// 반환 타입이 ResulSet이기에 그걸 rs변수에 담는다.
			
			// 여러개의 컬럼 데이터를 가져올때의 문법
			while (rs.next()) {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
