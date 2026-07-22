import java.util.*;

class TwoDArrays{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows and columns : ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] nums = new int[rows][cols];

        System.out.println("Enter elements of Array : ");

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){

                nums[i][j] = sc.nextInt();
            }
        }


        System.out.println("Enter a target num to search : ");

        int target = sc.nextInt();

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){

                if(target == nums[i][j]){

                    System.out.println("Target is found at position : " + i + " " + j);
                }
                else{

                    System.out.println("Target not found...");
                }
            }
        }

/**
        System.out.println("Array is : ");

        for(int i = 0; i < rows; i++){

            for(int j=0; j < cols; j++){

                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    **/

    } 
}