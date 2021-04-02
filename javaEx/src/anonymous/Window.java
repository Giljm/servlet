package anonymous;

public class Window {

	Button button1 = new Button();

	Button button2 = new Button();

	Button.OnClickListener listener = new Button.OnClickListener() {

		@Override
		public void onClick() {
			System.out.println("전화를 겁니다.");
		}
	};

	public Window() {

		button1.setOnClickListener(listener);

		// java 1.7까지 쓰던 최선
		button2.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick() {

				System.out.println("메세지를 보냅니다.");

			}
		});

		// java8 Lambda
		button2.setOnClickListener(() -> {
			System.out.println("메세지를 보냅니다.");
		});

	}

}
