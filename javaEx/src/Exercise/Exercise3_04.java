package Exercise;

import java.util.Random;

// ���� num�� ��(������ ��) �߿��� ���� �ڸ� ���ϸ� ������ �ڵ带 �ۼ��Ͻÿ�.
// ��) ���� num�� ���� 456�̶�� 400�� �ǰ�, 111�̶�� 100�� ��.

public class Exercise3_04 {

	public static void main(String[] args) {

		int num = 0;
		Random rnd = new Random();

		num = rnd.nextInt(900) + 101;

		System.out.println(num);

		System.out.println(num / 100 + "00");

	}

}
