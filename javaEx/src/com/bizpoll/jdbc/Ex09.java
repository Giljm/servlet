package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class Ex09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("ȸ�� ��ȣ�� �Է��ϼ��� : ");
		int no = sc.nextInt();
		sc.nextLine();

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();

		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("�ּҸ� �Է��ϼ��� : ");
		String addr = sc.nextLine();

		System.out.print("�޴��� ��ȣ�� �Է��ϼ��� : ");
		String phone = sc.nextLine();

		sc.close();

		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
		// �޼ҵ�� �ܺ��� �����͸� �����ϰ� �޾� �� �� �ִ� ��.
		int result = memInsert(mDto);

		if (result > 0) {

			System.out.println("��� ����");

		} else {

			System.out.println("��� ����");

		}

	}

	private static int memInsert(MemberDTO mDto) {
		// MemberDto mDto�� �޼����� �Ű������� �޴´�.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		int succ = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
		return 1;
	}

}
