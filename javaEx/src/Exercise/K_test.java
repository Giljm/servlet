package Exercise;

import java.util.Random;
import java.util.Scanner;

// ����ڰ� ������ ���� �Է��ϸ�, �Էµ� ���� �� �ڸ����� ��
// ��) ������ �� 12345�� �Է��� ���
// ��� : 15(Ǯ�� : 1 + 2 + 3 + 4 + 5)

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
		
		
//		int num1 = num / 100 % 100; // ù ° �ڸ�
//		int num2 = num / 10 % 10;// �� ° �ڸ�
//		int num3 = num % 10; // �� ° �ڸ�
//		int num4 = num1 + num2 + num3;
//		
//		System.out.println(num);
//		System.out.println("�� : " + num4 + "\nǮ�� : " + num1 + " + " + num2 + " + " + num3);

	}

}
