package com.bizpoll.admin;

import java.util.Scanner;

import com.bizpoll.admin.DAO.AdminDAO;

public class AdminMain {

	// 1. 관리자 등록 2. 관리자 로그인 3. 시스템 종료

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminDAO aDao = new AdminDAO();

		while (true) {

			System.out.println("=========================");
			System.out.println("1. 관리자 등록");
			System.out.println("2. 관리자 로그인");
			System.out.println("3. 시스템 종료");
			System.out.println("-------------------------");

			System.out.print("메뉴창 입력 >> ");
			int intNum = sc.nextInt();

			if (intNum == 1) {

				aDao.ManagerInsert();
				continue;

			} else if (intNum == 2) {

				aDao.ManagerLogin();
				continue;

			} else if (intNum == 3) {

				System.out.println("시스템 종료");
				break;

			}
		}
	}

}
