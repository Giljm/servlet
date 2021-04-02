package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenericEx1 {

	public static void main(String[] args) {

		// 1.5이전에는 이렇게 사용했다.
		List list1 = new ArrayList<>();
		list1.add("hello");

		String str1 = (String) list1.get(0);
		System.out.println(str1);

		// List의 generic < > 사이에는 객체가 들어간다.
		// 일반적으로 하나의 타입만 지정을 하지 않기 때문에 DTO 또는 VO클래스가 들어간다.
		List<String> list2 = new ArrayList<String>();
		list2.add("hello");

		String str2 = list2.get(0);
		System.out.println(str2);

		// Map 사용법
		// Map <key , value >
		Map<String, String> map = new HashMap<>();
		map.put("1", "범나은");
		map.put("2", "김솔빈");
		map.put("3", "김태인");
		map.put("4", "유지수");
		map.put("5", "구연호");

		System.out.println(map);
		System.out.println(map.get("1"));

		
		
		// 스캐너를 사용해서 그 값을 map의 객체값에 전달
		// 키값을 통해 출력
		// 위에서는 1번에 해당되는 
		Scanner scanner = new Scanner(System.in);
		System.out.print(">> ");
		String strname = scanner.next();

		map.put("1", strname);
		System.out.println(map.get("1"));

	}

}
