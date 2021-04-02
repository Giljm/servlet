package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenericEx1 {

	public static void main(String[] args) {

		// 1.5�������� �̷��� ����ߴ�.
		List list1 = new ArrayList<>();
		list1.add("hello");

		String str1 = (String) list1.get(0);
		System.out.println(str1);

		// List�� generic < > ���̿��� ��ü�� ����.
		// �Ϲ������� �ϳ��� Ÿ�Ը� ������ ���� �ʱ� ������ DTO �Ǵ� VOŬ������ ����.
		List<String> list2 = new ArrayList<String>();
		list2.add("hello");

		String str2 = list2.get(0);
		System.out.println(str2);

		// Map ����
		// Map <key , value >
		Map<String, String> map = new HashMap<>();
		map.put("1", "������");
		map.put("2", "��ֺ�");
		map.put("3", "������");
		map.put("4", "������");
		map.put("5", "����ȣ");

		System.out.println(map);
		System.out.println(map.get("1"));

		
		
		// ��ĳ�ʸ� ����ؼ� �� ���� map�� ��ü���� ����
		// Ű���� ���� ���
		// �������� 1���� �ش�Ǵ� 
		Scanner scanner = new Scanner(System.in);
		System.out.print(">> ");
		String strname = scanner.next();

		map.put("1", strname);
		System.out.println(map.get("1"));

	}

}
