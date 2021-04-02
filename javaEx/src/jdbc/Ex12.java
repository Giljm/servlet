package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jdbc.dto.MemberDTO;

public class Ex12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 번호를 입력하세요 : ");
		int no = sc.nextInt();

		sc.close();

		System.out.println();

		MemberDTO mDto = new MemberDTO();

		mDto.setNo(no);

		int result = memInsert(mDto);

		if (result > 0) {

			System.out.println(no + "번 회원 조회 성공");

		} else {

			System.out.println(no + "번 회원 조회 실패");

		}

	}

	private static int memInsert(MemberDTO mDto) {
		// MemberDto mDto를 메서드의 매개변수로 받는다.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "SELECT * FROM tblMember WHERE no = ? ";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");

				System.out.println("회원 번호 : " + no);
				System.out.println("회원 이름 : " + name);
				System.out.println("회원 나이 : " + age);
				System.out.println("회원 주소 : " + addr);
				System.out.println("회원 폰번 : " + phone);
			}

		} catch (Exception e) {

		}
		return 1;
	}

}
