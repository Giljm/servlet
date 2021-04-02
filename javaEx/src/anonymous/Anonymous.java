package anonymous;

public class Anonymous {

	Person field = new Person() {
		String studentNo;

		void walk() {
			System.out.println("��մϴ�.");
		}

		@Override
		void wake() {
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			walk();
		};
	};

	void method1() {
		Person localVar = new Person() {
			String studentNo;

			void walk() {
				System.out.println("��å�մϴ�");
			}

			@Override
			void wake() {
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				walk();
			};
		};

		localVar.wake();
	}

	void method2(Person person) {
		person.wake();
	}
}