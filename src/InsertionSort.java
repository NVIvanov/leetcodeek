import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        //// 5 7 6
        for (int i = 0; i < array.length; i++) {
            int max_i = i;
            for (int j = i; j < array.length; j++) {
                if (array[max_i] < array[j]) {
                    max_i = j;
                }
            }
            int tmp = array[i];
            array[i] = array[max_i];
            array[max_i] = tmp;
        }
    }

    public static void main(String[] args) {

        for (int i = 2; i <= 20; i++) {
            int[] arr = new Random().ints(i).toArray();
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
