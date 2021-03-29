package com.bizpoll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class Ex09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("회원 번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("주소를 입력하세요 : ");
		String addr = sc.nextLine();

		System.out.print("휴대폰 번호를 입력하세요 : ");
		String phone = sc.nextLine();

		sc.close();

		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

		MemberDTO mDto = new MemberDTO(no, name, age, addr, phone);
		// 메소드는 외부의 데이터를 유일하게 받아 올 수 있는 거.
		int result = memInsert(mDto);

		if (result > 0) {

			System.out.println("등록 성공");

		} else {

			System.out.println("등록 실패");

		}

	}

	private static int memInsert(MemberDTO mDto) {
		// MemberDto mDto를 메서드의 매개변수로 받는다.

		String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
		String user = "scott";
		String pw = "1234";

		int succ = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
		return 1;
	}

}
