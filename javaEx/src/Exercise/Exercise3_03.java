package Exercise;

import java.util.Random;

// ���� num�� ��(������ ��)�� ���� "���","����" ,
// '0' (num���� 0�� ���)��
// ����ϴ� �ڵ带 �ۼ��Ͻÿ� (��, ���� �����ڸ� �̿��ؼ� �ۼ��� ��)

public class Exercise3_03 {

	public static void main(String[] args) {
		
		Integer num1 = null;
		System.out.println(14 + 12);

		int num = 0;
		Random rnd = new Random();
		num = rnd.nextInt(100) - 50;

		System.out.println(num > 0 ? "���" : (num < 0 ? "����" : " 0"));

		System.out.println("===============================");

		String result = (num > 0 ? "���" : "����");

		if (num == 0) {
			result = "0";
		}

		System.out.println(result);

		System.out.println("===============================");

		if (result.equals("���")) {
			System.out.println(num + "�� ���");
		} else if (num == 0) {
			System.out.println(num + "�� 0");
		} else {
			System.out.println(num + "�� ����");
		}

	}

}
