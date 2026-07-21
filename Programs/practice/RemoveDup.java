import java.util.*;

class RemoveDup{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){

            arr[i] = sc.nextInt();

        }

        int[] newArr = new int[n];
        int size = 0;

        for(int i = 0; i < n; i++){

            int j;
            for(j = 0; j < size; j++){

                if(arr[i] == newArr[j]){

                    break;

                }

            }
                if(j == size){

                    newArr[size] = arr[i];
                    size++;

                 }
            }
            
        System.out.println("Array after removing duplicates : ");
        for(int i = 0; i < size; i++){

            System.out.print(newArr[i] + " ");

        }
    }
}