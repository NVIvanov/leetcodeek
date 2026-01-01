public class MaximumAbsoluteSumofAnySubarray {

    static class Solution {
        public int maxAbsoluteSum(int[] nums) {
            return Math.max(Math.abs(maxSum(nums)), Math.abs(minSum(nums)));
        }

        private int maxSum(int[] nums) {
            int maxSum = 0;
            int currentSum = 0;
            for (int num : nums) {
                currentSum = Math.max(currentSum + num, num);
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }

        private int minSum(int[] nums) {
            int minSum = 0;
            int currentSum = 0;
            for (int num : nums) {
                currentSum = Math.min(currentSum + num, num);
                minSum = Math.min(minSum, currentSum);
            }
            return minSum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}
