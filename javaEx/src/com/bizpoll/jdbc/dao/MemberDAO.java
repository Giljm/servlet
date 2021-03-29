package com.bizpoll.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bizpoll.jdbc.dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";
	Scanner sc = new Scanner(System.in);
	MemberDTO mDto = new MemberDTO();

	public void INSERT() {

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

		mDto.setNo(no);
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setAddr(addr);
		mDto.setPhone(phone);

		sc.close();

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

		if (succ == 1) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}

	}

	public void UPDATE() {

		System.out.print("업데이트를 실행할 회원 번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();

		System.out.print("업데이트 이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.print("업데이트 나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("업데이트 주소를 입력하세요 : ");
		String addr = sc.nextLine();

		System.out.print("업데이트 휴대폰 번호를 입력하세요 : ");
		String phone = sc.nextLine();

		System.out.println(no + " " + name + " " + age + " " + addr + " " + phone);

		mDto.setNo(no);
		mDto.setName(name);
		mDto.setAge(age);
		mDto.setAddr(addr);
		mDto.setPhone(phone);

		int succ = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "UPDATE tblMember " + "SET no = ?, name = ?, age = ?, addr = ?, phone = ? " + "WHERE no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());
			pstmt.setInt(6, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void DELETE() {

		int succ = 0;

		System.out.print("삭제할 회원의 번호를 입력하세요 : ");
		String updateno = sc.nextLine();

		while (true) {
			try {

				sc.close();

				System.out.println("삭제한 회원의 번호 : " + updateno);

				int upno = Integer.valueOf(updateno);
				mDto.setNo(upno);

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, user, pw);
				System.out.println("DB에 접속하셨습니다.");

				String sql = "DELETE FROM tblMember " + "WHERE no = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, mDto.getNo());
				succ = pstmt.executeUpdate();

				System.out.println(">> " + succ);

			} catch (Exception e) {
				System.out.println("정수만 입력하세요");
				continue;
			}

			if (succ > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
				break;
			}

		}

	}

	public void SELECT() {

		
		
		
	}

}
