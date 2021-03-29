package Exercise;

// 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오
// 실행결과
// c = 30
// ch = C
// f = 1.5
// 1 = 27000000000
// result = true

public class Exercise3_08 {

	public static void main(String[] args) {

		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);

		char ch = 'A';
		ch = (char) (ch + 2);

		float f = 3 / 2f;
		long l = 3000 * 3000 * 3000L;

		float f2 = 0.1f;
		double d = 0.1;

		boolean result = (float) d == f2;

		System.out.println("c = " + c);
		System.out.println("ch = " + ch);
		System.out.println("f = " + f);
		System.out.println("l = " + l);
		System.out.println("result = " + result);

	}
}
