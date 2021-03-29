package testProject.model;

public class ScoreDTO {

	private String Name;
	private int Kor;
	private int Eng;
	private int Math;

	public ScoreDTO(String Name, int Kor, int Eng, int Math) {
		this.Name = Name;
		this.Kor = Kor;
		this.Eng = Eng;
		this.Math = Math;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getKor() {
		return Kor;
	}

	public void setKor(int kor) {
		Kor = kor;
	}

	public int getEng() {
		return Eng;
	}

	public void setEng(int eng) {
		Eng = eng;
	}

	public int getMath() {
		return Math;
	}

	public void setMath(int math) {
		Math = math;
	}

}
