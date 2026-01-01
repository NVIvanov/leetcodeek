public class BitwiseXORofAllPairings {

    static class Solution {
        /*




         */
        public int xorAllNums(int[] nums1, int[] nums2) {
            int res = 0;
            if (nums2.length % 2 != 0) {
                for (int i = 0; i < nums1.length; i++) {
                    res ^= nums1[i];
                }
            }
            if (nums1.length % 2 != 0) {
                for (int i = 0; i < nums2.length; i++) {
                    res ^= nums2[i];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println((1 ^ 3) ^ (2 ^ 3));
        System.out.println(1 ^ 3);


        Solution solution = new Solution();
        System.out.println(solution.xorAllNums(
                new int[] {1,2},
                new int[] {3}
        ));
    }
}
