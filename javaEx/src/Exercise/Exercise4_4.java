package Exercise;

// 1 + (-2) + 3 + (-4) + ... �� ���� ������ ��� ���� �������� �� ���� ���ؾ�
// ������ 100�̻��� �Ǵ��� ���Ͻÿ�.

public class Exercise4_4 {

	public static void main(String[] args) {
		
		// �޼ҵ�ȿ� ������ �޼���� ���� �Ҹ���� �𸥴�.
		
		int sum = 0;
		int s = 1;
		int num = 0;
		
		
		//    �ʱ�ȭ     ���ǽ�			 �����ĺ�          
		for (int i = 1; true; i++, s = -s) {
			num = s * i;
			sum += num;
			
			if (sum >= 100) {
				break;
			}
			
		}
		System.out.println("sum = " + num);
		System.out.println("sum = " + sum);
		
		
		int j = 0;
		while (sum <= 100) {
			j++;
			if (j % 2 == 0) {
				sum = -j;
			} else {
				sum = +j;
			}

		}

		System.out.println("�� :" + j);
		
		
		while (sum <= 100) {
			j++;
			if (sum > 0) {
				sum = -j;
			} else {
				sum = +j;
			}

		}

		System.out.println("�� :" + sum);

	}

}
