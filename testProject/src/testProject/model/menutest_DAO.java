package testProject.model;

import java.util.Scanner;

public class menutest_DAO {

	private Scanner scan;
	// ��ĳ�� Ŭ������ ����ؼ� scan ��ü�� ����

	public menutest_DAO() {
		scan = new Scanner(System.in);
	}

	public Integer menuService() {

		while (true) {
			System.out.println("======================================");
			System.out.println("=== ��� ===");
			System.out.println("--------------------------------------");
			System.out.println("1. �μ�Ʈ");
			System.out.println("2. ������Ʈ");
			System.out.println("3. ��ȸ");
			System.out.println("4. ����Ʈ");
			System.out.println("QUIT. ������");
			System.out.println("======================================");

			try {
				System.out.print("��ɾ� �Է� >> ");
				String strMenu = scan.nextLine();
				// �Է��ؼ� strMenu�� ����

				if (strMenu.equals("QUIT")) {
					// �Է��ؼ� ����� strMenu�� QUIT�� ������ ��
					System.out.println("����");
					break;
					// while�� ������ �ֱ� ������
					// ���� �޼��� ����ϰ� break;
				}

				int intMenu = Integer.valueOf(strMenu);
				// ���ڿ��� �Է��ϰ� �Ǹ� ���⿡�� ������ ��ȯ

				// 1 ~ 3 ���� �Է�
				if (intMenu >= 1 && intMenu <= 4) {
					return intMenu; // 1 ~ 4������ ���� �Է��ϸ� ��ȯ
				} else {
					System.out.println("\n���� ������ 1 ~ 4 ���� �߿� �����ϼ���\n");
					continue;
				}

			} catch (Exception e) {
				System.out.println("\n���� ������ QUIT(������), 1 ~ 4 ���� ������ �Է��� �� �ֽ��ϴ�.\n");
			} // �ƿ� Ʋ���� �Է��ص� �ٽ� �Է°���

		} // end while

		// 1 ~ 3�� �Է��� ��� ����ؼ� ���ο� ����

		return null;
		// return�� ���� while���� ���� ���� �������� ��ȯ
		// null = ��� ����

	}

}
