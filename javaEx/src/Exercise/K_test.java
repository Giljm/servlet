package Exercise;

import java.util.Random;
import java.util.Scanner;

// 사용자가 임의의 수를 입력하면, 입력된 수의 각 자릿수의 합
// 예) 임의의 수 12345를 입력할 경우
// 출력 : 15(풀이 : 1 + 2 + 3 + 4 + 5)

public class K_test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print(">> ");
		int userInput = scan.nextInt();
		int sum = 0;

		while (userInput > 0) {
			sum = sum + userInput  % 10;
			userInput = userInput / 10;
			System.out.println(sum);
		}
		
		System.out.println(sum);
		
		
//		int num1 = num / 100 % 100; // 첫 째 자리
//		int num2 = num / 10 % 10;// 둘 째 자리
//		int num3 = num % 10; // 셋 째 자리
//		int num4 = num1 + num2 + num3;
//		
//		System.out.println(num);
//		System.out.println("합 : " + num4 + "\n풀이 : " + num1 + " + " + num2 + " + " + num3);

	}

}
