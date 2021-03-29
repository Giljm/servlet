package Exercise;

import java.util.Random;

// 변수 num의 값(임의의 수) 중에서 일의 자리를 1로 바꾸는 코드를 작성하시오.
// 예) 변수 num의 값이 333이라면 331이 되고, 777이라면 771이 됨

public class Exercise3_05 {

	public static void main(String[] args) {

		Random rnd = new Random();
		int num = rnd.nextInt(900) + 100;

		System.out.println(num);
		System.out.println(num / 10 + "1");
		System.out.println("==================");
		System.out.println(num / 10 * 10 + 1);

	}

}
