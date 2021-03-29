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

			System.out.println("DB에 접속하셨습니다.");

			String sql = "UPDATE tblMember " + "SET age = ?, phone = ? " + "WHERE name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			// 인덱스의 자리는 0부터 시작하는게 아니라 1부터 시작한다.
			pstmt.setInt(1, 28);
			pstmt.setString(2, "01058789645");
			pstmt.setString(3, "김보라");

			int result = pstmt.executeUpdate();

			if (result > 0) {

				System.out.println("회원수정 성공!");

			} else {

				System.out.println("회원수정 실패!");

			}

		} catch (Exception e) {

		}

	}
}