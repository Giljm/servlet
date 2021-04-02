package loginServece.main;

import java.util.Scanner;

public class loginMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String strTest = null;

		while (true) {

			System.out.print(">> ");
			strTest = sc.nextLine();

			if (strTest == null ) {

				System.out.println("∏ÿ√Á");

			} else if(strTest.equals("\n")) {
				
				System.out.println("§∑§∑");
				
			}

			System.out.println(strTest);

		}

	}
}