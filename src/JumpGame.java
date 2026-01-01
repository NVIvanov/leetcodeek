public class JumpGame {

    static class Solution {
        /*
            cabReach[i] = canReach[i - 1]
         */
        public boolean canJump(int[] nums) {
            int maxReachable = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i > maxReachable) {
                    return false;
                }
                maxReachable = Math.max(maxReachable, i + nums[i]);
                if (maxReachable >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {

    }
}
