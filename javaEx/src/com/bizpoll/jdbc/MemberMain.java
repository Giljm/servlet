package com.bizpoll.jdbc;

import java.util.List;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class MemberMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MemberSearch memSearch = new MemberSearch();

		System.out.print("�˻� �Ͻ� ȸ����ȣ�� �Է����ּ��� : ");
		int searchKey = sc.nextInt();

		List<MemberDTO> memList = memSearch.memSearch(searchKey);
		
		System.out.println("�̰� >> " + memList);

		if (memList.size() > 0) {
			for (MemberDTO memberDTO : memList) {
				System.out.println("�˻��Ͻ� ȸ�� ������ �Ʒ��� �����ϴ�.");
			}
		} else {
			System.out.println("ȸ���� �������� �ʽ��ϴ�.");
		}

	}

}
