package Exercise;

import java.io.IOException;
import java.util.Scanner;

/*
 * Ű����κ��� �Է¹��� ������ ���� ch�� ������(�빮�� �Ǵ� �ҹ���)
 * �̰ų� ������ ���� ���� result�� ���� true�� �ǵ��� �ϴ� �ڵ带 �ۼ��Ͻÿ�
 */

public class Exercise3_09 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("���ڸ� �Է��� �ּ��� : ");
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