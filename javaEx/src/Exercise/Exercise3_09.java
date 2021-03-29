package Exercise;

import java.io.IOException;
import java.util.Scanner;

/*
 * 키보드로부터 입력받은 문자형 변수 ch가 영문자(대문자 또는 소문자)
 * 이거나 숫자일 때만 변수 result의 값이 true가 되도록 하는 코드를 작성하시오
 */

public class Exercise3_09 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("문자를 입력해 주세요 : ");
		char ch = scan.nextLine().charAt(0);
		scan.close();

		boolean result = ('a' <= ch && ch <= 'z')
				|| ('A' <= ch && ch <= 'Z')
				|| ('0' <= ch && ch <= '9');
		System.out.println(result);

		
		
		
//		System.out.print(">> ");
//		try {
//			ch = (char) System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String result = "false";
//
//		if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
//			result = "true";
//		} else if (ch >= 0 || ch <= 1000000000) {
//			result = "true";
//		}
//		System.out.println(result);
//
//	}

	}
}