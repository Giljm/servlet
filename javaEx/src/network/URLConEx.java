package network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConEx {

	public URLConEx() {

		Scanner scanner = new Scanner(System.in);
		String code = null;

		System.out.print("�� �ּҸ� �Է��ϼ��� : ");
		String address = scanner.next();

		try {

			URL url = new URL(address);
			URLConnection con = url.openConnection();

			BufferedReader webData = new BufferedReader(new InputStreamReader(con.getInputStream()));
			// ���۴� ������ �ܾ���°� ����. ���� ���� ��� �����ٻ��̴�.
			// �ȿ� �Ű������� ���� �� �����´�.
			// ������ ���� �޾� ���� �𸣰ڴ�. �ּ� Ŭ������ �޾ƿͶ�.
			

			FileWriter fw = new FileWriter("D:\\java\\io\\file.html");
			// Ȯ���ڸ� html�� ��ƿ��� �о� �� ���� �ִ�.

			while ((code = webData.readLine()) != null) {
				// �󸶳� �����͸� ���� �� �� �˼��� ���⿡ while���� ����Ѵ�.
				// �����͸� �Ȱ��� �ö� ���߰� �ϱ� ���� != null�� ����

				fw.write(code);
				// code���� �о�� ���� �� �� ���� �����´�.

			}

			System.out.println(" The End ");

			fw.close();
			webData.close();
			// �ݴ°� ��������, �� ó�� ������ ���� �ݾ���� �Ѵ�.

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
