import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SpecialArrayII {

    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            List<List<Integer>> list = specialArraysBound(nums);
            list = list.stream()
                    .sorted(Comparator.<List<Integer>>comparingInt(List::getFirst).thenComparingInt(List::getLast))
                    .toList();

            boolean[] res = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                final int left = queries[i][0];
                final int right = queries[i][1];
                int a = 0, b = list.size() - 1;
                while (a <= b) {
                    int mid = a + (b - a) / 2;
                    if (list.get(mid).getFirst() > left) {
                        b = mid - 1;
                    } else if (list.get(mid).getLast() < right) {
                        a = mid + 1;
                    } else {
                        res[i] = true;
                        break;
                    }
                }
            }
            return res;
        }

        private static List<List<Integer>> specialArraysBound(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            current.add(0);
            boolean even = nums[0] % 2 == 0;
            for (int i = 1; i < nums.length; i++) {
                if ((nums[i] % 2 == 0) == even) {
                    current.add(i - 1);
                    list.add(current);
                    current = new ArrayList<>();
                    current.add(i);
                }
                even = nums[i] % 2 == 0;
            }
            current.add(nums.length - 1);
            list.add(current);
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().isArraySpecial(new int[]{
                        4,3,1,6
                },
                new int[][]{{0,2}, {2,3}})));
    }
}
