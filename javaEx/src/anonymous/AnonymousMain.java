package anonymous;

public class AnonymousMain {
   public static void main(String[] args) {
      Anonymous anonymous = new Anonymous(); // ��ü����
      
      anonymous.field.wake();
      
      System.out.println("==================");
      
      anonymous.method1();
      
      System.out.println("==================");
      
      anonymous.method2(new Person() {
         String studentNo;
         
         void study() {
            System.out.println("�����մϴ�.");
         }
         @Override
         void wake() {
            System.out.println("8�ÿ� �Ͼ�ϴ�.");
            study();
         };
      });
   }
   
}