package lambda;

public class LambdaDefaultExam {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.greeting(new Say() {
			
			@Override
			public void something() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
