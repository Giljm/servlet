package com.bizpoll.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAdressEx {

	// IO��ü�� Ȱ���Ҷ� �ݵ�� ����ó���� ����� �Ѵ�.
	// �����ͺ��̽��� �����ϴ� Ŭ��ü���𽺵��� ����ϴ� ��� �ݵ�� ����ó���� ������Ѵ�.
	// �����͸� ���δ� �޾� �ö��� �迭�� ���
	// �迭�� ����ϸ� ���� for�� ���

	Scanner scanner;

	public InetAdressEx() {
		System.out.println("Host �̸��� �Է��� �ּ���");

		scanner = new Scanner(System.in);

		try {
			InetAddress[] iaArr = InetAddress.getAllByName(scanner.next());

			System.out.println("�̸� : " + iaArr[0].getHostName());

			for (InetAddress inetAddress2 : iaArr) {

				System.out.println("Address : " + inetAddress2.getHostAddress());

			}
			// Exception e : ���� ó�� ���ǿ�
		} catch (Exception e) {

			e.printStackTrace();

			System.out.println();
		}

	}

}
