class ArrayInsertion{

    public static void main(String[] args) {

        int[] arr = new int[10];

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 40;
        arr[3] = 50;

        int size = 4;
        int position = 2;
        int value = 30;

        for(int i = size; i > position; i--){

            arr[i] = arr[i-1];
        }  

        arr[position] = value;

        for(int i = 0; i < arr.length; i++){

            System.out.println(arr[i] + " ");
        }

    }
}