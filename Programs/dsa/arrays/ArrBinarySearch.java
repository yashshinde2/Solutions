class ArrBinarySearch{

    public static void main(String[] args){

        int[] arr = {10, 20, 30, 40 };

        int low = 0;
        int high = arr.length - 1;

        int key = 30;

        while(low <= high){

            int mid = (low+high) / 2;

            if(arr[mid] == key){

                System.out.println("Key Found : " + arr[mid]);
                return;
            }

            if(arr[mid] < key){

                low = mid + 1;

            }
            else{

                high = mid - 1;
            }
        }

        System.out.println("Not found...");
    
    }


}