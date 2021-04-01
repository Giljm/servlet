package com.bizpoll.admin;

import java.util.Scanner;

import com.bizpoll.admin.DAO.AdminDAO;

public class AdminMain {

	// 1. ������ ��� 2. ������ �α��� 3. �ý��� ����

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();
		boolean login = false;

//		System.out.print("�Է� >> ");
//		String id = sc.nextLine();
//
//		boolean strBool = aDao.adminIdCheck(id);
//
//		if (strBool == true) {
//
//			System.out.println("���� ����");
//
//		} else {
//
//			System.out.println("���� �Ұ�");
//
//		}

		while (true) {

			System.out.println("=========================");
			System.out.println("1. ������ ���");
			System.out.println("2. ������ �α���");
			System.out.println("3. ������ ���");
			System.out.println("4. ������ ��������");
			System.out.println("5. �ý��� ����");
			System.out.println("-------------------------");
			System.out.print("�޴�â �Է� >> ");
			String strNum = sc.nextLine();

			try {

				int intNum = Integer.valueOf(strNum);

				if (intNum == 1) {

					aDao.ManagerInsert();

				} else if (intNum == 2) {

					login = aDao.ManagerLogin();

				} else if (intNum == 3) {

					if (login == true) {

						aDao.ManagerList();

					} else {

						System.out.println("\n�α����� �ؾ� �����ȸ ����\n");

					}

				} else if (intNum == 4) {

					if (login == true) {

						aDao.ManagerUpdate();

					} else {

						System.out.println("\n�α����� �ؾ� �������� ����\n");

					}

				} else if (intNum == 5) {

					System.out.println("\n�ý��� ����\n");
					break;
				}

			} catch (Exception e) {
				System.out.println("1 ~ 3�� �Է°���");

			}
		}
	}
}
