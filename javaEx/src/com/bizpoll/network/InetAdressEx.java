package com.bizpoll.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAdressEx {

	// IO객체를 활용할땐 반드시 예외처리를 해줘야 한다.
	// 데이터베이스를 연계하는 클래체선언스들을 사용하는 경우 반드시 예외처리를 해줘야한다.
	// 데이터를 전부다 받아 올때는 배열을 사용
	// 배열을 사용하면 향상된 for를 사용

	Scanner scanner;

	public InetAdressEx() {
		System.out.println("Host 이름을 입력해 주세요");

		scanner = new Scanner(System.in);

		try {
			InetAddress[] iaArr = InetAddress.getAllByName(scanner.next());

			System.out.println("이름 : " + iaArr[0].getHostName());

			for (InetAddress inetAddress2 : iaArr) {

				System.out.println("Address : " + inetAddress2.getHostAddress());

			}
			// Exception e : 예외 처리 끝판왕
		} catch (Exception e) {

			e.printStackTrace();

			System.out.println();
		}

	}

}
