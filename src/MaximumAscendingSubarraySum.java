public class MaximumAscendingSubarraySum {

    static class Solution {
        public int maxAscendingSum(int[] nums) {
            int sum = nums[0];
            int max = sum;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    sum += nums[i + 1];
                } else {
                    max = Math.max(max, sum);
                    sum = nums[i + 1];
                }
            }
            return Math.max(max, sum);
        }
    }

    public static void main(String[] args) {

    }
}
