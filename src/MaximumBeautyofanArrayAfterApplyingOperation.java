import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MaximumBeautyofanArrayAfterApplyingOperation {

    static class Solution {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
            int l = 0, r = 0;
            int len = 0;
            int spread = 2 * k;

            while (r < nums.length) {
                while (r < nums.length && nums[r] - nums[l] <= spread) {
                    r++;
                    len = Math.max(r - l, len);
                }
                l++;
                if (l > r) {
                    r = l;
                }
            }

            return len;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBeauty(new int[]{1,1,1,1}, 10));
    }
}
