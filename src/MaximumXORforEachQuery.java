import java.util.Arrays;

public class MaximumXORforEachQuery {

    static class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int[] answer = new int[nums.length];
            int xor = 0;
            int compareWith = (int) (Math.pow(2, maximumBit) - 1);
            for (int i = 0; i < nums.length; i++) {
                xor ^= nums[i];
                answer[nums.length - 1 - i] = xor ^ compareWith;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getMaximumXor(new int[]{2,3,4,7}, 3)));
    }
}
