public class SpecialArrayI {

    static class Solution {
        public boolean isArraySpecial(int[] nums) {
            int parity = nums[0] % 2;
            for (int num : nums) {
                if (num % 2 != parity) {
                    return false;
                }
                parity = (parity + 1) % 2;
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
