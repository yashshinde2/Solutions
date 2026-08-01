class ClearBit{

    public static void main(String[] args) {
        
        int num = 7;
        int pos = 2;
        int bitMask = 1<<pos;

        int notBitMask = ~(bitMask);

        int newNumber = notBitMask & num;

        System.out.println(newNumber);


    }
}