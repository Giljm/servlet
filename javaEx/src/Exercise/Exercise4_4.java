package Exercise;

// 1 + (-2) + 3 + (-4) + ... 과 같은 식으로 계속 더해 나갔을때 몇 까지 더해야
// 총합이 100이상이 되는지 구하시오.

public class Exercise4_4 {

	public static void main(String[] args) {
		
		// 메소드안에 생성된 메서드는 언제 소멸될지 모른다.
		
		int sum = 0;
		int s = 1;
		int num = 0;
		
		
		//    초기화     조건식			 증감식블럭          
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

		System.out.println("답 :" + j);
		
		
		while (sum <= 100) {
			j++;
			if (sum > 0) {
				sum = -j;
			} else {
				sum = +j;
			}

		}

		System.out.println("답 :" + sum);

	}

}
