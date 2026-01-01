public class BestSightseeingPair {

    static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int maxI = values[0];
            int maxResult = Integer.MIN_VALUE;

            for (int i = 1; i < values.length; i++) {
                maxResult = Math.max(maxResult, maxI + values[i] - i);
                maxI = Math.max(maxI, values[i] + i);
            }

            return maxResult;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
