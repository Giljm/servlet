package testProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import testProject.model.ScoreDTO;

public class Score {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String strName = scan.nextLine();
		int intKor = scan.nextInt();
		int intEng = scan.nextInt();
		int intMath = scan.nextInt();

		List<ScoreDTO> list = new ArrayList<ScoreDTO>();

		ScoreDTO scoreDTO = new ScoreDTO(strName, intKor, intEng, intMath);
		list.add(scoreDTO);

		
		System.out.println(list.get(0));
	}

}
