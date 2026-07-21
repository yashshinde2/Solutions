import java.util.Scanner;

class Reverse{

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        long num = sc.nextLong();   

        Long rev = 0L;

        while(num != 0){

            rev = rev * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Reverse number : " + (rev));
    }
}