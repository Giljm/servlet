package Exercise;

import java.util.Random;

public class Exercise4_5 {

	// �� ���� �ֻ����� ������ ��, ���� ���� 6�� �Ǵ� ��� ����� ����
	// ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	// ex)) 1 + 5 = 6
	// 2 + 4 = 6
	// 3 + 3 = 6
	public static void main(String[] args) {

		for (int i = 1; i <= 6; i++) {

			for (int j = 1; j <= 6; j++) {

				if (i + j == 6) {

					System.out.println(i + " + " + j + " = " + (i + j));
					
				}

			}
			
		}
		
		
//		�������� �ϴ� �ڵ�
//		for���ȿ� true ����ؼ� ���� �ݺ�
//		Random rnd = new Random();
//		num = 0;
//		int dice1 = rnd.nextInt(5) + 1;
//		int dice2 = rnd.nextInt(5) + 1;
//
//		for (int i = 0; true; i++) {
//			num = dice1 + dice2;
//			if (num == 6) {
//				System.out.println(num);
//				break;
//			}
//		}

		

	}

}
