package Exercise;

/*
 * 1과 1부터 시작하는 피보나치수열의 10번째 수는 무엇인지 계산하는
 * 프로그램을 완성하시오
 * 피보나치(Fibonaci) 수열
 * 	: 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열
 * 
 * 예) 앞의 두 수가 1과 1이라면 그 다음수는 2가 되고 그 다음수는 1과 2를 더해서 3이 되어서
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
				System.out.println("\n10번째 : " + num3 + "\n");
			}

		}

	}

}
