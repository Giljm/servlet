package Exercise;

/*
 * 1�� 1���� �����ϴ� �Ǻ���ġ������ 10��° ���� �������� ����ϴ�
 * ���α׷��� �ϼ��Ͻÿ�
 * �Ǻ���ġ(Fibonaci) ����
 * 	: ���� �� ���� ���ؼ� ���� ���� ����� ������ ����
 * 
 * ��) ���� �� ���� 1�� 1�̶�� �� �������� 2�� �ǰ� �� �������� 1�� 2�� ���ؼ� 3�� �Ǿ
 * 		0, 1, 1, 2, 3, 5, 8, 13, 21...
 */

public class Exercise4_11 {

	public static void main(String[] args) {

		int i = 1;
		int j = 0;
		int num = 0;
		int count = 0;

		while (100 > i) {
			num = i + j;
			System.out.println(num);
			j = num + i;
			System.out.println(j);
			i = num + j;
			System.out.println(i);

		}

		int num1 = 1;
		int num2 = 0;
		int num3 = 0;
		int count1 = 0;

		for (int a = 0; a < 12; a++) {
			count1++;
			num3 = num1 + num2;
			System.out.print(", " + num3);

			num1 = num2;
			num2 = num3;

			if (count1 == 10) {
				System.out.println("\n10��° : " + num3 + "\n");
			}

		}

	}

}
