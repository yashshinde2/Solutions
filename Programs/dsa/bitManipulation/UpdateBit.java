import java.util.*;

class UpdateBit{

    public static void main(String[] args){

        int num = 3;
        int pos = 2;
        int bitMask = 1<<pos;

        System.out.println("Enter oper 1 or 0 to perform - ");
        
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();

        if(oper == 1){

            int newNumber = bitMask | num;
            System.out.println("Set Bit : " + newNumber);
        }
        else{

            int notBitMask = ~(bitMask);
            int newNumber = notBitMask & num;

            System.out.println("Clear bit : " + newNumber);
        }
    }
}