package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import jdbc.dto.MemberDTO;

public class Ex11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("������ ȸ���� ��ȣ�� �Է��ϼ��� : ");
		int updateno = sc.nextInt();

		sc.close();

		System.out.println("������ ȸ���� ��ȣ : " + updateno);

		MemberDTO mDto = new MemberDTO();
		mDto.setNo(updateno);

		int result = memUpdate(mDto);

		if (result > 0) {

			System.out.println("���� ����");

		} else {

			System.out.println("���� ����");

		}

	}

	private static int memUpdate(MemberDTO mDto) {
		// MemberDto mDto�� �޼����� �Ű������� �޴´�.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		int succ = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "DELETE FROM tblMember " + "WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
		return succ;
	}

}
