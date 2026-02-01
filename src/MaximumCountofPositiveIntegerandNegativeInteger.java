public class MaximumCountofPositiveIntegerandNegativeInteger {
    static class Solution {
        public int maximumCount(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums[0] == 0 && nums[nums.length - 1] == 0) {
                return 0;
            }
            if (nums[0] > 0) {
                return nums.length;
            }
            if (nums[nums.length - 1] < 0) {
                return nums.length;
            }
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= 0) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int neg = l;
            l = 0;
            r = nums.length - 1;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= 0) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int pos = nums.length - l;
            return Math.max(neg, pos);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumCount(new int[] {0,0,0,0}));
    }
}
