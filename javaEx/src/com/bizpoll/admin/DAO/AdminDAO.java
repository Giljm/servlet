package com.bizpoll.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.bizpoll.admin.DTO.AdminDTO;
import com.bizpoll.common.DBManager;

public class AdminDAO {

	// admin ���

	// ���̵� üũ

	// �α���

	Scanner sc = new Scanner(System.in);
	String strId = null;
	String strPw = null;
	String strName = null;
	String strPhone = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void inputScId() {

		System.out.print("ID �Է� >> ");
		strId = sc.nextLine();

	}

	public void inputSc() {

		System.out.print("PW �Է� >> ");
		strPw = sc.nextLine();
		System.out.print("�̸� �Է� >> ");
		strName = sc.nextLine();
		System.out.print("�޴��� ��ȣ �Է� >> ");
		strPhone = sc.nextLine();

	}

	public void ManagerInsert() {

		String strCheck = null;
		AdminDTO aDto = new AdminDTO();

		while (true) {

			inputScId();
			aDto.setId(strId);

			// ������� ��ĳ�ʸ� ���� ���� ���� aDto�� strId �� ����ȴ�

			try {
				con = DBManager.getConnection();
				String sql = "SELECT ID " + "FROM ADMIN " + "WHERE ID = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, aDto.getId());

				rs = pstmt.executeQuery();

				while (rs.next()) {

					strCheck = rs.getString("ID");

				}

			} catch (Exception e) {

			}

			if (strId.equals(strCheck)) {

				System.out.println("�ߺ��� ID �Դϴ�");

			} else {

				inputSc();
				aDto.setPwd(strPw);
				aDto.setName(strName);
				aDto.setPhone(strPhone);

				try {

					con = DBManager.getConnection();
					String sql = "INSERT INTO ADMIN VALUES (?, ?, ?, ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, aDto.getId());
					pstmt.setString(2, aDto.getPwd());
					pstmt.setString(3, aDto.getName());
					pstmt.setString(4, aDto.getPhone());
					System.out.println("\n��� ����!\n");

					pstmt.executeUpdate();

					break;

				} catch (Exception e) {

					e.printStackTrace();

				} finally {

					DBManager.close(con, pstmt);

				}
			}
		}
	}

	public boolean ManagerLogin() {

		boolean bYes = false;

		String strId = null;
		String strPwd = null;

		String ID = null;
		String Pw = null;

		System.out.print("ID �Է� >> ");
		ID = sc.nextLine();

		System.out.print("PW �Է� >> ");
		Pw = sc.nextLine();

		try {

			String sql = "SELECT * " + "FROM ADMIN " + "WHERE ID = ? AND PWD = ?";
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, Pw);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				strId = rs.getString("ID");
				strPwd = rs.getString("PWD");

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(con, pstmt, rs);

		}

		if (ID.equals(strId) && Pw.equals(strPwd)) {

			System.out.println("\n" + strId + " �� �ݰ����ϴ�.\n");
			bYes = true;

		} else {

			System.out.println("\n���� ����� �Դϴ�.\n");

		}

		return bYes;

	}

	public void ManagerList() {

		String name = null;

		try {

			con = DBManager.getConnection();

			Statement pstmt = con.createStatement();
			String sql = "SELECT NAME " + "FROM ADMIN ";
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {

				String strName = rs.getString("NAME");
				System.out.println("������ : " + strName);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(con, pstmt, rs);

		}

	}

	public void ManagerUpdate() {

		AdminDTO aDto = new AdminDTO();

		System.out.print("������ ID�Է� >> ");
		String strId2 = sc.nextLine();
		System.out.print("���ο� ID�Է� >> ");
		String strId = sc.nextLine();
		System.out.print("���ο� ��й�ȣ �Է� >> ");
		String strPw = sc.nextLine();
		System.out.print("���ο� �̸��Է� >> ");
		String strName = sc.nextLine();
		System.out.print("���ο� �޴��� ��ȣ �Է� >> ");
		String strPhone = sc.nextLine();

		aDto.setId(strId);
		aDto.setPwd(strPw);
		aDto.setName(strName);
		aDto.setPhone(strPhone);

		try {

			con = DBManager.getConnection();
			String sql = "UPDATE ADMIN " + "SET ID = ?, PWD = ?, NAME = ?, phone = ? " + "WHERE ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aDto.getId());
			pstmt.setString(2, aDto.getPwd());
			pstmt.setString(3, aDto.getName());
			pstmt.setString(4, aDto.getPhone());
			pstmt.setString(5, strId2);

			pstmt.executeUpdate();

			System.out.println("\n���� ����!\n");
			
		} catch (Exception e) {


		} finally {

			DBManager.close(con, pstmt);

		}
	}

	// ���̵�üũ
	public boolean adminIdCheck(String id) {

		int resultCnt = 0;
		boolean useYN = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			String sql = "SELECT count(*) " + "FROM ADMIN " + "WHERE ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				resultCnt = rs.getInt("count(*)");

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(con, pstmt, rs);

		}

		if (resultCnt == 0) {

			useYN = true;

		}

		return useYN;

	}

}
