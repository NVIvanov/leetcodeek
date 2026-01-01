public class NumberofWaystoSplitArray {

    static class Solution {
        public int waysToSplitArray(int[] nums) {
            long rightSum = 0;
            for (int num : nums) {
                rightSum += num;
            }
            long leftSum = 0;

            int result = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                leftSum += nums[i];
                rightSum -= nums[i];
                if (leftSum >= rightSum) {
                    result++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

    }
}
