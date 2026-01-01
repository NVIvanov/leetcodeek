import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {

    static class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int a = 0, b = nums.size();
            while (a < b) {
                int mid = (a + b) / 2;
                if (hasIncreasingSubarrays(nums, mid)) {
                    a = mid + 1;
                } else {
                    b = mid;
                }
            }
            return a - 1;
        }

        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            for (int i = 0; i <= nums.size() - 2 * k; i++) {
                if (isIncreasing(nums, i, i + k) && isIncreasing(nums, i + k, i + 2*k)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isIncreasing(List<Integer> nums, int a, int b) {
            if (b - a == 1) {
                return true;
            }
            for (int i = a; i < b - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxIncreasingSubarrays(
                List.of(1,2,3,4,4,4,4,5,6,7)
        ));
    }


}
