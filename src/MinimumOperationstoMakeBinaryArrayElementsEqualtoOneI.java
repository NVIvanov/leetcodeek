public class MinimumOperationstoMakeBinaryArrayElementsEqualtoOneI {

    static class Solution {
        public int minOperations(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == 1) {
                    continue;
                }
                count++;
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
            return 0;
            
        }
    }

}
