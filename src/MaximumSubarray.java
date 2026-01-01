public class MaximumSubarray {

    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;

            for (var num : nums) {
                sum = Math.max(sum + num, num);
                maxSum = Math.max(maxSum, sum);
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {

    }
}
