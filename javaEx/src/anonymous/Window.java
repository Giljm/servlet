package anonymous;

public class Window {

	Button button1 = new Button();

	Button button2 = new Button();

	Button.OnClickListener listener = new Button.OnClickListener() {

		@Override
		public void onClick() {
			System.out.println("��ȭ�� �̴ϴ�.");
		}
	};

	public Window() {

		button1.setOnClickListener(listener);

		// java 1.7���� ���� �ּ�
		button2.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick() {

				System.out.println("�޼����� �����ϴ�.");

			}
		});

		// java8 Lambda
		button2.setOnClickListener(() -> {
			System.out.println("�޼����� �����ϴ�.");
		});

	}

}
