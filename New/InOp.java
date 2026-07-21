import java.util.Scanner;

class InOp{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age :");
        int age = sc.nextInt();

        sc.nextLine();
        
        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println(age + name);

    }
}