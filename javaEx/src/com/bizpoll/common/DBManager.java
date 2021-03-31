/*
 * **************************************************************
 * @Source : DBManager.java
 * @description : Connection 개체를 얻어오고 사용이 끝난 리소스를 해제한다.
 * **************************************************************
 * DATE			AUTHOR				DESCRIPTOIN
 * --------------------------------------------------------------
 * 2021/03/31	길지민				최초작성
 * 2021/04/31	길지민				회원 가입 기능 추가
 * 
 * 
 */

package com.bizpoll.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Singleton(싱글톤) 클래스 : 인스턴스를 하나만 만들어서 사용하는 방법
public class DBManager {
	private static Connection con; // 선언만

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String Url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	private static final String User = "scott";
	private static final String Pw = "1234";

	// 다른 곳에서 객체를 생성하지 못하게 막는다.
	private DBManager() {

	}

	public static Connection getConnection() {
		con = null;

		if (con == null) {

			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(Url, User, Pw);
				System.out.println("접속 성공!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return con;

	}

	// SELECT 자원해제
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
