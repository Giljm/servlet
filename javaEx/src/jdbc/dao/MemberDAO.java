package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import common.DBManager;
import jdbc.dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@192.168.4.5:1521:xe";
	String user = "scott";
	String pw = "1234";
	Scanner sc = new Scanner(System.in);
	MemberDTO mDto = new MemberDTO();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

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

			con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "INSERT INTO tblMember VALUES (?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {

			DBManager.close(con, pstmt);

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

			con = DriverManager.getConnection(url, user, pw);

			System.out.println("DB에 접속하셨습니다.");

			String sql = "UPDATE tblMember " + "SET no = ?, name = ?, age = ?, addr = ?, phone = ? " + "WHERE no = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mDto.getNo());
			pstmt.setString(2, mDto.getName());
			pstmt.setInt(3, mDto.getAge());
			pstmt.setString(4, mDto.getAddr());
			pstmt.setString(5, mDto.getPhone());
			pstmt.setInt(6, mDto.getNo());

			succ = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {

			DBManager.close(con, pstmt);

		}
	}

	public void DELETE() {

		int succ = 0;
		MemberDTO mDto = new MemberDTO();

		while (true) {

			System.out.print("삭제할 회원의 번호를 입력하세요 : ");
			String strUpno = sc.nextLine();

			try {
				int upno = Integer.valueOf(strUpno);
				mDto.setNo(upno); // 스캐너로 받은 데이터를 set으로 입력

				System.out.println("삭제한 회원의 번호 : " + upno);

				Class.forName("oracle.jdbc.driver.OracleDriver"); // try
				con = DriverManager.getConnection(url, user, pw); // try
				System.out.println("DB에 접속하셨습니다.");

				String sql = "DELETE FROM tblMember " + "WHERE no = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, mDto.getNo());
				succ = pstmt.executeUpdate();

				System.out.println(">> " + succ);

			} catch (Exception e) {
				System.out.println("정수만 입력하세요");
				continue;
			} finally {
				DBManager.close(con, pstmt);

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

		int rsNo = 0;
		String rsName = null;
		int rsAge = 0;
		String rsAddr = null;
		String rsPhone = null;

		while (true) {
			System.out.print("조회할 회원 이름 입력 >> ");
			String strName = sc.nextLine();

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, pw); // try

				String sql = "SELECT * " + "FROM tblmember " + "WHERE name LIKE ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, "%" + strName + "%");
				rs = pstmt.executeQuery();

				while (rs.next()) {

					rsNo = rs.getInt("no");
					rsName = rs.getString("name");
					rsAge = rs.getInt("age");
					rsAddr = rs.getString("addr");
					rsPhone = rs.getString("phone");

				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				DBManager.close(con, pstmt, rs);

			}

			if (strName.equals(rsName)) {

				System.out.println("회원 번호 : " + rsNo);
				System.out.println("이름 : " + rsName);
				System.out.println("나이 : " + rsAge);
				System.out.println("주소지 : " + rsAddr);
				System.out.println("휴대폰 번호 : " + rsPhone);

				break;

			} else {

				System.out.println("데이터가 없습니다.");
				continue;
			}

		}
	}

	public void Login() {

		int rsNo = 0;
		String stNo = null;
		String rsName = null;

		while (true) {
			System.out.print("회원번호 입력 >> ");
			String strId = sc.nextLine();

			System.out.print("이름 입력 >> ");
			String strName = sc.nextLine();

			try {

				DBManager.getConnection();

				String sql = "SELECT no, name " + "FROM tblMember " + "WHERE no = ? AND name = ?";
				pstmt = con.prepareStatement(sql);

				int intId = Integer.valueOf(strId);
				pstmt.setInt(1, intId);
				pstmt.setString(2, strName);
				rs = pstmt.executeQuery();

				while (rs.next()) { // 데이터가 여러개 일대 리스트 형식으로 받아 와야한다

					rsNo = rs.getInt("no");
					stNo = Integer.toString(rsNo);
					rsName = rs.getString("name");
				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				DBManager.close(con, pstmt, rs);

			}

			if (strId.equals(stNo) && strName.equals(rsName)) {

				System.out.println(rsName + " 님 로그인 하셨습니다.");
				break;

			} else {

				System.out.println("로그인 실패");
				continue;
			}

		}
	}
}
