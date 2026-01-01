import java.util.Arrays;

public class MaximumNumberofDistinctElementsAfterOperations {

    static class Solution {

        public int maxDistinctElements(int[] nums, int k) {
            Arrays.sort(nums);
            int counter = 1;
            nums[0] -= k;
            for (int i = 1; i < nums.length; i++) {
                int diff;
                if (nums[i] > nums[i - 1]) {
                    diff = Math.max(nums[i - 1] - nums[i] + 1, -k);
                } else {
                    diff = Math.min(nums[i - 1] - nums[i] + 1, k);
                }
                nums[i] += diff;
                if (nums[i] != nums[i - 1]) {
                    counter++;
                }
            }
            return counter;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistinctElements(new int[]{1,1,1,1,1,1,1,1,5,5,5}, 3));
    }
}
