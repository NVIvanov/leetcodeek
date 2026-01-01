import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumberofBadPairs {

    static class Solution {
        /*

         */
        public long countBadPairs(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
            }
            long sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += (long) entry.getValue() * (entry.getValue() - 1) / 2;
            }
            return (long) nums.length * (nums.length - 1) / 2 - sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBadPairs(new int[] { 1,2,3,4,5 }));
    }
}
