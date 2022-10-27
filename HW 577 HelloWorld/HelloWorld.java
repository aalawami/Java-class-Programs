
import java.util.Scanner;
public class HelloWorld {
   public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);

      int a = myObj.nextInt();
      String s = myObj.nextLine();
      for(int i = 0; i < a; i++){
         if(myObj.hasNext()){ // avoids exception if a is more than the names given
       s = myObj.nextLine();
       System.out.println("Hello, " + s + "!");
         }
      }
   }
}