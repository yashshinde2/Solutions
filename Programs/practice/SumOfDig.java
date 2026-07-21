import java.util.Scanner;

class SumOfDig{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num : ");
        int num = sc.nextInt();

        int sum = 0;

        while(num !=0){

            sum = sum + num % 10;
            num /= 10;
        }   
        System.out.println(sum);
    }
}