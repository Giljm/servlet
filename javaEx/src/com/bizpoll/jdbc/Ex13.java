package com.bizpoll.jdbc;

import java.util.Scanner;

import com.bizpoll.jdbc.dao.MemberDAO;

public class Ex13 {

	public static void main(String[] args) {


		while (true) {

			MemberDAO mDao = new MemberDAO();
			Scanner sc = new Scanner(System.in);
			System.out.println("==================");
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SELECT");
			System.out.println("5. Login");
			System.out.println("6. QUIT");
			System.out.println("------------------");
			System.out.print("선택 번호 입력 : ");
			String strSelectNo = sc.nextLine();

			try {

				int intSelectNo = Integer.valueOf(strSelectNo);

				if (1 == intSelectNo) {

					mDao.INSERT();

				} else if (2 == intSelectNo) {

					mDao.UPDATE();

				} else if (3 == intSelectNo) {

					mDao.DELETE();

				} else if (4 == intSelectNo) {

					mDao.SELECT();

				} else if (5 == intSelectNo) {

					mDao.Login();

				} else if (6 == intSelectNo) {

					System.out.println("종료");

					break;

				}

			} catch (Exception e) {
				continue;
			}

		}
	}
}
