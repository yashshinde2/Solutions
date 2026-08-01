class RangeSum{

    public static void main(String[] args){

        int arr[]={2,4,6,8};

        int prefix[]=new int[arr.length];

        prefix[0]=arr[0];

        for(int i=1;i<arr.length;i++){

            prefix[i]=prefix[i-1]+arr[i];

        }

        // for(int x:prefix){

        //     System.out.print(x+" ");

        // }

        int left = 1;
        int right = 3;

        int sum = 0;

        if(left == 0){

            sum = prefix[right];
        }

        else{

            sum = prefix[right] - prefix[left - 1];
        }

        System.out.println("Range sum is : " + sum); 
    }
    
}