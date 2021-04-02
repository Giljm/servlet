package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import jdbc.dto.MemberDTO;

public class MemberSearch {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";

	List<MemberDTO> memList = new ArrayList<>();

	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection con = null;

	public List<MemberDTO> memSearch(int inputNo) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB에 접속하셨습니다.");

			String sql = "SELECT * " + "FROM tblMember " + "WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, inputNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);

				memList.add(mDto);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
			DBManager.close(con, pstmt, rs);

//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}

		}

		return memList;

	}

}
