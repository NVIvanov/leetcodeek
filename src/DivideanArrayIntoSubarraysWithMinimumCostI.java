public class DivideanArrayIntoSubarraysWithMinimumCostI {

    static class Solution {
        public int minimumCost(int[] nums) {
            int firstMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            int firstMinI = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < firstMin) {
                    firstMin = nums[i];
                    firstMinI = i;
                }
            }
            nums[firstMinI] = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < secondMin) {
                    secondMin = nums[i];
                }
            }
            return nums[0] + firstMin + secondMin;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost(new int[]{10, 3, 1, 1}));
    }
}
