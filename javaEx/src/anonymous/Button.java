package anonymous;

public class Button {

	// �ʵ� Ÿ������ ��ø �������̽� Ÿ���� ����
	OnClickListener listener;

	// Ŭ���� �������̽�
	// �Ű������� �������̽� Ÿ���� �Ǹ� �پ��� ���� ��ü�� �� �� ����(�Ű� ������ ������)
	void setOnClickListener(OnClickListener listener) {

		this.listener = listener;

	}

	void touch() {

		listener.onClick();

	}

	// ��ø �������̽� ����� �ٱ� Ŭ������ ���� �����ϰ� �ܺο��� ������� �ʰ� ���ο����� ����� ��
	interface OnClickListener {

		void onClick();

	}

}
