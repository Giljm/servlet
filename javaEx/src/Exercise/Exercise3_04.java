package Exercise;

import java.util.Random;

// 변수 num의 값(임의의 수) 중에서 백의 자리 이하를 버리는 코드를 작성하시오.
// 예) 변수 num의 값이 456이라면 400이 되고, 111이라면 100이 됨.

public class Exercise3_04 {

	public static void main(String[] args) {

		int num = 0;
		Random rnd = new Random();

		num = rnd.nextInt(900) + 101;

		System.out.println(num);

		System.out.println(num / 100 + "00");

	}

}
