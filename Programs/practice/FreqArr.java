import java.util.*;

class FreqArr{


        public static void main(String[] args){


                Scanner sc = new Scanner(System.in);
                System.out.println("Enter size of arr : ");
                int n = sc.nextInt();
                
                System.out.println("Enter ele of arr : ");

                int[] arr = new int[n];

                for(int i = 0; i < n; i++){

                    arr[i] = sc.nextInt();
                }

                boolean[] visited = new boolean[n];

                for(int i = 0; i < n; i++){

                    if(visited[i]){

                        continue;
                    }

                    int count = 1;

                    for(int j = i + 1; j < n; j++){

                            if(arr[j] == arr[i]){

                                count++;
                                visited[j] = true;
                            }
                    }
                    
                    System.out.println("-------------------------");
                    System.out.println("Element : " + arr[i] + "\t" + " his freq in arr : " + count);
                }
        }    


}