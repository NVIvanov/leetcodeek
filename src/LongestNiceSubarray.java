public class LongestNiceSubarray {
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int maxL = 0;
            for (int i = 1; i <= 30 && i < nums.length; i++) {
                int currentBitwiseAnd = nums[0];
                for (int j = 0; j < nums.length; j++) {
                    if (j - i >= 0) {
                        currentBitwiseAnd &= ~nums[j - i];
                    }
                    currentBitwiseAnd &= nums[j];
                    if (currentBitwiseAnd == 0) {
                        maxL = Math.max(maxL, i);
                    }
                }
            }
            return maxL;
        }
    }
}
