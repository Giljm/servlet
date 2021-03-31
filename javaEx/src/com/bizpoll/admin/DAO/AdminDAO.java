package com.bizpoll.admin.DAO;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	public void inputSc() {

		System.out.print("ID �Է� >>");
		strId = sc.nextLine();
		System.out.print("PW �Է� >>");
		strPw = sc.nextLine();
		System.out.print("�̸� �Է� >>");
		strName = sc.nextLine();
		System.out.print("�޴��� ��ȣ �Է� >>");
		strPhone = sc.nextLine();
	}

	public void ManagerInsert() {
		inputSc();

		AdminDTO aDto = new AdminDTO();

		aDto.setId(strId);
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
			System.out.println("��� ����!");

			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(con, pstmt);

		}

	}

	public void ManagerLogin() {

		String strId = null;
		String strPwd = null;
		String strName = null;
		String strPhone = null;

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

			System.out.println(strId + " �� �ݰ����ϴ�.");

		} else {

			System.out.println("���� ����� �Դϴ�.");

		}

	}

}
