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

		System.out.print("웹 주소를 입력하세요 : ");
		String address = scanner.next();

		try {

			URL url = new URL(address);
			URLConnection con = url.openConnection();

			BufferedReader webData = new BufferedReader(new InputStreamReader(con.getInputStream()));
			// 버퍼는 실제로 긁어오는건 없다. 단지 성능 향상만 도와줄뿐이다.
			// 안에 매개변수로 생성 및 가져온다.
			// 변수를 뭘로 받아 올지 모르겠다. 최소 클래스로 받아와라.
			

			FileWriter fw = new FileWriter("D:\\java\\io\\file.html");
			// 확장자를 html로 잡아오면 읽어 올 수가 있다.

			while ((code = webData.readLine()) != null) {
				// 얼마나 데이터를 가져 올 지 알수가 없기에 while문을 사용한다.
				// 데이터를 안가져 올때 멈추게 하기 위해 != null을 설정

				fw.write(code);
				// code에서 읽어온 것을 한 줄 한줄 가져온다.

			}

			System.out.println(" The End ");

			fw.close();
			webData.close();
			// 닫는건 역순으로, 맨 처음 실행한 것을 닫아줘야 한다.

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
