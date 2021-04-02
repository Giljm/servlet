package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex01 {
	
	// INSERT

	public static void main(String[] args) {

		// ���� ����
		// 1�� : JDBC ����̺� �ε�
		// 2�� : �����ͺ��̽� ����
		// 3�� : SQL�� ����
		// 4�� : �����ͺ��̽� ��������

		try {
			// ����Ŭ ����̹� ��� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// @�ڿ��� pc ip�ּҰ� �;���
			String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
			// �����ͺ��̽� id/pass �Է�
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			// �����ߴٰ� ����� �ϰ� ��
			System.out.println("���� ����");

			Statement st = con.createStatement();

			String sql = "INSERT INTO tblMember VALUES (6,'�庸��',27,'����� ������ û�㵿','01022222222')";

			int result = st.executeUpdate(sql);

			if (result > 0) {

				System.out.println("��� ����");

			} else {

				System.out.println("��� ����");

			}
			
			

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
