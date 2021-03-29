package Exercise;

import java.util.Random;

public class Exercise4_5 {

	// 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를
	// 출력하는 프로그램을 작성하시오.
	// ex)) 1 + 5 = 6
	// 2 + 4 = 6
	// 3 + 3 = 6
	public static void main(String[] args) {

		for (int i = 1; i <= 6; i++) {

			for (int j = 1; j <= 6; j++) {

				if (i + j == 6) {

					System.out.println(i + " + " + j + " = " + (i + j));
					
				}

			}
			
		}
		
		
//		랜덤으로 하는 코드
//		for문안에 true 사용해서 무한 반복
//		Random rnd = new Random();
//		num = 0;
//		int dice1 = rnd.nextInt(5) + 1;
//		int dice2 = rnd.nextInt(5) + 1;
//
//		for (int i = 0; true; i++) {
//			num = dice1 + dice2;
//			if (num == 6) {
//				System.out.println(num);
//				break;
//			}
//		}

		

	}

}
