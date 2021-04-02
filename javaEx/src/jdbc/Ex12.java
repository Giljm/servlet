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
		System.out.print("��ȸ�� ��ȣ�� �Է��ϼ��� : ");
		int no = sc.nextInt();

		sc.close();

		System.out.println();

		MemberDTO mDto = new MemberDTO();

		mDto.setNo(no);

		int result = memInsert(mDto);

		if (result > 0) {

			System.out.println(no + "�� ȸ�� ��ȸ ����");

		} else {

			System.out.println(no + "�� ȸ�� ��ȸ ����");

		}

	}

	private static int memInsert(MemberDTO mDto) {
		// MemberDto mDto�� �޼����� �Ű������� �޴´�.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

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

				System.out.println("ȸ�� ��ȣ : " + no);
				System.out.println("ȸ�� �̸� : " + name);
				System.out.println("ȸ�� ���� : " + age);
				System.out.println("ȸ�� �ּ� : " + addr);
				System.out.println("ȸ�� ���� : " + phone);
			}

		} catch (Exception e) {

		}
		return 1;
	}

}
