package Exercise;

import java.util.Scanner;

/*
 * 대문자를 소문자로 변경하는 코드를 작성하시오
 * 단, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경
 * 힌트 : 문자코드는 소문자가 대문자보다 32만큼 큼
 * 예) 변수 ch에 'A'라는 대문자를 입력 받았을때 'a'로 출력
 */

public class Exercise3_10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print(">> ");
		char ch1 = scan.nextLine().charAt(0);

		int num = ch1;

		if (65 <= num && num <= 96) {
			num += 32;
		}

		char ch2 = (char) num;
		System.out.println(ch2);

		char lowerCase = ('A' <= ch1 && ch1 <= 'Z') ? (char) (ch1 + 32) : ch1;
		System.out.println(lowerCase);

// 1부터 100까지의 수중에서 3의 배수와 그 갯수를 출력하시오.
		int count = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0) {
				count ++;
				System.out.println(i);
			}

		}
		System.out.println(count);

	}
}
