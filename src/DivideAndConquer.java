import java.util.Arrays;
import java.util.Random;

public class DivideAndConquer {

    public static int sum(int[] arr, int l) {
        if (l == arr.length - 1) {
            return arr[l];
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void qsort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);

            qsort(arr, l, pivot - 1);
            qsort(arr, pivot + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int pivotStart = medianOfThree(arr, l, r);
        swap(arr, r, pivotStart);
        int pivotTarget = l;
        int pivotVal = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] < pivotVal) {
                swap(arr, i, pivotTarget);
                pivotTarget++;
            }
        }
        swap(arr, pivotTarget, r);
        return pivotTarget;
    }

    public static int medianOfThree(int[] arr, int l, int r) {
        int mid = (r + l) / 2;

        int biggest = biggest(arr, l, biggest(arr, mid, r));
        if (biggest == l) {
            return biggest(arr, mid, r);
        }
        if (biggest == r) {
            return biggest(arr, mid, l);
        }
        return biggest(arr, l, r);
    }

    public static int biggest(int[] arr, int a, int b) {
        if (arr[a] >= arr[b]) {
            return a;
        } else {
            return b;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int [] arr = new Random().ints(100000, 0, 199999999).toArray();
        qsort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
