class SetBit{

    public static void main(String[] args) {

        int num = 5;
        int pos = 3;
        int bitMask = 1<<pos;

        int newNumber = bitMask | num;

        System.out.println(newNumber);  

    }
}