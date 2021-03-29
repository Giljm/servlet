package Exercise;

import java.util.Scanner;

public class Exercise3_02 {

	/*
	 * 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 몇 개의 바구니가 필요한지 코드를 작성하시오
	 */

	public static void main(String[] args) {

		int apple = 123;
		int basket = 10;
		int needbasket = apple / basket;

		int numOfBucket = apple / basket + (apple % basket > 0 ? 1 : 0); // 삼항연산자

		System.out.println("필요한 바구니 갯수 : " + numOfBucket + "개");

		if (apple / basket == 0) {

		} else {
			needbasket += 1;
			System.out.println("필요한 바구니 갯수 : " + needbasket + "개");
		}

		if (apple % basket >= 1 && apple % basket <= 9) { // 사과의 바구니를 나누었을때 남은값이 1 ~ 9 사이의 값이면 바구니를 +1 해라
			int allBasket = apple / basket + 1;
			System.out.println("필요한 바구니 갯수 : " + allBasket + "개");

		}

	}

}
