package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex06 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "UPDATE tblMember " + "SET age = ?, phone = ? " + "WHERE name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			// �ε����� �ڸ��� 0���� �����ϴ°� �ƴ϶� 1���� �����Ѵ�.
			pstmt.setInt(1, 28);
			pstmt.setString(2, "01058789645");
			pstmt.setString(3, "�躸��");

			int result = pstmt.executeUpdate();

			if (result > 0) {

				System.out.println("ȸ������ ����!");

			} else {

				System.out.println("ȸ������ ����!");

			}

		} catch (Exception e) {

		}

	}
}