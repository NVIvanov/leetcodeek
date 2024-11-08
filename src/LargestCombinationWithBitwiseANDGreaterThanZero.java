public class LargestCombinationWithBitwiseANDGreaterThanZero {

    static class Solution {
        public int largestCombination(int[] candidates) {
            int count = 0, maxCount = 0, limit = (int) Math.pow(2, 24);
            for (int i = 1; i <= limit; i <<= 1) {
                for (int candidate : candidates) {
                    if ((candidate & i) > 0) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
            return maxCount;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestCombination(new int[]{8,8}));
    }
}
