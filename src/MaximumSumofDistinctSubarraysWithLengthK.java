import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumSumofDistinctSubarraysWithLengthK {

    static class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int l = 0, r = l + k;
            long sum = 0;
            for (int i = l; i < r - 1; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                sum += nums[i];
            }

            long maxSum = 0;
            for (int i = l; i < nums.length - k + 1; i++) {
                map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);
                sum += nums[i + k - 1];
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                if (map.get(nums[i]) == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                }
                sum -= nums[i];
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSubarraySum(new int[] {1,1,1,7,8,9}, 3));
    }
}
