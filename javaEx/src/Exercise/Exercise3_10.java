package Exercise;

import java.util.Scanner;

/*
 * �빮�ڸ� �ҹ��ڷ� �����ϴ� �ڵ带 �ۼ��Ͻÿ�
 * ��, ���� ch�� ����� ���ڰ� �빮���� ��쿡�� �ҹ��ڷ� ����
 * ��Ʈ : �����ڵ�� �ҹ��ڰ� �빮�ں��� 32��ŭ ŭ
 * ��) ���� ch�� 'A'��� �빮�ڸ� �Է� �޾����� 'a'�� ���
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

// 1���� 100������ ���߿��� 3�� ����� �� ������ ����Ͻÿ�.
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
