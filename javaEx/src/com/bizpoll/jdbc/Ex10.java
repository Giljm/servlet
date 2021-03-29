package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class Ex10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("������Ʈ ȸ�� ��ȣ�� �Է��ϼ��� : ");
		int no = sc.nextInt();
		sc.nextLine();

		System.out.print("������Ʈ �̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();

		System.out.print("������Ʈ ���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("������Ʈ �ּҸ� �Է��ϼ��� : ");
		String addr = sc.nextLine();

		System.out.print("������Ʈ �޴��� ��ȣ�� �Է��ϼ��� : ");
		String phone = sc.nextLine();

		sc.close();

		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);

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

			String sql = "UPDATE tblMember " + "SET no = ?, name = ?, age = ?, addr = ?, phone = ? " + "WHERE name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());
			pstmt.setInt(6, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
		return 1;
	}

}
