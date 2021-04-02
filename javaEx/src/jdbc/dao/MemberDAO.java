package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import common.DBManager;
import jdbc.dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";
	Scanner sc = new Scanner(System.in);
	MemberDTO mDto = new MemberDTO();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

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

			con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {

			DBManager.close(con, pstmt);

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

			con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB�� �����ϼ̽��ϴ�.");

			String sql = "UPDATE tblMember " + "SET no = ?, name = ?, age = ?, addr = ?, phone = ? " + "WHERE no = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());
			pstmt.setInt(6, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {

			DBManager.close(con, pstmt);

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
				con = DriverManager.getConnection(url, user, pw); // try
				System.out.println("DB�� �����ϼ̽��ϴ�.");

				String sql = "DELETE FROM tblMember " + "WHERE no = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, mDto.getNo());
				succ = pstmt.executeUpdate();

				System.out.println(">> " + succ);

			} catch (Exception e) {
				System.out.println("������ �Է��ϼ���");
				continue;
			} finally {
				DBManager.close(con, pstmt);

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

		int rsNo = 0;
		String rsName = null;
		int rsAge = 0;
		String rsAddr = null;
		String rsPhone = null;

		while (true) {
			System.out.print("��ȸ�� ȸ�� �̸� �Է� >> ");
			String strName = sc.nextLine();

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, pw); // try

				String sql = "SELECT * " + "FROM tblmember " + "WHERE name LIKE ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, "%" + strName + "%");
				rs = pstmt.executeQuery();

				while (rs.next()) {

					rsNo = rs.getInt("no");
					rsName = rs.getString("name");
					rsAge = rs.getInt("age");
					rsAddr = rs.getString("addr");
					rsPhone = rs.getString("phone");

				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				DBManager.close(con, pstmt, rs);

			}

			if (strName.equals(rsName)) {

				System.out.println("ȸ�� ��ȣ : " + rsNo);
				System.out.println("�̸� : " + rsName);
				System.out.println("���� : " + rsAge);
				System.out.println("�ּ��� : " + rsAddr);
				System.out.println("�޴��� ��ȣ : " + rsPhone);

				break;

			} else {

				System.out.println("�����Ͱ� �����ϴ�.");
				continue;
			}

		}
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

				DBManager.getConnection();

				String sql = "SELECT no, name " + "FROM tblMember " + "WHERE no = ? AND name = ?";
				pstmt = con.prepareStatement(sql);

				int intId = Integer.valueOf(strId);
				pstmt.setInt(1, intId);
				pstmt.setString(2, strName);
				rs = pstmt.executeQuery();

				while (rs.next()) { // �����Ͱ� ������ �ϴ� ����Ʈ �������� �޾� �;��Ѵ�

					rsNo = rs.getInt("no");
					stNo = Integer.toString(rsNo);
					rsName = rs.getString("name");
				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				DBManager.close(con, pstmt, rs);

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
