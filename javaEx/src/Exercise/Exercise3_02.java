package Exercise;

import java.util.Scanner;

public class Exercise3_02 {

	/*
	 * ����� ���� 123���̰� �ϳ��� �ٱ��Ͽ��� 10���� ����� ���� �� �ִٸ�, �� ���� �ٱ��ϰ� �ʿ����� �ڵ带 �ۼ��Ͻÿ�
	 */

	public static void main(String[] args) {

		int apple = 123;
		int basket = 10;
		int needbasket = apple / basket;

		int numOfBucket = apple / basket + (apple % basket > 0 ? 1 : 0); // ���׿�����

		System.out.println("�ʿ��� �ٱ��� ���� : " + numOfBucket + "��");

		if (apple / basket == 0) {

		} else {
			needbasket += 1;
			System.out.println("�ʿ��� �ٱ��� ���� : " + needbasket + "��");
		}

		if (apple % basket >= 1 && apple % basket <= 9) { // ����� �ٱ��ϸ� ���������� �������� 1 ~ 9 ������ ���̸� �ٱ��ϸ� +1 �ض�
			int allBasket = apple / basket + 1;
			System.out.println("�ʿ��� �ٱ��� ���� : " + allBasket + "��");

		}

	}

}
