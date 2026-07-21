import sortingalgorithms.InsertionSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {2, 9, 1, 5, 7, 3};
        

        int[] sortedData = InsertionSort.sort(data);

        System.out.println("Sorted array is : " + Arrays.toString(sortedData));
    }
}

