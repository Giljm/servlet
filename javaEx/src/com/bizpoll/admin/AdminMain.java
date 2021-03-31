package com.bizpoll.admin;

import java.util.Scanner;

import com.bizpoll.admin.DAO.AdminDAO;

public class AdminMain {

	// 1. ������ ��� 2. ������ �α��� 3. �ý��� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();

		while (true) {

			System.out.println("=========================");
			System.out.println("1. ������ ���");
			System.out.println("2. ������ �α���");
			System.out.println("3. �ý��� ����");
			System.out.println("-------------------------");

			System.out.print("�޴�â �Է� >> ");
			int intNum = sc.nextInt();

			if (intNum == 1) {

				aDao.ManagerInsert();
				continue;

			} else if (intNum == 2) {

				aDao.ManagerLogin();
				continue;

			} else if (intNum == 3) {

				System.out.println("�ý��� ����");
				break;

			}
		}
	}

}
