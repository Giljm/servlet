package anonymous;

public class AnonymousMain {
   public static void main(String[] args) {
      Anonymous anonymous = new Anonymous(); // 객체생성
      
      anonymous.field.wake();
      
      System.out.println("==================");
      
      anonymous.method1();
      
      System.out.println("==================");
      
      anonymous.method2(new Person() {
         String studentNo;
         
         void study() {
            System.out.println("공부합니다.");
         }
         @Override
         void wake() {
            System.out.println("8시에 일어납니다.");
            study();
         };
      });
   }
   
}