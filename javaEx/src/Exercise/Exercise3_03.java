package Exercise;

import java.util.Random;

// 변수 num의 값(임의의 수)에 따라 "양수","음수" ,
// '0' (num값이 0일 경우)을
// 출력하는 코드를 작성하시오 (단, 삼항 연산자를 이용해서 작성할 것)

public class Exercise3_03 {

	public static void main(String[] args) {
		
		Integer num1 = null;
		System.out.println(14 + 12);

		int num = 0;
		Random rnd = new Random();
		num = rnd.nextInt(100) - 50;

		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : " 0"));

		System.out.println("===============================");

		String result = (num > 0 ? "양수" : "음수");

		if (num == 0) {
			result = "0";
		}

		System.out.println(result);

		System.out.println("===============================");

		if (result.equals("양수")) {
			System.out.println(num + "은 양수");
		} else if (num == 0) {
			System.out.println(num + "은 0");
		} else {
			System.out.println(num + "은 음수");
		}

	}

}
