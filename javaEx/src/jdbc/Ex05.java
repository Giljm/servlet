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

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			// �ε����� �ڸ��� 0���� �����ϴ°� �ƴ϶� 1���� �����Ѵ�.
			pstmt.setInt(1, 7);
			pstmt.setString(2, "�躸��");
			pstmt.setInt(3, 50);
			pstmt.setString(4, "���ֱ����� �ϱ� ���ﵿ");
			pstmt.setString(5, "0000000000000");
			
			// INSERT,UPDATE,DELETE �ÿ� ���
			int result = pstmt.executeUpdate();
			// ���� ������ ��� executeUpdate���� 1�� ��´�. ��ȯŸ���� int��
			// �׷� result�� 1�� ��������� �Ʒ� if������ ���� ������ ������ Ȯ�� �� �� �ִ�.
			
			if (result > 0) {

				System.out.println("ȸ������ ����!");

			} else {

				System.out.println("ȸ������ ����!");
				
			}

		} catch (Exception e) {

		}

	}
}