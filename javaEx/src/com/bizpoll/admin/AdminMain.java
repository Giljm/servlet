package com.bizpoll.admin;

import java.util.Scanner;

import com.bizpoll.admin.DAO.AdminDAO;

public class AdminMain {

	// 1. 관리자 등록 2. 관리자 로그인 3. 시스템 종료

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();
		boolean login = false;

//		System.out.print("입력 >> ");
//		String id = sc.nextLine();
//
//		boolean strBool = aDao.adminIdCheck(id);
//
//		if (strBool == true) {
//
//			System.out.println("가입 가능");
//
//		} else {
//
//			System.out.println("가입 불가");
//
//		}

		while (true) {

			System.out.println("=========================");
			System.out.println("1. 관리자 등록");
			System.out.println("2. 관리자 로그인");
			System.out.println("3. 관리자 목록");
			System.out.println("4. 관리자 정보수정");
			System.out.println("5. 시스템 종료");
			System.out.println("-------------------------");
			System.out.print("메뉴창 입력 >> ");
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

						System.out.println("\n로그인을 해야 목록조회 가능\n");

					}

				} else if (intNum == 4) {

					if (login == true) {

						aDao.ManagerUpdate();

					} else {

						System.out.println("\n로그인을 해야 정보수정 가능\n");

					}

				} else if (intNum == 5) {

					System.out.println("\n시스템 종료\n");
					break;
				}

			} catch (Exception e) {
				System.out.println("1 ~ 3만 입력가능");

			}
		}
	}
}
