package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex02 {
	
	// UPDATE
	
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속 성공");

			Statement st = con.createStatement();

			String sql = "UPDATE tblMember SET age = 31, phone = '01098765432' WHERE name = '장보라'";
			

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
