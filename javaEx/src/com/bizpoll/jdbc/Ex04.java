package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04 {
	
	// SELECT
	
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속 성공");
			
			// Statement는 문제가 많다.
			Statement st = con.createStatement();

			String sql = "SELECT * " + "FROM tblMember";

			ResultSet rs = st.executeQuery(sql);

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
