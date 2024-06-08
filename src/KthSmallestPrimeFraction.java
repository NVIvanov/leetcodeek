import java.util.*;

public class KthSmallestPrimeFraction {

    /**
     *
     * 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3
     *
     * 6/30, 10/30, 12/30, 15/30, 18/30, 20/30
     *
     * 1*(2*3*5/5)/30, 1*(2*3*5/3)/30, 2*(2*3*5/5)/30, 3*5/30, 2*3*3/30, 2
     *
     *     2            3         5           7          11         13
     * 1  1/2 - 15  1/3 - 10   1/5 - 6    1/7 - 3     1/11 - 2     1/13 - 1
     * 2            2/3 - 19   2/5 - 12   2/7 - 9     2/11 - 5     2/13 - 4
     * 3                       3/5 - 17   3/7 - 13    3/11 - 8     3/13 - 7
     * 5                                  5/7 - 20    5/11 - 14    5/13 - 11
     * 7                                              7/11 - 18    7/13 - 16
     * 11                                                          11/13- 21
     */

//    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//
//    }

    public static void main(String[] args) {
        //                  q = [1/13]
        //                  candidates - 1/11, 2/13
        //                  q = [1/13, 1/11]
        //                    l                  r
        int[] arr = new int[]{1, 2, 3, 5, 7, 11, 13};
        Map<Float, String> orderedMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                orderedMap.put((float)arr[i]/arr[j], arr[i] + "/" + arr[j]);
            }
        }
        int i = 1;
        for (Map.Entry<Float, String> entry : orderedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + ", i=" + i++);
        }
    }
}
