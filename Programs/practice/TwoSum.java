class TwoSum{

    public static void main(String[] args){

        int[] arr = {3, 2, 4};
        int Target = 6;

        for(int i = 0; i < arr.length; i++){

            for(int j = i + 1; j < arr.length; j++){

                if((arr[i] + arr[j]) == Target){

                    System.out.println(i + " " + " " + j);
                    
                }
            }
        }
    }
}