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

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "SELECT * " + "FROM tblMember";

			PreparedStatement pstmt = con.prepareStatement(sql);

			// ��ȸ�Ҷ� executeQuery�� ���
			ResultSet rs = pstmt.executeQuery();
			// ��ȯ Ÿ���� ResulSet�̱⿡ �װ� rs������ ��´�.
			
			// �������� �÷� �����͸� �����ö��� ����
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
