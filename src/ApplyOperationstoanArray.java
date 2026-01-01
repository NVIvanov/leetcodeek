import java.util.Arrays;

public class ApplyOperationstoanArray {

    static class Solution {
        public int[] applyOperations(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }

            int j = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                }
            }

            while (j < nums.length) {
                nums[j] = 0;
                j++;
            }

            return nums;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{0, 1})));
    }
}
