package Exercise;

import java.util.Random;

// ���� num�� ��(������ ��) �߿��� ���� �ڸ��� 1�� �ٲٴ� �ڵ带 �ۼ��Ͻÿ�.
// ��) ���� num�� ���� 333�̶�� 331�� �ǰ�, 777�̶�� 771�� ��

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
