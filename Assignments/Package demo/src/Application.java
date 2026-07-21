import java.util.Scanner;
import mypackage.Calculator;


public class Application {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number : ");
        int a=sc.nextInt();
        System.out.println("Enter the second number : ");
        int b=sc.nextInt();


        Calculator obj = new Calculator();
        System.out.println("The Addition of numbers is : "+obj.add(a,b));
        
        System.out.println("\nThe Subbstraction of numbers is : "+obj.sub(a, b));
        
        System.out.println("\nThe Division of numbers is : "+obj.div(a, b));
        
        System.out.println("\nThe Mod of numbers is : "+obj.mod(a, b));
      
    }
}   