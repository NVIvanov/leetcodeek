import java.util.*;

public class IntersectionofTwoArrays {

    public static int binarySearch(int[] array, int x) {
        if (array.length == 0) {
            return -1;
        }
        int r = array.length - 1;
        int l = 0;
        do {
            int index = (r + l) / 2;
            if (array[index] > x) {
                r = index - 1;
            } else if (array[index] < x) {
                l = index + 1;
            } else {
                return index;
            }
        } while (l <= r);
        return -1;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();
        for (var num: nums1) {
            if (!result.contains(num) && binarySearch(nums2, num) != -1) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (var el: result) {
            res[i++] = el;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
