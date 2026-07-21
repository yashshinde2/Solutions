import java.util.*;

class RevArr{

    public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter size of arr : ");
      int n = sc.nextInt();
                
      System.out.println("Enter ele of arr : ");

      int[] arr = new int[n];

      for(int i = 0; i < n; i++){

         arr[i] = sc.nextInt();
        }
      
      int start = 0;
      int end = n - 1;

      while(start < end){

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;

      }

      System.out.println("Reversed array is : " );
      
      for(int i = 0; i < n; i++){

            System.out.println(arr[i] + " ");
      }


    }
}