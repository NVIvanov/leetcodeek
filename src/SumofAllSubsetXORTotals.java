import java.util.ArrayList;
import java.util.List;

public class SumofAllSubsetXORTotals {

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = getAllSubsets(nums);
        int sum = 0;
        for (List<Integer> subset : subsets) {
            sum += subset.stream().reduce(0, (x, y) -> x ^ y);
        }
        return sum;
    }

    public static List<List<Integer>> getAllSubsets(int[] arr) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = 1 << n; // 2^n subsets

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit in the i-th subset is set
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
    }
}
