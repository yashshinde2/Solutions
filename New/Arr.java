import java.util.Arrays;

class Arr{

    public static void main(String[] args){

        int[] marks = {100, 98 , 99};
        int[][] finalMarks = {{90, 99, 88}, {99, 95, 90}};

        System.out.println(marks[0]);
        Arrays.sort(marks);
        System.out.println(marks[0]); 

        System.out.println(finalMarks[0][1]);          

    }
}