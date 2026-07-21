import java.util.*;

class PalindromeNum{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num : ");
        int num = sc.nextInt();

        int rev = 0;

        int og = num;

        while(num != 0){

            rev = rev * 10 + num % 10;
            num /= 10;
        }

        System.out.println(rev);

        if(rev == og){

            System.out.println("Palindrome...");
        }
        else{

            System.out.println("Not");
        }
    }
}