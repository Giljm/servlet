package testProject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class test_DAO {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";
	String strno;
	String name;
	String strage;
	String addr;
	String phone;

	public void Input() {

		Scanner sc = new Scanner(System.in);
		System.out.println("정보 INSERT");
		System.out.print("번호 >> ");
		strno = sc.nextLine();
		System.out.print("이름 >> ");
		name = sc.nextLine();
		System.out.print("나이 >> ");
		strage = sc.nextLine();
		System.out.print("주소 >> ");
		addr = sc.nextLine();
		System.out.print("번호 >> ");
		phone = sc.nextLine();

	}

	public void INSERT() {

		Input();
		int no = Integer.valueOf(strno);
		int age = Integer.valueOf(strage);
		while (true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection(url, user, pw);

				System.out.println("DB에 접속하셨습니다.");

				String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

				PreparedStatement pstmt = con.prepareStatement(sql);
				// 0부터 시작하는게 아니라 1부터 시작한다.
				pstmt.setInt(1, no);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, addr);
				pstmt.setString(5, phone);

				int result = pstmt.executeUpdate();

				if (result > 0) {

					System.out.println("회원가입 성공!");

				} else {

					System.out.println("회원가입 실패!");

				}

			} catch (Exception e) {

			}
			break;
		}
	}

	public void UPDATE() {
		Input();
		while (true) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection(url, user, pw);

				System.out.println("DB에 접속하셨습니다.");

				String sql = "UPDATE tblMember " + "SET age = ?, phone = ? " + "WHERE name = ?";

				PreparedStatement pstmt = con.prepareStatement(sql);
				// 0부터 시작하는게 아니라 1부터 시작한다.
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

	public void DELETE() {

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름 >> ");
		name = sc.nextLine();
		while (true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection(url, user, pw);

				System.out.println("DB에 접속하셨습니다.");

				String sql = "DELETE FROM tblMember " + "WHERE name = ?";

				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, name);

				int result = pstmt.executeUpdate();

				if (result > 0) {

					System.out.println("정보삭제 성공!");

				} else {

					System.out.println("정보삭제 실패!");

				}

			} catch (Exception e) {

			}
			break;
		}
	}

	public void SELECT() {
		while (true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection(url, user, pw);

				System.out.println("DB에 접속하셨습니다.");

				String sql = "SELECT * " + "FROM tblMember";

				PreparedStatement pstmt = con.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

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
			break;
		}

	}
}
