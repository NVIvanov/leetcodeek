import java.util.*;

public class FindthePowerofKSizeSubarraysI {

    static class Solution {

        public int[] resultsArray(int[] nums, int k) {
            if (k == 1) {
                return nums;
            }
            int ascSum = 0;
            int i = 0;
            while (i < k - 1) {
                if (i < nums.length - 1) {
                    if (nums[i] + 1 == nums[i+1]) {
                        ascSum++;
                    }
                } else {
                    ascSum++;
                }
                i++;
            }
            ascSum++;
            i++;
            int[] res = new int[nums.length - k + 1];
            while (i < nums.length) {
                res[i - k] = ascSum == k ? nums[i - k] : -1;
                if (nums[i - k] + 1 == nums[i - k + 1]) {
                    ascSum--;
                }
                if (nums[i - 1] + 1 == nums[i]) {
                    ascSum++;
                }
                i++;
            }
            res[i - k] = ascSum == k ? nums[i - k] : -1;
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{21,4,5}, 2)));
    }
}
