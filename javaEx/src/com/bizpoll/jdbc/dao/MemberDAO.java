package com.bizpoll.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";
	Scanner sc = new Scanner(System.in);
	MemberDTO mDto = new MemberDTO();

	public void INSERT() {

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

		mDto.setNo(no);
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setAddr(addr);
		mDto.setPhone(phone);

		sc.close();

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

		if (succ == 1) {
			System.out.println("��� ����");
		} else {
			System.out.println("��� ����");
		}

	}

	public void UPDATE() {

		System.out.print("������Ʈ�� ������ ȸ�� ��ȣ�� �Է��ϼ��� : ");
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

		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

		mDto.setNo(no);
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setAddr(addr);
		mDto.setPhone(phone);

		int succ = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "UPDATE tblMember " + "SET no = ?, name = ?, age = ?, addr = ?, phone = ? " + "WHERE no = ?";

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
	}

	public void DELETE() {

		int succ = 0;
		MemberDTO mDto = new MemberDTO();

		while (true) {

			System.out.print("������ ȸ���� ��ȣ�� �Է��ϼ��� : ");
			String strUpno = sc.nextLine();

			try {
				int upno = Integer.valueOf(strUpno);
				mDto.setNo(upno); // ��ĳ�ʷ� ���� �����͸� set���� �Է�

				System.out.println("������ ȸ���� ��ȣ : " + upno);

				Class.forName("oracle.jdbc.driver.OracleDriver"); // try
				Connection con = DriverManager.getConnection(url, user, pw); // try
				System.out.println("DB�� �����ϼ̽��ϴ�.");

				String sql = "DELETE FROM tblMember " + "WHERE no = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, mDto.getNo());
				succ = pstmt.executeUpdate();

				System.out.println(">> " + succ);

			} catch (Exception e) {
				System.out.println("������ �Է��ϼ���");
				continue;
			}

			if (succ > 0) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
				break;
			}

		}

	}

	public void SELECT() {

	}

	public void Login() {

		int rsNo = 0;
		String stNo = null;
		String rsName = null;

		while (true) {
			System.out.print("ȸ����ȣ �Է� >> ");
			String strId = sc.nextLine();

			System.out.print("�̸� �Է� >> ");
			String strName = sc.nextLine();

			try {

				int intId = Integer.valueOf(strId);

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, user, pw); // try

				String sql = "SELECT no, name " + "FROM tblMember " + "WHERE no = ? AND name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, intId);
				pstmt.setString(2, strName);
				ResultSet succ = pstmt.executeQuery();

				while (succ.next()) { // �����Ͱ� ������ �ϴ� ����Ʈ �������� �޾� �;��Ѵ�

					rsNo = succ.getInt("no");
					stNo = Integer.toString(rsNo);
					rsName = succ.getString("name");
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			if (strId.equals(stNo) && strName.equals(rsName)) {

				System.out.println(rsName + " �� �α��� �ϼ̽��ϴ�.");
				break;

			} else {

				System.out.println("�α��� ����");
				continue;
			}

		}
	}
}
