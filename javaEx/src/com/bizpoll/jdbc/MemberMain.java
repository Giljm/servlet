package com.bizpoll.jdbc;

import java.util.List;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class MemberMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MemberSearch memSearch = new MemberSearch();

		System.out.print("검색 하실 회원번호를 입력해주세요 : ");
		int searchKey = sc.nextInt();

		List<MemberDTO> memList = memSearch.memSearch(searchKey);
		
		System.out.println("이거 >> " + memList);

		if (memList.size() > 0) {
			for (MemberDTO memberDTO : memList) {
				System.out.println("검색하신 회원 정보는 아래와 같습니다.");
			}
		} else {
			System.out.println("회원이 존재하지 않습니다.");
		}

	}

}
