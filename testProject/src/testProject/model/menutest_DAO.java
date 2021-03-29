package testProject.model;

import java.util.Scanner;

public class menutest_DAO {

	private Scanner scan;
	// 스캐너 클래스를 사용해서 scan 객체를 선언

	public menutest_DAO() {
		scan = new Scanner(System.in);
	}

	public Integer menuService() {

		while (true) {
			System.out.println("======================================");
			System.out.println("=== 기능 ===");
			System.out.println("--------------------------------------");
			System.out.println("1. 인서트");
			System.out.println("2. 업데이트");
			System.out.println("3. 조회");
			System.out.println("4. 딜리트");
			System.out.println("QUIT. 끝내기");
			System.out.println("======================================");

			try {
				System.out.print("명령어 입력 >> ");
				String strMenu = scan.nextLine();
				// 입력해서 strMenu에 저장

				if (strMenu.equals("QUIT")) {
					// 입력해서 저장된 strMenu와 QUIT가 같는지 비교
					System.out.println("종료");
					break;
					// while로 묶어져 있기 때문에
					// 종료 메세지 출력하고 break;
				}

				int intMenu = Integer.valueOf(strMenu);
				// 문자열로 입력하게 되면 여기에서 정수로 변환

				// 1 ~ 3 값을 입력
				if (intMenu >= 1 && intMenu <= 4) {
					return intMenu; // 1 ~ 4사이의 값을 입력하면 반환
				} else {
					System.out.println("\n업무 선택은 1 ~ 4 까지 중에 선택하세요\n");
					continue;
				}

			} catch (Exception e) {
				System.out.println("\n업무 선택은 QUIT(끝내기), 1 ~ 4 까지 정수만 입력할 수 있습니다.\n");
			} // 아예 틀린걸 입력해도 다시 입력가능

		} // end while

		// 1 ~ 3을 입력할 경우 통과해서 메인에 전달

		return null;
		// return을 통해 while에서 나온 값을 메인으로 반환
		// null = 비어 있음

	}

}
