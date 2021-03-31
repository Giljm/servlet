/*
 * **************************************************************
 * @Source : DBManager.java
 * @description : Connection ��ü�� ������ ����� ���� ���ҽ��� �����Ѵ�.
 * **************************************************************
 * DATE			AUTHOR				DESCRIPTOIN
 * --------------------------------------------------------------
 * 2021/03/31	������				�����ۼ�
 * 2021/04/31	������				ȸ�� ���� ��� �߰�
 * 
 * 
 */

package com.bizpoll.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Singleton(�̱���) Ŭ���� : �ν��Ͻ��� �ϳ��� ���� ����ϴ� ���
public class DBManager {
	private static Connection con; // ����

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String Url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	private static final String User = "scott";
	private static final String Pw = "1234";

	// �ٸ� ������ ��ü�� �������� ���ϰ� ���´�.
	private DBManager() {

	}

	public static Connection getConnection() {
		con = null;

		if (con == null) {

			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(Url, User, Pw);
				System.out.println("���� ����!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return con;

	}

	// SELECT �ڿ�����
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void close(Connection con, PreparedStatement pstmt) {

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
