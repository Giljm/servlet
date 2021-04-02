package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import jdbc.dto.MemberDTO;

public class Ex11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("삭제할 회원의 번호를 입력하세요 : ");
		int updateno = sc.nextInt();

		sc.close();

		System.out.println("삭제한 회원의 번호 : " + updateno);

		MemberDTO mDto = new MemberDTO();
		mDto.setNo(updateno);

		int result = memUpdate(mDto);

		if (result > 0) {

			System.out.println("삭제 성공");

		} else {

			System.out.println("삭제 실패");

		}

	}

	private static int memUpdate(MemberDTO mDto) {
		// MemberDto mDto를 메서드의 매개변수로 받는다.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		int succ = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "DELETE FROM tblMember " + "WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
		return succ;
	}

}
